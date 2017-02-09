/*       Hyperboloid2.java (hyperboloid of 2 sheets ��t�o�Ȗ�)  */
/*       �ގ���ݒ�                             �@�@�@�@�@�@�@�@ */
/*       �C���f�b�N�X�t��4�p�`�|���S��(����)                     */
/*       GeometryInfo/NormalGenerator�̎g�p                      */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Hyperboloid2 extends Shape3D{

   public Hyperboloid2(){
      super(createGeometry(), createAppearance());
   }

   private static Geometry createGeometry(){

      // �C���f�b�N�X�t��4�p�`�|���S���̎w��


    int n = 201;
    int m = 101;

    float a = 2.0f;
    float b = 1.0f;
    float c = 3.0f;



    Point3f[] vertices = new Point3f[n*m];

      float theta0 = 0.0f;
      float phi0 = 0.0f;
    
      float Dtheta = 2.0f*(float)Math.PI/(n-1);
      float Dphi = 2.0f/(m-1);


    float phi = phi0;
    for(int j  = 0; j < m; j++){
       float  theta = theta0;
   
       for(int i = 0; i < n; i++){
         int k = i + n*j;
         float x = (float)(a*Math.cos(theta)*Math.sinh(phi));
         float y = (float)(b*Math.sin(theta)*Math.sinh(phi));
         float z = -(float)(c*Math.cosh(phi));
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
    Color3f color3f = new Color3f(1.0f, 0.0f, 0.0f);  // ��
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