import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyCone extends TransformGroup{

   public MyCone(){
      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
       transform3D.setScale(0.2);                           // new ÉXÉPÅ[ÉãÇ0.2Ç…èkè¨ 
  
       Vector3d vector3d = new Vector3d(0.f, 0.0f, 0.f);
       transform3D.setTranslation(vector3d);
       transformGroup.setTransform(transform3D);             
       OriginalCone originalCone = new OriginalCone();         
       transformGroup.addChild(originalCone);

       OriginalCone2 originalCone2 = new OriginalCone2();         
       transformGroup.addChild(originalCone2);

       this.addChild(transformGroup);


   }
}
 
