import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class MyObject4 extends Applet {
  public MyObject4() {
  }

   public static TransformGroup createObject() {


      TransformGroup transformGroup = new TransformGroup();  
      Transform3D transform3D = new Transform3D();
      transform3D.setScale(0.2);                           // new ÉXÉPÅ[ÉãÇ0.2Ç…èkè¨ 

      Vector3d vector3d = new Vector3d(0.f, 0.0f, 0.f);
      transform3D.setTranslation(vector3d);

      transformGroup.setTransform(transform3D);             

      Plane4 plane4 = new Plane4();
      transformGroup.addChild(plane4);

     return transformGroup;
   }

}
