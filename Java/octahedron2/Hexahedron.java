/*       Hexahedron.java  (正八面体)                 */
/*       材質を設定                                  */
/*       インデックス付き3角形ポリゴン(完成)         */
/*  　　 GeometryInfo/NormalGeneratorの使用          */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Hexahedron extends Shape3D{

   public Hexahedron(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // インデックス付き4角形ポリゴンの指定

    Point3f[] vertices = new Point3f[8];

      float r = 1.0f;
//      float r = 0.34f;

      vertices[0] = new Point3f( r,  r, r);
      vertices[1] = new Point3f(-r,  r, r);
      vertices[2] = new Point3f(-r, -r, r);
      vertices[3] = new Point3f( r, -r, r);
      vertices[4] = new Point3f( r,  r, -r);  
      vertices[5] = new Point3f(-r,  r, -r);
      vertices[6] = new Point3f(-r, -r, -r);
      vertices[7] = new Point3f( r, -r, -r);




      int[] indices = {  0, 1, 2, 3,
                         0, 4, 5, 1,
                         1, 5, 6, 2,
                         2, 6, 7, 3,
                         3, 7, 4, 0,
                         7, 6, 5, 4
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

    material = new Material();                        //  
    Color3f color3f = new Color3f(0.1f, 0.1f, 0.9f);  // 
    material.setAmbientColor(color3f);                // 環境光の設定 
//    Color3f color3f0 = new Color3f(0.0f, 0.1f, 0.99f);
//    material.setEmissiveColor(color3f0);              // 放射光
    Color3f color3f1 = new Color3f(1.0f, 0.0f, 0.0f); // 赤
    material.setDiffuseColor(color3f1);               // 拡散反射(普通の色) 

 
    material.setShininess(12.8f);                     // 光の反射具合の設定
   appearance.setMaterial(material);

 
   // 透明度の設定
   appearance.setTransparencyAttributes(
      new TransparencyAttributes(
      TransparencyAttributes.BLENDED, 0.2f));    

      return appearance;
   }

}   








