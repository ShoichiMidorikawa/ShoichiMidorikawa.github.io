/*
<applet code = "DragonG.class" width = "800" height = "600" >
</applet>
*/

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class DragonG extends Applet{

   public void init(){
      DrawCanvas dc = new DrawCanvas();
      ControlPanel cp = new ControlPanel(dc);
      setLayout(new BorderLayout());
         add(cp, "North");
         add(dc, "Center");
   }
} 


class DrawCanvas extends Canvas{
   public static int p = 11;
   public static double a0 = 90;

   public DrawCanvas(){
//      setBackground(Color.yellow);
   }

   public void paint(Graphics g){

      double h = Math.pow(2, -p/2);
      int h0 = (int)Math.pow(2, p);
      int s = 0;
      int d;
      
      double a = a0*Math.PI/180.;
      double b = Math.PI - a;
            
      double x = h;
      double y = 0;

      int x0 = 400; 
      int y0 = 200;
      g.drawLine(x0, y0, (int)(h*100)+x0, y0);

      for(int n = 1; n < h0 ;n++){
         int m = n;
         while((m%2) == 0){
            m = m/2;
         }            

         int m4 = m%4;
         if(m4 == 1){
             d = 1;
         }
         else{
             d = -1;
         }
        
         s = s + d;
           
         double x1 = x + h*Math.cos(s*b);
         double y1 = y + h*Math.sin(s*b);   

         g.drawLine((int)(x*100) + x0, (int)(y*100) + y0, 
          (int)(x1*100) + x0, (int)(y1*100) + y0);             

         x = x1;
         y = y1; 
      }  
  }
}
   

class ControlPanel extends Panel implements ActionListener{

   TextField txt0, txt1; 
   int p = 11;
   double a0 = 90;
   private DrawCanvas dc;

   GridBagLayout gb;
   GridBagConstraints gc;
 

   public ControlPanel(DrawCanvas dc ){
      this.dc = dc;
      setGUI();
   }

   public void setGUI(){
      gb = new GridBagLayout(); setLayout(gb);
      gc = new GridBagConstraints();
 
//      gc.ipadx = 10;
//      gc.ipady = 10;

      gc.fill = GridBagConstraints.BOTH;
     
      constraints(0, 0, 1, 1);
         Label lb0 = new Label("20以下の次数 p を選んでください。", Label.LEFT);
         gb.setConstraints(lb0, gc);      
         add(lb0);

      constraints(0, 1, 1, 1);
         Label lb1 = new Label("90°またはそれより少し大きい角度を選んでください。",
                                 Label.LEFT);
         gb.setConstraints(lb1, gc);
         add(lb1);

//      gc.insets = new Insets(10, 0, 10, 0);
       
      constraints(1, 0, 1, 1);
         txt0 = new TextField(" 11");
         gb.setConstraints(txt0, gc);
         add(txt0);

      constraints(1, 1, 1, 1);
         txt1 = new TextField(" 90");
         gb.setConstraints(txt1, gc);
         add(txt1);

      gc.fill = GridBagConstraints.HORIZONTAL;
 

      txt0.addActionListener(this);
      txt1.addActionListener(this);
   }

   private void constraints( int x, int y, int w, int h){
      gc.gridx = x;     gc.gridy = y;
      gc.gridwidth = w; gc.gridheight = h;
   }


   public void actionPerformed(ActionEvent e){
      if(e.getSource() == txt0){
         String str = txt0.getText().trim();
         p = Integer.parseInt(str);
      }

      if(e.getSource() == txt1){
         a0 = Double.valueOf(txt1.getText()).doubleValue();
      }
      dc.p = p;  dc.a0 =a0;
      dc.repaint();
   }
}