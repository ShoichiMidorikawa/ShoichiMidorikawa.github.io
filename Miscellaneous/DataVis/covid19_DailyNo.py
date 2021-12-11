import numpy as np
import pandas as pd
import numpy as np
from pandas import Series,DataFrame
import matplotlib.pyplot as plt
import matplotlib.dates as mdates

covid = pd.read_csv('nhk_news_covid19_domestic_daily_data.csv')
df = DataFrame(covid)

ax=df.plot(x="日付", y="国内の感染者数_1日ごとの発表数", kind='bar', rot=90, fontsize=9)

ax.xaxis.set_major_locator(mdates.DayLocator(interval=30))

plt.xlabel("", fontname="MS Gothic") #これが無いとコンパイル時にwarning messageが出る。
plt.legend(prop={"family":"MS Gothic"})

plt.show()
