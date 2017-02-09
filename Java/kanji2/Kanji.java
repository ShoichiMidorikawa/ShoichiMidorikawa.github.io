// Kanji.java (国名・地名編)
// 

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

/*
<applet code = "Kanji" width = 700 height = 300>
</applet>
*/

public class Kanji extends Applet implements ActionListener{
  
  Font f0  = new Font("Courier", Font.PLAIN, 22);
  Font f1  = new Font("Courier", Font.PLAIN, 16);
  Font f  = new Font("Courier", Font.PLAIN, 26);
  Font ft = new Font("Serif",Font.BOLD, 32);
 
  TextField ta, tf0, tf1;
  TextField tr0, tr1; 

  ActionEvent ae;

  double x, y, rand, rand0;

  Label l0, l1, l2;
  String s0 = "当て字";
  String s1 = "読み(カタカナ)";
  String prob1, prob2, ans1, ans2;

  Label la, lb, lc;
  String sa = "成績 : ";
  String sb = "得点";
  String sc = "失点";

  int m = 70;
  int n =  0;

  int right = 0;
  int error;

  boolean bool = false;

  Panel pn = new Panel();
  Panel pc = new Panel();

  int ansi, tai;

  String array[][] = new String [m][2];

  public void init(){
   
      array[0][0] = "愛蘭";      array[0][1] ="アイルランド";
      array[1][0] = "亜米利加";      array[1][1] = "アメリカ";
      array[2][0] = "英吉利";        array[2][1] = "イギリス";
      array[3][0] = "伊色剌";        array[3][1] = "イスラエル";
      array[4][0] = "伊太利";        array[4][1] = "イタリア";
      array[5][0] = "埃及";        array[5][1] = "エジプト";
      array[6][0] = "濠太剌利";        array[6][1] = "オーストラリア";
      array[7][0] = "加奈陀";      array[7][1] = "カナダ";
      array[8][0] = "新嘉坡";      array[8][1] = "シンガポール";
      array[9][0] = "瑞西";        array[9][1] = "スイス";
      array[10][0] = "瑞典";       array[10][1] = "スウェーデン";
      array[11][0] = "西班牙";       array[11][1] = "スペイン";
      array[12][0] = "丁抹";       array[12][1] = "デンマーク";
      array[13][0] = "独逸";     array[13][1] = "ドイツ";
      array[14][0] = "土耳古";       array[14][1] = "トルコ";
      array[15][0] = "新西蘭";       array[15][1] = "ニュージーランド";
      array[16][0] = "希臘";       array[16][1] = "ギリシア";
      array[17][0] = "諾威";       array[17][1] = "ノルウェー";
      array[18][0] = "洪牙利";       array[18][1] = "ハンガリー";
      array[19][0] = "伯剌西爾";       array[19][1] = "ブラジル";
      array[20][0] = "仏蘭西";       array[20][1] = "フランス";      
      array[21][0] = "越南";     array[21][1] = "ベトナム";
      array[22][0] = "白耳義";     array[22][1] = "ベルギー";
      array[23][0] = "波斯";     array[23][1] = "ペルシャ";
      array[24][0] = "波蘭";       array[24][1] = "ポーランド";
      array[25][0] = "葡萄牙";       array[25][1] = "ポルトガル";
      array[26][0] = "露西亜";       array[26][1] = "ロシア";
      array[27][0] = "雅典";       array[27][1] = "アテネ";
      array[28][0] = "阿羅斯加";       array[28][1] = "アラスカ";
      array[29][0] = "阿爾卑斯";       array[29][1] = "アルプス";
      array[30][0] = "英蘭";       array[30][1] = "イングランド";
      array[31][0] = "維納";       array[31][1] = "ウィーン";
      array[32][0] = "牛津";       array[32][1] = "オックスフォード";
      array[33][0] = "改羅";       array[33][1] = "カイロ";
      array[34][0] = "加里保爾尼";       array[34][1] = "カリフォルニア";
      array[35][0] = "格林威治";       array[35][1] = "グリニッジ";
      array[36][0] = "角布";       array[36][1] = "ケープタウン";
      array[37][0] = "剣橋";       array[37][1] = "ケンブリッジ";
      array[38][0] = "桜府";       array[38][1] = "サクラメント";
      array[39][0] = "聖市";       array[39][1] = "サンパウロ";
      array[40][0] = "桑港";       array[40][1] = "サンフランシスコ";
      array[41][0] = "舎路";       array[41][1] = "シアトル";
      array[42][0] = "市俄古";       array[42][1] = "シカゴ";
      array[43][0] = "獅子利";     array[43][1] = "シシリー";
      array[44][0] = "悉徳尼";     array[44][1] = "シドニー";
      array[45][0] = "寿府";     array[45][1] = "ジュネーブ";
      array[46][0] = "蘇素";       array[46][1] = "スエズ";
      array[47][0] = "聖路易";     array[47][1] = "セントルイス";
      array[48][0] = "都伯林";       array[48][1] = "ダブリン";
      array[49][0] = "得撒";       array[49][1] = "テキサス";
      array[50][0] = "多倫多";     array[50][1] = "トロント";
      array[51][0] = "那坡利";       array[51][1] = "ナポリ"; 
      array[52][0] = "紐育";     array[52][1] = "ニューヨーク"; 
      array[53][0] = "報達";       array[53][1] = "バグダッド"; 
      array[54][0] = "巴里";       array[54][1] = "パリ"; 
      array[55][0] = "聖林";       array[55][1] = "ハリウッド"; 
      array[56][0] = "布哇";       array[56][1] = "ハワイ"; 
      array[57][0] = "普魯西";       array[57][1] = "プロシア"; 
      array[58][0] = "佛羅里達";       array[58][1] = "フロリダ"; 
      array[59][0] = "威内斯";       array[59][1] = "ベニス";
      array[60][0] = "伯林";     array[60][1] = "ベルリン"; 
      array[61][0] = "馬徳里";     array[61][1] = "マドリード"; 
      array[62][0] = "閔行";     array[62][1] = "ミュンヘン"; 
      array[63][0] = "曼澈斯特";     array[63][1] = "マンチェスター"; 
      array[64][0] = "莫斯科";     array[64][1] = "モスクワ"; 
      array[65][0] = "欧羅巴";     array[65][1] = "ヨーロッパ"; 
      array[66][0] = "羅馬";     array[66][1] = "ローマ"; 
      array[67][0] = "路照";     array[67][1] = "ロッテルダム"; 
      array[68][0] = "倫敦";     array[68][1] = "ロンドン"; 
      array[69][0] = "華盛頓";     array[69][1] = "ワシントン"; 


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

    tf0 = new TextField(8);   // 漢字問題欄
    tf0.setEditable(false);
    tf0.setText(prob1);

    ta = new TextField(15);    // 解答欄　　*****
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
