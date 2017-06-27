/*

  DBA2.java�@
  
*/    



import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;

/*
<applet code="DBA2.class" width=1000 height=700>
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
  int pw = 4209;  // �p�m���}�ʐ^�̕�
  int ph = 3008;   // �p�m���}�ʐ^�̏c
  int nw=770;     // �`��̉���
  int nh=nw*ph/pw;     //�`��̍���
  int ax= 50;     // �\���摜�̍�����̃u���E�U�[�ɂ�����x���W�̒l
  int ay= 50;      // �\���摜�̍�����̃u���E�U�[�ɂ�����y���W�̒l
  int sy; 
  int ny;
  int xsc=nw;           // �u���E�U�[��x�������̃X�P�[��         
  int ysc=nh;          // �u���E�U�[��y�������̃X�P�[��
     int sv;
     int nw_s;
     int nh_s;

   int min=100*nh/ph;

  int dw;
  int dh;
  
  int scale= (int)(min*2.5); 

  public void init() {
    setLayout(new BorderLayout());
    Panel p = new Panel();

    p.setLayout(new GridLayout(1, 3, 0, 0));
    scr = new Scrollbar(Scrollbar.HORIZONTAL, scale, 20, min, 100);
    p.add(new Label("�@	�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�g��k��"));
    p.add(scr);  p.add(new Label("�@�@�@�@�@�@�@�@�@ ")); 
    add("North", p);

     mt = new MediaTracker(this);

     image = getImage(getDocumentBase(), "honntai70.jpg");
     mt.addImage(image,0);

      kick = new Thread(this);
      kick.start();
//      sx=2000;   // �ʐ^�̏����ʒu��x���W
//      sy=ph-nh*2;     // �ʐ^�̏����ʒu��y���W 
      buffer = createImage(nw, nh);	
//      System.out.println("start");
      System.out.println("min"+min);
      sx=0; sy=0;  //�ʐ^�̏����ʒu��x,y���W
  }


  public void run() {


   addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent e){
         xp = e.getX();
         yp = e.getY();

        URL newURL = null;

         int x2 = (int)((xp-ax)*100/sv+sx+dw);   
         int y2 = (int)((yp-ay)*100/sv+sy+dh);   
         System.out.print("sv="+sv+"  "); 
         System.out.print("x2="+x2+",  ");
         System.out.println("y2="+y2);

         if(x2>465 && x2<640 && y2 > 370 && y2<440){
            AppletContext ac = getAppletContext();
            try{newURL = new URL(getCodeBase(),"daigaku/DBAnimeEvent.html");}
            catch (MalformedURLException e1){}
            ac.showDocument(newURL);
//          ac.showDocument(newURL, "frame2");  //�ʃt���[���ŊJ��
            System.out.println("OK!");

         } 
         if(x2>1610 && x2 < 1640 && y2 > 1560 && y2 < 1580){
            try{newURL = new URL(getCodeBase(),"taikukan/AomoriU1.html");}	//�w�Z�̈��
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         } 
         if(x2>2160 && x2 < 2200 && y2 > 100 && y2 < 130){
            try{newURL = new URL(getCodeBase(),"ramen/DBA4.html");}		//���[�����V���b�v
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1930 && x2 < 1960 && y2 > 770 && y2 < 810){
            try{newURL = new URL(getCodeBase(),"koban/DBA4.html");}			//���
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1770 && x2 < 1810 && y2 > 100 && y2 < 140){
            try{newURL = new URL(getCodeBase(),"kobata/DBA4.html");}		//�K�����w�Z
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1640 && x2 < 1680 && y2 > 1170 && y2 < 1210){
            try{newURL = new URL(getCodeBase(),"seimon/DBA4.html");}	//�w�Z����
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1720 && x2 < 1750 && y2 > 1330 && y2 < 1370){
            try{newURL = new URL(getCodeBase(),"tyari2/DBA4.html");}	//���֏�
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>2485 && x2 < 2510 && y2 > 1480 && y2 < 1510){
            try{newURL = new URL(getCodeBase(),"syoutokukann/DBA4.html");}	//������
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>2100 && x2 < 21300 && y2 > 1570 && y2 < 1610){
            try{newURL = new URL(getCodeBase(),"nakaniwa/DBA4.html");}	//����
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1880 && x2 < 2010 && y2 > 1465 && y2 < 1490){
            try{newURL = new URL(getCodeBase(),"Tyuuou/DBA4.html");}	//������
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>2380 && x2 < 2420 && y2 > 2260 && y2 < 2300){
            try{newURL = new URL(getCodeBase(),"ginkou/DBA4.html");}	//��s
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>2324 && x2 < 2360 && y2 > 2140 && y2 < 2165){
            try{newURL = new URL(getCodeBase(),"yubin/DBA4.html");}	//�X�֋�
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>2640 && x2 < 2670 && y2 > 1640 && y2 < 1670){
            try{newURL = new URL(getCodeBase(),"max/DBA4.html");}	//�}�b�N�X�o�����[
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1770 && x2 < 1800 && y2 > 2400 && y2 < 2415){
            try{newURL = new URL(getCodeBase(),"syoutenn/DBA2.html");}	//���X
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>3288 && x2 < 3310 && y2 > 1034 && y2 < 1060){
            try{newURL = new URL(getCodeBase(),"siminnkann/DBA2.html");}	//�s����
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1373 && x2 < 1393 && y2 > 1660 && y2 < 1690){
            try{newURL = new URL(getCodeBase(),"hokabenn/DBA2.html");}	//�ق���
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
         if(x2>1850 && x2 < 1895 && y2 > 1130 && y2 < 1170){
            try{newURL = new URL(getCodeBase(),"syokuin/DBA4.html");}	//�E��
            catch(MalformedURLException e2){}
            getAppletContext().showDocument(newURL);
            System.out.println("That's OK!");
         }
      }
   });


   addMouseMotionListener(new MouseMotionAdapter(){
      public void mouseDragged(MouseEvent e){
         x = e.getX();
         y = e.getY();
         dx = -x+xp;
         dy = -y+yp;
         nx = (int)(dx/20);
         ny = (int)(dy/20);

 
         sx = nx+sx;

         if(-dw<sx && sx<=pw-nw_s-dw){
            sx= sx%pw;
            repaint();
         } 
         else if(sx<-dw) {
            sx = -dw;
            repaint();
	 }
	 else if(sx > pw-nw_s-dw){
            sx=pw-nw_s-dw;
	    repaint();
         }

         sy = ny+sy; 

         if(-dh<sy && sy<=ph-nh_s-dh){
            sy= sy%ph;
            repaint();
         } 
         else if(sy<-dh) {
            sy = -dh;
            repaint();
	 }
	 else if(sy > ph-nh_s-dh){
            sy=ph-nh_s-dh;
	    repaint();
         }

    }
   });     


   scr.addAdjustmentListener(new AdjustmentListener(){ 
       public void adjustmentValueChanged(AdjustmentEvent e){
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

    dw = (nw*100/min-nw_s)/2;
    dh = (nh*100/min-nh_s)/2;     

     if(bufferg == null)
        bufferg = buffer.getGraphics();

     Dimension d = getSize();
     bufferg.setColor(Color.white);
     bufferg.fillRect( 0, 0, d.width, d.height);
       
     if(sy+nh_s+dh < ph && sx+nw_s+dw<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, sx+dw, sy+dh, sx+nw_s+dw+nx, sy+nh_s+dh, this); // OK!
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
        System.out.println("sy="+sy);
     }else if(sy+nh_s+dh < ph && sx+nw_s+dw>=pw){
        bufferg.drawImage(image, 0, 0, nw, nh, pw-nw_s, sy+dh, pw, sy+nh_s+dh, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else if(sy+nh_s+dh >= ph && sx+nw_s+dw<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, sx+dw, ph-nh_s, sx+nw_s+dw, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else if(sy+nh_s+dh >= ph && sx+nw_s+dw>=pw){
        bufferg.drawImage(image, 0,  0, nw, nh , pw-nw_s, ph-nh_s, pw, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
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


/*
     if(sy+nh_s < ph && sx+nw_s<pw){     
        bufferg.drawImage(image, 0, 0, nw, nh, sx, sy, sx+nw_s, sy+nh_s, this);
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else if(sy+nh_s < ph && sx+nw_s<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, pw-nw_s, sy, pw, sy+nh_s, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else if(sy+nh_s >= ph && sx+nw_s<pw){
        bufferg.drawImage(image, 0, 0, nw, nh, sx, ph-nh_s, sx+nw_s, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else{
        bufferg.drawImage(image, 0,  0, nw, nh , pw-nw_s, ph-nh_s, pw, ph, this); 
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }
*/