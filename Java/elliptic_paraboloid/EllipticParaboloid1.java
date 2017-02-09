/*       EllipticParaboloid1.java (elliptic paraboloid �ȉ~������)   */
/*       �ގ���ݒ�                             �@�@�@�@�@�@    �@�@ */
/*       �C���f�b�N�X�t��4�p�`�|���S��(����)                         */
/*       GeometryInfo/NormalGenerator�̎g�p                          */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class EllipticParaboloid1 extends Shape3D{

   public EllipticParaboloid1(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // �C���f�b�N�X�t��4�p�`�|���S���̎w��


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