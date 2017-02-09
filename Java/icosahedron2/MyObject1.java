import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject1 extends TransformGroup{

   public MyObject1(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
      transform3D.setTranslation(vector3d);
      transform3D.setScale(0.4);                           // new ÉXÉPÅ[ÉãÇ0.5Ç…èkè¨ 
      transformGroup.setTransform(transform3D);             

      DrawLine drawLine = new DrawLine();
      transformGroup.addChild(drawLine);
 
      Icosahedron icosahedron = new Icosahedron();         
      transformGroup.addChild(icosahedron);

      this.addChild(transformGroup);
 


   }
}
 
