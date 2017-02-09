import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class MyTetrahedron2 extends TransformGroup{
  
   Appearance app = createAppearance(); 

   public MyTetrahedron2(){

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      
     
//       Vector3d vector3d = new Vector3d(0.f, 0.f, 0.f);
//       transform3D.setTranslation(vector3d);

       Transform3D transform3D2 = new Transform3D();
       transform3D.rotZ(Math.PI);
       transform3D.mul(transform3D2);

       Transform3D transform3D3 = new Transform3D();
       transform3D.rotX(Math.PI);
       transform3D2.mul(transform3D3);


       transform3D.setScale(0.17f);                     // new ƒXƒP[ƒ‹‚ğ0.5/3‚Ék¬ 
       transformGroup.setTransform(transform3D);             
 
       Tetrahedron tetrahedron = new Tetrahedron(app);         
       transformGroup.addChild(tetrahedron);

       this.addChild(transformGroup);
   }

   private static Appearance createAppearance(){

      Appearance appearance = new Appearance();

    Material material = new Material();
                         
    Color3f color3f = new Color3f(0.1f, 0.1f, 0.8f);  // 
    material.setAmbientColor(color3f);                // ŠÂ‹«Œõ‚Ìİ’è 
    Color3f color3f1 = new Color3f(0.0f, 1.0f, 0.0f); // —Î
    material.setDiffuseColor(color3f1);               // ŠgU”½Ë(•’Ê‚ÌF) 
 
    material.setShininess(12.8f);                     // Œõ‚Ì”½Ë‹ï‡‚Ìİ’è
    appearance.setMaterial(material);

//    appearance.setTransparencyAttributes(new TransparencyAttributes
//        (TransparencyAttributes.BLENDED, 0.2f));
 
      return appearance;
   }
}
 
