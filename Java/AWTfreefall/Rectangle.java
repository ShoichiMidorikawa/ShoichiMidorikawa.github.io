/*       Rectangle.java                   */
/*       �ގ���ݒ�                       */
import javax.media.j3d.*;
import javax.vecmath.*;

public class Rectangle extends Shape3D{


    static Point3f[] vertices = new Point3f[4];


   public Rectangle(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){
         // ���s�ړ� + ���̔��a
    float y = -0.5f - 0.05f;

    vertices[0] = new Point3f(-1.0f, y, -1.0f);
    vertices[1] = new Point3f(-1.0f, y,  1.0f);
    vertices[2] = new Point3f( 1.0f, y,  1.0f);
    vertices[3] = new Point3f( 1.0f, y, -1.0f);

    int[] indices = {0, 1, 2, 3, 3, 2, 1, 0};


    Color3f[] colors = new Color3f[2];

      colors[0] = new Color3f(0.0f, 0.0f, 0.6f);   // blue              
      colors[1] = new Color3f(0.5f, 0.0f, 0.0f);   // brown              

    int[] colorIndices = {//    �\�@�@�@�@�@�� 
                           0, 0, 0, 0,  1, 1, 1, 1  };  

//      Vector3f normal, v1, v2;

      // �l�p�`�|���S���̒�`
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
    Material material;

    appearance = new Appearance();

      return appearance;
   }

}   








