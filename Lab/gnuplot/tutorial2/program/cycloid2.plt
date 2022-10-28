# サイクロイド
reset
set terminal png transparent
set output "cycloid2.png" 
#set terminal postscript portrait enhanced color
#set output "cycloid2.ps"
set size ratio 0.318  1.
se nokey
set xzeroaxis
set yzeroaxis
set xtics ("0" 0, "p" pi ,"2p" 2*pi ,"3p" 3*pi ,"4p" 4*pi) font "Symbol"  
set xrange[0:4*pi]
set yrange[-2:2] 
set parametric
set trange[-pi:4*pi]
set samples 300
a=1
set label "a=1" at 5.8, 1.5 font ', 18'
x0(t) = a*(t-sin(t))
y0(t) = a*(1-cos(t))
plot a*(t - sin(t)), a*(1 - cos(t)) lc rgb "red" lw 1, \
for [i=1:80] t, -(1-cos(i*pi/20))/sin(i*pi/20)*(t-x0(i*pi/20))+y0(i*pi/20) lt -1, \
pi, t lt -1, 3*pi, t lt -1


