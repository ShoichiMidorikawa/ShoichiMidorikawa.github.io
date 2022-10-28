set size  square
set nokey
set xrange [0:1]
set yrange [0:1]
set xzeroaxis
set yzeroaxis
set samples 300 

set terminal gif animate optimize size 600, 240
set output "astroid3.gif"
set tics font 'Times,18'
set colorsequence classic

n = 0

#if (exist("n")==0 || n<0) n=0 #変数の初期化

while(n<=40){
  title(n) = sprintf("n = %d",n)  #タイトル名
  unset label 
  set label title(n)  font 'Times,10'  at 0.1 , 1.05 

  plot for [i=1:n] -x/abs(tan(i*pi/40)) + abs(cos(i*pi/40)) lc 2 
  n = n+1 
}

set output 


