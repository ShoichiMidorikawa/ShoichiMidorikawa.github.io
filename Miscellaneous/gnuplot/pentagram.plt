
# ¯Œ`}Œ`(pentagram)‚ğ•`‚­

reset
set terminal postscript portrait
set output "pentagram.ps"
set size  square
set xrange[-2: 2] 
set yrange[-2: 2]

set noborder 
set nokey
set noxtics 
set noytics 

plot "-"  w l lw 4
 0.000   1.000   
 0.588  -0.809
-0.951   0.309
 0.951   0.309
-0.588  -0.809
 0.000   1.000
