import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyPolygon2 extends TransformGroup{

   public MyPolygon2(){
      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      
     
       Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
       transform3D.setTranslation(vector3d);
       transform3D.setScale(0.15);                       // スケールを0.15に縮小 
       transformGroup.setTransform(transform3D);             
 
       Polygon2 polygon = new Polygon2();         
       transformGroup.addChild(polygon);
       this.addChild(transformGroup);


   }
}
 
