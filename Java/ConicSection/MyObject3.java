import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class MyObject3 extends Applet {
  public MyObject3() {
  }

   public static TransformGroup createObject() {

     TransformGroup transformGroup = new TransformGroup();  
     Transform3D transform3D = new Transform3D();
     transform3D.setScale(0.2);                           // new ÉXÉPÅ[ÉãÇ0.2Ç…èkè¨ 

      Vector3d vector3d = new Vector3d(0.f, 0.0f, 0.f);
      transform3D.setTranslation(vector3d);

      transformGroup.setTransform(transform3D);             

     Plane3 plane3 = new Plane3();
     transformGroup.addChild(plane3);

     return transformGroup;
   }

}
