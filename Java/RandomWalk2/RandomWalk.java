import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

/* 
<applet code="RandomWalk" width=600 height=600>
</applet>
*/

public class RandomWalk extends Applet 
           implements ActionListener, Runnable{

   Button b = new Button("start/stop");

   Thread t = null;
   boolean flag=false;

   int n = 2000;
   int x[] = new int[n];
   int y[] = new int[n]; 


   int x0 = 300;
   int y0 = 300;

   Image img;
   Graphics bg;

   public void init(){

      for(int i = 0; i < n ; i++){  
          x[i] = x0; y[i] = y0;
      }

      b.addActionListener(this);
      add(b);

      Dimension d = getSize();
      img = createImage(d.width, d.height);

   }

   public void actionPerformed(ActionEvent ae) {
         if(flag == false){
           flag =!false; 
           t = new Thread(this);t.start();}
         else {
           flag = false; 
         }
   }

   public void run(){
      try{
         while(flag == true){
            repaint();
         }
      }
      catch(Exception e){
      }
   }

   public void stop(){
      flag = true;
   } 



   public void update(Graphics g){
      paint(g);
   }

   public void paint(Graphics g){


      if(bg == null)    
         bg = img.getGraphics();

         Dimension d = getSize();
         bg.setColor(Color.white);
         bg.fillRect(0, 0, d.width, d.height);
         bg.setColor(Color.red);
         for(int i = 0; i < n; i++){  
            bg.fillOval(x[i]-2, y[i]-2, 4, 4);
         }

         g.drawImage(img, 0, 0, this); 

         int sgnx;
         int sgny;
         
         for(int i = 0; i < n; i++){
            double rndx = Math.random();
            double rndy = Math.random();

            if(rndx >= 0.5)  sgnx = 1;
            else sgnx = -1;
            if(rndy >= 0.5)  sgny = 1;
            else sgny = -1;
            int dx = sgnx*1;
            int dy = sgny*1;     
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
         }

   }
}