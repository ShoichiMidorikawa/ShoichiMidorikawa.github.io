$(function(){
	var mouseX;	// X座標
	var mouseY;	// Y座標

   document.body.addEventListener( "click", function( e ) {
	// マウス位置を取得する
	mouseX = e.pageX ;	// X座標
	mouseY = e.pageY ;	// Y座標
        console.log('mouseX='+mouseX);
        console.log('mouseY='+mouseY); 
   } ) ;


   var x2, y2;
   var photo = document.getElementById('photo'); 
   // img要素をHTLに追加
   var img;
      img = document.createElement('img');
      img.src = "map50.jpg";  
      img.alt="大学地図";
      img.id="map"; 
      img.style.display = 'none';
 

//      img.width = 1503*1.5; 
      img.width = 2200; 
      img.height= Math.round(img.width*2148/3006);
//      img.height= 1572;

      photo.appendChild(img);


   title.innerHTML = img.alt;   
   img.style.display = 'inline';   


// mousemoveマウスを使って地図を動かす
   var xm, ym;
   var xi, yi;
   var xf, yf; 
   var xd, yd;
   var xl=-720;  //cssのmargin-left 
   var yl=-510;  //cssのmargin-top
   var xe= img.width-700; //cssの値から 
   var ye= img.height-500;
     $("#photo").mousedown(function(e){
//        console.log("mouse down");
        xi=e.clientX;
        yi=e.clientY;  
     });
   

    $("#photo").mouseup(function(evt){
//        console.log("mouse up");
       xf=evt.clientX;
       yf=evt.clientY;
       xd =xf-xi;
       yd =yf-yi;
       xl +=xd;
       yl +=yd;
       if(xl<-xe) xl=-xe;
       if(yl<-ye) yl=-ye; 
       if(xl>0) xl=0;
       if(yl>0) yl=0;


//       console.log("xl="+xl);
//       console.log("yl="+yl);
       $("p:not(:animated)").animate({
           "margin-left": xl,
           "margin-top" : yl
       },"slow", "swing");
      
      x2=xf-xl;      
      y2=mouseY-yl;
//      y2=yf-yl;
  
     $("dd#start").html("x2="+x2+"<br>"
                       +"y2="+y2+"<br>");


//クリックした点の表示
      if(x2>1574 && x2<1599 && y2>1083 && y2<1105) 
        location.href="http://www.aomori-u.ac.jp";
//リンクの張ってある場所を開く
     if(x2>1210 && x2<1228 && y2>1089 && y2<1107)  //ピロティ
	        location.href="panorama/ListP.html";

	if(x2>1220 && x2<1238 && y2>1066 && y2<1084)  //休憩室
	        location.href="kyukeisitu/ListP.html";

	if(x2>1318 && x2<1337 && y2>1071 && y2<1089)　//中庭・ステージ
	        location.href="nakaniwa_stage/ListP.html";
   
	if(x2>1394 && x2<1410 && y2>1088 && y2<1103)　//中庭・階段上
	        location.href="nakaniwa_ue/ListP.html";

	if(x2>1260 && x2<1280 && y2>1065 && y2<1122)　//中庭・ピロティ近く
	        location.href="nakaniwa_3tika/ListP.html"; 

	if(x2>1315 && x2<1330 && y2>1145 && y2<1160)　//中庭・６号館近く
	        location.href="nakaniwa_6tika/ListP.html"; 

	if(x2>1646 && x2<1670 && y2>1194 && y2<1216)　//マックスバリュー
	        location.href="max/ListP.html"; 
  
	if(x2>1206 && x2<1223 && y2>675 && y2<690)　//交番
	        location.href="koban/ListP.html"; 

	if(x2>1113 && x2<1130 && y2>1096 && y2<1111)　//５号館前
	        location.href="5gou/ListP.html"; 

	if(x2>1139 && x2<1155 && y2>1074 && y2<1089)　//食堂内
	        location.href="syokudo/ListP.html"; 

	if(x2>1175 && x2<1191 && y2>1073 && y2<1088)　//食堂横
	        location.href="syokuyoko/ListP.html"; 

	if(x2>1032 && x2<1049 && y2>1132 && y2<1146)　//第一体育館
	        location.href="1tai/ListP.html"; 

	if(x2>1500 && x2<1516 && y2>1086 && y2<1101)　//正徳館
	        location.href="syotoku/ListP.html"; 

	if(x2>1180 && x2<1196 && y2>914 && y2<930)　//学生課出入り口
	        location.href="gakuseika/ListP.html";


	if(x2>1116 && x2<1134 && y2>969 && y2<985)　//駐輪場
	        location.href="tyurin/ListP.html";

	if(x2>1106 && x2<1127 && y2>877 && y2<895)　//正門
	        location.href="seimon/ListP.html";

	if(x2>1543 && x2<1562 && y2>1164 && y2<1179)　//裏門
	        location.href="uramon/ListP.html";

	if(x2>1211 && x2<1231 && y2>1262 && y2<1279)　//職員用駐車場
	        location.href="syokutyu/ListP.html";

	if(x2>914 && x2<932 && y2>1142 && y2<1160)　//交差点superman
	        location.href="superman/ListP.html"; 

	if(x2>1182 && x2<1201 && y2>353 && y2<369)　//幸畑小学校
	        location.href="koubata/ListP.html"; 

	if(x2>956 && x2<973 && y2>1171 && y2<1186)　//ふくふく
	        location.href="meet/ListP.html"; 

	if(x2>902 && x2<920 && y2>1098 && y2<1114)　//ミニストップ
	        location.href="mini/ListP.html"; 

	if(x2>1039 && x2<1058 && y2>752 && y2<769)　//幼稚園
	        location.href="youti/ListP.html"; 

	if(x2>1428 && x2<1447 && y2>1446 && y2<1464)　//郵便局
	        location.href="yubin/ListP.html"; 




    });


});



