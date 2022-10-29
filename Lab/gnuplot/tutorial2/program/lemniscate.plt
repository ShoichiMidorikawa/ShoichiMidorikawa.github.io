# レム二スケート
reset
set terminal png
set output "lemniscate1.png"
set size  ratio 0.5
se nokey
set xzeroaxis
set yzeroaxis 
set xrange[-2:2]
set yrange[-1:1] 
set parametric
set trange[0:2*pi]
set samples 10000
a=1
set label "a=1" at 1.2, 0.7 font ', 25'
plot sqrt(2*a*a*cos(2*t))*cos(t), sqrt(2*a*a*cos(2*t))*sin(t)


