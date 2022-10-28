# サイクロイド
reset
set terminal png transparent
set output "cycloid.png"
set size ratio 0.318  1.
se nokey
set xzeroaxis
set yzeroaxis
set xtics ("0" 0, "p" pi ,"2p" 2*pi) font "Symbol"  
set xrange[0:2*pi]
set yrange[0:2] 
set parametric
set trange[0:4*pi]
set samples 300
a=1
set label "a=1" at 5.5, 1.5 font ', 25'
plot a*(t - sin(t)), a*(1 - cos(t))


