import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyHyperboloid extends TransformGroup{

   public MyHyperboloid(){
      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, 0.0, 0.0);
      transform3D.setTranslation(vector3d);
      transform3D.setScale(0.1);                           // new ÉXÉPÅ[ÉãÇ0.1Ç…èkè¨ 
      transformGroup.setTransform(transform3D);             


      Hyperboloid1 hyperboloid1 = new Hyperboloid1();         
      transformGroup.addChild(hyperboloid1);

      Hyperboloid2 hyperboloid2 = new Hyperboloid2();         
      transformGroup.addChild(hyperboloid2);

 
      this.addChild(transformGroup);
 


   }
}
 
