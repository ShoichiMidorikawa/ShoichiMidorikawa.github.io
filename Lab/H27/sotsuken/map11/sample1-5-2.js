$(function(){
	var mouseX;	// X���W
	var mouseY;	// Y���W

   document.body.addEventListener( "click", function( e ) {
	// �}�E�X�ʒu���擾����
	mouseX = e.pageX ;	// X���W
	mouseY = e.pageY ;	// Y���W
        console.log('mouseX='+mouseX);
        console.log('mouseY='+mouseY); 
   } ) ;


   var x2, y2;
   var photo = document.getElementById('photo'); 
   // img�v�f��HTL�ɒǉ�
   var img;
      img = document.createElement('img');
      img.src = "map50.jpg";  
      img.alt="��w�n�}";
      img.id="map"; 
      img.style.display = 'none';
 

//      img.width = 1503*1.5; 
      img.width = 2200; 
      img.height= Math.round(img.width*2148/3006);
//      img.height= 1572;

      photo.appendChild(img);


   title.innerHTML = img.alt;   
   img.style.display = 'inline';   


// mousemove�}�E�X���g���Ēn�}�𓮂���
   var xm, ym;
   var xi, yi;
   var xf, yf; 
   var xd, yd;
   var xl=-720;  //css��margin-left 
   var yl=-510;  //css��margin-top
   var xe= img.width-700; //css�̒l���� 
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
  
//     $("dd#start").html("x2="+x2+"<br>"
//                       +"y2="+y2+"<br>");


//�N���b�N�����_�̕\��
      if(x2>1574 && x2<1599 && y2>1083 && y2<1105) 
        location.href="http://www.aomori-u.ac.jp";
//�����N�̒����Ă���ꏊ���J��
     if(x2>1210 && x2<1228 && y2>1089 && y2<1107)  //�s���e�B
	        location.href="panorama/ListP.html";

	if(x2>1220 && x2<1238 && y2>1066 && y2<1084)  //�x�e��
	        location.href="kyukeisitu/ListP.html";

	if(x2>1318 && x2<1337 && y2>1071 && y2<1089)�@//����E�X�e�[�W
	        location.href="nakaniwa_stage/ListP.html";
   
	if(x2>1394 && x2<1410 && y2>1088 && y2<1103)�@//����E�K�i��
	        location.href="nakaniwa_ue/ListP.html";

	if(x2>1219 && x2<1236 && y2>1104 && y2<1121)�@//����E�s���e�B�߂�
	        location.href="nakaniwa_3tika/ListP.html"; 

	if(x2>1315 && x2<1332 && y2>1145 && y2<1160)�@//����E�U���ً߂�
	        location.href="nakaniwa_6tika/ListP.html"; 

	if(x2>1646 && x2<1670 && y2>1194 && y2<1216)�@//�}�b�N�X�o�����[
	        location.href="max/ListP.html"; 
  
	if(x2>1206 && x2<1223 && y2>675 && y2<690)�@//���
	        location.href="koban/ListP.html"; 

	if(x2>1113 && x2<1130 && y2>1096 && y2<1111)�@//�T���ّO
	        location.href="5gou/ListP.html"; 

	if(x2>1139 && x2<1155 && y2>1074 && y2<1089)�@//�H����
	        location.href="syokudo/ListP.html"; 

	if(x2>1175 && x2<1191 && y2>1073 && y2<1088)�@//�H����
	        location.href="syokuyoko/ListP.html"; 

	if(x2>1032 && x2<1049 && y2>1132 && y2<1146)�@//���̈��
	        location.href="1tai/ListP.html"; 

	if(x2>1500 && x2<1516 && y2>1086 && y2<1101)�@//������
	        location.href="syotoku/ListP.html"; 

	if(x2>1180 && x2<1196 && y2>914 && y2<930)�@//�w���ۏo�����
	        location.href="gakuseika/ListP.html";


	if(x2>1116 && x2<1134 && y2>969 && y2<985)�@//���֏�
	        location.href="tyurin/ListP.html";

	if(x2>1106 && x2<1127 && y2>877 && y2<895)�@//����
	        location.href="seimon/ListP.html";

	if(x2>1543 && x2<1562 && y2>1164 && y2<1179)�@//����
	        location.href="uramon/ListP.html";

	if(x2>1211 && x2<1231 && y2>1262 && y2<1279)�@//�E���p���ԏ�
	        location.href="syokutyu/ListP.html";

	if(x2>914 && x2<932 && y2>1142 && y2<1160)�@//�����_superman
	        location.href="superman/ListP.html"; 

	if(x2>1182 && x2<1201 && y2>353 && y2<369)�@//�K�����w�Z
	        location.href="koubata/ListP.html"; 

	if(x2>956 && x2<973 && y2>1171 && y2<1186)�@//�ӂ��ӂ�
	        location.href="meet/ListP.html"; 

	if(x2>902 && x2<920 && y2>1098 && y2<1114)�@//�~�j�X�g�b�v
	        location.href="mini/ListP.html"; 

	if(x2>1039 && x2<1058 && y2>752 && y2<769)�@//�c�t��
	        location.href="youti/ListP.html"; 

	if(x2>1428 && x2<1447 && y2>1446 && y2<1464)�@//�X�֋�
	        location.href="yubin/ListP.html"; 




    });


});



