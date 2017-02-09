/*       Icosahedron.java  (正20面体)                */
/*       線画　　　                                  */
/*       インデックス付き3角形ポリゴン(完成)         */
/*  　　                                             */

import javax.media.j3d.*;
import javax.vecmath.*;

public class DrawLine extends Shape3D{

   public DrawLine(){
      super(createGeometry(), createAppearance());
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

     
      int[] indices = {  0, 1,   0, 2,   0, 3,   0, 4,   0, 5, 
                         1, 2,   2, 3,   3, 4,   4, 5,   5, 1,
                         1, 6,   2, 7,   3, 8,   4, 9,   5, 10,
                         2, 6,   3, 7,   4, 8,   5, 9,   1, 10,
                         6, 7,   7, 8,   8, 9,   9, 10, 10, 6,
                         6, 11,  7, 11,  8, 11,  9, 11, 10, 11
                       };

      Color3f[] colors = new Color3f[1];
         colors[0] = new Color3f(0.0f, 1.0f, 0.0f);

       int n = 12;
       int[] colorIndices = new int[n];
    
       for(int i = 0; i < n ; i++){
          colorIndices[i] = 0;
       }  

       IndexedLineArray geometry =
         new IndexedLineArray( p.length,
                 IndexedLineArray.COORDINATES | IndexedLineArray.COLOR_3,
                            indices.length);
       geometry.setCoordinates(0, p);
       geometry.setCoordinateIndices(0, indices);
       geometry.setColors(0, colors);
       geometry.setColorIndices(0, colorIndices);

      return geometry;
   }
  
   private static Appearance createAppearance(){

      Appearance appearance;
      appearance = new Appearance();
      return appearance;
   }

}   
