      var n=0; 
      function display_eq(){
         if(n%2 == 0){ 
            document.getElementById("MyEquation").innerHTML=
　　　  '$$ f_{(x)}=2(x-p)(x-q)-(x-r)^2とおく。 $$'+
            '$$ p＜q＜rより、 $$'+
            '$$ f_{(p)}=-(p-r)^2＜0,　f_{(q)}=-(q-r)^2＜0,　f_{(r)}=2(r-p)(r-q)＞0 $$'+
　　　  '$$ f_{(x)}は下に凸のグラフであるため、pより小さい値で、f_{(\\alpha)}=0となる\\alphaが存在する。 $$'+
            '$$ さらに、q＜rで、f_{(q)}＜0,　f_{(r)}＞0より、q＜\\beta＜rでf_{(\\beta)}=0となる\\betaが存在する。 $$'+
            '$$ 以上より、解答は　１　\\alpha＜p＜q＜\\beta＜r $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n+=1;
         }else{
            document.getElementById("MyEquation").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n+=1;
         } 
      }; 

    var n2=0;  
      function display_eq2(){
         if(n2%2 == 0){ 
            document.getElementById("MyEquation2").innerHTML=
　　　  '$$ \\sin\\theta+\\cos\\theta=\\frac{1}{2}より、\\sin\\theta=\\frac{1}{2}-\\cos\\thetaとなる。 $$'+
        '$$ \\sin\\theta=\\frac{1}{2}-\\cos\\theta$$'+
　　　  '$$ \\sin^2\\theta=\\left(\\frac{1}{2}-\\cos\\theta\\right)^2 $$'+
        '$$ \\sin^2\\theta=1-\\cos^2\\thetaより、 $$'+
　　　  '$$ 1-\\cos^2\\theta=\\left(\\frac{1}{2}-\\cos\\theta\\right)^2 $$'+
        '$$ \\cos\\theta=xとおくと、1-x^2=\\left(\\frac{1}{2}-x\\right)^2 $$'+
        '$$ 1-x^2=\\frac{1}{4}-x+x^2 $$'+
        '$$ 2x^2-x-\\frac{3}{4}=0 $$'+
        '$$ 8x^2-4x-3=0 $$'+
　　　  '$$ これを解の公式を用いて解くと、 $$'+
        '$$ x=\\frac{1\\pm\\sqrt{7}}{4} $$'+
        '$$ \\sin\\theta=\\frac{1}{2}-\\cos\\theta＞0より、 $$'+
        '$$ \\frac{1}{2}＞\\cos\\thetaとなるので、 $$'+
        '$$ x=\\frac{1-\\sqrt{7}}{4} $$'+
        '$$ 以上より、解答は　２　\\frac{1-\\sqrt{7}}{4} $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n2+=1;
         }else{
            document.getElementById("MyEquation2").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n2+=1;
         } 
};

  var n3=0;  
      function display_eq3(){
         if(n3%2 == 0){ 
            document.getElementById("MyEquation3").innerHTML=
            '$$ 10個のデータをa、b、c、d、e、f、g、h、i、jとする。 $$'+
            '$$ 平均値4、標準偏差2のデータをa、b、c、d、e、平均値8、標準偏差4のデータをf、g、h、i、jとする。 $$'+
            '$$ 10個のデータの平均をx、分散をsとすると、 $$'+
            '$$ s^2=\\frac{1}{10} \\{(a-x)^2 +(b-x)^2+・・・+(j-x)^2\\} $$'+
            '$$ s^2=\\frac{1}{10} \\{a^2+b^2+・・・j^2 -2(a+b・・・+j)x+10(x)^2\\} $$'+
            '$$ a、b、c、d、eは平均4より合計20、f、g、h、i、jは平均8より合計40となる。 $$'+
            '$$ よってデータ全体の平均は、 $$'+
            '$$ x=\\frac{1}{10}(20+40)=6 $$'+
            '$$ a、b、c、d、eの標準偏差は2より、 $$'+
            '$$ 2^2=\\frac{1}{5}\\{(a-4)^2+(b-4)^2+(c-4)^2+(d-4)^2+(e-4)^2\\} $$'+
            '$$ 4=\\frac{1}{5}\\{a^2+b^2+c^2+d^2+e^2-2(5・4)・4+5・4^2\\} $$'+
            '$$ a^2+b^2+c^2+d^2+e^2=100 $$'+
            '$$ 同様にf、g、h、i、j の標準偏差は４より、$$'+
            '$$ 4^2=\\frac{1}{5}\\{(f-8)^2+(g-8)^2+(h-8)^2+(i-8)^2+(j-8)^2\\} $$'+
            '$$ 16=\\frac{1}{5}\\{f^2+g^2+h^2+i^2+j^2-2(5・8)・8+5・8^2\\} $$'+
            '$$ f^2+g^2+h^2+i^2+j^2=400 $$'+
            '$$ よってa^2+b^2+c^2+d^2+e^2+f^2+g^2+h^2+i^2+j^2=500 $$'+
            '$$ 以上より $$'+
            '$$ s^2=\\frac{1}{10}(500-2・60・6+10・6^2)=14 $$'+
            '$$ よって解答は４　14 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n3+=1;
         }else{
            document.getElementById("MyEquation3").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n3+=1;
         } 
};


  var n4=0;  
      function display_eq4(){
         if(n4%2 == 0){ 
            document.getElementById("MyEquation4").innerHTML=
　　　  '$$ 3の倍数と5の倍数が少なくとも1つずつでれば15の倍数になる。 $$'+
            '$$ これを余事象を使って考える。 $$'+
            '$$ 3の倍数がでないときは1、2、4、5の4つの目がでるので、確率は $$'+
            '$$ \\frac{4^3}{6^3} =\\frac{64}{216}$$'+
            '$$ 5の倍数がでないときは1、2、3、4、6の5つの目がでるので、確率は $$'+
            '$$ \\frac{5^3}{6^3}=\\frac{125}{216} $$'+
            '$$ 3の倍数も5の倍数もでないときは1、2、4の3つの目がでるので、確率は $$'+
            '$$ \\frac{3^3}{6^3}=\\frac{27}{216} $$'+
            '$$ よって求める確率は $$'+
            '$$ 1-\\frac{64}{216}-\\frac{125}{216}+\\frac{27}{216}=\\frac{54}{216}=\\frac{1}{4} $$'+
            '$$ 以上より、解答は　２　\\frac{1}{4}　 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n4+=1;
         }else{
            document.getElementById("MyEquation4").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n4+=1;
         } 
};

  var n5=0;  
      function display_eq5(){
         if(n5%2 == 0){ 
            document.getElementById("MyEquation5").innerHTML=
            '$$ 接する点を(x,y)とおくと、点A(1,3)を通り、円x^2+y^2=5に第2象限で接する直線の傾きは、 $$'+
            '$$ \\frac{y-3}{x-1}で表すことができる。 $$'+
            '$$ 円の中心である原点(0,0)から接する点(x,y)に伸びる直線の傾きは、 $$'+
            '$$ \\frac{y}{x}で表すことができる。 $$'+
            '$$ この2つの直線は接する点で直角に交わるので、 $$'+
            '$$ \\left(\\frac{y-3}{x-1}\\right)・\\left(\\frac{y}{x}\\right)=-1で表すことができる。 $$'+
            '$$ y(y-3)=-x(x-1) $$'+
            '$$ y^2-3y=-x^2+x $$'+
            '$$ x^2+y^2=x+3y $$'+
            '$$ x^2+y^2=5より、 $$'+
            '$$ x+3y=5 $$'+
            '$$ x=-3y+5 $$'+
            '$$ 円x^2+y^2=5より $$'+
            '$$ (-3y+5)^2+y^2=5 $$'+
            '$$ 9y^2-30y+25+y^2=5 $$'+
            '$$ 10y^2-30y+20=0 $$'+
            '$$ 両辺を10で割り $$'+
            '$$ y^2-3y+2=0 $$'+
            '$$ (y-1)(y-2) $$'+
            '$$ y=1,2 $$'+
            '$$ y=1の場合x+3y=5の式に代入して $$'+
            '$$ x+3=5 $$'+
            '$$ x=2 $$'+
            '$$ y=2の場合x+3y=5の式に代入して $$'+
            '$$ x+6=5 $$'+
            '$$ x=-1 $$'+
            '$$ この条件を満たすのは　１　-x+2y=5 $$'+
            '$$  $$'+
            '$$ 別解１　 $$'+
            '$$ (1,3)を通る直線の方程式は、傾きをaとおくと、 $$'+
            '$$ y-3=a(x-1)で表すことができる。 $$'+
            '$$ y-3=ax-a $$'+
            '$$ ax-y-(a-3)=0 $$'+
            '$$ この直線と原点(0,0)の距離dは $$'+
            '$$ d=\\frac{|a-3|}{\\sqrt{a^2+(-1)^2}}=\\sqrt{5} $$'+
            '$$ \\frac{(a-3)^2}{a^2+1}=5 $$'+
            '$$ (a-3)^2=5(a^2+1) $$'+
            '$$ a^2-6a+9=5a^2+5 $$'+
            '$$ 4a^2+6a-4=0 $$'+
            '$$ 2a^2+3a-2=0 $$'+
            '$$ (2a-1)(a+2)=0 $$'+
            '$$ a=\\frac{1}{2},-2 $$'+
            '$$ 第2象限で接するので、傾きはa＞0となる。 $$'+
            '$$ よって、a=\\frac{1}{2} $$'+
            '$$ y-3=\\frac{1}{2}(x-1) $$'+
            '$$ 2y-6=x-1 $$'+
            '$$ -x+2y=5 $$'+
            '$$ よって解答は、　１　-x+2y=5 $$'+
            '$$  $$'+
            '$$ 別解２ $$'+
            '$$ (1,3)を通る直線の方程式は、傾きをaとおくと、 $$'+
            '$$ y-3=a(x-1)で表すことができる。 $$'+
            '$$ y-3=ax-a $$'+
            '$$ y=ax-(a-3) $$'+
            '$$ この直線の式を、円x^2+y^2=5の式に代入して、 $$'+
            '$$ x^2+\\left\\{ax-(a-3)\\right\\}^2 $$'+
            '$$ x^2+a^2x^2-2a(a-3)x+(a-3)^2-5=0 $$'+
            '$$ (a^2+1)x^2-2a(a-3)x+\\left\\{(a-3)^2-5\\right\\}=0 $$'+
            '$$ 接するとき判別式D=0となるので、 $$'+
            '$$ \\frac{D}{4}=4a^2(a-3)^2-4(a^2-1)・\\left\\{(a-3)^2-5\\right\\}=0 $$'+
            '$$ D=a^2(a-3)^2-a^2(a-3)^2+5a^2-(a-3)^2+5=0 $$'+
            '$$ D=5a^2-a^2+6a-9+5=0 $$'+
            '$$ D=4a^2+6a-4=0 $$'+
            '$$ D=2a^2+3a-2=0 $$'+
            '$$ (2a-1)(a+2)=0 $$'+
            '$$ a=\\frac{1}{2},-2 $$'+
            '$$ 第2象限で接するので、傾きはa＞0となる。 $$'+
            '$$ よって、a=\\frac{1}{2} $$'+
            '$$ y-3=\\frac{1}{2}(x-1) $$'+
            '$$ 2y-6=x-1 $$'+
            '$$ -x+2y=5 $$'+
            '$$ よって解答は、　１　-x+2y=5 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n5+=1;
         }else{
            document.getElementById("MyEquation5").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n5+=1;
         } 
};

  var n6=0;  
      function display_eq6(){
         if(n6%2 == 0){ 
            document.getElementById("MyEquation6").innerHTML=
　　　  '$$ 直線AIは\\angle{BAC}を２等分するから、\\frac{AB}{AC}=\\frac{BD}{DC} $$'+
            '$$ 直線AIは\\angle{ABD}を２等分するから、\\frac{AI}{ID}=\\frac{BA}{BD} $$'+
　　　  '$$ AB=5、BC=10、CA=8、DC=BC-BD=10-BDより、 $$'+
            '$$ \\frac{5}{8}=\\frac{BD}{10-BD} $$'+    
　　　  '$$ BD=\\frac{50}{13} $$'+
　　　  '$$ \\frac{AI}{ID}=\\frac{BA}{BD}=\\frac{5}{\\frac{50}{13}}=\\frac{13}{10} $$'+      
            '$$ 以上より、解答は　３　\\frac{13}{10}  $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n6+=1;
         }else{
            document.getElementById("MyEquation6").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n6+=1;
         } 
};

 var n7=0;  
      function display_eq7(){
         if(n7%2 == 0){ 
            document.getElementById("MyEquation7").innerHTML=
            '$$ 積の末尾に0が付くのは10をかけた時、2×5が出てきたとき、 $$'+
            '$$ よって2と5の組み合わせが何回出てくるのかを求める。 $$'+
            '$$  2は登場回数が多いので、5の登場回数を求める。$$'+
            '$$  5の倍数　100÷5=20 $$'+
            '$$  25の倍数ではもう1つ5が出てくるので、 $$'+
            '$$  25の倍数　100÷25=4 $$'+
            '$$  合計24回$$'+
            '$$  以上から、2と5の組み合わせは24回できるので、$$'+
            '$$  解答は４　24 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n7+=1;
         }else{
            document.getElementById("MyEquation7").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n7+=1;
         } 
};

 var n8=0;  
      function display_eq8(){
         if(n8%2 == 0){ 
            document.getElementById("MyEquation8").innerHTML=
　　　  '$$ 三角関数の合成より、 $$'+
            '$$ \\sqrt{3}\\sin\\frac{\\pi}{12}+\\cos\\frac{\\pi}{12}=2\\sin\\frac{\\pi}{4}=2\\times\\frac{\\sqrt{2}}{2}=\\sqrt{2} $$'+
            '$$ よって、解答は　３　\\sqrt{2} $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n8+=1;
         }else{
            document.getElementById("MyEquation8").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n8+=1;
         } 
};

 var n9=0;  
      function display_eq9(){
         if(n9%2 == 0){ 
            document.getElementById("MyEquation9").innerHTML=
　　　  '$$ \\triangle{OAB}の面積Sはベクトル表示すると、S=\\frac{1}{2}\\sqrt{|\\overrightarrow{a}|^2|\\overrightarrow{b}|^2-(\\overrightarrow{a}\\cdot\\overrightarrow{b})^2}で求められるので、 $$'+
            '$$ |\\overrightarrow{a}+\\overrightarrow{b}|=|{a}|^2+2\\overrightarrow{a}\\cdot\\overrightarrow{b}+|{b}|^2=7^2より、\\overrightarrow{a}\\cdot\\overrightarrow{b}=4であるから $$'+
            '$$ S=\\frac{1}{2}\\sqrt{4^2\\cdot5^2-4^2 }=4\\sqrt{6} 　よって解答は２　4\\sqrt{6}$$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n9+=1;
         }else{
            document.getElementById("MyEquation9").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n9+=1;
         } 
};

 var n10=0;  
      function display_eq10(){
         if(n10%2 == 0){ 
            document.getElementById("MyEquation10").innerHTML=
　　　  '$$ y = x^x とおく。 $$'+
            '$$ 両辺の対数を取って $$'+
            '$$ \\log y=x\\log x $$'+
            '$$ 両辺をxで微分して $$'+
            '$$ \\frac{1}{y} \\cdot \\frac{dy}{dx}=\\log x+1 $$'+
            '$$ \\frac{dy}{dx}=y(\\log x+1) $$'+
            '$$ \\frac{dy}{dx}=x^x(\\log x+1) $$'+
            '$$ よって解答は４　x^x(\\log x+1) $$'+
            '$$  $$'+
　　　  '$$ 別解 $$'+
            '$$ x=e^{\\log x}と表すことができるので、 $$'+
            '$$ x^x=e^{x\\log x} $$'+
            '$$ \\left(x^x\\right)’=\\left(e^{x\\log x}\\right)’ $$'+
            '$$ \\left(x^x\\right)’=(x\\log x)’e^{x\\log x} $$'+
            '$$ (x\\log x)’=x・\\frac{1}{x}+1・\\log x=1+\\log xと表すことができるので、 $$'+
            '$$ \\left(x^x\\right)’=(\\log x +1)e^{x\\log x} $$'+
            '$$ \\left(x^x\\right)’=x^x(\\log x +1) $$'+

            '$$ よって解答は４　x^x(\\log x+1) $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n10+=1;
         }else{
            document.getElementById("MyEquation10").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n10+=1;
         } 
};

 var n11=0;  
      function display_eq11(){
         if(n11%2 == 0){ 
            document.getElementById("MyEquation11").innerHTML=
　　　  '$$  花子さんの発表内容は2点(0,0)、(7,1120)を通っていて、比例の式で表せるので正しい。$$'+
            '$$  桜子さんの発表内容はグラフで示されているので、正しい。$$'+
            '$$  梅子さんの発表内容は原点(0,0)を通るという比例の式の条件を満たしていない。よって比例の式にならないので誤り。$$'+
　　　  '$$  薫子さんの発表内容はコンビニエンスストアで買い物しているところが、平らなので、正しい。$$'+
            '$$  よって誤っているのは梅子さんだけなので　３　梅子さん$$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n11+=1;
         }else{
            document.getElementById("MyEquation11").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n11+=1;
         } 
};

 var n12=0;  
      function display_eq12(){
         if(n12%2 == 0){ 
            document.getElementById("MyEquation12").innerHTML=
        '$$ 未知の数量をxとおくことで、太郎さんがコンビニエンスストアを出発した時刻を求めていきたい。 $$'+
　　　  '$$ 走った距離と歩いた距離の合計は5000ｍであるから、既知の数量であるので、ふさわしくない。 $$'+
　　　  '$$ よって解答は　２ $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n12+=1;
         }else{
            document.getElementById("MyEquation12").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n12+=1;
         } 
};

 var n13=0;  
      function display_eq13(){
         if(n13%2 == 0){ 
            document.getElementById("MyEquation13").innerHTML=
            '$$ 走った時間をx分と歩いた時間y分とすると、コンビニエンスストアの買い物時間の7分を加えた移動時間は $$'+
            '$$ x+y+7=60 と表すことができる。$$'+
            '$$ 太郎さんの走っているときは毎分160ｍ、歩いているときは毎分40ｍであるから、 $$'+
            '$$ 160x+40y=5000 と表すことができる。 $$'+
            '$$ この2つの式の連立方程式を解くと、 $$'+
            '$$ (x,y)=(24,29)  $$'+
            '$$ この解は問題にあっている。 $$'+
            '$$ よって解答は３　9時31分 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n13+=1;
         }else{
            document.getElementById("MyEquation13").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n13+=1;
         } 
};

 var n14=0;  
      function display_eq14(){
         if(n14%2 == 0){ 
            document.getElementById("MyEquation14").innerHTML=
        ' <img src = "img6.jpg" width="350" height="500">'+
　　　  '$$ 1は、2\\alpha+2\\beta=\\piであるから、\\alpha+\\beta=\\frac{\\pi}{2}より、 PQ⊥ORである。 $$'+
            '$$ 2は、1と同様に\\alpha+\\beta=\\frac{\\pi}{2}より、\\triangle OPQは直角三角形である。 $$'+
            '$$ 3は、OP+QOの値は一定ではない。 $$'+
            '$$ 4は、PQはPA+QBで表せるので合っている。 $$'+
            '$$ 5は、3つの対応する角がすべて等しいので、\\triangle{AOP} ∽ \\triangle{BQO}となっている。 $$'+
            '$$ よって解答は３ $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n14+=1;
         }else{
            document.getElementById("MyEquation14").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n14+=1;
         } 
};

 var n15=0;  
      function display_eq15(){
         if(n15%2 == 0){ 
            document.getElementById("MyEquation15").innerHTML=
            '$$ 線分EFが最大値となるのは、線分PQが最大値をとるときなので、PQの最大値を求めていく。 $$'+
            '$$ 線分PQが最大値をとるのは、点Pまたは点Qが点Dまたは点Cから伸びているときより、 $$'+
            '$$ PR、QR=7となるときである。 $$'+
            '$$ PR=7の場合を考える。 $$'+
            '$$ \\tan\\alpha=\\frac{3}{PR}、\\tan\\beta=\\frac{3}{QR}と表すと、 $$'+
            '$$ PQ=PR+RQより、 $$'+
            '$$ PQ=\\frac{3}{\\tan\\alpha}+\\frac{3}{\\tan\\beta} $$'+
            '$$ PQ=3\\left(\\frac{1}{\\tan\\alpha}+\\frac{1}{\\tan\\beta}\\right) $$'+
            '$$ \\frac{1}{\\tan\\beta}=\\frac{1}{\\tan\\left(\\frac{\\pi}{2}-\\alpha\\right)}=\\tan\\alphaより、 $$'+
            '$$ PQ=3\\left(\\frac{1}{\\tan\\alpha}+\\tan\\alpha\\right) $$'+
            '$$ AP=7,OA=3より、\\tan\\alpha=\\frac{3}{7}と表すことができるので、 $$'+
            '$$ PQ=3\\left(\\frac{7}{3}+\\frac{3}{7}\\right) $$'+
            '$$ PQ=\\frac{58}{7} $$'+
            '$$ 中点連結定理より、線分EFは線分PQの\\frac{1}{2}の長さなので、 $$'+
            '$$ EF=\\frac{29}{7} $$'+
            '$$ よって解答は２　\\frac{29}{7} $$'+
　　　　　  '$$  $$'+
            '$$ 別解 $$'+
　　　  '$$ AP=xとする。対称なので、半円Oの半径は3、AD=7より、3≦x≦7として考える。 $$'+
            '$$ \\triangle{AOP} ∽ \\triangle{BQO}より、AP:AO=BO:BQ $$'+
　　　  '$$ よってx:3＝3:BQより、BQ=\\frac{9}{x} $$'+
            '$$ 線分EFが最大値をとるとき、線分PQの長さも最大値をとることから、線分PQの最大値を考える。 $$'+
            '$$ 点Pから線分BCに垂線を下ろし、その交点をHとすると、HQ＝x-\\frac{9}{x} $$'+
            '$$ 三平方の定理より、PQ^2=PH^2+HQ^2 $$'+
            '$$ PH=6より、PHは一定である。PQが最大値をとるときは、HQが最大値をとるときである。 $$'+
            '$$ x=7で、HQが最大より、PQの値は、 $$'+
            '$$ PQ=PA+QB=7+\\frac{9}{7}=\\frac{58}{7} $$'+
            '$$ \\triangle{POB} ∽ \\triangle{EOF}、PO:EO=2:1より、EF＝\\frac{1}{2}PQ=\\frac{29}{7} $$'+
            '$$ よって解答は２　\\frac{29}{7} $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n15+=1;
         }else{
            document.getElementById("MyEquation15").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n15+=1;
         } 
};

 var n16=0;  
      function display_eq16(){
         if(n16%2 == 0){ 
            document.getElementById("MyEquation16").innerHTML=
　　　  '$$ 線分PQが長方形ABCDの面積を二等分するときは、台形ABQPの面積が長方形ABCDの面積の半分のときである。 $$'+
            '$$ (2)より、AP=x、BQ=\\frac{9}{x}とすると、台形ABQPの面積は、 $$'+
            '$$ \\left(x+\\frac{9}{x}・6・\\frac{1}{2}=21 \\right) $$'+
            '$$ x+\\frac{9}{x}=7より、x^2-7x+9=0 $$'+
            '$$ 解の公式を使って解くと、x=\\frac{7\\pm \\sqrt{13}}{2} $$'+
            '$$ よって解答は１　\\frac{7\\pm \\sqrt{13}}{2}  $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n16+=1;
         }else{
            document.getElementById("MyEquation16").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n16+=1;
         } 
};

 var n17=0;  
      function display_eq17(){
         if(n17%2 == 0){ 
            document.getElementById("MyEquation17").innerHTML=
            '$$ (1)　3つの方程式の範囲を図示すると１になる $$'+
            '$$ (2)　x=1のとき、\\log_2 1、2^1=2より、格子点は、(x,y)=(1,0)、(1,1)、(1,2)の3個ある。 $$'+
            '$$ (3)　底2は1より、大きいから、\\log_2 2＜\\log_2 3＜\\log_2 4、つまり、1＜\\log_2 3＜2となる。 $$'+
            '$$ よってm=1となる。 $$'+ 
            '$$ x=1のとき、2^3=8である。また1＜\\log_2 3＜2より、格子点の数は8-1=7である。 $$'+
            '$$ (4)　\\log_2 nが整数かどうか、nが2の累乗数かどうかで場合分けして調べる。 $$'+
            '$$ (ⅰ)　nが2の累乗数であるとき、 $$'+
            '$$ x＞0、y≦2^xで、直線x=n上にある格子点の個数は、2^n個である。 $$'+
            '$$ x＞0、y＜\\log_2 xで、直線x=n上にある格子点の個数は、log_2 n-1個である。 $$'+
            '$$ 以上より、領域D内にあって、x=n上にある格子点の個数は、2^n-log_2 n-1個である。 $$'+
            '$$ (ⅱ)　(ⅰ)でないとき、 $$'+
            '$$ x＞0、y≦2^xで、直線x=n上にある格子点の個数は、2^n個である。 $$'+
            '$$ x＞0、y＜\\log_2 xで、直線x=n上にある格子点の個数は、log_2 n個である。 $$'+
            '$$ 以上より、領域D内にあって、x=n上にある格子点の個数は、2^n-log_2 n個である。 $$'+
　　　　　　'$$ (5)　1から31までの自然数のうち、2の累乗数は1、2、4、8、16の5つある。 $$'+
            '$$ 領域Dないにあって、1≦x≦31にある格子点の個数は、 $$'+
            '$$ \\sum_{k=1}^{31}(2^k -[\\log_2 k])+1・5 $$'+
　　　　　　'$$ =2・\\frac{2^{31} -1}{2-1}-([\\log_2 1][\\log_2 2]+・・・+[\\log_2 31])+5 $$'+
            '$$ =2^{32}-2-(0+1・2+2・4+3・8+4・16)+5=2^{32}-95 $$'+
            '$$ よって解答は、(1)a　１  　(2)ア　３  　(3)イ　１　ウ　７ $$'+
　　　　　　'$$ (4)b　３　c　１　d　２  　(5)エ　３　オ　２　カ　９　キ　５ $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n17+=1;
         }else{
            document.getElementById("MyEquation17").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n17+=1;
         } 
};

 var n18=0;  
      function display_eq18(){
         if(n18%2 == 0){ 
            document.getElementById("MyEquation18").innerHTML=
            '$$ 領域Dは2≦x≦3、0≦y≦3より、領域Dをx軸の周りを1回転してできる円柱は、 $$'+
            '$$ 半径3-0=3、高さ3-2=1である。 $$'+
            '$$ yz平面で考え、ｌは中心(0,0)、半径3の円の内部にあって、z軸と平行な線分の長さになる。 $$'+
            '$$ 中心(0,0)、半径3の円の方程式はz^2+y^2=9であるから、 $$'+
            '$$ z^2+t^2=9より、z=\\pm \\sqrt{9-t^2} $$'+
            '$$ よってｌの長さは、2\\sqrt{9-t^2} $$'+
            '$$ 三平方の定理より、r^2=3^2+(\\sqrt{9-t^2})^2=18-t^2 $$'+
            '$$ 面積S_{(t)}は、半円rの円の面積から、半径2の円の面積を除いた部分である。 $$'+
            '$$ よって、S_{(t)}=r^2\\pi-4\\pi=(18-t^2)\\pi-4\\pi=(14-t^2)\\pi $$'+
            '$$ これより体積Vは、 $$'+
            '$$ V=\\int_{-3}^3 (14-t^2)\\pi dt=\\pi\\left[14t- \\frac{1}{3} t^3 \\right]_{-3}^3 $$'+
            '$$ \\{(14・3-9)-(-14・3+9)\\}\\pi=66\\pi $$'+
            '$$ よって解答は、２８　3　　２９　1　　３０　2　　３１　9　　３２　0　 $$'+
            '$$ ３３　1　　３４　8　　３５　0　　３６　1　　３７　4　　３８　0　　３９　6　　４０　6 $$';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n18+=1;
         }else{
            document.getElementById("MyEquation18").innerHTML='  ';
            MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            n18+=1;
         } 
};
