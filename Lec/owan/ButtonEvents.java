// ButtonEventsD2.java
// start/stop ボタンを押すとアニメーションがスタート、停止する。

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="ButtonEvents" width=400 height=400>
 </applet>
*/


public class ButtonEvents extends Applet implements ActionListener, Runnable {
    private static final long serialVersionUID = 1L;


        int i = 0;
        int n = 0;
        int j = 0; 
        int k = 0;
        Image im[] = new Image[62];
        Image buffer;
	Thread t = null;
        boolean flag = false;
        MediaTracker mt = new MediaTracker(this);
        Graphics bufferg;

   Label label;
 
   public void init() {

     for (i = 0; i < im.length; i++){
       im[i] = getImage(getDocumentBase(), "owanimages/output"+i+".JPG");
       mt.addImage(im[i],0);
     }


      Button b3 = new Button("start/stop");
      b3.addActionListener(this);
      add(b3);

      buffer = createImage(400, 400);

   }



    public synchronized void actionPerformed(ActionEvent ae) {

         flag = !flag;
         if(flag == true)
	 notify();
    }    


     public void start() {
          if (t == null) {
   	      t = new Thread(this);
	      t.start();                    
          }
     }

     public void stop() {
          if (t != null) {
              t = null;
          }
     }

     public void run(){

          while(true){
	       if(flag == false){
                   repaint();
  	       }  	 
               else{
                    k++;
                    if((k % im.length) == 0) j++;
                    if(j%2 == 0) n = (k % im.length);
                    else n = im.length - (k % im.length) - 1 ;
                    try{
                         if(n == 0 || n == 61) t.sleep(1000);
                         t.sleep(50);
                     
                         if(flag==false){
                              synchronized(this){
                                   while (flag)
                                   wait();
                              }
                         }  
                    } 
                    catch(InterruptedException e){}
                    repaint();
               }    
         }
     }

     public void update(Graphics g){
	  paint(g);
     }

     public void paint(Graphics g) {

	if(bufferg == null)
	    bufferg =buffer.getGraphics();
            Dimension d = getSize();
            bufferg.setColor(Color.white);
            g.drawImage(im[n], 10, 40, this);
     }

}

