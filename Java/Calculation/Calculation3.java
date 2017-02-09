// Calculation3.java
// ÇQÇ¬ÇÃêîÇÃélë•ââéZ

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

/*
<applet code = "Calculation3" width = 500 height = 300>
</applet>
*/

public class Calculation3 extends Applet implements ActionListener{
  
  Font f0  = new Font("Courier", Font.PLAIN, 22);
  Font f  = new Font("Courier", Font.PLAIN, 28);
  Font ft = new Font("Serif",Font.BOLD, 32);
 
  TextField ta, tf0, tf1;
  TextField tr0, tr1; 

  ActionEvent ae;

  String pm ="";
  String plus = " + ";
  String minus = " - "; 
  String times = " Å~ ";
  String divide = " ÅÄ ";

  String eq = "=";
  int ans, tai, xi, yi;
  double x, y, rand, rand0;

  Label l0, l1, l2;

  Label la, lb, lc;
  String sa = "ê¨ê— : ";
  String sb = "ìæì_";
  String sc = "é∏ì_";

  int n = 0;

  int right = 0;
  int error;

  boolean bool = false;

  Panel pn = new Panel();
  Panel pc = new Panel();

  public void init(){

    setLayout(new BorderLayout(0,20)); 


    la = new Label(sa); la.setFont(f0);
    lb = new Label(sb); lb.setFont(f0);
    lc = new Label(sc); lc.setFont(f0);   

    tr0 = new TextField(2);
    tr0.setEditable(false);

    tr1 = new TextField(2);
    tr1.setEditable(false);

    pn.add(la); pn.add(lb); pn.add(tr0); pn.add(lc); pn.add(tr1);

    add(pn, "South");

    l2 = new Label(eq);

    tf0 = new TextField(7);
    tf0.setEditable(false);


    ta = new TextField(3);
    ta.addActionListener(this);


    tf0.setFont(f);
    l2.setFont(f);
    ta.setFont(f);

    pc.add(tf0); pc.add(l2); pc.add(ta);
    add(pc, "North");   

    tr0.setFont(f);
    tr1.setFont(f);

        tr0.setText(" 0");
        tr1.setText(" 0");


       rand0 = Math.random();
       if( rand0 > 0.5){
           x = 100*Math.random();
           y = 100*Math.random();

           xi = (int)Math.floor(x);
           yi = (int)Math.floor(y); 

           rand = Math.random();
 
           if(rand > 0.5){
              pm = plus; 
              ans = xi + yi;
           } else {
              pm = minus;
              ans = xi - yi;
           }

      }
      else{
           yi =0;
           while(yi == 0){ 
              y = 10*Math.random();
              yi = (int)Math.floor(y); 
           }   

           rand = Math.random();
           if(rand > 0.5){
              pm = times; 
              x = 100*Math.random();
              xi = (int)Math.floor(x);
              ans = xi * yi;
           } else {
              pm = divide;
              ans = (int)Math.floor(100*Math.random());
              xi = yi*ans;
           }
      }  

      String sxi = Integer.toString(xi);
      String syi = Integer.toString(yi);

      tf0.setText(" " + sxi + pm + syi); 

   }


  public void actionPerformed(ActionEvent ae){ 
     if(ae.getSource() == ta ){      // adder
        String sta = ta.getText(); 
        tai = Integer.valueOf(sta).intValue();
         
        if(ans == tai){
           right++;
           bool = true;
        }
        else if(ans != tai){   
           error++;        
           bool = false;
        }

       rand0 = Math.random();
       if( rand0 > 0.5){
         
           x = 100*Math.random();
           y = 100*Math.random();
       
           xi = (int)Math.floor(x);
           yi = (int)Math.floor(y); 
         
           rand = Math.random();
 
           if(rand > 0.5){ 
              pm = plus; 
              ans = xi + yi;
           } else {
              pm = minus;
              ans = xi - yi;
           }  
      }
      else{
           yi = 0;
           while(yi == 0){ 
              y = 10*Math.random();
              yi = (int)Math.floor(y); 
           }   
           rand = Math.random();
           if(rand > 0.5){
              pm = times; 
              x = 100*Math.random();
              xi = (int)Math.floor(x);
              ans = xi * yi;
           } else {
              pm = divide;
              ans = (int)Math.floor(100*Math.random());
              xi = yi*ans;
           }
      }  
         
         String sxi = Integer.toString(xi);
         String syi = Integer.toString(yi);

         String sright = Integer.toString(right);
         String serror = Integer.toString(error);
 
      
        tr0.setText(" " + sright);
        tr1.setText(" " + serror);
            
        tf0.setText(" " + sxi + pm + syi); 
        ta.setText("");  
      
        n++;        
        repaint();
     }
  }


  public void paint(Graphics g){
     g.setFont(ft);
           if( n == 0){
           }  
           else if(bool == true){
              g.setColor(Color.blue);
              g.drawString("ê≥âÇ≈Ç∑ÅI", 170, 150);
              g.setColor(Color.black);
           }
           else{ 
              g.setColor(Color.red);
              g.drawString("écîOÅAä‘à·Ç¢ÅI" , 170, 150);
              g.setColor(Color.black); 
           } 

         String sn = Integer.toString(n); 
  } 
}
