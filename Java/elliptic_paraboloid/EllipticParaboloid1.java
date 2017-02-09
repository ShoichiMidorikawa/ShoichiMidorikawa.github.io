/*       EllipticParaboloid1.java (elliptic paraboloid 楕円放物面)   */
/*       材質を設定                             　　　　　　    　　 */
/*       インデックス付き4角形ポリゴン(完成)                         */
/*       GeometryInfo/NormalGeneratorの使用                          */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class EllipticParaboloid1 extends Shape3D{

   public EllipticParaboloid1(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // インデックス付き4角形ポリゴンの指定


    int n = 51;
    int m = 51;

    float a = 1.0f;
    float b = 0.5f;

    Point3f[] vertices = new Point3f[n*m];

      float r0 = 0.0f;
      float theta0 = 0.0f;
    
      float Dr = 2.0f/(m-1);
      float Dtheta = (float)(2.0*Math.PI/(n-1));


    float r = r0;
    for(int j  = 0; j < m; j++){
       float theta = theta0;
       for(int i = 0; i < n; i++){
         int k = i + n*j;
         float x = (float)(a*r*Math.cos(theta));
         float y = (float)(b*r*Math.sin(theta));
         float z = x*x/a/a + y*y/b/b;
         vertices[k] = new Point3f(x, z, y);
         theta += Dtheta;
       }
       r += Dr;
    }  

     int indices[] = new int[(n-1)*(m-1)*4];

      int n_ind = 0;
      for(int j = 0; j < m-1; j++){
         for(int i = 0; i < n-1;  i++){
            indices[n_ind++] = i + n*j;
            indices[n_ind++] = i + n*(j+1);
            indices[n_ind++] = i + 1 + n*(j+1);
            indices[n_ind++] = i+1 + n*j;
         }
      }

       
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
    Color3f color3f = new Color3f(0.0f, 0.0f, 1.0f);  // 青
    material.setAmbientColor(color3f);                // 環境光の設定 

    Color3f color3f1 = new Color3f(0.0f, 1.0f, 1.0f); // 水色 
    material.setDiffuseColor(color3f1);               // 拡散反射(通常の色) 
    material.setSpecularColor(color3f1);
    // 光の反射具合の設定 0～128 数値が大きいと反射領域は小さい
    material.setShininess(10.0f);                     
   appearance.setMaterial(material);
 
   // 透明度の設定
//   appearance.setTransparencyAttributes(
//      new TransparencyAttributes(
//      TransparencyAttributes.BLENDED, 0.2f));    

      return appearance;
   }

}