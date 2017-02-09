import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class wave extends Applet{

   public void paint(Graphics g){
  
      double f, f0, f1, r, x, a;
      double red, blue;
      int x0, y0, x1, y1;
      int t = 0;
      x0 = 100;
      y0 = 200;
      x1 = 100;
      y1 = 400;
      a =  40;

      for(int i = 0; i < 700; i++){
        for(int j = 0; j < 500; j++){
           double r0 = Math.sqrt((i-x0)*(i-x0) + (j-y0)*(j-y0));
           double r1 = Math.sqrt((i-x1)*(i-x1) + (j-y1)*(j-y1));
             
           f0 = Math.sin(2.0 * Math.PI * (t-r0) / a);      
           f1 = Math.sin(2.0 * Math.PI * (t-r1) / a); 
 
           f = (f0+f1)/2;    
             if( f <= 0){
                red = -f;
                blue = 0;}
             else{ 
               red = 0;
               blue = f;
             }
             g.setColor(new Color((float)red, 0, (float)blue));
             g.fillRect(i, j, 1, 1);
         } 
      }
   }
}
   
 
