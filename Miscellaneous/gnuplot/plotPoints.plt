reset
set terminal postscript portrait
set output "points.ps"

set size square .7, .7

set xrange[-2: 2] 
set yrange[-2: 2]

set nokey
set xlabel "x" font "Helvetica,20"
set ylabel "y" font "Helvetica,20"
set xtics nomirror
set ytics nomirror

set zeroaxis
set noxtics
set noytics

plot "-" w p pt 1 ps 2, "-"  w p pt 2 ps 2, "-"  w p pt 3 ps 2, \
"-" w p pt 4 ps 2, "-"  w p pt 5 ps 2, "-"  w p pt 6 ps 2, \
"-" w p pt 7 ps 2, "-"  w p pt 8 ps 2, "-"  w p pt 9 ps 2
 -1     1
e
  0     1
e  
  1     1
e
 -1     0
e
  0     0
e  
  1     0
e
 -1     -1
e
  0     -1
e  
  1     -1
e

