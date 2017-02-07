$(function(){

/* ---   写真のデータ入力 ----  */

      ph = 1177;   // 写真の高さ
      pw = 8191;   // 写真の幅
      pr = pw/ph;



   var photo = document.getElementById('photo'); 


   // img要素をHTLに追加
   var img;
      img = document.createElement('img');
      img.src = "SEIMON.jpg";  
      img.alt="正門前";
      img.id="panorama"; 
//      img.vspace="50";
      img.style.display = 'none';

   var img2;
      img2 = document.createElement('img');
      img2.src = "SEIMON.jpg";  
      img2.alt="正門前";
//      img2.vspace="50";
      img.id="panorama"; 
      img2.style.display = 'none';

   var img3;
      img3 = document.createElement('img');
      img3.src = "SEIMON.jpg";  
      img3.alt="正門前";
//      img3.vspace="50";
      img.id="panorama"; 
      img3.style.display = 'none';


      img.height = 350;
      img.width = Math.round(img.height*pr); 

      img2.height = 350;
      img2.width = Math.round(img.height*pr); 

      img3.height = 350;
      img3.width = Math.round(img.height*pr); 


      plm = 3*pr*img.height-600;  // left-margin

      console.log("width="+Math.round(3*pr*img.height)) // cssの値
      console.log("height="+img.height);  // cssの値


      photo.appendChild(img);

      photo.appendChild(img2);

      photo.appendChild(img3);


   title.innerHTML = img.alt;   
   img.style.display = 'inline';   

   title.innerHTML = img2.alt;   
   img2.style.display = 'inline';   

   title.innerHTML = img3.alt;   
   img3.style.display = 'inline';   



// mousemove
   var xm, ym;
   var xi, yi;
   var xf, yf; 
   var xd;
   var xl;
   var xl=-2100; //cssファイルのmargin-leftの値 
  
     console.log("margin-left="+xl); // cssファイルのmargin-leftの値 


     $("#photo").mousedown(function(e){
        console.log("mouse down");
        xi=e.clientX;
        yi=e.clientY;  
     });
   

    $("#photo").mouseup(function(evt){
        console.log("mouse up");
       xf=evt.clientX;
       yf=evt.clientY;
       xd =xf-xi;
       xl +=xd;
       if(xl<-plm) xl=-plm; 
       if(xl>0) xl=0;
       console.log("xl="+xl);
       $("p:not(:animated)").animate({
           "margin-left": xl
       },"slow", "swing");
    });




});


