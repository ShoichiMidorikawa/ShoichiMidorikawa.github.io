#ƒŠƒT[ƒWƒ…‹Èü
reset
set terminal png
set output "lissajous2-3.png"
set size  square
set nokey
set parametric
set samples 300 
set label "a=2, b=3" at 0, 0.8 font ', 25'
plot sin(2*t), sin(3*t)


