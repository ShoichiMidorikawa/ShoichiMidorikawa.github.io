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

df_s=df.set_index("Date")["2020/5/9":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

c0 = df_r.loc[:,"Date"]
c1 = df_r.loc[:,"Aomori"]

df0 = pd.DataFrame(data=c0)

for i in range(0, num):
    df0.loc[i,"Aomori"] = c1[i]


#------------------------------------------

covid2 = pd.read_csv('deaths_cumulative_daily.csv')
df2 = DataFrame(covid2)

# num = df_rの行数(rows)
n = len(df2)

c2 = df2.loc[:,"Aomori"]



for i in range(1, n):
    df0.loc[i,"死者数"] = c2[i]-c2[i-1]

df_s=df0.set_index("Date")["2022/1/1":]
df_r = df_s.reset_index()
df0 = DataFrame(df_r)

# num = df_rの行数(rows)
num = len(df_r)

df0.to_csv('newly_confirmed_cases_daily_Aomori.csv', encoding="ANSI", index=False)

ax1.bar(df0["Date"],df0["Aomori"], label="青森県の感染者数_1日ごとの発表数",color='royalblue',width=0.85,align="center")
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=50))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")

print(ax1.get_ylim())
y1_max= ax1.get_ylim()[1]

#---------------------------------------


ax2.bar(df0["Date"],df0["死者数"], label="青森県の死者数_1日ごとの発表数", color='red',width=0.6,align="center")
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=7))

ax2.tick_params(axis='x', colors ="black", rotation = 90)
ax2.tick_params(axis='y', colors ="red")

ax1.set_ylabel("新規感染者数", fontname="MS Gothic", fontsize=13, color="navy")
ax2.set_ylabel("死者数", fontname="MS Gothic", fontsize=13, color="red")


ax2.set_ylim(0, y1_max/200)


plt.xlim(0, num)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
