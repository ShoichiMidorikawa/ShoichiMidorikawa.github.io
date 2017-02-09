import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*
<applet code="Weierstrass" width=800 height=600>
</applet>
*/


public class Weierstrass extends Applet implements ActionListener{

   TextField tfa, tfb, tf1, tf2;

    double a=0.5;
    double b=2;

    double x_m=1.0;
    int n=0; 

   public void init(){

      Label lb_a = new  Label("a =");
      Label lb_b = new Label("   b =");
      Label lb1 =  new Label("   N =");
      Label lb2 =  new Label("   x_max =");

      tfa = new TextField(2);
      tfa.setText("0.5"); 
      tfb = new TextField(2);
      tfb.setText("2");
      
      tf1 = new TextField(2);
      tf1.setText("0");

      tf2 = new TextField(5);
      tf2.setText("1.0");
      
      tfa.addActionListener(this);
      tfb.addActionListener(this);
      tf1.addActionListener(this);
      tf2.addActionListener(this);

      add(lb_a);
      add(tfa);
      add(lb_b);
      add(tfb);
      add(lb1);
      add(tf1);
      add(lb2);
      add(tf2);
   }


   public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == tfa){
         String str = ae.getActionCommand();
	 a = Double.valueOf(str).doubleValue();
      }
      if(ae.getSource() == tfb){
         String str = ae.getActionCommand();
	 b = Double.valueOf(str).doubleValue();
      }
      if(ae.getSource() == tf1){
         String str = ae.getActionCommand();
	 n = Integer.valueOf(str).intValue();
      }
      if(ae.getSource() == tf2){
         String str = ae.getActionCommand();
	 x_m = Double.valueOf(str).doubleValue();
      }
      repaint();
   }

    public void paint(Graphics g){
      // é≤Çï`âÊÇ∑ÇÈ
      g.setColor(Color.lightGray);
      int x0 = 50;
      int y0 = 50;
      int width = 701;
      int height = 400;
      g.drawRect(x0, y0, width - 1, height - 1);
      g.drawLine(x0, y0+height/2, x0+width, y0+height/2);
      g.drawLine(x0+width/2, y0, x0+width/2, y0+height - 1);

      g.setColor(Color.black);
      String str0 = String.valueOf(-x_m);
      String str1 = String.valueOf(x_m);
      g.drawString(str0, x0-10, y0+height+20);
      g.drawString("0", x0+width/2-3, y0+height+20);
      g.drawString(str1, x0+width-7, y0+height+20);

      // îgå`Çï`âÊÇ∑ÇÈ
      g.setColor(Color.blue);
      double dx = 2.0*x_m/width;
      double x = - 1.0*x_m;
      int h = height;
     

      // f(x)ÇÃç≈ëÂílÇåvéZÇ∑ÇÈÅBÅ@y_MAX = (1.-a^{n+1})/(1.-a)
      double s=1.;
      for(int i=0; i<=n; i++) 
         s*=a;

      double mx=(1.0-s)/(1.-a);
      System.out.println(mx);

      x = - 1.0*x_m;
      for(int i = 0 ; i < width - 1; i++){
         double f1 = W.func(a, b, n, x);
   	 double f2 = W.func(a, b, n, x+dx);
   	 int v1 = (int)(h*f1/2/mx);
         int v2 = (int)(h*f2/2/mx);
         g.drawLine(i+x0, -v1+h/2+y0, i + 1+x0, -v2+h/2+y0);
         x += dx;
      }
      

      double y_m = ((int)(mx*10+0.5))/10.;
      g.setColor(Color.black);
      String str2 = String.valueOf(-y_m);
      String str3 = String.valueOf(y_m);
      g.drawString(str2, x0-28, y0+height+5);
      g.drawString("0", x0-23, y0+height/2+5);
      g.drawString(str3, x0-28, y0+5);


   }


}


class W{
   double x;
      public static double func(double a, double b, int n, double x){ 
         double y = 0;
         double a0=1;
	 double b0=1;
         int i;
	 for(i=0; i <= n; i++){
            y += a0*Math.cos(b0*Math.PI*x);
            a0 *= a;
            b0 *= b;
          }
         return y;
      }
}		

