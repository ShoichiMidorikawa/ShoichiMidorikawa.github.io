import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject1 extends TransformGroup{

   public MyObject1(){

   MyTransparencyInterpolator myTransparencyInterpolator 
                         = new MyTransparencyInterpolator();
   this.addChild(myTransparencyInterpolator);

   MyDrawLine myDrawLine = new MyDrawLine();
   this.addChild(myDrawLine);

   MyTetrahedron2 myTetrahedron2 = new MyTetrahedron2();
   this.addChild(myTetrahedron2);

   }
}
 
