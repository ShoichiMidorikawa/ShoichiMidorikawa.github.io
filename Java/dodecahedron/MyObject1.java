import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject1 extends TransformGroup{


   public MyObject1(Appearance app){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
       Vector3d vector3d = new Vector3d(0.f, 0.f, 0.f);
       transform3D.setTranslation(vector3d);
       transform3D.setScale(0.2);                           // new ÉXÉPÅ[ÉãÇ0.2Ç…èkè¨ 
       transformGroup.setTransform(transform3D);             


       MyDodecahedron myDodecahedron = new MyDodecahedron(app); 
       transformGroup.addChild(myDodecahedron);

       DrawLine drawLine = new DrawLine();
       transformGroup.addChild(drawLine);

       this.addChild(transformGroup);
   }



}
 
