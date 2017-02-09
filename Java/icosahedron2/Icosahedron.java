/*       Icosahedron.java  (正20面体)                */
/*       材質を設定                                  */
/*       インデックス付き3角形ポリゴン(完成)         */
/*  　　 Geometry/NormalGeneratorの使用              */

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class Icosahedron extends Shape3D{

   public Icosahedron(Appearance app){
      super(createGeometry(), app);
   }

   private static Geometry createGeometry(){

      float r = 0.7f;
      double phi = 2.0*Math.PI/5.0;
      double c_p = Math.cos(phi);
      double s_p = Math.sin(phi);
      double c_p2 = Math.cos(phi*2.0);
      double s_p2 = Math.sin(phi*2.0);
      double c_p3 = Math.cos(phi*3.0);
      double s_p3 = Math.sin(phi*3.0);
      double c_p4 = Math.cos(phi*4.0);
      double s_p4 = Math.sin(phi*4.0);

      double s_t = c_p/(1.0-c_p);
      double c_t = Math.sqrt(1.0 - s_t*s_t);

      float x1 = (float)(r*c_t);
      float y1 = 0.0f;
      float z1 = (float)(r*s_t);

      float x2 = (float)(r*c_t*c_p);
      float y2 = (float)(r*c_t*s_p); 
      float z2 = z1;

      float x3 = (float)(r*c_t*c_p2);
      float y3 = (float)(r*c_t*s_p2); 
      float z3 = z1;
 
      float x4 = (float)(r*c_t*c_p3);
      float y4 = (float)(r*c_t*s_p3); 
      float z4 = z1;

      float x5 = (float)(r*c_t*c_p4);
      float y5 = (float)(r*c_t*s_p4); 
      float z5 = z1;


      double ph = Math.PI/5.0;
      double c_p0s = Math.cos(ph);
      double s_p0s = Math.sin(ph);
      double c_p1s = Math.cos(phi+ph);
      double s_p1s = Math.sin(phi+ph);
      double c_p2s = Math.cos(phi*2.0+ph);
      double s_p2s = Math.sin(phi*2.0+ph);
      double c_p3s = Math.cos(phi*3.0+ph);
      double s_p3s = Math.sin(phi*3.0+ph);
      double c_p4s = Math.cos(phi*4.0+ph);
      double s_p4s = Math.sin(phi*4.0+ph);

      float x6 = (float)(r*c_t*c_p0s);
      float y6 = (float)(r*c_t*s_p0s);
      float z6 = -(float)(r*s_t);

      float x7 = (float)(r*c_t*c_p1s);
      float y7 = (float)(r*c_t*s_p1s); 
      float z7 = -z1;

      float x8 = (float)(r*c_t*c_p2s);
      float y8 = (float)(r*c_t*s_p2s); 
      float z8 = -z1;
 
      float x9 = (float)(r*c_t*c_p3s);
      float y9 = (float)(r*c_t*s_p3s); 
      float z9 = -z1;

      float x10 = (float)(r*c_t*c_p4s);
      float y10 = (float)(r*c_t*s_p4s); 
      float z10 = -z1;


      // インデックス付き3角形ポリゴンの指定

      Point3f[] p = new Point3f[12];

         p[0] = new Point3f(0.0f, 0.0f, r);
         p[1] = new Point3f( x1, y1, z1);
         p[2] = new Point3f( x2, y2, z2);
         p[3] = new Point3f( x3, y3, z3);
         p[4] = new Point3f( x4, y4, z4);  
         p[5] = new Point3f( x5, y5, z5);
         p[6] = new Point3f( x6, y6, z6);
         p[7] = new Point3f( x7, y7, z7);
         p[8] = new Point3f( x8, y8, z8);
         p[9] = new Point3f( x9, y9, z9);
         p[10] = new Point3f( x10, y10, z10);
         p[11] = new Point3f(0.0f, 0.0f, -r);

      int n = 60;

      Point3f[] vertices = new Point3f[n];

         vertices[0] = p[0];
         vertices[1] = p[1];
         vertices[2] = p[2];
         vertices[3] = p[0];
         vertices[4] = p[2];
         vertices[5] = p[3];
         vertices[6] = p[0];
         vertices[7] = p[3];
         vertices[8] = p[4];
         vertices[9] = p[0];
         vertices[10] = p[4];
         vertices[11] = p[5];
         vertices[12] = p[0];
         vertices[13] = p[5];
         vertices[14] = p[1];
         vertices[15] = p[1];
         vertices[16] = p[6];
         vertices[17] = p[2];
         vertices[18] = p[2];
         vertices[19] = p[6];
         vertices[20] = p[7];
         vertices[21] = p[2];
         vertices[22] = p[7];
         vertices[23] = p[3];
         vertices[24] = p[3];
         vertices[25] = p[7];
         vertices[26] = p[8];
         vertices[27] = p[3];
         vertices[28] = p[8];
         vertices[29] = p[4];
         vertices[30] = p[4];
         vertices[31] = p[8];
         vertices[32] = p[9];
         vertices[33] = p[4];
         vertices[34] = p[9];
         vertices[35] = p[5];
         vertices[36] = p[5];
         vertices[37] = p[9];
         vertices[38] = p[10];
         vertices[39] = p[5];
         vertices[40] = p[10];
         vertices[41] = p[1];
         vertices[42] = p[1];
         vertices[43] = p[10];
         vertices[44] = p[6];
         vertices[45] = p[6];
         vertices[46] = p[11];
         vertices[47] = p[7];
         vertices[48] = p[7];
         vertices[49] = p[11];
         vertices[50] = p[8];
         vertices[51] = p[8];
         vertices[52] = p[11];
         vertices[53] = p[9];
         vertices[54] = p[9];
         vertices[55] = p[11];
         vertices[56] = p[10];
         vertices[57] = p[10];
         vertices[58] = p[11];
         vertices[59] = p[6];

/*
     
      int[] indices = {  0, 1, 2,
                         0, 2, 3,
                         0, 3, 4,
                         0, 4, 5,
                         0, 5, 1,
                         1, 6, 2,
                         2, 6, 7,
                         2, 7, 3,
                         3, 7, 8,
                         3, 8, 4,
                         4, 8, 9, 
                         4, 9, 5, 
                         5, 9, 10, 
                         5, 10, 1,
                         1, 10, 6,
                         11, 7, 6,
                         11, 8, 7,
                         11, 9, 8, 
                         11, 10, 9,
                         11, 6, 10                  
                      }; 
*/
       
      TriangleArray geometry = new TriangleArray(vertices.length, 
         TriangleArray.COORDINATES | TriangleArray.NORMALS);

      geometry.setCoordinates(0, vertices);

      Vector3f normal, v1, v2;

      for(int i = 0; i < n ; i+=3){
         v1 = new Vector3f();
         v1.sub(vertices[i+1], vertices[i]);
         v2 = new Vector3f();
         v2.sub(vertices[i+2], vertices[i]);
         normal = new Vector3f();
         normal.cross(v1, v2);
         normal.normalize();
         geometry.setNormal(i, normal);
         geometry.setNormal(i+1, normal);
         geometry.setNormal(i+2, normal);
      };

 
      return geometry;


   }

/*  
   private static Appearance createAppearance(){
    Appearance appearance;
    Material material;

    appearance = new Appearance();
    material = new Material();

    Color3f color3f = new Color3f(0.1f, 0.9f, 0.1f);
    material.setAmbientColor(color3f);
    Color3f color3f1 = new Color3f(0.0f, 1.0f, 0.0f);
    material.setDiffuseColor(color3f1);

    Color3f color3f2 = new Color3f(0.316228f, 0.368228f, 0.3168228f);
    material.setSpecularColor(color3f1);
    material.setShininess(12.8f);
    // 光の反射具合の設定
   appearance.setMaterial(material);

 
   // 透明度の設定
   appearance.setTransparencyAttributes(
      new TransparencyAttributes(
      TransparencyAttributes.BLENDED, 0.2f));    

      return appearance;
   }
*/
}   








