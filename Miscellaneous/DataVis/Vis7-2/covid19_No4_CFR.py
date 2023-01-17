import numpy as np
import pandas as pd
import numpy as np
from pandas import Series,DataFrame
import matplotlib.pyplot as plt
import matplotlib.dates as mdates
import csv
from scipy.interpolate import interp1d
import locale
import japanize_matplotlib

plt.rcParams['figure.subplot.bottom'] = 0.25

fig = plt.figure()
ax1= fig.add_subplot(1,1,1)
ax2 = ax1.twinx()



covid = pd.read_csv('newly_confirmed_cases&deathNo2.csv', encoding="ANSI")
df = DataFrame(covid)

n = len(df)
b3 = df.iloc[:,3]
b4 = df.iloc[:,4]

day=17

for i in range(5, n-3-day):
    df.loc[i, "致死率"] = b4[i+day]/b3[i]




#確認のため、csvに書き出し
df.to_csv('newly_confirmed_cases&deathNo3.csv',encoding="ANSI", index=False)


df_s=df.set_index("Date")["2022/1/10":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

df0 = pd.DataFrame(df_r)


ax1.bar(df0["Date"],df0["ALL"], label="国内の感染者数_1日ごとの発表数", linewidth=1.)
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=10))
ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")
ax1.set_ylabel("感染者数", fontname="MS Gothic", fontsize=14,color='navy')

ax1.set_ylim(0, )


ax2.plot(df0["Date"], df0["致死率"],label="致死率", linewidth=1.,color='red')
ax2.xaxis.set_major_locator(mdates.DayLocator(interval=10))
ax2.tick_params(axis='y', colors ="red")


ax2.set_ylabel("致死率", fontname="MS Gothic", fontsize=14,color='red')

plt.xlim(0, num-20)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')


plt.grid()
plt.show()
