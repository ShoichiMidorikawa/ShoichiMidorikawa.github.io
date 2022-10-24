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


#----------------------------------
    
for i in range(3, num-3):
    df0.loc[i,"感染者_MAV"] = sum(c1[i-3:i+4])/7

c2 = df0.loc[:,"感染者_MAV"]

for i in range(6, num-6):
    df0.loc[i,"感染者_TMA"] = sum(c2[i-3:i+4])/7

c12 = df0.loc[:,"感染者_TMA"]

for i in range(0, num-1):
    df0.loc[i,"dI(t)/dt"] =c12[i+1]-c12[i]

#--------------------------

for i in range(5, num):
    df0.loc[i, "実効再生産数C"] = c12[i]/(c12[i]+4*c12[i-1]+9*c12[i-2]+8*c12[i-3]+7*c12[i-4]+c12[i-5])*30

cc = df0.loc[:,"実効再生産数C"]

#--------------------------

for i in range(8, num):
    df0.loc[i, "実効再生産数K"] = c12[i]/c12[i-2] 

k1 = df0.loc[:,"実効再生産数K"]

#for i in range(3, num-3):
#    df0.loc[i,"実効再生産数K_7平均"] = sum(k1[i-3:i+4])/7

#k2 = df0.loc[:,"実効再生産数K_7平均"]

#---------------------------

for i in range(8, num):
    df0.loc[i, "実効再生産数B"] = sum(c12[i-6:i+1])/sum(c12[i-8:i-1]) 

c2 = df0.loc[:,"実効再生産数B"]

#----------------------------

for i in range(13, num):
    df0.loc[i, "実効再生産数N"] = (sum(c12[i-6:i+1])/sum(c12[i-13:i-6]))**(2/7) 

c4 = df0.loc[:,"実効再生産数N"]


df0.to_csv('effective_production_numberB&N.csv', encoding="ANSI", index=False)


#-------------

gamma = 1/3

#------------

dayC = 1

for i in range(0, num-dayC):
    df0.loc[i,"gamma*(R_C-1)*I"] =gamma*(cc[i+dayC]-1)*c12[i]


#-----------------------------------------------

dayK = 1

for i in range(0, num-dayK):
    df0.loc[i,"gamma*(R_K-1)*I"] =gamma*(k1[i+dayK]-1)*c12[i]

#-------------

dayB = 4

for i in range(0, num-dayB):
    df0.loc[i,"gamma*(R_B-1)*I"] =gamma*(c2[i+dayB]-1)*c12[i]

#-------------

dayN = 7

for i in range(0, num-dayN):
    df0.loc[i,"gamma*(R_N-1)*I"] =gamma*(c4[i+dayN]-1)*c12[i]

#-------------
    


df_s=df0.set_index("Date")["2022/1/1":]
df_r = df_s.reset_index()

# num = df_rの行数(rows)
num = len(df_r)

df0 = DataFrame(df_r)

print(df0)
df0.to_csv('effective_production_numberB&N.csv', encoding="ANSI", index=False)

ax1.xaxis.set_major_locator(mdates.DayLocator(interval=50))

ax1.tick_params(axis='x', colors ="black", rotation = 90)
ax1.tick_params(axis='y', colors ="navy")


ax1.plot(df0["Date"],df0["dI(t)/dt"], label="dI(t)/dt",color='black',linewidth=1.0)
ax1.xaxis.set_major_locator(mdates.DayLocator(interval=10))

#----------------------------------------
ax2.plot(df0["Date"],df0["gamma*(R_C-1)*I"], label="gamma*(R_C(t+"+str(dayC)+")-1)*I(t)", linewidth=1.5,color='brown')
ax2.plot(df0["Date"],df0["gamma*(R_K-1)*I"], label="gamma*(R_K(t+"+str(dayK)+")-1)*I(t)", linewidth=2.0,color='green')
ax2.plot(df0["Date"],df0["gamma*(R_B-1)*I"],":", label="gamma*(R_B(t+"+str(dayB)+")-1)*I(t)", linewidth=2.0,color='blue')
ax2.plot(df0["Date"],df0["gamma*(R_N-1)*I"],":", label="gamma*(R_N(t+"+str(dayN)+")-1)*I(t)", linewidth=2.0,color='red')
ax2.annotate("γ = "+str(gamma),xy=(253,8000),fontsize=11) 

ax2.xaxis.set_major_locator(mdates.DayLocator(interval=7))
ax2.tick_params(axis='y', colors ="red")

plt.xlim(0, num)

ax1.set_ylabel("dI(t)/dt", fontname="MS Gothic", fontsize=13, color="navy")
ax2.set_ylabel("γ*(R(t+α)-1)*I(t)", fontname="MS Gothic", fontsize=13, color="red")
y_min, y_max = ax1.get_ylim()
ax2.set_ylim(y_min,y_max)



plt.xlim(0, num)

handler1, label1 = ax1.get_legend_handles_labels()
handler2, label2 = ax2.get_legend_handles_labels()
ax1.legend(handler1+handler2,label1+label2,borderaxespad=0)
ax1.grid(axis='x')

plt.grid()
plt.show()
