import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyObject extends TransformGroup{

   public MyObject(){
      Appearance appearance = new Appearance();
      Material material = new Material();
      material.setLightingEnable(true);
      appearance.setMaterial(material);

      MoebiusStrip moebiusStrip = new MoebiusStrip();
      moebiusStrip.setAppearance(appearance);

      this.addChild(moebiusStrip);



   }
}   