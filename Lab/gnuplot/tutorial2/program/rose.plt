# ³—t‹Èü
reset
set terminal png
set output "rose1.5.png"
set size  square
se nokey
set xzeroaxis
set yzeroaxis 
set xrange[-1.2:1.2]
set yrange[-1.2:1.2] 
set parametric
set trange[-10:10]
set samples 300
a=1.5
set label "a=3/2" at 0.7, 0.9 font ', 25'
plot (sin(a*t))*cos(t), (sin(a*t))*sin(t)


