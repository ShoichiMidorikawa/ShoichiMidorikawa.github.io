import numpy as np
import pandas as pd
from pandas import Series,DataFrame
import matplotlib.pyplot as plt
import matplotlib.dates as mdates
import csv
from scipy.interpolate import interp1d
import locale
import japanize_matplotlib
import pathlib


encoding = locale.getpreferredencoding()

plt.rcParams['figure.subplot.bottom'] = 0.25

fig = plt.figure()
ax1 = fig.add_subplot(1,1,1)
ax2 = ax1.twinx()


covid = pd.read_csv('newly_confirmed_cases_daily.csv')
df = DataFrame(covid)

df_s=df.set_index("Date")["2021/12/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

c0 = df_r.loc[:,"Date"]
c1 = df_r.loc[:,"ALL"]

df0 = pd.DataFrame(data=c0)

for i in range(0, num):
    df0.loc[i,"ALL"] = c1[i]

#print(df0)

for i in range(5, num):
    df0.loc[i, "実効再生産数C"] = c1[i]/(c1[i]+4*c1[i-1]+9*c1[i-2]+8*c1[i-3]+7*c1[i-4]+c1[i-5])*30

#-----------------------------

for i in range(8, num):
    df0.loc[i, "実効再生産数K"] = c1[i]/c1[i-2] 


#---------------------------    

for i in range(8, num):
    df0.loc[i, "実効再生産数B"] = sum(c1[i-6:i+1])/sum(c1[i-8:i-1]) 

#----------------------

for i in range(13, num):
    df0.loc[i, "実効再生産数N"] = (sum(c1[i-6:i+1])/sum(c1[i-13:i-6]))**(2/7) 


df0.to_csv('effective_production_numberB&N.csv', encoding="ANSI", index=False)



df_s=df0.set_index("Date")["2022/1/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

df0 = DataFrame(df_r)

print(df0)
df0.to_csv('effective_production_numberB&N.csv', encoding="ANSI", index=False)


ax1.bar(df0["Date"],df0["ALL"], label="国内の感染者数_1日ごとの発表数",color='lightsteelblue',width=0.85,align="center")
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=30))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")


#---------------------------------------
ax2.plot(df0["Date"],df0["実効再生産数C"], label="実効再生産数C", color='brown',linewidth=2.)
ax2.plot(df0["Date"],df0["実効再生産数K"], label="実効再生産数K", color='green',linewidth=1.)
ax2.plot(df0["Date"],df0["実効再生産数B"], label="実効再生産数B", color='blue',linewidth=1.)
ax2.plot(df0["Date"],df0["実効再生産数N"], label="実効再生産数N", color='red',linewidth=1.)
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=7))

ax1.set_ylabel("新規感染者数", fontname="MS Gothic", fontsize=13, color="navy")
ax2.set_ylabel("実効再生産数", fontname="MS Gothic", fontsize=13, color="red")


#y_min, y_max = ax1.get_ylim()


plt.xlim(0, num)
#ax2.set_ylim(y_min,y_max)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
