/*   Plane3.java                    */
/*   IndexedTriangleArrayÇÃégóp     */
/*   colorÇ…ÇÊÇÈêFÇ√ÇØ              */ 

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Plane3 extends Shape3D {

  public Plane3() {
     super(createGeometry(), createAppearance());
  }


  private static Geometry createGeometry() {
    
       float r = 2.0f;  // ãÖÇÃîºåa
       Point3f[] vertices = new Point3f[4];
     
       vertices[0] = new Point3f(1, 2, 2);
       vertices[1] = new Point3f(-1, -2, 2);
       vertices[2] = new Point3f(-1, -2, -2);
       vertices[3] = new Point3f(1, 2, -2);

       
       int[] indices = { 0, 1, 2, 3, 3, 2, 1, 0};



      Color3f[] colors = new Color3f[1];
         colors[0] = new Color3f(1.0f, 0.0f, 0.0f);   // red
      int[] colorIndices = new int[8];
    
    for(int i = 0; i < 8 ; i++){
       colorIndices[i] = 0;
    }  

        
       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.QUAD_ARRAY);
       geometryInfo.setCoordinates(vertices);
       geometryInfo.setCoordinateIndices(indices);
       geometryInfo.setColors(colors);
       geometryInfo.setColorIndices(colorIndices);

       NormalGenerator normalGenerator = new NormalGenerator();
       normalGenerator.generateNormals(geometryInfo);
       IndexedGeometryArray geom = geometryInfo.getIndexedGeometryArray();

      return (Geometry)geom;
  }

   private static Appearance createAppearance(){
    
    Appearance appearance = new Appearance();

    Material material = new Material();
                         
    Color3f color3f = new Color3f(0.1f, 0.1f, 0.9f);  // 
//    material.setAmbientColor(color3f);                // ä¬ã´åıÇÃê›íË 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f);   // ê¬
    material.setDiffuseColor(color3f1);               // ägéUîΩéÀ(ïÅí ÇÃêF) 
 
    material.setShininess(12.8f);                     // åıÇÃîΩéÀãÔçáÇÃê›íË
    appearance.setMaterial(material);

//    appearance.setTransparencyAttributes(new TransparencyAttributes
//        (TransparencyAttributes.BLENDED, 0.2f));
 
      return appearance;
   }

}
