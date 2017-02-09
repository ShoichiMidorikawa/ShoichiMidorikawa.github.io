/*       Octahedron.java  (�����ʑ�)                 */
/*       �ގ���ݒ�                                  */
/*       �C���f�b�N�X�t��3�p�`�|���S��(����)         */
/*  �@�@ GeometryInfo/NormalGenerator�̎g�p          */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Octahedron extends Shape3D{

   public Octahedron(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // �C���f�b�N�X�t��3�p�`�|���S���̎w��

    Point3f[] vertices = new Point3f[6];

      float r = 1.0f;

      vertices[0] = new Point3f(0.0f,    r, 0.0f);
      vertices[1] = new Point3f(   r, 0.0f, 0.0f);
      vertices[2] = new Point3f(0.0f, 0.0f,   -r);
      vertices[3] = new Point3f(  -r, 0.0f, 0.0f);
      vertices[4] = new Point3f(0.0f, 0.0f,    r);  
      vertices[5] = new Point3f(0.0f,   -r, 0.0f);




      int[] indices = {  0, 1, 2,
                         0, 2, 3,
                         0, 3, 4,
                         0, 4, 1,
                         5, 1, 4,
                         5, 4, 3,
                         5, 3, 2,
                         5, 2, 1 
                      }; 

        
       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
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
    material.setAmbientColor(color3f);                // �����̐ݒ� 
//    Color3f color3f0 = new Color3f(0.0f, 0.1f, 0.99f);
//    material.setEmissiveColor(color3f0);              // ���ˌ�
    Color3f color3f1 = new Color3f(0.0f, 1.0f, 0.0f); // ��
    material.setDiffuseColor(color3f1);               // �g�U����(���ʂ̐F) 

 
    material.setShininess(12.8f);                     // ���̔��ˋ�̐ݒ�
   appearance.setMaterial(material);
/* 
   // �����x�̐ݒ�
   appearance.setTransparencyAttributes(
      new TransparencyAttributes(
      TransparencyAttributes.BLENDED, 0.01f));    
*/
      return appearance;
   }

}   








