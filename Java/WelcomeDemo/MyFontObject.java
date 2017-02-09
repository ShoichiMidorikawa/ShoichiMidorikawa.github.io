import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyFontObject extends TransformGroup{

   public MyFontObject(){

   My3DFont2 my3DFont2 = new My3DFont2();
   this.addChild(my3DFont2);

   My3DFont my3DFont = new My3DFont();
   this.addChild(my3DFont);
 
   }
}
 
