import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyHyperCyl extends TransformGroup{

   public MyHyperCyl(){
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


      HyperCyl1_1 hyperCyl1_1 = new HyperCyl1_1();         
      transformGroup.addChild(hyperCyl1_1);

      HyperCyl1_2 hyperCyl1_2 = new HyperCyl1_2();         
      transformGroup.addChild(hyperCyl1_2);

      HyperCyl2_1 hyperCyl2_1 = new HyperCyl2_1();         
      transformGroup.addChild(hyperCyl2_1);

      HyperCyl2_2 hyperCyl2_2 = new HyperCyl2_2();         
      transformGroup.addChild(hyperCyl2_2);

 
      this.addChild(transformGroup);
 


   }
}
 
