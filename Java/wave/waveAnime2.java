import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code = "waveAnime2.class" width = 500 height = 500>
</applet>
*/


public class waveAnime2 extends Applet implements ItemListener, Runnable{

   int t = 0;
   Thread thr;
   Image buffer;
   Graphics bufferg;
      int lambda =  60;     // îgí∑	
      int dist = (int)(lambda/4);        // îgåπä‘ÇÃãóó£
      double pShift = Math.PI/2;       // îgåπÇÃà ëäÇÃÇ∏ÇÍ

//***********************************************************************
//   (1) dist = lambda/2,  pShift = 0
//   (2) dist = lambda/2,  pShift = Math.PI 
//   (3) dist = lambda/4,  pShift = Math.PI/2
//*********************************************************************** 

      int xsize = 500;
      int ysize = 500;    
      int x0 = (int)xsize/2;
      int y0 = (int)(xsize - dist)/2;
      int x1 = x0;
      int y1 = (int)(ysize + dist)/2;
 
   String str0 = "îgåπä‘ÇÃãóó£";
   String str1 ="à ëäÇÃÇ∏ÇÍ";
   
   Choice c1 = new Choice(); 
   Choice c2 = new Choice();

   Label lb0, lb1;

   public void init(){

      lb0 = new Label(str0);
      add(lb0);

      c1.addItem(" É… / 4");
      c1.addItem(" É… / 2");
      c1.addItem(" É… ");
      c1.addItem(" 2É… ");
      c1.addItem(" 3É… ");
      c1.addItem(" 4É… ");
      c1.select(" É… / 4");
      add(c1);
      c1.addItemListener(this);

      lb1 = new Label(str1);
      add(lb1);

      c2.addItem(" 0 ");
      c2.addItem(" ÉŒ / 2");
      c2.addItem(" ÉŒ ");
      c2.select(" ÉŒ / 2");
      add(c2);
      c2.addItemListener(this);      

      thr = new Thread(this);
      thr.start();
      Dimension d = getSize();
      buffer = createImage(d.width, d.height);
   }


   public void itemStateChanged(ItemEvent e){

      if(e.getSource() == c1){
         String s0 = c1.getSelectedItem();
            if(s0 == " É… / 4"){
               dist = lambda/4;
            }else if(s0 == " É… / 2"){
               dist = lambda/2;
            }else if(s0 == " É… "){
               dist = lambda;
            }else if(s0 == " 2É… "){
               dist = 2*lambda;
            }else if(s0 == " 3É… "){
               dist = 3*lambda;
            }else if(s0 == " 4É… "){
               dist = 4*lambda;
            }
            
//            System.out.println("dist = " + dist);   
      }

      if(e.getSource() == c2){
         String s1 = c2.getSelectedItem();
            if(s1 == " 0 "){
                pShift = 0;
            }else if(s1 == " ÉŒ / 2"){
                pShift = Math.PI/2;
            }else if(s1 == " ÉŒ "){
                pShift = Math.PI;  
            }
//            System.out.println("pShift = " + pShift);
      }
      x0 = (int)xsize/2;
      y0 = (int)(xsize - dist)/2;
      x1 = x0;
      y1 = (int)(ysize + dist)/2;
      repaint();     
   }



   public void run(){
      try{
         while(true){
            repaint();
         }
      }
      catch(Exception e){
      }
   }

   public void update(Graphics g){
      paint(g);
   }

   public void paint(Graphics g){  
      double f, f0, f1;
      double red, blue;
  
      if(bufferg == null)
         bufferg = buffer.getGraphics();
           int cell = 4;
            for(int i = 0; i <= xsize/2 ; i += cell){
               for(int j = 0; j < ysize; j += cell){
                  double r0 = Math.sqrt((i-x0)*(i-x0) + (j-y0)*(j-y0));
                  double r1 = Math.sqrt((i-x1)*(i-x1) + (j-y1)*(j-y1));
                                              
                  f0 = Math.sin(2.0 * Math.PI * (t - r0) / lambda);    // lambda : îgí∑      
                  f1 = Math.sin(2.0 * Math.PI * (t - r1) / lambda + pShift); 
                  
                  f = (f0+f1)/2;
    
                  if( f <= 0){
                     red = -f;
                     blue = 0;}
                  else{ 
                    red = 0;
                    blue = f;
                  }


                  bufferg.setColor(new Color((float)red, 0, (float)blue));
                  bufferg.fillRect(i-cell/2, j-cell/2, cell, cell);
                  bufferg.fillRect(xsize-i-cell/2, j-cell/2, cell, cell); 
               } 
            }
          bufferg.setColor(Color.white);
          bufferg.fillOval(x0-cell/2, y0-cell/2, cell, cell);
          bufferg.fillOval(x1-cell/2, y1-cell/2, cell, cell);          
   g.drawImage(buffer, 0, 0, this);
   t += 2;
   }
} 
 
