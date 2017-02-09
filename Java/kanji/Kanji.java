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
  String s0 = "�n���P";
  String s1 = "�ǂ�(�Ђ炪��)";
  String prob1, prob2, ans1, ans2;

  Label la, lb, lc;
  String sa = "���� : ";
  String sb = "���_";
  String sc = "���_";

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
   
      array[0][0] = "������";      array[0][1] ="�����傤";
      array[1][0] = "���Y��";      array[1][1] = "���݂Ȃ���";
      array[2][0] = "�S���g";        array[2][1] = "���邷�ׂ�";
      array[3][0] = "����";        array[3][1] = "���킢";
      array[4][0] = "�S��";        array[4][1] = "�ق�����";
      array[5][0] = "�Z��";        array[5][1] = "�Ă�Ƃ��ނ�";
      array[6][0] = "�ӓ�";        array[6][1] = "�����";
      array[7][0] = "�P�m��";      array[7][1] = "���Ƃ�";
      array[8][0] = "�����q";      array[8][1] = "����";
      array[9][0] = "�t�m";        array[9][1] = "�݂݂�";
      array[10][0] = "�P��";       array[10][1] = "�ς��Ȃ��Ղ�";
      array[11][0] = "�G��";       array[11][1] = "���[�����";
      array[12][0] = "�Ï�";       array[12][1] = "�΂Ȃ�";
      array[13][0] = "���ԉ�";     array[13][1] = "��������";
      array[14][0] = "煔B";       array[14][1] = "������傤";
      array[15][0] = "���";       array[15][1] = "�΂���";
      array[16][0] = "��";       array[16][1] = "�����낤";
      array[17][0] = "�w�";       array[17][1] = "����";
      array[18][0] = "����";       array[18][1] = "����ɂႭ";
      array[19][0] = "�C�l";       array[19][1] = "�Ȃ܂�";
      array[20][0] = "�S��";       array[20][1] = "����";      
      array[21][0] = "���z��";     array[21][1] = "��������";
      array[22][0] = "������";     array[22][1] = "�ςς���";
      array[23][0] = "������";     array[23][1] = "�Ђ܂��";
      array[24][0] = "���w";       array[24][1] = "�����Ȃ�";
      array[25][0] = "�H��";       array[25][1] = "��������";
      array[26][0] = "�E�G";       array[26][1] = "�����";
      array[27][0] = "�C�^";       array[27][1] = "�����炵";
      array[28][0] = "�C�";       array[28][1] = "������";
      array[29][0] = "�C��";       array[29][1] = "���邩";
      array[30][0] = "ꌑl";       array[30][1] = "������";
      array[31][0] = "�͔n";       array[31][1] = "����";
      array[32][0] = "�y��";       array[32][1] = "������";
      array[33][0] = "�p�k";       array[33][1] = "�炭��";
      array[34][0] = "途n";       array[34][1] = "���";
      array[35][0] = "�I�l";       array[35][1] = "�肷";
      array[36][0] = "醔n";       array[36][1] = "���";
      array[37][0] = "�鎭";       array[37][1] = "�ƂȂ���";
      array[38][0] = "�C��";       array[38][1] = "��������";
      array[39][0] = "�i��";       array[39][1] = "�����";
      array[40][0] = "㷗r";       array[40][1] = "��������";
      array[41][0] = "��";       array[41][1] = "��������";
      array[42][0] = "��";       array[42][1] = "�Ƃ���";
      array[43][0] = "�H����";     array[43][1] = "�����";
      array[44][0] = "���t��";     array[44][1] = "�������";
      array[45][0] = "�m����";     array[45][1] = "������";
      array[46][0] = "�Ջ�";       array[46][1] = "������";
      array[47][0] = "�|�ԋ�";     array[47][1] = "�܂�ڂ�";
      array[48][0] = "�͓�";       array[48][1] = "�ӂ�";
      array[49][0] = "�Ɗ�";       array[49][1] = "���Ђ�";
      array[50][0] = "�s�@�A";     array[50][1] = "�قƂƂ���";
      array[51][0] = "�_��";       array[51][1] = "�Ђ΂�"; 
      array[52][0] = "�M�V��";     array[52][1] = "���ق��ǂ�"; 
      array[53][0] = "�_�F";       array[53][1] = "����"; 
      array[54][0] = "�ؓp";       array[54][1] = "�݂݂���"; 
      array[55][0] = "����";       array[55][1] = "�ނ��ǂ�"; 
      array[56][0] = "�R�{";       array[56][1] = "�����"; 
      array[57][0] = "���";       array[57][1] = "�Ƃ�"; 
      array[58][0] = "�k��";       array[58][1] = "�����傤"; 
      array[59][0] = "嗋�";       array[59][1] = "�����ނ�"; 


    setLayout(new BorderLayout(0,20)); 


    la = new Label(sa); la.setFont(f0); //  ����(����)
    lb = new Label(sb); lb.setFont(f0); //  ���_(����)
    lc = new Label(sc); lc.setFont(f0); //  ���_(����) 

    tr0 = new TextField(4);   // ���_(����)
    tr0.setEditable(false);

    tr1 = new TextField(4);   // ���_(����)
    tr1.setEditable(false);

//  ���сF���_�F���_�@�̕\��  
    pn.add(la); pn.add(lb); pn.add(tr0); pn.add(lc); pn.add(tr1);
    add(pn, "South");


    l0 = new Label(s0); l0.setFont(f0);
    l1 = new Label(s1); l1.setFont(f0);

    double rand;
    rand = Math.random();
    int ri = (int)Math.floor(m*Math.random());
    
    prob1 = array[ri][0];

    tf0 = new TextField(6);   // ������藓
    tf0.setEditable(false);
    tf0.setText(prob1);

    ta = new TextField(10);    // �𓚗��@�@*****
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
              g.drawString("�����ł��I", 120, 150);
              g.setColor(Color.black);
           }
           else{ 
              g.setColor(Color.red);
              g.drawString("�c�O�A�ԈႢ�I" , 120, 150);
              g.drawString(prob1 + "�́A[" + ans1 + "]�ł��B", 120, 185); 
              g.setColor(Color.black); 
           } 

//         String sn = Integer.toString(n); 
  } 
}
