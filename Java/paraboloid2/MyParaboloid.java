import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyParaboloid extends TransformGroup{

   public MyParaboloid(){
      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
      transform3D.setTranslation(vector3d);
      transform3D.setScale(0.18);                           // new ÉXÉPÅ[ÉãÇ0.18Ç…èkè¨ 
      transformGroup.setTransform(transform3D);             


      Paraboloid1 paraboloid1 = new Paraboloid1();         
      transformGroup.addChild(paraboloid1);
 

      Paraboloid2 paraboloid2 = new Paraboloid2();         
      transformGroup.addChild(paraboloid2);

      this.addChild(transformGroup);
 


   }
}
 
