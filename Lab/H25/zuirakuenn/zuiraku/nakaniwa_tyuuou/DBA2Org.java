//  DBA2.java�@
//  1���̎ʐ^���}�E�X�ł��邮��񂷁B
//  double buffering�g�p�@���������
//  bridge3.jpg 3653�~484 pixel



import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
<applet code="DBA2.class" width=900 height=600>
</applet>
*/

public class DBA2 extends Applet implements ActionListener, Runnable {
  Scrollbar scr;

  Image image;
  Image buffer;
  Graphics bufferg;
  Thread kick;
  int i,j = 0;
  MediaTracker mt;
  double xp, yp;
  double x, y;
  double dx, dy;
  int nx, sx;
  int k = 12;
  int pw = 8046;  // �p�m���}�ʐ^�̕�
  int ph = 1576;   // �p�m���}�ʐ^�̏c
  int nw=750;     // �`��̉���
  int nh=450;     //�`��̍���
  int ax= 100;     // �\���摜�̍�����̃u���E�U�[�ɂ�����x���W�̒l
  int ay= 50;      // �\���摜�̍�����̃u���E�U�[�ɂ�����y���W�̒l
  int sy; 
  int ny;
  int xsc=750;          // �u���E�U�[��x�������̃X�P�[��         
  int ysc=450;          // �u���E�U�[��y�������̃X�P�[��
     int sv;
     int nw_s;
     int nh_s;

  int min=100*nw/pw+1;

  int aaa;


  public void init() {
    setLayout(new BorderLayout());
    Panel p = new Panel();

    p.setLayout(new GridLayout(1, 3, 0, 0));
    scr = new Scrollbar(Scrollbar.HORIZONTAL, 50, 1, min, 100);
    p.add(new Label("�@	�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�g��k��"));
    p.add(scr);  p.add(new Label("�@�@�@�@�@�@�@�@�@ ")); 
    add("North", p);

     mt = new MediaTracker(this);

     image = getImage(getDocumentBase(), "tyuuou.jpg");
     mt.addImage(image,0);

      kick = new Thread(this);
      kick.start();
      sx=2000;   // �ʐ^�̏����ʒu��x���W
      sy=ph-nh*2;     // �ʐ^�̏����ʒu��y���W 
      buffer = createImage(nw, nh);	
//      System.out.println("start");

  }


  public void run() {


   addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent e){
         xp = e.getX();
         yp = e.getY();
      }
   });


   addMouseMotionListener(new MouseMotionAdapter(){
      public void mouseDragged(MouseEvent e){
         x = e.getX();
         y = e.getY();
         dx = x-xp;
         dy = y - yp;
         nx = (int)(dx/50);
         ny = (int)(dy/50);


         sx = nx+sx;
         if(0<sx && sx<pw-nw_s){
            sx= sx%pw;
            repaint();
         }  
         else if(sx<0) {
            sx = 0;
            repaint();
	 }
	 else if(sx > pw-nw_s){
            sx=pw-nw_s;
	    repaint();
         }

         sy = ny+sy; 
         if(sy<0)
            sy=0;
         if(sy>ph-nh_s)
            sy=ph-nh_s;

      }
   });     

   scr.addAdjustmentListener(new AdjustmentListener(){ 
       public void adjustmentValueChanged(AdjustmentEvent e){
          System.out.println("aaa="+aaa);
          repaint();
       }
   });


  }


  public void actionPerformed(ActionEvent e){
     repaint();
  }



  public void update(Graphics g){
    paint(g);
  }


  public void paint(Graphics g) {
     
     sv=scr.getValue();
     nw_s=nw*100/sv;
     nh_s=nh*100/sv;

    
     if(bufferg == null)
        bufferg = buffer.getGraphics();

     Dimension d = getSize();
     bufferg.setColor(Color.white);
     bufferg.fillRect( 0, 0, d.width, d.height);

        
     if(sy+nh_s < ph && sx+nw_s<pw){        //���ǒ�
        System.out.println("nh_s =" +nh_s);
        bufferg.drawImage(image, 0, 0, nw, nh, sx, sy, sx+nw_s, sy+nh_s, this);
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
        System.out.println("TEST");
     }else if(sy+nh_s < ph && sx+nw_s<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, pw-nw_s, sy, pw, sy+nh_s, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
        System.out.println("nh_s =" +nh_s);
        System.out.println("TEST2");
     }else if(sy+nh_s >= ph && sx+nw_s<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, sx, ph-nh_s, sx+nw_s, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
        System.out.println("nh_s =" +nh_s);
        System.out.println("TEST3");
     }else{
        bufferg.drawImage(image, 0,  0, nw, nh , pw-nw_s, ph-nh_s, pw, ph, this); 
//        bufferg.drawImage(image, 0, 0, nw, nh, pw-nw_s, ph-nh_s, pw, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
        System.out.println("nh_s =" +nh_s);
        System.out.println("TEST4");
     }

   }
}
/*
 drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)

�p�����[�^: 
	img - �`�悳���w��C���[�W
	dx1 - �f�X�e�B�l�[�V������`�̍ŏ��̋��� x ���W
	dy1 - �f�X�e�B�l�[�V������`�̍ŏ��̋��� y ���W
	dx2 - �f�X�e�B�l�[�V������`�� 2 �Ԗڂ̋��� x ���W
	dy2 - �f�X�e�B�l�[�V������`�� 2 �Ԗڂ̋��� y ���W
	sx1 - �\�[�X��`�̍ŏ��̋��� x ���W
	sy1 - �\�[�X��`�̍ŏ��̋��� y ���W
	sx2 - �\�[�X��`�� 2 �Ԗڂ̋��� x ���W
	sy2 - �\�[�X��`�� 2 �Ԗڂ̋��� y ���Wo
	bserver - �C���[�W������ɃX�P�[�����O����A�ϊ�����邱�Ƃ�ʒm����I�u�W�F�N�g
*/
