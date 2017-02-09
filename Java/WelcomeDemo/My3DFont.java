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
      Vector3d vector3d = new Vector3d(0.0, 0.2, 0.0);      // �x�N�g���̒�`
      transform3D.setTranslation(vector3d);                 // ���s�ړ�
      transform3D.setScale(0.1);                           // new �X�P�[����0.1�ɏk�� 
      transformGroup.setTransform(transform3D);             


 
/*----------------- Font3D�̐����@-----------------*/
      Font3D font3D = new Font3D(new Font("Helvetica", Font.BOLD, 1),
                      new FontExtrusion());
//      Text3D textGeom = new Text3D(font3D, new String("Java3D�̐��E�ցI"));
//      Text3D textGeom = new Text3D(font3D, new String("�X��w�ցI"));
      Text3D textGeom = new Text3D(font3D, new String("�ΐ쌤�����ցI"));
      textGeom.setAlignment(Text3D.ALIGN_CENTER);
      Shape3D textShape = new Shape3D();
      textShape.setGeometry(textGeom);

/*---------- �e�L�X�g���V�[���O���t�ɒǉ� ---------*/
      transformGroup.addChild(textShape);
      this.addChild(transformGroup);


   }
}
 
