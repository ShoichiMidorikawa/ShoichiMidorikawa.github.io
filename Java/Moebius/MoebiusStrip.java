import javax.media.j3d.*;
import javax.vecmath.*;

public class MoebiusStrip extends Shape3D{

   static int n = 50;
   static Point3d[] vertices = new Point3d[4*n+2];
   static Color3f[] colors   = new Color3f[4*n+2];
   static Vector3f[] normals = new Vector3f[4*n+2];

   public MoebiusStrip(){
      super(createGeometry(), createAppearance());
   }


   private static Geometry createGeometry(){

      double r = 0.6;
      double a = 0.25;     

      for(int i = 0; i < 4*n+1 ; i += 2){
         double rp = r + a*Math.sin(Math.PI*i/2.0/n);         
         double rn = r - a*Math.sin(Math.PI*i/2.0/n);         
         double xp = rp*Math.cos(Math.PI*i/n);
         double yp = rp*Math.sin(Math.PI*i/n);
         double xn = rn*Math.cos(Math.PI*i/n);
         double yn = rn*Math.sin(Math.PI*i/n);
         double zz = a*Math.cos(Math.PI*i/2.0/n);
         float x0 =  (float)(Math.cos(Math.PI*i/2.0/n)*Math.cos(2*Math.PI*i/n));
         float y0 =  (float)(Math.cos(Math.PI*i/2.0/n)*Math.sin(2*Math.PI*i/n));
         float z0 = -(float)Math.sin(Math.PI*i/2.0/n); 
         vertices[i]   = new Point3d(xp, yp, zz);
         normals[i]    = new Vector3f(x0, y0, z0);
         vertices[i+1] = new Point3d(xn, yn, -zz);
         normals[i+1]  = new Vector3f(x0, y0, z0);
      }

      for(int i = 0; i < 4*n+2 ; i++){
         colors[i] = new Color3f(0.2f, 0.8f, 0.4f);
      }
      


      int[] stripVertexCounts = {4*n+2}; 
      
      TriangleStripArray geometry = new TriangleStripArray(vertices.length, 
         GeometryArray.COORDINATES | GeometryArray.COLOR_3 |
         GeometryArray.NORMALS, 
         stripVertexCounts);

      geometry.setCoordinates(0, vertices);
      geometry.setColors(0, colors);
      geometry.setNormals(0, normals);

      return geometry;
   }


   private static Appearance createAppearance(){

      Appearance appearance = new Appearance();

      return appearance;
   }
}   








