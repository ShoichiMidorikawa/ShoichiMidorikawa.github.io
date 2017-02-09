import javax.media.j3d.*;
import javax.vecmath.*;



public class DrawLine extends Shape3D{

   static int n = 200;
   static Point3d[] vertices = new Point3d[n+1];
   static Color3f[] colors   = new Color3f[n+1];
   
   public DrawLine(){
     super(createGeometry(), createAppearance());   
    }

   
   private static Geometry createGeometry(){
     // O‚Â—tŒ‹‚Ñ(¶)
     for(int i = 0; i < n+1; i++){
	double r = 0.15*(Math.cos(3.*Math.PI*((double)i/(double)n-1./8.))*Math.cos(3.*Math.PI*((double)i/(double)n-1./8.))+1.5);
	//double r = 0.2*(Math.cos(3.*Math.PI*((double)i/(double)n))*Math.cos(3.*Math.PI*((double)i/(double)n))+1.4);
        double x = r*Math.cos(4.*Math.PI*i/n);
        double y = r*Math.sin(4.*Math.PI*i/n);
        double z = -0.2*r*Math.sin(6.*Math.PI*i/n);
        vertices[i] = new Point3d(x, y, z);
     }

     for(int i = 0; i < n+1; i++){
       float cr = (float)(1.0);       
       float cg = (float)(1.0);
       float cb = (float)(1.0);
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








