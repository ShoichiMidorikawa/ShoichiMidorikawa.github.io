/*       Rectangle.java                   */
/*       çﬁéøÇê›íË                       */
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Rectangle2 extends Shape3D{


    static Point3f[] vertices = new Point3f[6];


   public Rectangle2(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

    vertices[0] = new Point3f(0.0f, 0.0f, 0.0f);
    vertices[1] = new Point3f(1.0f, 0.0f, 0.0f);
    vertices[2] = new Point3f(1.0f, 1.0f, 0.0f);
    vertices[3] = new Point3f(0.0f, 1.0f, 0.0f);

    vertices[4] = new Point3f(1.0f, 2.0f, 0.1f);
    vertices[5] = new Point3f(0.0f, 2.0f, 0.1f);
   

    int[] indices = {0, 1, 2, 3, 3, 2, 1, 0,
                     2, 4, 5, 3, 3, 5, 4, 2 
                     };


       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.QUAD_ARRAY);
       geometryInfo.setCoordinates(vertices);
       geometryInfo.setCoordinateIndices(indices);

       NormalGenerator normalGenerator = new NormalGenerator();
       normalGenerator.generateNormals(geometryInfo);
       IndexedGeometryArray geom = geometryInfo.getIndexedGeometryArray();

      return (Geometry)geom;

   }

  
   private static Appearance createAppearance(){
    Appearance appearance;
    Material material;

    appearance = new Appearance();

    material = new Material();
    Color3f color3f = new Color3f(0.0f, 0.5f, 0.0f);
    material.setAmbientColor(color3f);
    Color3f color3f1 = new Color3f(0.54f, 0.89f, 0.63f);
    material.setDiffuseColor(color3f1);
    Color3f color3f2 = new Color3f(0.316228f, 0.3168228f, 0.368228f);
    material.setSpecularColor(color3f2);
    material.setShininess(12.8f);
    // åıÇÃîΩéÀãÔçáÇÃê›íË
   appearance.setMaterial(material);
 

      return appearance;
   }

}   








