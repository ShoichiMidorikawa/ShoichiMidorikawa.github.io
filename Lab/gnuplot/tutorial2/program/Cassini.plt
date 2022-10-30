# カッシーニの卵型曲線(Cassinian oval)
reset
set terminal png
set output "Cassini.png"
set size  ratio 0.67
se nokey
set xzeroaxis
set yzeroaxis 
set xrange[-3:3]
set yrange[-2:2] 
set parametric
set trange[0:2*pi]
set samples 60000
a=2.
b=1.8
b2=2.2 
set label "a=2, b=1.8" at 1.5, 1.34 font ', 15' textcolor rgb "red"
set label "a=2, b=2"   at 1.5, 1.57 font ', 15' textcolor rgb "blue"
set label "a=2, b=2.2" at 1.5, 1.8 font ', 15' textcolor rgb "green"
f(a,b,t) = sqrt(a*a*cos(2*t)+sqrt(b**4-a**4*sin(2*t)**2))
g(a,b,t) = sqrt(a*a*cos(2*t)-sqrt(b**4-a**4*sin(2*t)**2))
plot f(a,b,t)*cos(t), f(a,b,t)*sin(t) lc rgb "red", g(a,b,t)*cos(t), g(a,b,t)*sin(t) lc rgb "red", \
f(a,a,t)*cos(t), f(a,a,t)*sin(t) lc rgb "blue", \
f(a,b2,t)*cos(t), f(a,b2,t)*sin(t) lc rgb "green"


