// MyCanvas.java

import java.awt.*;
import java.awt.image.*;

public class MyCanvas extends Component{

  // ���[�U�[���W�͈̔́i�f�t�H���g��[-1, 1] x [-1,1])
  protected double userMinx = -1;
  protected double userMaxx = 1;
  protected double userMiny = -1;
  protected double userMaxy = 1;

  // �r���[�|�[�g�͈̔́@�f�t�H���g��[0, 1] x [0,1])
  protected double[] viewMinx;
  protected double[] viewMaxx;
  protected double[] viewMiny;
  protected double[] viewMaxy;

  final static int DefaultViewportMax = 256;
  protected int viewportMax = DefaultViewportMax;
  protected int viewportNum = 0;
  protected int currentViewport = 0;
  // �E�B���h�E�̃T�C�Y
  final static int DefaultWindowSize = 256;
  protected int windowWidth = DefaultWindowSize;
  protected int windowHeight = DefaultWindowSize;

  // Java AWT Graphics and its Component
  protected Graphics graphics;
  protected Component component;
  protected Color currentFrontColor = Color.white;
  protected Color currentBackColor = Color.black;

  public MyCanvas(Component a){
    component = a;
    graphics = a.getGraphics();
    currentGraphics = graphics;
    windowWidth = a.getSize().width;
    windowHeight = a.getSize().height;
    createViewport(DefaultViewportMax);
  }

  private void createViewport(int max){
    currentViewport = 0;
    viewportMax = max;
    viewMinx = new double[viewportMax];
    viewMaxx = new double[viewportMax];
    viewMiny = new double[viewportMax];
    viewMaxy = new double[viewportMax];
    viewMinx[0] = viewMiny[0] = 0.0;
    viewMaxx[0] = viewMaxy[0] = 1.0;
    viewportNum = 1;
  }

  // ���[�U���W�n�̐ݒ�
  public void setWindow(double x1, double x2, double y1, double y2){
    userMinx = x1;
    userMaxx = x2;
    userMiny = y1;
    userMaxy = y2;
  }
 
  // �r���[�|�[�g�̐ݒ�
  public void setViewport(double x1, double x2, double y1, double y2){
    viewMinx[viewportNum] = x1;
    viewMaxx[viewportNum] = x2;
    viewMiny[viewportNum] = y1;
    viewMaxy[viewportNum] = y2;
    currentViewport = viewportNum;
    viewportNum++;
    setClip(x1, y1, x2, y2, true);
  }
  private void setClip(double x1, double y1, double x2, double y2, boolean flag){
    int ix1 = getIntX(x1);
    int iy1 = getIntY(y1);
    int ix2 = getIntX(x2);
    int iy2 = getIntY(y2);
    int width = Math.abs(ix1-ix2)+1;
    int height = Math.abs(iy1-iy2)+1;
    int x0 = (ix1 <= ix2) ? ix1 : ix2;
    int y0 = (iy1 <= iy2) ? iy1 : iy2;
    graphics.setClip(x0, y0, width, height);
  }

  // ***** �r���[�|�[�g�̃��Z�b�g *****
  public void resetViewport(){
    currentViewport = 0;
    viewMinx[0] = viewMiny[0] = 0.0;
    viewMaxx[0] = viewMaxy[0] = 1.0;
    viewportNum = 1;
  }

  // ***** �r���[�|�[�g���W���@Java AWT���W�Ƀ}�b�s���O���郁�\�b�h *****
  public int getIntX(double x){ return (int)(windowWidth*x);}
  public int getIntY(double y){ return (int)(windowHeight*(1-y));}

  // ���[�U���W���r���[�|�[�g���W�Ƀ}�b�s���O���郁�\�b�h *****
  public double viewX(double x){
    double s = (x - userMinx)/(userMaxx - userMinx);
    double t = viewMinx[currentViewport] + s *
    (viewMaxx[currentViewport] - viewMinx[currentViewport]);
    return t;
  }
  public double viewY(double y){
    double s = (y - userMiny)/(userMaxy - userMiny);
    double t = viewMiny[currentViewport] + s *
    (viewMaxy[currentViewport] - viewMiny[currentViewport]);
    return t;
  }

  // ***** ���[�U���W���� Java AWT ���W�𓾂郁�\�b�h *****
  public int getX(double x){
    double xx = viewX(x);
    int ix = getIntX(xx);
    return ix;
  }
  public int getY(double y){
    double yy = viewY(y);
    int iy = getIntY(yy);
    return iy;
  }


  // Java AWT���W����r���[�|�[�g�ɋt�}�b�s���O
  public int getViewport(int ix, int iy){
    if(viewportNum == 1) return 0;
    double s = (double)(ix)/(double)windowWidth;
    double t = (double)(windowHeight-iy)/(double)windowHeight;
    for(int i = 0; i < viewportNum; i++){
      if(s >= viewMinx[i] && s <= viewMaxx[i] && 
         t >= viewMiny[i] && t <= viewMaxy[i]) return i;
    }
    return 0;
  }

  // �r���[�|�[�g���烆�[�U���W�n�ɋt�}�b�s���O�iX���W�j
  public double getUserX(int ix, int v){
    double t = (double)(ix)/(double)windowWidth;
    double x = userMinx + (t - viewMinx[v]) / (viewMaxx[v] - viewMinx[v]) *
               (userMaxx - userMinx);
    return x;
  }

  // �r���[�|�[�g���烆�[�U���W�n�ɋt�}�b�s���O�iY���W�j
  public double getUserY(int iy, int v){
    double t = (double)(windowHeight - iy)/(double)windowHeight;
    double y = userMiny + (t - viewMiny[v]) / (viewMaxy[v] - viewMiny[v]) *
               (userMaxy - userMiny);
    return y;
  }
 
  

  // ***** Dimension �𓾂郁�\�b�h *****
  public int getDimensionX(double w){
    double x = viewMaxx[currentViewport] - viewMinx[currentViewport];
    x *= windowWidth * w / (userMaxx - userMinx);
    return ((int)Math.abs(x));
  }
  public int getDimensionY(double h){
    double y = viewMaxy[currentViewport] - viewMiny[currentViewport];
    y *= windowHeight * h /(userMaxy - userMiny);
    return ((int)Math.abs(y));
  }

  // ***** �F�w��֘A�̃��\�b�h *****
  public Color getColor(){ return currentFrontColor;}
  public void setColor(Color c){ graphics.setColor(c);
    currentFrontColor = c;}
  public Color getForeground(){ return currentFrontColor;}
  public void setForeground(Color c){ component.setForeground(c);
    currentFrontColor = c;}
  public Color getBackground(){ return currentBackColor;}
  public void setBackground(Color c){ component.setBackground(c);
    currentBackColor = c;}

  // �`�惁�\�b�h
  // �����̕`��
  public void drawLine(double x1, double y1, double x2, double y2){
    // Java AWT���W�l�ɕϊ�
    int ix1 = getX(x1); int iy1 = getY(y1);
    int ix2 = getX(x2); int iy2 = getY(y2);
//    graphics.drawLine(ix1, iy1, ix2, iy2); 
    currentGraphics.drawLine(ix1, iy1, ix2, iy2);
  }

  // �ȉ~�̕`��@�i���S(x,y) ���a(xr, yr)�j
  public void drawOval(double x, double y, double xr, double yr){
    int ix = getX(x);
    int iy = getY(y);
    int ixr = getDimensionX(xr);
    int iyr = getDimensionY(yr);
    int x0 = ix - ixr;
    int y0 = iy - iyr;
    graphics.drawOval(x0, y0, 2*ixr, 2*iyr);
  }
  // �ȉ~�̓h��Ԃ��@�i���S(x,y) ���a(xr, yr)�j
  public void fillOval(double x, double y, double xr, double yr){
    int ix = getX(x);
    int iy = getY(y);
    int ixr = getDimensionX(xr);
    int iyr = getDimensionY(yr);
    int x0 = ix - ixr;
    int y0 = iy - iyr;
    graphics.fillOval(x0, y0, 2*ixr, 2*iyr);
  }
  // �~�ʂ̕`��@�i���S(x,y) ���a(xr, yr)�j
  public void drawArc(double x, double y, double xr, double yr, 
                      double startAngle, double arcAngle){
    int ix = getX(x);
    int iy = getY(y);
    int ixr = getDimensionX(xr);
    int iyr = getDimensionY(yr);
    int x0 = ix - ixr;
    int y0 = iy - iyr;
    int is = (int)(90 - (startAngle+arcAngle));
    int ia = (int)arcAngle;
    graphics.drawArc(x0, y0, 2*ixr, 2*iyr, is, ia);
  }
  // ��`�̓h��Ԃ��@�i���S(x,y) ���a(xr, yr)�j
  public void fillArc(double x, double y, double xr, double yr, 
                      double startAngle, double arcAngle){
    int ix = getX(x);
    int iy = getY(y);
    int ixr = getDimensionX(xr);
    int iyr = getDimensionY(yr);
    int x0 = ix - ixr;
    int y0 = iy - iyr;
    int is = (int)(90 - (startAngle+arcAngle));
    int ia = (int)arcAngle;
    graphics.fillArc(x0, y0, 2*ixr, 2*iyr, is, ia);
  }    
  // �܂���̕`��
  public void drawPolyline(double[] x, double[] y, int numPoints){
    int[] ix = new int[numPoints]; 
    int[] iy = new int[numPoints];
    for(int i = 0; i < numPoints; i++){
      ix[i] = getX(x[i]);
      iy[i] = getY(y[i]);
    }
    graphics.drawPolyline(ix, iy, numPoints);
  }
  // ���p�`�̕`��
  public void drawPolygon(double[] x, double[] y, int numPoints){
    int[] ix = new int[numPoints]; 
    int[] iy = new int[numPoints];
    for (int i=0; i < numPoints; i++){
      ix[i] = getX(x[i]);
      iy[i] = getY(y[i]);
    }
    graphics.drawPolygon(ix, iy, numPoints);
  }   
  // ���p�`�̓h��Ԃ�
  public void fillPolygon(double[] x, double[] y, int numPoints){
    int[] ix = new int[numPoints]; int[] iy = new int[numPoints];
    for(int i = 0; i < numPoints; i++){
      ix[i] = getX(x[i]);
      iy[i] = getY(y[i]);
    }
    graphics.fillPolygon(ix, iy, numPoints);
  }  

  // ������̕`��
  public void drawString(String str, double x, double y){
    int ix = getX(x);
    int iy = getY(y);
    graphics.drawString(str, ix, iy);
  }
  // �t�H���g�̐ݒ�
  public Font getFont(){
    return graphics.getFont();
  }
  public void setFont(Font f){
    graphics.setFont(f);
  }
  public Font MyFont(String name, int style, double size){
    int DefaultFontSize = 12;
    if(size <= 0) size = 1.0;
    int isize = (int)(DefaultFontSize*size);
    Font f = new Font(name, style, isize);
    return f;
  } 

  // �����̃��X�^���C�Y
  // �������C���[�W�\�[�X�p�̃f�[�^
  protected Image image;
  protected MemoryImageSource mis;
  protected int[] pixel;
  protected int pixelWidth;
  protected int pixelHeight;
  protected int xoffset;
  protected int yoffset;
  //����i���X�^���C�Y���o�[�W�����j�����^Bresenham's algorithm
  public void rasterizeDrawLine(double x1, double y1, double x2, double y2){
    double leftTopx, leftTopy;
    int ix1 = getX(x1);
    int iy1 = windowHeight - getY(y1);
    int ix2 = getX(x2);
    int iy2 = windowHeight - getY(y2);
    if(x1 < x2){
      leftTopx = x1;
      xoffset = ix1; 
    }
    else{
      leftTopx = x2;
      xoffset = ix2;
    }
    if(y1 < y2){
      leftTopy = y2;
      yoffset = iy1;
    }
    else{
      leftTopy = y1;
      yoffset = iy2;
    }
    int dx = ix2 - ix1;
    int dy = iy2 - iy1;
    int adx = Math.abs(dx);
    int ady = Math.abs(dy);
    pixelWidth = adx + 1;
    pixelHeight = ady + 1;
    pixel = new int[pixelWidth*pixelHeight];
    for(int k = 0; k < pixelWidth*pixelHeight; k++)
      pixel[k] = 0x00000000;
    int sx = Sign(dx); int sy = Sign(dy);
    int x = ix1;
    int y = iy1;
    if(adx == 0){
      for (int j = 1; j <= ady; j++){putPixel(x,y); y += sy;}
    }
    else if (ady == 0){
      for ( int i = 1; i <= adx; i++){putPixel(x,y); x += sx;}
    }
    else if (adx > ady){
      double d = (double)dy/(double)dx; double ty = (double)y;
        for (int i = 1; i <= adx; i++, x += sx){
          putPixel(x,y);
          ty += sx*d;
          if (Math.abs(ty-y) > Math.abs(ty-(y+sy)))
            y += sy;
        }
    }
    else {
      double d = (double)dx/(double)dy; double tx = (double)x;
      for (int j = 1; j <= ady; j++, y += sy){
        putPixel(x,y);
        tx += sy*d;
        if (Math.abs(tx-x) > Math.abs(tx-(x+sx)))
          x += sx;
      }
    }        
    mis = new MemoryImageSource(pixelWidth, pixelHeight, pixel, 0, pixelWidth);
    image = createImage(mis);
    drawImage(image, leftTopx, leftTopy, this);
  }
  // ��f�l�Ɍ��݂̐F�l���Z�b�g���郁�\�b�h
  public void putPixel(int i, int j){
    int r = getColor().getRed() & 0xff;
    int g = getColor().getGreen() & 0xff;
    int b = getColor().getBlue() & 0xff;
    int a = 0xff000000|(r<<16)|(g<<8)|b;
    pixel[(pixelHeight-1-(j-yoffset))*pixelWidth+(i-xoffset)] = a;    
  }
  // x�̕�����Ԃ����\�b�h
  public int Sign(int x){
    if (x > 0) return 1;
    else if (x < 0) return -1;
    return 0;
  }
  // �摜�̕`��
  public boolean drawImage(Image img, double x, double y, ImageObserver observer){
    if (currentGraphics == null) return false;
    int ix = getX(x);
    int iy = getY(y);
    return currentGraphics.drawImage(img, ix, iy, observer);
  }
  public boolean drawImage(Image img, double x, double y, double w, 
                           double h, ImageObserver observer){
    if (currentGraphics == null) return false;
    int ix = getX(x);
    int iy = getY(y);
    int iw = getDimensionX(w);
    int ih = getDimensionY(h);
    return currentGraphics.drawImage(img, ix, iy, iw, ih, observer);
  }

  // MoveTo(x,y) ��LineTo(x,y)�̃T�|�[�g�p
  protected double lastx = 0;
  protected double lasty = 0;
  // �����`��̕ʂ̃��\�b�h
  public void moveTo(double x, double y){
    lastx = x;
    lasty = y;
  }
  public void lineTo(double x, double y){
    drawLine(lastx, lasty, x, y);
    lastx = x; lasty = y;
  }

  // �I�t�X�N���[���p�f�[�^
  protected Graphics currentGraphics;
  protected Image offScreenImage;
  protected Graphics offScreenGraphics;
  protected Graphics printerGraphics;
  protected Graphics userGraphics;

  final static int DEFAULT_GRAPHICS = 0;
  final static int OFFSCREEN_GRAPHICS = 1;
  final static int PRINTER_GRAPHICS = 2;
  final static int USER_GRAPHICS = 3;

  // �I�t�X�N���[���o�b�t�@�ݒ�
  public void setOffScreenBuffer(){
    if(component == null) return;
    offScreenImage = component.createImage(windowWidth, windowHeight);
    offScreenGraphics = offScreenImage.getGraphics();
  }
  public void setOffScreenBuffer(int width, int height){
    if(component == null) return;
    offScreenImage = component.createImage(width, height);
    offScreenGraphics = offScreenImage.getGraphics();
  }

  // �O���t�B�b�N�X�̊��p
  public void dispose(){
    if ( currentGraphics == null) return;
    currentGraphics.dispose();
  } 

  // �I�t�X�N���[���C���[�W
  public Image getOffScreenImage(){return(offScreenImage);}
  // �I�t�X�N���[���O���t�B�b�N�X
  public Graphics getOffScreenGraphics(){ return(offScreenGraphics);}
  // ���݂̃O���t�B�b�N�X�̊l��
  public Graphics getGraphics(){ return(currentGraphics);}
  // �v�����^�[�O���t�B�b�N�X�̐ݒ�
  public void setPrinterGraphics(Graphics g){ printerGraphics = g; }
  // ���݃O���t�B�b�N�X�̐ݒ�
  public void setGraphics(int index){
    if(index == DEFAULT_GRAPHICS) currentGraphics = graphics;
    else if(index == OFFSCREEN_GRAPHICS)
      currentGraphics = offScreenGraphics;
    else if(index == PRINTER_GRAPHICS)
      currentGraphics = printerGraphics;
    else if(index == USER_GRAPHICS)
      currentGraphics = userGraphics;
  } 


}    
   
 



      
    