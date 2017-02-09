/*       Paraboloid1.java (hyperbolic paraboloid �o�ȓI�@����)   */
/*       �ގ���ݒ�                             �@�@�@�@�@�@�@�@ */
/*       �C���f�b�N�X�t��4�p�`�|���S��(����)                     */
/*       GeometryInfo/NormalGenerator�̎g�p                      */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Paraboloid1 extends Shape3D{

   public Paraboloid1(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // �C���f�b�N�X�t��4�p�`�|���S���̎w��


    int n = 20;
    int m = 20;

    Point3f[] vertices = new Point3f[n*m];

      float x0 = -2.0f;
      float y0 = -2.0f;
    
      float dx = 2.0f*(-x0)/n;
      float dy = 2.0f*(-y0)/m;


    float y = y0;
    for(int j  = 0; j < m; j++){
       float x = x0;
       for(int i = 0; i < n; i++){
         int k = i + n*j;
         float z = x*x - y*y;
         vertices[k] = new Point3f(x, z, y);
         x += dx;
       }
       y += dy;
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
    Color3f color3f = new Color3f(0.0f, 0.0f, 1.0f);  // ��
    material.setAmbientColor(color3f);                // �����̐ݒ� 

    Color3f color3f1 = new Color3f(0.0f, 1.0f, 1.0f); // ���F 
    material.setDiffuseColor(color3f1);               // �g�U����(�ʏ�̐F) 
    material.setSpecularColor(color3f1);
    // ���̔��ˋ�̐ݒ� 0�`128 ���l���傫���Ɣ��˗̈�͏�����
    material.setShininess(10.0f);                     
   appearance.setMaterial(material);
 
   // �����x�̐ݒ�
//   appearance.setTransparencyAttributes(
//      new TransparencyAttributes(
//      TransparencyAttributes.BLENDED, 0.2f));    

      return appearance;
   }

}