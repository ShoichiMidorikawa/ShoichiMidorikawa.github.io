import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyEllipticCone extends TransformGroup{

   public MyEllipticCone(){
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


      EllipticCone1 ellipticCone1 = new EllipticCone1();         
      transformGroup.addChild(ellipticCone1);

      EllipticCone2 ellipticCone2 = new EllipticCone2();         
      transformGroup.addChild(ellipticCone2);

 
      this.addChild(transformGroup);
 


   }
}
 
