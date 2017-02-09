import javax.media.j3d.*;
import javax.vecmath.*;


public class DrawLine extends Shape3D{

   static Point3d[] vertices = new Point3d[18];
   
   public DrawLine(){

     super(createGeometry(), createAppearance());

   
    }

   
   private static Geometry createGeometry(){

       Point3f[] vertices = new Point3f[20];
    
       float r = 1.0f;  // ‹…‚Ì”¼Œa
     
       double theta = 2.0*Math.PI/5.0;    // = 72‹

       double l = 2.0*r*Math.sin(theta/2.0); //  5ŠpŒ`‚Ìˆê•Ó‚Ì’·‚³

       float u = r*(float)((Math.sqrt(5.0) + 1.0)/2.0);
 
       float h = u + 1.0f;

       float z_c = h/2.0f;

       for(int i = 0; i < 10 ; i++){
          float t = r*(1.0f - i/5) + u*(i/5);           
          float x = t*(float)Math.cos(theta*i);
          float y = t*(float)Math.sin(theta*i);
          float z = (i/5)*r;
          vertices[i] = new Point3f(x, y, z-z_c);
       }   

       for(int i = 10; i < 20; i++){
          float t = u*(3.0f - i/5) + r*(i/5 - 2.0f);           
          float x = t*(float)Math.cos(theta*(i+0.5));
          float y = t*(float)Math.sin(theta*(i+0.5));
          float z = u*(3.0f - i/5) + h*(i/5 - 2.0f);
          vertices[i] = new Point3f(x, y, z-z_c);
       }   

   int[] indices = { 
                    0, 1,   1, 2,   2, 3,    3, 4,    4, 0,
                    0, 5,   1, 6,   2, 7,    3, 8,    4, 9,
                    5,10,  10, 6,   6,11,   11, 7,    7,12,
                   12, 8,   8,13,  13, 9,    9,14,   14, 5,
                   10,15,  11,16,  12,17,   13,18,   14,19,
                   15,16,  16,17,  17,18,   18,19,   19,15  
                                                          };


   Color3f[] colors = new Color3f[4];
      colors[0] = new Color3f(1.0f, 1.0f, 1.0f);   // white
      colors[1] = new Color3f(0.0f, 1.0f, 0.0f);   // green
      colors[2] = new Color3f(0.0f, 0.0f, 1.0f);   // blue
      colors[3] = new Color3f(0.0f, 1.0f, 1.0f);   // cyan

    int n = 60;
    int[] colorIndices = new int[n];
    
    for(int i = 0; i < n ; i++){
       colorIndices[i] = 2;
    }  

    IndexedLineArray geometry =
      new IndexedLineArray( vertices.length,
                 IndexedLineArray.COORDINATES | IndexedLineArray.COLOR_3,
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








