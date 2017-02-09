import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject1 extends TransformGroup{

   public MyObject1(){


   MyOctahedron myOctahedron = new MyOctahedron();
   this.addChild(myOctahedron);

   MyHexahedron myHexahedron = new MyHexahedron();
   this.addChild(myHexahedron);

   }
}
 
