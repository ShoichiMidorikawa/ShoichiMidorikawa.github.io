import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;

public class My3DFont extends TransformGroup{

   public My3DFont(){
      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);

      TransformGroup transformGroup = new TransformGroup(); 
      Transform3D transform3D = new Transform3D();
      Vector3d vector3d = new Vector3d(0.0, 0.2, 0.0);      // ベクトルの定義
      transform3D.setTranslation(vector3d);                 // 平行移動
      transform3D.setScale(0.1);                           // new スケールを0.1に縮小 
      transformGroup.setTransform(transform3D);             


 
/*----------------- Font3Dの生成　-----------------*/
      Font3D font3D = new Font3D(new Font("Helvetica", Font.BOLD, 1),
                      new FontExtrusion());
//      Text3D textGeom = new Text3D(font3D, new String("Java3Dの世界へ！"));
//      Text3D textGeom = new Text3D(font3D, new String("青森大学へ！"));
      Text3D textGeom = new Text3D(font3D, new String("緑川研究室へ！"));
      textGeom.setAlignment(Text3D.ALIGN_CENTER);
      Shape3D textShape = new Shape3D();
      textShape.setGeometry(textGeom);

/*---------- テキストをシーングラフに追加 ---------*/
      transformGroup.addChild(textShape);
      this.addChild(transformGroup);


   }
}
 
