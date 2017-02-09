import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;


public class MyObject1 extends Applet {
  public MyObject1() {
  }

   public static TransformGroup createObject() {

      TransformGroup transformGroup = new TransformGroup();  
      Transform3D transform3D = new Transform3D();
      transform3D.setScale(0.2);                           // new ÉXÉPÅ[ÉãÇ0.2Ç…èkè¨ 

      Vector3d vector3d = new Vector3d(0.f, 0.0f, 0.f);
      transform3D.setTranslation(vector3d);

      transformGroup.setTransform(transform3D);             

      Plane1 plane1 = new Plane1();
      transformGroup.addChild(plane1);

     return transformGroup;
   }

}
