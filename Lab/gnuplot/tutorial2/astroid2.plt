# 包絡線としてのアステロイド(astroid)
reset
set terminal png
set output "astroid2.png"
set size  square
set nokey
set xrange [0:1]
set yrange [0:1]
set xzeroaxis
set yzeroaxis
set samples 300 
plot for [i=1: 20] -x/tan(i*pi/40) + cos(i*pi/40)


