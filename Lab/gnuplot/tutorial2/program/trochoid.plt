if (exist("n")==0 || n<0) n=0 #•Ï”‚Ì‰Šú‰»
title(n) = sprintf("t = %d",n)  #ƒ^ƒCƒgƒ‹–¼
unset label 
#set label title(n)  font 'Times,20'  at 0 , 3.3 

theta = pi/20 * n
a=0.5
b=1.5
fx(t) = t<=theta ? t-sin(t) : 1/0
fy(t) = t<=theta ? 1-cos(t) : 1/0
gx(t) = t<=theta ? t-a*sin(t) : 1/0
gy(t) = t<=theta ? 1-a*cos(t) : 1/0
hx(t) = t<=theta ? t-b*sin(t) : 1/0
hy(t) = t<=theta ? 1-b*cos(t) : 1/0

lx(t) = t<=1 ? theta-b*t*sin(theta) : 1/0
ly(t) = t<=1 ? 1-b*t*cos(theta) : 1/0


set xtics ("0" 0.0, "p" pi ,"2p" 2*pi ,"3p" 3*pi ,"4p" 4*pi ,"5p" 5*pi ,"6p" 6*pi) font "Symbol" 

#set arrow from  theta ,1.0 to theta-sin(theta), 1 - cos(theta) nohead lw 2 dt (10,5)

plot fx(t),fy(t) w l lc rgb "blue", \
     gx(t),gy(t) w l lc rgb "red",  \
     hx(t),hy(t) w l lc rgb "green",\
     cos(t)+theta,sin(t)+1  w l lc rgb "black",\
     lx(t), ly(t) w l lc rgb "black", \
     fx(theta), fy(theta) with points pt 7 lc rgb "blue", \
     gx(theta), gy(theta) with points pt 7 lc rgb "red", \
     hx(theta), hy(theta) with points pt 7 lc rgb "green" 

if (n<200)  n=n+1; reread