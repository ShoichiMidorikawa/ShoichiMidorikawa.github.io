import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyDrawLine extends TransformGroup{
  

   public MyDrawLine(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      
       transform3D.setScale(0.5f);                     // new ÉXÉPÅ[ÉãÇ0.5/3Ç…èkè¨ 
       transformGroup.setTransform(transform3D);             
 
       DrawLine drawLine = new DrawLine();         
       transformGroup.addChild(drawLine);
       this.addChild(transformGroup);
   }


}
 
