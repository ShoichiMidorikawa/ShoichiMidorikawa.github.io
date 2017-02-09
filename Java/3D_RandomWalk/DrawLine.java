import javax.media.j3d.*;
import javax.vecmath.*;



public class DrawLine extends Shape3D{

   static Point3d[] vertices = new Point3d[6];
   static Color3f[] colors   = new Color3f[6];
   
   public DrawLine(){

     super(createGeometry(), createAppearance());

   
    }

   
   private static Geometry createGeometry(){

     vertices[0]  = new Point3d( -1.0  ,  0.0  , 0.0  );
     vertices[1]  = new Point3d(  1.0  ,  0.0  , 0.0  );
     
     vertices[2]  = new Point3d( 0.0,  -1.0  , 0.0  );
     vertices[3]  = new Point3d( 0.0  , 1.0  , 0.0  );

     vertices[4]  = new Point3d( 0.0  ,  0.0  , -1.0  );
     vertices[5]  = new Point3d( 0.0  ,  0.0  ,  1.0  );



     colors[0] = new Color3f(0.9f, 0.1f, 1.0f);
     colors[1] = new Color3f(0.8f, 0.2f, 1.0f);
     colors[2] = new Color3f(0.8f, 0.2f, 1.0f);
     colors[3] = new Color3f(0.7f, 0.3f, 1.0f);
     colors[4] = new Color3f(0.7f, 0.3f, 1.0f);
     colors[5] = new Color3f(0.6f, 0.4f, 1.0f);



    LineArray geometry = new LineArray(vertices.length, LineArray.COORDINATES |
                             LineArray.COLOR_3);
    geometry.setCoordinates(0, vertices);
    
    geometry.setColors(0, colors);
    
    return geometry;
  }

   private static Appearance createAppearance(){

      Appearance appearance = new Appearance();

      return appearance;
   }
}   








