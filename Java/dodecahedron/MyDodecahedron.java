import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyDodecahedron extends Shape3D{

     static Geometry geom = createGeometry();
    
   public MyDodecahedron(Appearance app){ 

       super(geom, app);

   }

 public static Geometry createGeometry() {

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
                      2, 1, 0,   3, 2, 0,    4, 3, 0,   
                      1, 6, 0,   6,10, 0,   10, 5, 0,
                      2, 7, 1,   7,11, 1,   11, 6, 1,
                      3, 8, 2,   8,12, 2,   12, 7, 2,
                      9,13, 4,  13, 8, 4,    8, 3, 4,
                      5,14, 0,  14, 9, 0,    9, 4, 0,    
                     10, 6,15,   6,11,15,   11,16,15,
                     11, 7,16,   7,12,16,   12,17,16,
                     12, 8,17,   8,13,17,   13,18,17,
                     13, 9,18,   9,14,18,   14,19,18,
                     14, 5,19,   5,10,19,   10,15,19,
                     16,17,15,  17,18,15,   18,19,15
                                                      };




    Color3f[] colors = new Color3f[4];
      colors[0] = new Color3f(1.0f, 0.0f, 0.0f);   // red
      colors[1] = new Color3f(0.0f, 1.0f, 0.0f);   // green
      colors[2] = new Color3f(0.0f, 0.0f, 1.0f);   // blue
      colors[3] = new Color3f(0.0f, 1.0f, 1.0f);   // cyan

    int n = 9*12;
    int[] colorIndices = new int[n];
    
    for(int i = 0; i < n ; i++){
       colorIndices[i] = 2;
    }  

        
       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
       geometryInfo.setCoordinates(vertices);
       geometryInfo.setCoordinateIndices(indices);
       geometryInfo.setColors(colors);
       geometryInfo.setColorIndices(colorIndices);

       NormalGenerator normalGenerator = new NormalGenerator();
       normalGenerator.generateNormals(geometryInfo);
       IndexedGeometryArray geom = geometryInfo.getIndexedGeometryArray();

      return (Geometry)geom;
  }

}
 
