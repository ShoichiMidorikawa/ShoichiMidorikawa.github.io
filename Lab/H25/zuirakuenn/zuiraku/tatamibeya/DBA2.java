//  DBA2.java　
//  1枚の写真をマウスでぐるぐる回す。
//  double buffering使用　ちらつき無し
//  bridge3.jpg 3653×484 pixel



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
  int pw = 5367;  // パノラマ写真の幅
  int ph = 877;   // パノラマ写真の縦
  int nw=750*4/5;     // 描画の横幅
  int nh=550*4/5;     //描画の高さ
  int ax= 100;     // 表示画像の左上隅のブラウザーにおけるx座標の値
  int ay= 50;      // 表示画像の左上隅のブラウザーにおけるy座標の値
  int sy; 
  int ny;
  int xsc=750;          // ブラウザーのx軸方向のスケール         
  int ysc=550;          //  ブラウザーのy軸方向のスケール
     int sv;
     int nw_s;
     int nh_s;


  public void init() {
    setLayout(new BorderLayout());
    Panel p = new Panel();

    p.setLayout(new GridLayout(1, 3, 0, 0));
    scr = new Scrollbar(Scrollbar.HORIZONTAL, 100, 10, 60, 200);
    p.add(new Label("　	　　　　　　　　　　　　　　　　　　　拡大縮小"));
    p.add(scr);  p.add(new Label("　　　　　　　　　 ")); 
    add("North", p);

     mt = new MediaTracker(this);

     image = getImage(getDocumentBase(), "tatami.jpg");
     mt.addImage(image,0);

      kick = new Thread(this);
      kick.start();
      sx=2200;   // 写真の初期位置のx座標
      sy=100;     // 写真の初期位置のy座標
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
         nx = (int)(dx/50);     // マウスの動き
         ny = (int)(dy/50);     // マウスの動き


         sx = nx+sx;
         if((0<sx && sx<pw-nw)||sx>=pw){
            sx= sx%pw;
            repaint();
         }  
         else if(sx<0) {
            sx = pw-sx; 
            repaint();
	 }
	 else if(pw > sx && sx > pw-nw){
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
/*
       Dimension d = getSize();
       bufferg.setColor(Color.white);
       bufferg.fillRect( 0, 0, d.width, d.height);
*/
     if(0<sx && sx<pw-nw_s){
        bufferg.drawImage(image, 0, 0, nw, nh, sx, sy, sx+nw_s, sy+nh_s, this);
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }else{
        bufferg.drawImage(image, 0, 0, (pw-sx)*sv/100, nh, sx, sy, pw, sy+nh_s, this);
        bufferg.drawImage(image, (pw-sx)*sv/100, 0, nw, nh, 0, sy, nw_s+sx-pw, sy+nh_s, this);
        g.drawImage(buffer, ax, ay, xsc, ysc, this);
     }



   }
}
/*
 drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)

パラメータ: 
	img - 描画される指定イメージ
	dx1 - デスティネーション矩形の最初の隅の x 座標
	dy1 - デスティネーション矩形の最初の隅の y 座標
	dx2 - デスティネーション矩形の 2 番目の隅の x 座標
	dy2 - デスティネーション矩形の 2 番目の隅の y 座標
	sx1 - ソース矩形の最初の隅の x 座標
	sy1 - ソース矩形の最初の隅の y 座標
	sx2 - ソース矩形の 2 番目の隅の x 座標
	sy2 - ソース矩形の 2 番目の隅の y 座標o
	bserver - イメージがさらにスケーリングされ、変換されることを通知するオブジェクト
*/
