# nhk_news_covid19_domestic_daily_dataNo2-2.csvの読み込み

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

#--------------------------------------
df3 = pd.read_csv('nhk_news_covid19_domestic_daily_dataNo2.csv',encoding="ANSI")

df0 = pd.DataFrame(df3)
num = len(df0)

c6 = df0.iloc[:,6]

for i in range(0, num-1):
    df0.loc[i,"dI(t)/dt"] =c6[i+1]-c6[i]

gamma = 1/2

c8 =  df0.iloc[:,8]

day = 7

for i in range(0, num-day):
    df0.loc[i,"gamma*(R-1)*I"] =gamma*(c8[i]-1)*c6[i]


df0.to_csv('nhk_news_covid19_domestic_daily_dataNo3.csv',encoding="ANSI", index=False)
#----------------------------------------

ax1.plot(df0["日付"],df0["dI(t)/dt"], label="dI(t)/dt")
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=15))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")


ax2.tick_params(colors ="red")

ax2.plot(df0["日付"],df0["gamma*(R-1)*I"], label="R(t+"+str(day)+")を使用",color="red")
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=7))


plt.xlim(0,num-2)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')
ax1.set_ylim(-2000,13000)


ax1.set_ylabel("dI(t)/dt", fontname="MS Gothic", fontsize=13, color="navy")
ax2.set_ylabel("γ*(R(t+"+str(day)+")-1)*I(t)", fontname="MS Gothic", fontsize=13, color="red")
ax2.set_ylim(-2000,13000)

#ax2.set_ylim(0.5,2.6)



plt.grid()
plt.show()
