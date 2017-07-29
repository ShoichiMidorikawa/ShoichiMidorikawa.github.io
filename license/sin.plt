# ƒTƒCƒ“ŠÖ”‚Ì•`‰æ
reset
set terminal png
set output "sin.png"

set xtics ( "-3p" -3*pi, "-2p" -2*pi, "-p" -pi, \
"0" 0.0, "p" pi, "2p" 2*pi, "2p" 2*pi, "3p" 3*pi) font "Symbol"

set xzeroaxis
set yzeroaxis

plot sin(x)