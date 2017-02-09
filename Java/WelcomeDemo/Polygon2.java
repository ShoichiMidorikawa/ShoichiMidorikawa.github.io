/*   polygon2.java            */
/*  indexed triangleの使用    */
/*   colorによる色づけ        */ 
import javax.media.j3d.*;
import javax.vecmath.*;

public class Polygon2 extends Shape3D {

  public Polygon2() {
     super(createGeometry(), createAppearance());
  }


  private static Geometry createGeometry() {

    Point3f[] vertices = new Point3f[24];
      vertices[0] = new Point3f(-0.5f, 1.0f, 0.0f);
      vertices[1] = new Point3f(-0.5f, 0.0f, 0.5f);
      vertices[2] = new Point3f( 0.5f, 1.0f, 0.0f);
      vertices[3] = new Point3f( 0.5f, 0.0f, 0.5f);
      vertices[4] = new Point3f(-0.5f, 0.0f,-0.5f);
      vertices[5] = new Point3f( 0.5f, 0.0f,-0.5f);
      vertices[6] = new Point3f( 0.4f, 1.0f, 0.0f);
      vertices[7] = new Point3f( 0.4f, 0.2f, 0.4f);
      vertices[8] = new Point3f( 0.4f, 0.2f,-0.4f);
      vertices[9] = new Point3f( 0.4f,-0.5f, 0.4f);
      vertices[10] = new Point3f( 0.4f,-0.5f,-0.4f);    

      vertices[11] = new Point3f(-0.4f, 1.0f, 0.0f);
      vertices[12] = new Point3f(-0.4f, 0.2f, -0.4f);
      vertices[13] = new Point3f(-0.4f, 0.2f, 0.4f);
      vertices[14] = new Point3f(-0.4f,-0.5f,-0.4f);
      vertices[15] = new Point3f(-0.4f,-0.5f, 0.4f);    
 
      vertices[16] = new Point3f(0.2f, 1.5f, 0.2f);
      vertices[17] = new Point3f(0.3f, 1.5f, 0.2f);
      vertices[18] = new Point3f(0.2f, 1.5f, 0.3f);
      vertices[19] = new Point3f(0.3f, 1.5f, 0.3f);
      vertices[20] = new Point3f(0.2f, 0.0f, 0.2f);
      vertices[21] = new Point3f(0.3f, 0.0f, 0.2f);
      vertices[22] = new Point3f(0.2f, 0.0f, 0.3f);
      vertices[23] = new Point3f(0.3f, 0.0f, 0.3f);
      


   
    int[] indices = { 
                   //    表　　　  裏
                      16, 17, 20,   17, 16, 20,    // 煙突
                      17, 21, 20,   21, 17, 20,     
                      17, 19, 21,   19, 17, 21,
                      19, 23, 21,   23, 19, 21, 
                      19, 18, 23,   18, 19, 23, 
                      18, 22, 23,   22, 18, 23, 
                      18, 16, 22,   16, 18, 22,
                      16, 20, 22,   20, 16, 22,                      

                      0, 1, 2,   1, 0, 2,          // 屋根  
                      2, 1, 3,   1, 2, 3,
                      0, 5, 4,   5, 0, 4, 
                      0, 2, 5,   2, 0, 5,
                      
                      6, 7, 8,   7, 6, 8, 
                      8, 7, 9,   7, 8, 9,
                      8, 9, 10,  9, 8, 10,
                      11, 12, 13,  12, 11, 13,
                      13, 12, 14,  12, 13, 14,                    
                      13, 14, 15,  14, 13, 15,
                      8, 10, 12,   10, 8, 12,
                      12, 10, 14,  10, 12, 14,  
                      7, 13, 15,   13, 7, 15,
                      7, 15, 9,    15, 7, 9 };


    Color3f[] colors = new Color3f[7];
      colors[0] = new Color3f(1.0f, 0.0f, 0.0f);   // red
      colors[1] = new Color3f(0.0f, 1.0f, 0.0f);   // green
      colors[2] = new Color3f(0.0f, 0.0f, 1.0f);   // blue
      colors[3] = new Color3f(0.0f, 1.0f, 1.0f);   // cyan
      colors[4] = new Color3f(0.1f, 0.9f, 0.9f);   // cyan
      colors[5] = new Color3f(0.5f, 0.0f, 0.0f);   // brown              
      colors[6] = new Color3f(0.7f, 0.2f, 0.5f);   //               

    int[] colorIndices = {
                       //    表　　　　　裏 
                           5, 5, 5,   6, 6, 6,   //煙突
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,
                           5, 5, 5,   6, 6, 6,

                           2, 2, 2,   0, 0, 0,   //屋根　   
                           2, 2, 2,   0, 0, 0,  
                           2, 2, 2,   0, 0, 0,  
                           2, 2, 2,   0, 0, 0,
                           
                           3, 3, 3,   3, 3, 3,
                           3, 3, 3,   3, 3, 3,
                           3, 3, 3,   3, 3, 3,
                           3, 3, 3,   3, 3, 3,
                           3, 3, 3,   3, 3, 3,
                           3, 3, 3,   3, 3, 3,
                           4, 4, 4,   4, 4, 4,
                           4, 4, 4,   4, 4, 4,
                           4, 4, 4,   4, 4, 4,
                           4, 4, 4,   4, 4, 4};

    
    IndexedTriangleArray geometry =
      new IndexedTriangleArray( vertices.length,
                 IndexedTriangleArray.COORDINATES | IndexedTriangleArray.COLOR_3,
                            indices.length);
    geometry.setCoordinates(0, vertices);
    geometry.setCoordinateIndices(0, indices);
    geometry.setColors(0, colors);
    geometry.setColorIndices(0, colorIndices);
       
    return geometry;
  }

   private static Appearance createAppearance(){

      Appearance appearance = new Appearance();

      return appearance;
   }

}
