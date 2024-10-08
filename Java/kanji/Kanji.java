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
  String s0 = "熟字訓";
  String s1 = "読み(ひらがな)";
  String prob1, prob2, ans1, ans2;

  Label la, lb, lc;
  String sa = "成績 : ";
  String sb = "得点";
  String sc = "失点";

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
   
      array[0][0] = "公孫樹";      array[0][1] ="いちょう";
      array[1][0] = "女郎花";      array[1][1] = "おみなえし";
      array[2][0] = "百日紅";        array[2][1] = "さるすべり";
      array[3][0] = "慈姑";        array[3][1] = "くわい";
      array[4][0] = "鬼灯";        array[4][1] = "ほおずき";
      array[5][0] = "瓢虫";        array[5][1] = "てんとうむし";
      array[6][0] = "胡桃";        array[6][1] = "くるみ";
      array[7][0] = "善知鳥";      array[7][1] = "うとう";
      array[8][0] = "胡頽子";      array[8][1] = "ぐみ";
      array[9][0] = "蚯蚓";        array[9][1] = "みみず";
      array[10][0] = "鳳梨";       array[10][1] = "ぱいなっぷる";
      array[11][0] = "扁桃";       array[11][1] = "あーもんど";
      array[12][0] = "甘蕉";       array[12][1] = "ばなな";
      array[13][0] = "無花果";     array[13][1] = "いちじく";
      array[14][0] = "辣韮";       array[14][1] = "らっきょう";
      array[15][0] = "飛蝗";       array[15][1] = "ばった";
      array[16][0] = "蜉蝣";       array[16][1] = "かげろう";
      array[17][0] = "蜘蛛";       array[17][1] = "くも";
      array[18][0] = "蒟蒻";       array[18][1] = "こんにゃく";
      array[19][0] = "海鼠";       array[19][1] = "なまこ";
      array[20][0] = "百舌";       array[20][1] = "もず";      
      array[21][0] = "紫陽花";     array[21][1] = "あじさい";
      array[22][0] = "万寿果";     array[22][1] = "ぱぱいあ";
      array[23][0] = "向日葵";     array[23][1] = "ひまわり";
      array[24][0] = "翌檜";       array[24][1] = "あすなろ";
      array[25][0] = "秋桜";       array[25][1] = "こすもす";
      array[26][0] = "檸檬";       array[26][1] = "れもん";
      array[27][0] = "海豹";       array[27][1] = "あざらし";
      array[28][0] = "海驢";       array[28][1] = "あしか";
      array[29][0] = "海豚";       array[29][1] = "いるか";
      array[30][0] = "鼬鼠";       array[30][1] = "いたち";
      array[31][0] = "河馬";       array[31][1] = "かば";
      array[32][0] = "土竜";       array[32][1] = "もぐら";
      array[33][0] = "駱駝";       array[33][1] = "らくだ";
      array[34][0] = "騾馬";       array[34][1] = "らば";
      array[35][0] = "栗鼠";       array[35][1] = "りす";
      array[36][0] = "驢馬";       array[36][1] = "ろば";
      array[37][0] = "馴鹿";       array[37][1] = "となかい";
      array[38][0] = "海象";       array[38][1] = "せいうち";
      array[39][0] = "麒麟";       array[39][1] = "きりん";
      array[40][0] = "羚羊";       array[40][1] = "かもしか";
      array[41][0] = "蝙蝠";       array[41][1] = "こうもり";
      array[42][0] = "蜥蜴";       array[42][1] = "とかげ";
      array[43][0] = "秋刀魚";     array[43][1] = "さんま";
      array[44][0] = "柳葉魚";     array[44][1] = "ししゃも";
      array[45][0] = "杜父魚";     array[45][1] = "かじか";
      array[46][0] = "虎魚";       array[46][1] = "おこぜ";
      array[47][0] = "翻車魚";     array[47][1] = "まんぼう";
      array[48][0] = "河豚";       array[48][1] = "ふぐ";
      array[49][0] = "家鴨";       array[49][1] = "あひる";
      array[50][0] = "不如帰";     array[50][1] = "ほととぎす";
      array[51][0] = "雲雀";       array[51][1] = "ひばり"; 
      array[52][0] = "信天翁";     array[52][1] = "あほうどり"; 
      array[53][0] = "鸚哥";       array[53][1] = "いんこ"; 
      array[54][0] = "木菟";       array[54][1] = "みみずく"; 
      array[55][0] = "椋鳥";       array[55][1] = "むくどり"; 
      array[56][0] = "軍鶏";       array[56][1] = "しゃも"; 
      array[57][0] = "朱鷺";       array[57][1] = "とき"; 
      array[58][0] = "駝鳥";       array[58][1] = "だちょう"; 
      array[59][0] = "蝸牛";       array[59][1] = "かたつむり"; 


    setLayout(new BorderLayout(0,20)); 


    la = new Label(sa); la.setFont(f0); //  成績(文字)
    lb = new Label(sb); lb.setFont(f0); //  得点(文字)
    lc = new Label(sc); lc.setFont(f0); //  失点(文字) 

    tr0 = new TextField(4);   // 得点(数字)
    tr0.setEditable(false);

    tr1 = new TextField(4);   // 失点(数字)
    tr1.setEditable(false);

//  成績：得点：失点　の表示  
    pn.add(la); pn.add(lb); pn.add(tr0); pn.add(lc); pn.add(tr1);
    add(pn, "South");


    l0 = new Label(s0); l0.setFont(f0);
    l1 = new Label(s1); l1.setFont(f0);

    double rand;
    rand = Math.random();
    int ri = (int)Math.floor(m*Math.random());
    
    prob1 = array[ri][0];

    tf0 = new TextField(6);   // 漢字問題欄
    tf0.setEditable(false);
    tf0.setText(prob1);

    ta = new TextField(10);    // 解答欄　　*****
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
              g.drawString("正解です！", 120, 150);
              g.setColor(Color.black);
           }
           else{ 
              g.setColor(Color.red);
              g.drawString("残念、間違い！" , 120, 150);
              g.drawString(prob1 + "は、[" + ans1 + "]です。", 120, 185); 
              g.setColor(Color.black); 
           } 

//         String sn = Integer.toString(n); 
  } 
}
