# レム二スケート
reset
set terminal png
set output "lemniscate2.png"
set size  ratio 0.5
se nokey
set xzeroaxis
set yzeroaxis 
set xrange[-3:3]
set yrange[-2:2] 
set parametric
set trange[0:2*pi]
set samples 10000
a=2
set label "a=2" at 1.2, 0.7 font ', 25'
plot sqrt(2*a*a*cos(2*t))*cos(t), sqrt(2*a*a*cos(2*t))*sin(t)


