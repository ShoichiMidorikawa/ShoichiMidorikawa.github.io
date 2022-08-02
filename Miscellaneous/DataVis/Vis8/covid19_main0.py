import numpy as np
import pandas as pd
from pandas import Series,DataFrame
import matplotlib.pyplot as plt
import matplotlib.dates as mdates
import csv
from scipy.interpolate import interp1d
import locale
import japanize_matplotlib

encoding = locale.getpreferredencoding()

plt.rcParams['figure.subplot.bottom'] = 0.25

fig = plt.figure()
ax1 = fig.add_subplot(1,1,1)
ax2 = ax1.twinx()

covid = pd.read_csv('nhk_news_covid19_domestic_daily_data.csv')
df = DataFrame(covid)

n = len(df)
c1 = df.iloc[:,1]
for i in range(3, n-3):
    df.loc[i,"感染者_7日平均"] = sum(c1[i-3:i+4])/7


c5 = df.iloc[:,5]

for i in range(6, n-6):
    df.loc[i,"感染者_TMA"] = sum(c5[i-3:i+4])/7


df_s=df.set_index("日付")["2020/3/1":]
df_r = df_s.reset_index()

df0 = pd.DataFrame(df_r)

#--------------------------------
encoding = locale.getpreferredencoding()

covid2 = pd.read_csv('effective_reproduction_number.csv', encoding="ANSI")
df2 = DataFrame(covid2)

n = len(df2)
c1 = df2.iloc[:,1]

for i in range(0, n):
    df0.loc[i,"実効再生産数"] = c1[i]


for i in range(3, n-3):
    df0.loc[i,"実効再生産数_7日平均"] = sum(c1[i-3:i+4])/7

#---------------------------------

df_s=df0.set_index("日付")["2022/1/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

df0 = pd.DataFrame(df_r)


df0.to_csv('nhk_news_covid19_domestic_daily_dataNo2.csv',encoding="ANSI", index=False)

 
ax1.bar(df0["日付"],df0["国内の感染者数_1日ごとの発表数"], label="国内の感染者数_1日ごとの発表数", linewidth=1.)
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=10))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")

ax1.set_ylim(0,)
#print(ax1.get_ylim())
y1_max= ax1.get_ylim()[1]

#---------------------------------------


ax2.plot(df0["日付"],df0["実効再生産数"], label="実効再生産数", linewidth=2.,color='red')
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=7))

ax2.tick_params(axis='y', colors ="red")

#ax2.set_ylim(0,y1_max/400)

ax1.set_ylabel("新規感染者数", fontname="MS Gothic", fontsize=13, color="navy")
ax2.set_ylabel("実効再生産数", fontname="MS Gothic", fontsize=13, color="red")

plt.xlim(0, num)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
