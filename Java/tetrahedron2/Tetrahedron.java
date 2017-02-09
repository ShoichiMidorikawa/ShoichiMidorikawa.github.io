/*   Tetrahedron.java              */
/*   IndexedTriangleArrayの使用    */
/*   colorによる色づけ             */ 
/* ******************************* */


import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Tetrahedron extends Shape3D {

  Appearance app;  

  public Tetrahedron(Appearance app) {
     super(createGeometry(), app);
  }


  private static Geometry createGeometry() {

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
                   //    表　　　     裏
                      2, 1, 0,   //  0, 1, 2,
                      0, 1, 3,   //  3, 1, 0,
                      1, 2, 3,   //  3, 2, 1,
                      2, 0, 3    //  3, 0, 2
                                              };




       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
       geometryInfo.setCoordinates(vertices);
       geometryInfo.setCoordinateIndices(indices);

       NormalGenerator normalGenerator = new NormalGenerator();
       normalGenerator.generateNormals(geometryInfo);
       IndexedGeometryArray geom = geometryInfo.getIndexedGeometryArray();

      return (Geometry)geom;
  }

}
