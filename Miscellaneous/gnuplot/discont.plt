reset
set terminal postscript portrait
set output "discont.ps"
set size  .5, .5
set xrange[-2: 2] 
set yrange[-1:5]
set nokey
set tics font "Helvetica,20"
set xtics -2, 1 
set ytics 
set xzeroaxis
set yzeroaxis
set arrow from -2, 0 to 2, 0
set arrow from 0, -1 to 0, 5
plot x*x+1, \
"-" w p pt 7 lc rgb "white", \
"-" w p pt 6 , \
"-" w p pt 7 
  0     1
e
  0     1
e
  0     0
e
