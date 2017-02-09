/*       Rectangle.java                   */
/*       材質を設定                       */
import javax.media.j3d.*;
import javax.vecmath.*;

public class Rectangle extends Shape3D{


    static Point3f[] vertices = new Point3f[4];


   public Rectangle(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){
         
    float y = 0.0f;

    vertices[0] = new Point3f(-1.0f, y, -1.0f);
    vertices[1] = new Point3f(-1.0f, y,  1.0f);
    vertices[2] = new Point3f( 1.0f, y,  1.0f);
    vertices[3] = new Point3f( 1.0f, y, -1.0f);

    int[] indices = {0, 1, 2, 3, 3, 2, 1, 0};


    Color3f[] colors = new Color3f[2];

      colors[0] = new Color3f(0.0f, 0.0f, 0.6f);   // blue              
      colors[1] = new Color3f(0.5f, 0.0f, 0.0f);   // brown              

    int[] colorIndices = {//    表　　　　　裏 
                           0, 0, 0, 0,  1, 1, 1, 1  };  

//      Vector3f normal, v1, v2;

      // 四角形ポリゴンの定義
    IndexedQuadArray geometry =
      new IndexedQuadArray( vertices.length,
                 IndexedQuadArray.COORDINATES | IndexedQuadArray.COLOR_3,
                            indices.length);
    geometry.setCoordinates(0, vertices);
    geometry.setCoordinateIndices(0, indices);
    geometry.setColors(0, colors);
    geometry.setColorIndices(0, colorIndices);
       
    return geometry;
   }

  
   private static Appearance createAppearance(){
    Appearance appearance;
    Material material = new Material();

    appearance = new Appearance();

    Color3f color3f = new Color3f(0.1f, 0.1f, 0.9f);  // 
    material.setAmbientColor(color3f);                // 環境光の設定 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // 青
    material.setDiffuseColor(color3f1);               // 拡散反射(普通の色) 
 
    material.setShininess(12.8f);                     // 光の反射具合の設定
    appearance.setMaterial(material);

    appearance.setTransparencyAttributes(new TransparencyAttributes
        (TransparencyAttributes.BLENDED, 0.5f));
 


      return appearance;
   }

}   








