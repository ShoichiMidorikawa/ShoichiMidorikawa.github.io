reset
set terminal postscript portrait
set output "meanVal.ps"
set size  .5, .5
set xrange[-2: 4] 
set yrange[-5:20]
set trange[-8: 20]
set nokey
set noxtics 
set noytics 
set parametric 
set label "a" at -1.6, -5.4 font "Times New Roman-Italic, 12"
set label "c" at 0.93 , -5.4 font "Times Roman-Italic, 12"
set label "b" at 3.4 , -5.4 font "Times Roman-Italic, 12"
set label "f(a)" at -2.55, 2.3 font 'Times New Roman-Italic, 12'
set label "f(b)" at -2.55, 12.3 font 'Times Roman-Italic, 12'
set label "f(c)" at -2.55, 1.1 font 'Times Roman-Italic, 12'
plot t, t*t ls 1 lw 2, t, 2*t+5.25 ls 1, t, 2*t-1 ls 1, -1.5, t ls 1, 3.5, t ls 1, 1, t ls 1, t, 1 ls 1 , t, 2.25 ls 1, t, 12.25 ls 1 
