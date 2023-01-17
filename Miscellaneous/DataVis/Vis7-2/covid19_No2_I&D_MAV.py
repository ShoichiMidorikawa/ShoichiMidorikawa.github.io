#  nhk_news_covid19_domestic_daily_data.csvの読み込み
#  nhk_news_covid19_domestic_daily_dataNo2.csvの書き込み



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

covid = pd.read_csv('newly_confirmed_cases&death.csv',encoding="ANSI")
df = DataFrame(covid)

n = len(df)
b1 = df.iloc[:,1]
b2 = df.iloc[:,2]

for i in range(3, n-3):
    df.loc[i,"感染者_7日平均"] = sum(b1[i-3:i+4])/7
    df.loc[i,"死亡者_7日平均"] = sum(b2[i-3:i+4])/7



print(df)


df.to_csv('newly_confirmed_cases&deathNo2.csv',encoding="ANSI", index=False)




df3 = pd.read_csv('newly_confirmed_cases&deathNo2.csv',encoding="ANSI")

df_s=df3.set_index("Date")["2022/1/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)


df0 = pd.DataFrame(df_r)
 
ax1.plot(df0["Date"],df0["感染者_7日平均"], label="国内の感染者数_1日ごとの発表数(一週間平均)", linewidth=1.)
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=10))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")

ax1.set_ylim(0,)
#print(ax1.get_ylim())
y1_max= ax1.get_ylim()[1]

#---------------------------------------


ax2.plot(df0["Date"],df0["死亡者_7日平均"], label="国内の死者数_1日ごとの発表数(一週間平均)", linewidth=1.,color='red')
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=10))

#ax2.tick_params(axis='x', colors ="black", rotation = 90)
ax2.tick_params(axis='y', colors ="red")

ax2.set_ylim(0,y1_max/400)


plt.xlim(0, num)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
