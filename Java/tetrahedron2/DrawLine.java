import javax.media.j3d.*;
import javax.vecmath.*;


public class DrawLine extends Shape3D{

   static Point3d[] vertices = new Point3d[4];
   
   public DrawLine(){

     super(createGeometry(), createAppearance());
   
    }

   
   private static Geometry createGeometry(){

    Point3f[] vertices = new Point3f[4];

      float y2 = (float)Math.sqrt(3.); 

      float y3 = 1.0f/y2;
      float z3 = 2.0f*(float)Math.sqrt(2./3.);

      float xc = 1.0f;
      float yc = y3;
      float zc = 1.0f/(float)Math.sqrt(6.0);


      vertices[0] = new Point3f(0.0f-xc, 0.0f-yc, 0.0f-zc);
      vertices[1] = new Point3f(2.0f-xc, 0.0f-yc, 0.0f-zc);
      vertices[2] = new Point3f(1.0f-xc, y2-yc, 0.0f-zc);
      vertices[3] = new Point3f(1.0f-xc, y3-yc, z3-zc);    


   int[] indices = { 
                    3, 1,   1, 2,   2, 3,    
                    0, 1,   0, 2,   0, 3 };   

   Color3f[] colors = new Color3f[1];
      colors[0] = new Color3f(0.0f, 0.0f, 1.0f);

    int n = 12;
    int[] colorIndices = new int[n];
    
    for(int i = 0; i < n ; i++){
       colorIndices[i] = 0;
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








