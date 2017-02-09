/*                            */
/*    ínãÖÇÃãOìπÇÃì«Ç›çûÇ›    */
/*                            */
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

     Transform3D t3d = new Transform3D();
     TransformGroup trans = new TransformGroup(t3d);
     
     DrawOrbit drawOrbit = new DrawOrbit();

     trans.addChild(drawOrbit);

     return trans;
   }

}
