// Kanji.java (�����E�n����)
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
  String s0 = "���Ď�";
  String s1 = "�ǂ�(�J�^�J�i)";
  String prob1, prob2, ans1, ans2;

  Label la, lb, lc;
  String sa = "���� : ";
  String sb = "���_";
  String sc = "���_";

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
   
      array[0][0] = "����";      array[0][1] ="�A�C�������h";
      array[1][0] = "���ė���";      array[1][1] = "�A�����J";
      array[2][0] = "�p�g��";        array[2][1] = "�C�M���X";
      array[3][0] = "�ɐF��";        array[3][1] = "�C�X���G��";
      array[4][0] = "�ɑ���";        array[4][1] = "�C�^���A";
      array[5][0] = "���y";        array[5][1] = "�G�W�v�g";
      array[6][0] = "��������";        array[6][1] = "�I�[�X�g�����A";
      array[7][0] = "���ޑ�";      array[7][1] = "�J�i�_";
      array[8][0] = "�V�Ú�";      array[8][1] = "�V���K�|�[��";
      array[9][0] = "����";        array[9][1] = "�X�C�X";
      array[10][0] = "���T";       array[10][1] = "�X�E�F�[�f��";
      array[11][0] = "���ǉ�";       array[11][1] = "�X�y�C��";
      array[12][0] = "����";       array[12][1] = "�f���}�[�N";
      array[13][0] = "�ƈ�";     array[13][1] = "�h�C�c";
      array[14][0] = "�y����";       array[14][1] = "�g���R";
      array[15][0] = "�V����";       array[15][1] = "�j���[�W�[�����h";
      array[16][0] = "���c";       array[16][1] = "�M���V�A";
      array[17][0] = "����";       array[17][1] = "�m���E�F�[";
      array[18][0] = "�^�嗘";       array[18][1] = "�n���K���[";
      array[19][0] = "��������";       array[19][1] = "�u���W��";
      array[20][0] = "������";       array[20][1] = "�t�����X";      
      array[21][0] = "�z��";     array[21][1] = "�x�g�i��";
      array[22][0] = "�����`";     array[22][1] = "�x���M�[";
      array[23][0] = "�g�z";     array[23][1] = "�y���V��";
      array[24][0] = "�g��";       array[24][1] = "�|�[�����h";
      array[25][0] = "������";       array[25][1] = "�|���g�K��";
      array[26][0] = "�I����";       array[26][1] = "���V�A";
      array[27][0] = "��T";       array[27][1] = "�A�e�l";
      array[28][0] = "�����z��";       array[28][1] = "�A���X�J";
      array[29][0] = "�����ڎz";       array[29][1] = "�A���v�X";
      array[30][0] = "�p��";       array[30][1] = "�C���O�����h";
      array[31][0] = "�۔[";       array[31][1] = "�E�B�[��";
      array[32][0] = "����";       array[32][1] = "�I�b�N�X�t�H�[�h";
      array[33][0] = "����";       array[33][1] = "�J�C��";
      array[34][0] = "�����ێ���";       array[34][1] = "�J���t�H���j�A";
      array[35][0] = "�i�шЎ�";       array[35][1] = "�O���j�b�W";
      array[36][0] = "�p�z";       array[36][1] = "�P�[�v�^�E��";
      array[37][0] = "����";       array[37][1] = "�P���u���b�W";
      array[38][0] = "���{";       array[38][1] = "�T�N�������g";
      array[39][0] = "���s";       array[39][1] = "�T���p�E��";
      array[40][0] = "�K�`";       array[40][1] = "�T���t�����V�X�R";
      array[41][0] = "�ɘH";       array[41][1] = "�V�A�g��";
      array[42][0] = "�s���";       array[42][1] = "�V�J�S";
      array[43][0] = "���q��";     array[43][1] = "�V�V���[";
      array[44][0] = "������";     array[44][1] = "�V�h�j�[";
      array[45][0] = "���{";     array[45][1] = "�W���l�[�u";
      array[46][0] = "�h�f";       array[46][1] = "�X�G�Y";
      array[47][0] = "���H��";     array[47][1] = "�Z���g���C�X";
      array[48][0] = "�s����";       array[48][1] = "�_�u����";
      array[49][0] = "���T";       array[49][1] = "�e�L�T�X";
      array[50][0] = "���ϑ�";     array[50][1] = "�g�����g";
      array[51][0] = "�ߚ���";       array[51][1] = "�i�|��"; 
      array[52][0] = "�R��";     array[52][1] = "�j���[���[�N"; 
      array[53][0] = "��B";       array[53][1] = "�o�O�_�b�h"; 
      array[54][0] = "�b��";       array[54][1] = "�p��"; 
      array[55][0] = "����";       array[55][1] = "�n���E�b�h"; 
      array[56][0] = "�z��";       array[56][1] = "�n���C"; 
      array[57][0] = "���D��";       array[57][1] = "�v���V�A"; 
      array[58][0] = "�ŗ����B";       array[58][1] = "�t�����_"; 
      array[59][0] = "�Г��z";       array[59][1] = "�x�j�X";
      array[60][0] = "����";     array[60][1] = "�x������"; 
      array[61][0] = "�n����";     array[61][1] = "�}�h���[�h"; 
      array[62][0] = "�{�s";     array[62][1] = "�~�����w��"; 
      array[63][0] = "���K�z��";     array[63][1] = "�}���`�F�X�^�["; 
      array[64][0] = "���z��";     array[64][1] = "���X�N��"; 
      array[65][0] = "�����b";     array[65][1] = "���[���b�p"; 
      array[66][0] = "���n";     array[66][1] = "���[�}"; 
      array[67][0] = "�H��";     array[67][1] = "���b�e���_��"; 
      array[68][0] = "�ϓ�";     array[68][1] = "�����h��"; 
      array[69][0] = "�ؐ���";     array[69][1] = "���V���g��"; 


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

    tf0 = new TextField(8);   // ������藓
    tf0.setEditable(false);
    tf0.setText(prob1);

    ta = new TextField(15);    // �𓚗��@�@*****
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
