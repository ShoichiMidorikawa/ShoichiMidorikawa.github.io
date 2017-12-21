reset
set terminal png
set output "tangent.png"
set nokey 
set grid

set xtics ("-3p/2" -1.5*pi, "-p" -pi, "-p/2" -0.5*pi,  \
"0" 0.0, "p/2" 0.5*pi, "p" pi, "3p/2" 1.5*pi) font "Symbol"

set ytics -4, 1
set xzeroaxis
set yzeroaxis
set xrange [-1.5*pi: 1.5*pi]
set yrange [-4:4] 
plot tan(x) ls 1 notitle