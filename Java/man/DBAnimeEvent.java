//  DBAnimeEvent.java　
//  写真をマウスでぐるぐる回す。
//  double buffering使用　ちらつき無し

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
<applet code="DBAnimeEvent.class" width=440 height=380>
</applet>
*/

public class DBAnimeEvent extends Applet implements Runnable {
  Image im[] = new Image[24];
  Image buffer;
  Graphics bufferg;
  Thread kick;
  int i,j = 0;
  MediaTracker mt;
  double xp, yp;
  double x, y;
  double dx;
  int n, s;
  int k = 12;
 
  public void init() {
    mt = new MediaTracker(this);

    for (i = 0; i < im.length; i++){
     im[i] = getImage(getDocumentBase(), "manimg/man24_"+i+".jpg");
     mt.addImage(im[i],0);
    }
      kick = new Thread(this);
      kick.start();

      Dimension d = getSize();
      buffer = createImage(d.width, d.height);
  }


  public void run() {


   addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent e){
         xp = e.getX();
         yp = e.getY();
      }
   });


   addMouseMotionListener(new MouseMotionAdapter(){
      public void mouseDragged(MouseEvent e){
         x = e.getX();
         y = e.getY();
         dx = x-xp;
         n = (int)(dx/10);

         n = n+s;
         if(n > 0){
           s = Math.abs(n%im.length);
           repaint();
         }  
         else {
          s = im.length - 1 + n%im.length; 
         repaint();
         }

      }
   });     

  }


  public void update(Graphics g){
    paint(g);
  }


  public void paint(Graphics g) {
     
     if(bufferg == null)
       bufferg = buffer.getGraphics();
     bufferg.drawImage(im[s], 10, 10, this);
     g.drawImage(buffer, 10, 10, this);

   }
}