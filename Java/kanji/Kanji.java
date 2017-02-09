// Kanji.java
// 

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

/*
<applet code = "Kanji" width = 560 height = 300>
</applet>
*/

public class Kanji extends Applet implements ActionListener{
  
  Font f0  = new Font("Courier", Font.PLAIN, 22);
  Font f1  = new Font("Courier", Font.PLAIN, 16);
  Font f  = new Font("Courier", Font.PLAIN, 28);
  Font ft = new Font("Serif",Font.BOLD, 32);
 
  TextField ta, tf0, tf1;
  TextField tr0, tr1; 

  ActionEvent ae;

  double x, y, rand, rand0;

  Label l0, l1, l2;
  String s0 = "nšŒP";
  String s1 = "“Ç‚İ(‚Ğ‚ç‚ª‚È)";
  String prob1, prob2, ans1, ans2;

  Label la, lb, lc;
  String sa = "¬Ñ : ";
  String sb = "“¾“_";
  String sc = "¸“_";

  int m = 60;
  int n =  0;

  int right = 0;
  int error;

  boolean bool = false;

  Panel pn = new Panel();
  Panel pc = new Panel();

  int ansi, tai;

  String array[][] = new String [m][2];

  public void init(){
   
      array[0][0] = "Œö‘·÷";      array[0][1] ="‚¢‚¿‚å‚¤";
      array[1][0] = "—˜Y‰Ô";      array[1][1] = "‚¨‚İ‚È‚¦‚µ";
      array[2][0] = "•S“úg";        array[2][1] = "‚³‚é‚·‚×‚è";
      array[3][0] = "œŒÆ";        array[3][1] = "‚­‚í‚¢";
      array[4][0] = "‹S“”";        array[4][1] = "‚Ù‚¨‚¸‚«";
      array[5][0] = "•Z’";        array[5][1] = "‚Ä‚ñ‚Æ‚¤‚Ş‚µ";
      array[6][0] = "ŒÓ“";        array[6][1] = "‚­‚é‚İ";
      array[7][0] = "‘P’m’¹";      array[7][1] = "‚¤‚Æ‚¤";
      array[8][0] = "ŒÓèöq";      array[8][1] = "‚®‚İ";
      array[9][0] = "åtåm";        array[9][1] = "‚İ‚İ‚¸";
      array[10][0] = "–P—œ";       array[10][1] = "‚Ï‚¢‚È‚Á‚Õ‚é";
      array[11][0] = "G“";       array[11][1] = "‚ [‚à‚ñ‚Ç";
      array[12][0] = "ŠÃÔ";       array[12][1] = "‚Î‚È‚È";
      array[13][0] = "–³‰Ô‰Ê";     array[13][1] = "‚¢‚¿‚¶‚­";
      array[14][0] = "ç…”B";       array[14][1] = "‚ç‚Á‚«‚å‚¤";
      array[15][0] = "”òå›";       array[15][1] = "‚Î‚Á‚½";
      array[16][0] = "åŠå ";       array[16][1] = "‚©‚°‚ë‚¤";
      array[17][0] = "’wå";       array[17][1] = "‚­‚à";
      array[18][0] = "äåäè";       array[18][1] = "‚±‚ñ‚É‚á‚­";
      array[19][0] = "ŠC‘l";       array[19][1] = "‚È‚Ü‚±";
      array[20][0] = "•Sã";       array[20][1] = "‚à‚¸";      
      array[21][0] = "‡—z‰Ô";     array[21][1] = "‚ ‚¶‚³‚¢";
      array[22][0] = "–œõ‰Ê";     array[22][1] = "‚Ï‚Ï‚¢‚ ";
      array[23][0] = "Œü“úˆ¨";     array[23][1] = "‚Ğ‚Ü‚í‚è";
      array[24][0] = "—‚w";       array[24][1] = "‚ ‚·‚È‚ë";
      array[25][0] = "H÷";       array[25][1] = "‚±‚·‚à‚·";
      array[26][0] = "ŸEŸG";       array[26][1] = "‚ê‚à‚ñ";
      array[27][0] = "ŠC•^";       array[27][1] = "‚ ‚´‚ç‚µ";
      array[28][0] = "ŠCé†";       array[28][1] = "‚ ‚µ‚©";
      array[29][0] = "ŠC“Ø";       array[29][1] = "‚¢‚é‚©";
      array[30][0] = "êŒ‘l";       array[30][1] = "‚¢‚½‚¿";
      array[31][0] = "‰Í”n";       array[31][1] = "‚©‚Î";
      array[32][0] = "“y—³";       array[32][1] = "‚à‚®‚ç";
      array[33][0] = "épék";       array[33][1] = "‚ç‚­‚¾";
      array[34][0] = "é€”n";       array[34][1] = "‚ç‚Î";
      array[35][0] = "ŒI‘l";       array[35][1] = "‚è‚·";
      array[36][0] = "é†”n";       array[36][1] = "‚ë‚Î";
      array[37][0] = "“é­";       array[37][1] = "‚Æ‚È‚©‚¢";
      array[38][0] = "ŠCÛ";       array[38][1] = "‚¹‚¢‚¤‚¿";
      array[39][0] = "êi—Ù";       array[39][1] = "‚«‚è‚ñ";
      array[40][0] = "ã·—r";       array[40][1] = "‚©‚à‚µ‚©";
      array[41][0] = "åå•";       array[41][1] = "‚±‚¤‚à‚è";
      array[42][0] = "å’å";       array[42][1] = "‚Æ‚©‚°";
      array[43][0] = "H“‹›";     array[43][1] = "‚³‚ñ‚Ü";
      array[44][0] = "–ö—t‹›";     array[44][1] = "‚µ‚µ‚á‚à";
      array[45][0] = "“m•ƒ‹›";     array[45][1] = "‚©‚¶‚©";
      array[46][0] = "ŒÕ‹›";       array[46][1] = "‚¨‚±‚º";
      array[47][0] = "–|Ô‹›";     array[47][1] = "‚Ü‚ñ‚Ú‚¤";
      array[48][0] = "‰Í“Ø";       array[48][1] = "‚Ó‚®";
      array[49][0] = "‰ÆŠ›";       array[49][1] = "‚ ‚Ğ‚é";
      array[50][0] = "•s”@‹A";     array[50][1] = "‚Ù‚Æ‚Æ‚¬‚·";
      array[51][0] = "‰_";       array[51][1] = "‚Ğ‚Î‚è"; 
      array[52][0] = "M“V‰¥";     array[52][1] = "‚ ‚Ù‚¤‚Ç‚è"; 
      array[53][0] = "ê_šF";       array[53][1] = "‚¢‚ñ‚±"; 
      array[54][0] = "–Ø“p";       array[54][1] = "‚İ‚İ‚¸‚­"; 
      array[55][0] = "–¸’¹";       array[55][1] = "‚Ş‚­‚Ç‚è"; 
      array[56][0] = "ŒRŒ{";       array[56][1] = "‚µ‚á‚à"; 
      array[57][0] = "éë";       array[57][1] = "‚Æ‚«"; 
      array[58][0] = "ék’¹";       array[58][1] = "‚¾‚¿‚å‚¤"; 
      array[59][0] = "å—‹";       array[59][1] = "‚©‚½‚Â‚Ş‚è"; 


    setLayout(new BorderLayout(0,20)); 


    la = new Label(sa); la.setFont(f0); //  ¬Ñ(•¶š)
    lb = new Label(sb); lb.setFont(f0); //  “¾“_(•¶š)
    lc = new Label(sc); lc.setFont(f0); //  ¸“_(•¶š) 

    tr0 = new TextField(4);   // “¾“_(”š)
    tr0.setEditable(false);

    tr1 = new TextField(4);   // ¸“_(”š)
    tr1.setEditable(false);

//  ¬ÑF“¾“_F¸“_@‚Ì•\¦  
    pn.add(la); pn.add(lb); pn.add(tr0); pn.add(lc); pn.add(tr1);
    add(pn, "South");


    l0 = new Label(s0); l0.setFont(f0);
    l1 = new Label(s1); l1.setFont(f0);

    double rand;
    rand = Math.random();
    int ri = (int)Math.floor(m*Math.random());
    
    prob1 = array[ri][0];

    tf0 = new TextField(6);   // Š¿š–â‘è—“
    tf0.setEditable(false);
    tf0.setText(prob1);

    ta = new TextField(10);    // ‰ğ“š—“@@*****
    ta.addActionListener(this);
    ans1 = array[ri][1];

    System.out.println(ans1);

    tf0.setFont(f);
    ta.setFont(f1);
 
    pc.add(l0);
    pc.add(tf0);
    pc.add(l1); 
    pc.add(ta);
    add(pc, "North");   

    tr0.setFont(f);
    tr1.setFont(f);

        tr0.setText(" 0");
        tr1.setText(" 0");



   }


  public void actionPerformed(ActionEvent ae){ 
     if(n != 0){
        prob1 = prob2;
        ans1 = ans2;
     }

     if(ae.getSource() == ta ){    
        String sta = ta.getText();

        System.out.println(sta);

        if(sta.equals(ans1)){
           right++;
           bool = true;
        }
        else{   
           error++;        
           bool = false;
        }

        System.out.println(bool);
         
         String sright = Integer.toString(right);
         String serror = Integer.toString(error);
 
      
        tr0.setText(" " + sright);
        tr1.setText(" " + serror);

        double rand;
        rand = Math.random();
        int ri = (int)Math.floor(m*Math.random());
    
        prob2 = array[ri][0];
        ans2 = array[ri][1];

        System.out.println(ans2);
            
        tf0.setText(prob2); 
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
              g.drawString("³‰ğ‚Å‚·I", 120, 150);
              g.setColor(Color.black);
           }
           else{ 
              g.setColor(Color.red);
              g.drawString("c”OAŠÔˆá‚¢I" , 120, 150);
              g.drawString(prob1 + "‚ÍA[" + ans1 + "]‚Å‚·B", 120, 185); 
              g.setColor(Color.black); 
           } 

//         String sn = Integer.toString(n); 
  } 
}
