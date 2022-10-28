reset
set terminal png
set output "milktea.png"
set nokey
set size square
set xzeroaxis
#set yzeroaxis
set xrange [ -1 : 1 ] noreverse nowriteback
set yrange [ -1 : 1 ] noreverse nowriteback

f(t, x) = (sin(2*t)-sin(t))/(cos(2*t)-cos(t))*(x - cos(t))+sin(t) 

plot sample \
 [cos(2*pi/24) : cos(pi/24)]   f(pi/24, x)   w l ls -1,     [cos(4*pi/24) : cos(2*pi/24)]  f(2*pi/24, x) w l ls -1, \
 [cos(6*pi/24) : cos(3*pi/24)] f(3*pi/24, x) w l ls -1,   [cos(8*pi/24) : cos(4*pi/24)]  f(4*pi/24, x) w l ls -1, \
[cos(10*pi/24) : cos(5*pi/24)] f(5*pi/24, x) w l ls -1,   [cos(12*pi/24) : cos(6*pi/24)] f(6*pi/24, x) w l ls -1, \
[cos(14*pi/24) : cos(7*pi/24)] f(7*pi/24, x) w l ls -1,   [cos(16*pi/24) : cos(8*pi/24)] f(8*pi/24, x) w l ls -1, \
[cos(18*pi/24) : cos(9*pi/24)] f(9*pi/24, x) w l ls -1,   [cos(20*pi/24) : cos(10*pi/24)] f(10*pi/24, x) w l ls -1, \
[cos(22*pi/24) : cos(11*pi/24)] f(11*pi/24, x) w l ls -1, [cos(24*pi/24) : cos(12*pi/24)] f(12*pi/24, x) w l ls -1, \
[cos(26*pi/24) : cos(13*pi/24)] f(13*pi/24, x) w l ls -1, [cos(28*pi/24) : cos(14*pi/24)] f(14*pi/24, x) w l ls -1, \
[cos(30*pi/24) : cos(15*pi/24)] f(15*pi/24, x) w l ls -1, [cos(32*pi/24) : cos(16*pi/24)] f(16*pi/24, x) w l ls -1, \
[cos(17*pi/24) : cos(34*pi/24)] f(17*pi/24, x) w l ls -1, [cos(18*pi/24) : cos(36*pi/24)] f(18*pi/24, x) w l ls -1, \
[cos(19*pi/24) : cos(38*pi/24)] f(19*pi/24, x) w l ls -1, [cos(20*pi/24) : cos(40*pi/24)] f(20*pi/24, x) w l ls -1, \
[cos(21*pi/24) : cos(42*pi/24)] f(21*pi/24, x) w l ls -1, [cos(22*pi/24) : cos(44*pi/24)] f(22*pi/24, x) w l ls -1, \
[cos(23*pi/24) : cos(46*pi/24)] f(23*pi/24, x) w l ls -1, [cos(24*pi/24) : cos(48*pi/24)] f(24*pi/24, x) w l ls -1, \
[cos(25*pi/24) : cos(50*pi/24)] f(25*pi/24, x) w l ls -1, [cos(26*pi/24) : cos(52*pi/24)] f(26*pi/24, x) w l ls -1, \
[cos(27*pi/24) : cos(54*pi/24)] f(27*pi/24, x) w l ls -1, [cos(28*pi/24) : cos(56*pi/24)] f(28*pi/24, x) w l ls -1, \
[cos(29*pi/24) : cos(58*pi/24)] f(29*pi/24, x) w l ls -1, [cos(30*pi/24) : cos(60*pi/24)] f(30*pi/24, x) w l ls -1, \
[cos(31*pi/24) : cos(62*pi/24)] f(31*pi/24, x) w l ls -1, [cos(32*pi/24) : cos(64*pi/24)] f(32*pi/24, x) w l ls -1, \
[cos(66*pi/24) : cos(33*pi/24)] f(33*pi/24, x) w l ls -1, [cos(68*pi/24) : cos(34*pi/24)] f(34*pi/24, x) w l ls -1, \
[cos(70*pi/24) : cos(35*pi/24)] f(35*pi/24, x) w l ls -1, [cos(72*pi/24) : cos(36*pi/24)] f(36*pi/24, x) w l ls -1, \
[cos(74*pi/24) : cos(37*pi/24)] f(37*pi/24, x) w l ls -1, [cos(76*pi/24) : cos(38*pi/24)] f(38*pi/24, x) w l ls -1, \
[cos(78*pi/24) : cos(39*pi/24)] f(39*pi/24, x) w l ls -1, [cos(80*pi/24) : cos(40*pi/24)] f(40*pi/24, x) w l ls -1, \
[cos(82*pi/24) : cos(41*pi/24)] f(41*pi/24, x) w l ls -1, [cos(84*pi/24) : cos(42*pi/24)] f(42*pi/24, x) w l ls -1, \
[cos(86*pi/24) : cos(43*pi/24)] f(43*pi/24, x) w l ls -1, [cos(88*pi/24) : cos(44*pi/24)] f(44*pi/24, x) w l ls -1, \
[cos(90*pi/24) : cos(45*pi/24)] f(45*pi/24, x) w l ls -1, [cos(92*pi/24) : cos(46*pi/24)] f(46*pi/24, x) w l ls -1, \
[cos(94*pi/24) : cos(47*pi/24)] f(47*pi/24, x) w l ls -1, [cos(96*pi/24) : cos(48*pi/24)] f(48*pi/24, x) w l ls -1, \
 sqrt(1-x**2) w l ls -1, \
-sqrt(1-x**2) w l ls -1

