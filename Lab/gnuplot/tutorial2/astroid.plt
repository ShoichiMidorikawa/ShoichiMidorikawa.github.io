# アステロイド(astroid)
reset
set terminal png
set output "astroid.png"
set size  square
set nokey
set xzeroaxis
set yzeroaxis
set parametric
set samples 300 
set label "a=1" at 0.4, 0.8 font ', 25'
plot cos(t)**3, sin(t)**3


