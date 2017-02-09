import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject3 extends TransformGroup{

   public MyObject3(){

   MyPolygon2 myPolygon = new MyPolygon2();
   this.addChild(myPolygon);

   MyPolygon2_2 myPolygon2 = new MyPolygon2_2();
   this.addChild(myPolygon2);

   MyPolygon2_3 myPolygon3 = new MyPolygon2_3();
   this.addChild(myPolygon3);

   MyPolygon2_4 myPolygon4 = new MyPolygon2_4();
   this.addChild(myPolygon4);

   MyPolygon2_5 myPolygon5 = new MyPolygon2_5();
   this.addChild(myPolygon5);

   }
}
 
