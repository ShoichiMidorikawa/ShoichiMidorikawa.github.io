onload= function(){
  var sl=document.getElementById('sel1');
  var image=document.getElementById('image');


  var bgm=document.getElementById('bgm');  
  var b=document.getElementsByTagName('button'); 

  var n =0;
  b[0].onclick = function(){
      console.log('click');
      if (n%2==0){
         console.log('n=0');
         b[0].style.color='black';
         b[0].innerHTML='BGM ON';
         bgm.src="" ;
         n=n+1;
      }
      else if(n==1){
          console.log('n=1');
         b[0].style.color='red';
         b[0].innerHTML='BGM OFF';
         bgm.src="https://www.youtube.com/embed/1oeTz_zocC0?rel=0&autoplay=1&loop=1&playlist=ZYeC7ErV9Oc" ;
         document.body.style.backgroundImage = "url(back1_5.JPG)";
         n=2;
      }
      else if(n==3){
          console.log('n=3');
         b[0].style.color='red';
         b[0].innerHTML='BGM OFF';
         bgm.src="https://www.youtube.com/embed/M46YflO-Q9k?rel=0&autoplay=1&loop=1&playlist=M46YflO-Q9k" ;
         document.body.style.backgroundImage = "url(1.jpg)";
         n=4;
      }
      else if(n==5){
          console.log('n=5');
         b[0].style.color='red';
         b[0].innerHTML='BGM OFF';
         bgm.src="https://www.youtube.com/embed/pKHf2y2p41k?rel=0&autoplay=1&loop=1&playlist=pKHf2y2p41k" ;
         document.body.style.backgroundImage = "url(back1_4.jpg)";
         n=0;
      }
  }


sl.onchange = function(){
  var selectedItem = this.options[this.selectedIndex];
  image.width="600";
  image.height="390";

  console.log('test');
    switch (selectedItem.value){
       case '0':image.width="0";image.height="0";
                image.src="back1_4.jpg"    ;break;
       case '1':image.src="../../HTMLtutorial/AodaiPV-ver01.mp4"    ;break;
       case '2':image.src="../../HTMLtutorial/AodaiPV-ver02.1.mp4"  ;break;
       case '3': image.src="https://youtu.be/t5-CBQRCH1c" ;break;
       
  }
 }
};


//<iframe width="854" height="480" src="https://www.youtube.com/embed/ZYeC7ErV9Oc" frameborder="0" 
//gesture="media" allowfullscreen></iframe>


//<iframe width="854" height="480" src="https://www.youtube.com/embed/pBEZCRrtVFk" frameborder="0" 
//gesture="media" allowfullscreen></iframe>

//<iframe width="854" height="480" src="https://www.youtube.com/embed/M46YflO-Q9k" frameborder="0" 
//gesture="media" allowfullscreen></iframe>
