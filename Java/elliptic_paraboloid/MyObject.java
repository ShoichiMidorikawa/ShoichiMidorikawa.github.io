import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject extends TransformGroup{

   public MyObject(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, -0.3, 0.0);
      transform3D.setTranslation(vector3d);
      transformGroup.setTransform(transform3D);             


   MyParaboloid myParaboloid = new MyParaboloid();
   transformGroup.addChild(myParaboloid);
   this.addChild(transformGroup);

   }
}
 
