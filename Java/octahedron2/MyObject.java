import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject extends TransformGroup{

   public MyObject(){


   MyRotationInterpolator myRotationInterpolator =
           new MyRotationInterpolator(); 

   this.addChild(myRotationInterpolator);

   }
}
 
