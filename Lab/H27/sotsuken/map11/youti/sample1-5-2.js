$(function(){

/* ---   Ê^‚Ìƒf[ƒ^“ü—Í ----  */

      ph = 1134;   // Ê^‚Ì‚‚³
      pw = 8192;   // Ê^‚Ì•
      pr = pw/ph;



   var photo = document.getElementById('photo'); 


   // img—v‘f‚ğHTL‚É’Ç‰Á
   var img;
      img = document.createElement('img');
      img.src = "youti2.jpg";  
      img.alt="KL—c’t‰€";
      img.id="panorama"; 
//      img.vspace="50";
      img.style.display = 'none';

   var img2;
      img2 = document.createElement('img');
      img2.src = "youti2.jpg";  
      img2.alt="KL—c’t‰€";
//      img2.vspace="50";
      img.id="panorama"; 
      img2.style.display = 'none';

   var img3;
      img3 = document.createElement('img');
      img3.src = "youti2.jpg";  
      img3.alt="KL—c’t‰€";
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

      console.log("width="+Math.round(3*pr*img.height)) // css‚Ì’l
      console.log("height="+img.height);  // css‚Ì’l


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
   var xl=-2100; //cssƒtƒ@ƒCƒ‹‚Ìmargin-left‚Ì’l 
  
     console.log("margin-left="+xl); // cssƒtƒ@ƒCƒ‹‚Ìmargin-left‚Ì’l 


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


