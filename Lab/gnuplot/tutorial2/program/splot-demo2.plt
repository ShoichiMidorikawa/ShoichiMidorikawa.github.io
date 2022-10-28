reset
#set terminal postscript portrait
#set output "splot-demo.ps"

set nokey
set view equal xy
set hidden3d offset 0
set isosamples 80
set contour  
set nosurface
set view 0,0,1,1
set cntrparam levels discrete 0
set xrange[-0.5:2]
set yrange[-1.25:1.25]

splot 4*(x**2+y**2-2*x)**2+(x**2-y**2)*(x-1)*(2*x-3), 0


