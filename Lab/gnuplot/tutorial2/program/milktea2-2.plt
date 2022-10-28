reset
set terminal png
set output "milktea2-2.png"
set nokey
set size square
#set xzeroaxis
set yzeroaxis
set xrange [ -1 : 1 ] noreverse nowriteback
set yrange [ -1 : 1 ] noreverse nowriteback

f(t, x) = (sin(3*t)-sin(t))/(cos(3*t)-cos(t))*(x - cos(t))+sin(t) 

plot for [i=1:12]  [cos(3*i*pi/24) : cos(i*pi/24)]   f(i*pi/24, x)  lt -1, \
for [i=13: 24]  [cos(i*pi/24) : cos(3*i*pi/24)] f(i*pi/24, x) lt -1, \
 sqrt(1-x**2) w l ls -1, \
-sqrt(1-x**2) w l ls -1

