#カージオイド
reset
set terminal png
set output "cardioid2.png"
set size  square
set nokey
set xrange[-0.5:2.5]
set yrange[-1.5:1.5]
set parametric
set samples 300 
plot for [i=-12:12] cos(i*pi/24)**2+cos(i*pi/24)*cos(t), cos(i*pi/24)*sin(i*pi/24)+cos(i*pi/24)*sin(t) lt -1


