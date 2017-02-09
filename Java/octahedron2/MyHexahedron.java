import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyHexahedron extends TransformGroup{

   public MyHexahedron(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
      transform3D.setTranslation(vector3d);
      transform3D.setScale(0.35);                       // new ÉXÉPÅ[ÉãÇ0.35Ç…èkè¨ 
      transformGroup.setTransform(transform3D);             
 

      Hexahedron hexahedron = new Hexahedron();         
      transformGroup.addChild(hexahedron);

   }
}
 
