reset
set terminal postscript portrait
set output "l-spiral.eps"
set size  square
set xzeroaxis
set yzeroaxis 
set nokey
set parametric
set label "a=1, b =0.3" at 6, 14 font ', 18'
set xrange[-5*pi:5*pi]
set yrange[-5*pi:5*pi]
a=1
b=0.3
plot[-2*pi:3*pi] a*exp(b*t)*cos(t), a*exp(b*t)*sin(t)
