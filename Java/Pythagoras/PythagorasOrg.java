import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="Pythagoras" width=800 height=600>
</applet>
*/

public class Pythagoras extends Applet implements ActionListener, Runnable{

   int i;

   Thread t;
   Image buffer;
   Graphics bufferg;
   boolean flag = false;

   public void init(){

      Button b = new Button("start/stop");
      b.addActionListener(this);
      add(b);

      t = new Thread(this);
      t.start();

      Dimension d = getSize();
      buffer = createImage(d.width, d.height);

   }

   public void actionPerformed(ActionEvent ae) {
      Button bt = (Button)ae.getSource();
      String st = bt.getLabel();
      if(flag == false)
	t.resume();
       else
        t.suspend();
        flag = !flag;
   }

     public void start() {
                 if (t == null) {
   		     t = new Thread(this);
		     t.start();                    
	         }
	}

        public void stop() {
	         if (t != null) {
                     t.stop();
                     t = null;
                 }
	}




   public void run(){


	  while(true){
	    if(flag == false){
                 repaint();
                 t.suspend();
	    }  	 
            else
                i++;
                if(1 == 140) i = 1;
                try{
                   t.sleep(300);
                }	       
             catch(InterruptedException e){}
                 repaint();
             }    


   }

   public void update(Graphics g){
      paint(g);
   }
 

   public void paint(Graphics g){
      int n = 3, nq=4;
      int xt[] = new int[3]; int yt[] = new int[3];
      int xt1[] = new int[3]; int yt1[] = new int[3];
      int xt2[] = new int[3]; int yt2[] = new int[3];
      int xt3[] = new int[3]; int yt3[] = new int[3];
      int xa[] = new int[4]; int ya[] = new int[4];
      int xb[] = new int[4]; int yb[] = new int[4];
      int xc[] = new int[4]; int yc[] = new int[4];
      int xe[] = new int[4]; int ye[] = new int[4];

      int xf[] = new int[3]; int yf[] = new int[3];
      int xg[] = new int[3]; int yg[] = new int[3];
      int xh[] = new int[3]; int yh[] = new int[3];

      int xbt[] = new int[4]; int ybt[] = new int[4];
      int xct[] = new int[4]; int yct[] = new int[4];


      int x0 = 200, y0 = 200;
      int x1 = 350, y1 = 260;
      xt[0] = x0; yt[0] = y0;
      xt[1] = x0; yt[1] = y1;
      xt[2] = x1; yt[2] = y1;


      int xd = x1 - x0, yd = y1 - y0;  
      xa[0] = x0;        ya[0] = y0;
      xa[1] = x1;        ya[1] = y1;
      xa[2] = xa[1] + yd;   ya[2] = ya[1] - xd;
      xa[3] = xa[2] - xd; ya[3] = ya[2] - yd;

      xb[0] = xt[1]  ;    yb[0] = yt[1];
      xb[1] = xt[1]  ;    yb[1] = yb[0] + xd;
      xb[2] = xt[1] + xd; yb[2] = yb[1];
      xb[3] = xt[2]  ;    yb[3] = yt[2];

      xc[0] = xt[1]  ;    yc[0] = yt[1];
      xc[1] = xt[0]  ;    yc[1] = yt[0];
      xc[2] = xt[0] - yd; yc[2] = yc[1];
      xc[3] = xc[2]  ;    yc[3] = yt[1];

      xt1[0] = xa[1]   ; yt1[0] = ya[1];
      xt1[1] = xa[2]   ; yt1[1] = ya[1];
      xt1[2] = xa[2]   ; yt1[2] = ya[2];

      xt2[0] = xa[2]   ; yt2[0] = ya[2];
      xt2[1] = xa[2]   ; yt2[1] = ya[3];
      xt2[2] = xa[3]   ; yt2[2] = ya[3];

      xt3[0] = xa[3]   ; yt3[0] = ya[3];
      xt3[1] = xa[0]   ; yt3[1] = ya[3];
      xt3[2] = xa[0]   ; yt3[2] = ya[0];


      xe[0] = xt[1]  ;    ye[0] = yt[1];
      xe[1] = xa[2]  ;    ye[1] = ya[1];
      xe[2] = xa[2]  ;    ye[2] = ya[3];
      xe[3] = xa[0]  ;    ye[3] = ya[3];

      xf[0] = xt2[0] - yd ;    yf[0] = yt2[0] + xd;
      xf[1] = xt2[1] - yd ;    yf[1] = yt2[1] + xd;
      xf[2] = xt2[2] - yd ;    yf[2] = yt2[2] + xd;

      xg[0] = xt1[0]  ;    yg[0] = yt1[0] - yd;
      xg[1] = xt1[1]  ;    yg[1] = yt1[1] - yd;
      xg[2] = xt1[2]  ;    yg[2] = yt1[2] - yd;

      xh[0] = xt3[0] + xd ;    yh[0] = yt3[0] ;
      xh[1] = xt3[1] + xd ;    yh[1] = yt3[1] ;
      xh[2] = xt3[2] + xd ;    yh[2] = yt3[2] ;


      xbt[0] = xb[0]  ;    ybt[0] = yb[0] - xd - yd;
      xbt[1] = xb[1]  ;    ybt[1] = yb[1] - xd - yd;
      xbt[2] = xb[2]  ;    ybt[2] = yb[2] - xd - yd;
      xbt[3] = xb[3]  ;    ybt[3] = yb[3] - xd - yd;

      xct[0] = xc[0] + xd + yd ;    yct[0] = yc[0];
      xct[1] = xc[1] + xd + yd ;    yct[1] = yc[1];
      xct[2] = xc[2] + xd + yd ;    yct[2] = yc[2];
      xct[3] = xc[3] + xd + yd ;    yct[3] = yc[3];


      if(bufferg == null)
         bufferg = buffer.getGraphics();
         
         Dimension d = getSize();
         bufferg.setColor(Color.white);
         bufferg.fillRect(0, 0, d.width, d.height);


         bufferg.setColor(Color.green);
         bufferg.fillPolygon(xa, ya, 4);  //斜辺の四角形

         bufferg.setColor(Color.red);
         bufferg.fillPolygon(xb, yb, 4);  //底辺の四角形

         bufferg.setColor(Color.orange);
         bufferg.fillPolygon(xc, yc, 4);  //高さの四角形


         bufferg.setColor(Color.blue);
         bufferg.fillPolygon(xt, yt, 3);    //三角形


         if(i>=20&&i<=40){
            bufferg.setColor(Color.blue);
            bufferg.fillPolygon(xt1, yt1, 3);  //三角形
            bufferg.fillPolygon(xt2, yt2, 3);  //三角形
            bufferg.fillPolygon(xt3, yt3, 3);  //三角形
         }

         if(i>=40){
            bufferg.setColor(Color.green);
            bufferg.fillPolygon(xe, ye, 4);  //大きな四角形
	    bufferg.setColor(Color.blue);
            bufferg.fillPolygon(xt, yt, 3);    //三角形
            bufferg.fillPolygon(xf, yf, 3);    //三角形
            if(i<=60){
               bufferg.fillPolygon(xt1, yt1, 3);  //三角形
            }
            if(i<=80){
               bufferg.fillPolygon(xt3, yt3, 3);  //三角形
            }
         }

         if(i>=61){
	    bufferg.setColor(Color.blue);
            bufferg.fillPolygon(xg, yg, 3);    //三角形
         }


         if(i>=81){
	    bufferg.setColor(Color.blue);
            bufferg.fillPolygon(xh, yh, 3);    //三角形
         }


	 if(i>=100){
            bufferg.setColor(Color.white);
            bufferg.fillPolygon(xb, yb, 4);  //底辺の四角形
            bufferg.setColor(Color.red);
            bufferg.fillPolygon(xbt, ybt, 4);  //底辺の四角形
	 }


	 if(i>=120){
            bufferg.setColor(Color.white);
            bufferg.fillPolygon(xc, yc, 4);  //底辺の四角形
            bufferg.setColor(Color.orange);
            bufferg.fillPolygon(xct, yct, 4);  //高さの四角形
	 }


        g.drawImage(buffer, 0, 0, this);

         i+=5;


   }
}
 
