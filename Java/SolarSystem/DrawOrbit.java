import javax.media.j3d.*;
import javax.vecmath.*;



public class DrawOrbit extends Shape3D{

   static  int n = 200;
   static Point3d[] vertices = new Point3d[n+1];
   static Color3f[] colors   = new Color3f[n+1];
   
   public DrawOrbit(){
     super(createGeometry(), createAppearance());   
    }

   
   private static Geometry createGeometry(){
     double p = 0.49; 
     double e = 0.3;      

     for(int i = 0; i < n+1; i++){
        double r = p/(1.0 -e*Math.cos(2*Math.PI*i/n));
        double x = r*Math.cos(2*Math.PI*i/n);
        double y = r*Math.sin(2*Math.PI*i/n);
        double z = 0.0;
        vertices[i] = new Point3d(x, y, z);
     }

       float cr = (float)0.5;       
       float cg = (float)0.5;
       float cb = (float)0.5;     
     for(int i = 0; i < n+1; i++){
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








