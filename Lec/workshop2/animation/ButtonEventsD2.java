// ButtonEventsD2.java
// start ボタンを押すとアニメーションがスタートする。

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="ButtonEventsD2" width=600 height=600>
 </applet>
*/


public class ButtonEventsD2 extends Applet implements ActionListener, Runnable {
    private static final long serialVersionUID = 1L;

        int i = 0;
        int n = 0;
        int j = 0; 
        int k = 0;
        Image im[] = new Image[21];
        Image buffer;
	Thread t = null;
        boolean flag = false;
        MediaTracker mt = new MediaTracker(this);
        Graphics bufferg;

        Button b = new Button();

        Label label;
 
   public void init() {

     for (i = 0; i < im.length; i++){
       im[i] = getImage(getDocumentBase(), "RDSimages/output"+i+".JPG");
       mt.addImage(im[i],0);
     }

      b.addActionListener(this);
      add(b);

      buffer = createImage(600, 600);

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
	 b.setLabel(" START ");                    
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
            b.setLabel(" STOP ");  
            k++;
            if((k % im.length) == 0) j++;
            if(j%2 == 0) n = (k % im.length);
            else n = im.length - (k % im.length) - 1 ;
            try{
               if(n == 0 || n == 20) t.sleep(100);
                  t.sleep(50);
                     
               if(flag==false){ 
                  synchronized(this){
                     while (flag)
                        wait();
                        b.setLabel(" RESUME ");  
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
      g.drawImage(im[n], 0, 40, this);
   }

}

