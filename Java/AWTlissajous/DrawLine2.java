import javax.media.j3d.*;
import javax.vecmath.*;



public class DrawLine2 extends Shape3D{

   static  int n = 200;
   static Point3d[] vertices = new Point3d[n+1];
   static Color3f[] colors   = new Color3f[n+1];
   
   public DrawLine2(){
     super(createGeometry(), createAppearance());   
    }

   
   private static Geometry createGeometry(){
     
     for(int i = 0; i < n+1; i++){
        double x = 0.5*Math.sin(6*Math.PI*i/n);
        double y = 0.5*Math.sin(8*Math.PI*i/n);
        double z = 0.5*Math.cos(10*Math.PI*i/n);
        vertices[i] = new Point3d(x, y, z);
     }

     
     for(int i = 0; i < n+1; i++){
       float cr = (float)((1.0 + Math.sin(4*Math.PI*i/n))/2.0);       
       float cg = 0.0f;
        // (float)((1.0 + Math.sin(4*(2*Math.PI*i/n + Math.PI/3)))/2.0);
       float cb = (float)((1.0 + Math.sin(4*(Math.PI*i/n +Math.PI/4)))/2.0);
       colors[i] = new Color3f(cr, cg, cb);
       }


 
    int[] stripVertexCounts = {n+1};

    LineStripArray geometry = new LineStripArray(vertices.length, 
                  GeometryArray.COORDINATES | GeometryArray.COLOR_3,
                  stripVertexCounts);


    geometry.setCoordinates(0, vertices);    
    geometry.setColors(0, colors);
    
    return geometry;
  }

   private static Appearance createAppearance(){

      Appearance appearance = new Appearance();

      return appearance;
   }
}   








