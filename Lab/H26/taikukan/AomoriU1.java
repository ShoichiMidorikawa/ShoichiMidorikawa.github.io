//  DBAnimeEvent.java　
//  写真をマウスでぐるぐる回す。
//  double buffering使用　ちらつき無し
//  回転操作の改良　2014/5/13 


import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
<applet code="AomoriU1.class" width=666 height=500>
</applet>
*/

public class AomoriU1 extends Applet implements Runnable {
  Image im[] = new Image[26]; //写真の枚数
  Image buffer;
  Graphics bufferg;
  Thread kick;
  int i,j = 0;
  MediaTracker mt;
  double xp, yp;
  double x, y;
  double dx;
  int n, s;

   double z=0.0;
 
  public void init() {
    mt = new MediaTracker(this);

    s=1;

    for (i = 1; i < im.length; i++){
     im[i] = getImage(getDocumentBase(), "taikukann/26_"+i+".jpg"); //写真の読み込み
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

         z+= 0.125;
//         System.out.println("z="+z);
       if(z>1){
         if(x>xp)
            n=1;
         else 
            n=-1;

         n = n+s;
         if(n > 0){
           s = Math.abs(n%im.length);
           repaint();
         }  
         else {
          s = im.length - 1 + n%im.length; 
         repaint();
         }
         z=0.0;
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

//     System.out.println("s="+s+",  n="+n);
      
     g.drawImage(buffer, 10, 10, this);

   }
}