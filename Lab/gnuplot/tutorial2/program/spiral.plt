reset
set terminal png
set output "spiral.png"
set size  square
set xzeroaxis
set yzeroaxis 
set nokey
set parametric
set label "a=1" at 10, 12 font ', 25'
set xrange[-5*pi:5*pi]
set yrange[-5*pi:5*pi]
plot[0:5*pi] t*cos(t), t*sin(t)


