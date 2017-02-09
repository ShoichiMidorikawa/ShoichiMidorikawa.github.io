import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject2 extends TransformGroup{

   public MyObject2(){

   MyRotationInterpolator1 myRotationInterpolator1 
                         = new MyRotationInterpolator1();
   this.addChild(myRotationInterpolator1);



   }
}
 
