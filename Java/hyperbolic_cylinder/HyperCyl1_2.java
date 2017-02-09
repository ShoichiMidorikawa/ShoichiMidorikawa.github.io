/*       HyperCyl1_2.java (hyper cylinder 双曲柱面)　　 　　　　   */
/*       材質を設定                             　　　　　　　　 */
/*       インデックス付き4角形ポリゴン(完成)                     */
/*       GeometryInfo/NormalGeneratorの使用                      */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class HyperCyl1_2 extends Shape3D{

   public HyperCyl1_2(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // インデックス付き4角形ポリゴンの指定


    int n = 201;
    int m = 101;

    float a = 2.0f;
    float b = 1.0f;
    float c = 5.0f;



    Point3f[] vertices = new Point3f[n*m];

      float theta0 = -(float)(Math.PI-0.5f)/2.0f;
      float phi0 = -1.0f;
    
      float Dtheta = (float)(Math.PI-0.5f)/(n-1);
      float Dphi = -2*phi0/(m-1);


    float phi = phi0;
    for(int j  = 0; j < m; j++){
       float  theta = theta0;
   
       for(int i = 0; i < n; i++){
         int k = i + n*j;
         float x = (float)(a/Math.cos(theta));
         float y = (float)(b*Math.tan(theta));
         float z = (float)(c*Math.sin(phi));
         vertices[k] = new Point3f(x, y, z);
         theta += Dtheta;
       }
       phi += Dphi;
    }  

     int indices[] = new int[(n-1)*(m-1)*4];

      int n_ind = 0;
      for(int j = 0; j < m-1; j++){
         for(int i = 0; i < n-1;  i++){
            indices[n_ind++] = i + n*j;
            indices[n_ind++] = i +1 + n*j;
            indices[n_ind++] = i + 1 + n*(j+1);
            indices[n_ind++] = i + n*(j+1);
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