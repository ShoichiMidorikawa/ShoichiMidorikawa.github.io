# ƒŠƒ}ƒ\ƒ“
reset
set terminal png
set output "limacon1-1.5.png"
set size  square
se nokey
set xzeroaxis
set yzeroaxis 
set xrange[-0.5:2.5]
set yrange[-1.5:1.5] 
set parametric
a=1
b=1.5
set label "a=1, b=1.5" at 0, 0.8 font ', 25'
plot (a+b*cos(t))*cos(t), (a+b*cos(t))*sin(t)


