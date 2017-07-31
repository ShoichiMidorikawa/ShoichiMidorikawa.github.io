# リサージュ図形(Lissajous figure)の描画
reset
set terminal png
set output "lissajous.png"
set size square
set parametric
plot sin(t), sin(2*t)