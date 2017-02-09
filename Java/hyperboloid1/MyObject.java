import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject extends TransformGroup{

   public MyObject(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      transform3D.rotX(Math.PI/2);
      transformGroup.setTransform(transform3D);             
   

      MyHyperboloid myHyperboloid = new MyHyperboloid();
      transformGroup.addChild(myHyperboloid);
      this.addChild(transformGroup);

   }
}
 
