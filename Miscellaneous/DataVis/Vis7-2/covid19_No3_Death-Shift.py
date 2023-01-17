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

covid = pd.read_csv('newly_confirmed_cases&deathNo2.csv',encoding="ANSI")
df = DataFrame(covid)

n = len(df)

b4 = df.iloc[:,4]

day = 17

for i in range(0, n-day):
    df.loc[i,"死者day日前"] = b4[i+day]

print(df)



df_s=df.set_index("Date")["2022/1/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

df_r.to_csv('newly_confirmed_cases&deathNo3.csv',encoding="ANSI", index=False)

df0 = pd.DataFrame(df_r)
 
ax1.plot(df0["Date"],df0["感染者_7日平均"], label="国内の感染者数_1日ごとの発表数(一週間平均)", linewidth=1.)
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=5))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")

ax1.set_ylim(0,)
#print(ax1.get_ylim())
y1_max= ax1.get_ylim()[1]

#---------------------------------------


ax2.plot(df0["Date"],df0["死者day日前"], label=str(day)+"日後の国内の死者数_1日ごとの発表数(一週間平均)", linewidth=1.,color='red')
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=5))

#ax2.tick_params(axis='x', colors ="black", rotation = 90)
ax2.tick_params(axis='y', colors ="red")

ax2.set_ylim(0,y1_max/400)
# y1: y2 = 400:1

plt.xlim(0, num)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
