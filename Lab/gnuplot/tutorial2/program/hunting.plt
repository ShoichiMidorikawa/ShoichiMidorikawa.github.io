set size ratio 0.8  1

if(exist("n")==0 || n<0) n = 0  # ループ変数の初期化

#-------------------------------------------------------------------------------
# プロット
#-------------------------------------------------------------------------------
tmax= n/6.0
fx(t) = t<=tmax ? t : 1/0
fy(t) = t<=tmax ? -2.*t**2+20.*t : 1/0 

gy(a,t) = t<=tmax ? 20*a-2.*t**2 : 1/0

plot fx(t), fy(t) w l , \
t, 20*t w l, \
0, 0 w p pt 6 ps 2 lc rgb "purple", \
fx(tmax), fy(tmax) w p pt 7 ps 2 lc rgb "purple", \
2, gy(2,0) w p pt 6 ps 2 lc rgb "red" , \
2, gy(2,t) w l lc rgb "red", \
2, gy(2,tmax) w p pt 7 ps 2 lc rgb "red", \
4, gy(4,0) w p pt 6 ps 2 lc rgb "orange", \
4, gy(4,t) w l lc rgb "orange", \
4, gy(4,tmax) w p pt 7 ps 2 lc rgb "orange", \
6, gy(6,0) w p pt 6 ps 2 lc rgb "yellow", \
6, gy(6,t) w l lc rgb "yellow", \
6, gy(6,tmax) w p pt 7 ps 2 lc rgb "yellow" , \
8, gy(8,0) w p pt 6 ps 2 lc rgb "green" , \
8, gy(8,t) w l lc rgb "green", \
8, gy(8,tmax) w p pt 7 ps 2 lc rgb "green", \
10, gy(10,0) w p pt 6 ps 2 lc rgb "blue" , \
10, gy(10,t) w l lc rgb "blue", \
10, gy(10,tmax) w p pt 7 ps 2 lc rgb "blue"


#-------------------------------------------------------------------------------
# ループ処理
#-------------------------------------------------------------------------------
if ( n <= 120 ) n=n+1 ; reread  # ループの評価
undefine n            # ループ変数の削除