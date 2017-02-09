import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.applet.MainFrame;

public class RotateLine2 extends Applet{

   public RotateLine2(){

/*----------------- �V�[���O���t�̍\�z�@------------------*/
      Canvas3D canvas3D = 
          new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      this.setLayout(borderLayout);
      this.add(canvas3D, BorderLayout.CENTER);
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
      BranchGroup objRoot = new BranchGroup();

/*------------------ �����Ɋւ���ݒ�  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      DirectionalLight directionalLight = new DirectionalLight();
      directionalLight.setInfluencingBounds(boundingSphere);

      TransformGroup transformGroup = new TransformGroup();


/*------------------  ����̐���-------------------------*/
      DrawLine2 drawLine2 = new DrawLine2();


      Transform3D transform3D = new Transform3D();
      transformGroup.setTransform(transform3D);
      transformGroup.addChild(drawLine2);


/*------------------ Capability�̐ݒ� --------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      transformGroup.setCapability(TransformGroup.ENABLE_PICK_REPORTING);

/*------------------ ��]������s�b�L���O�̒�` ----------*/
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 


/* ----------------- ���̂��V�[���O���t�ɒǉ�-------------*/
      objRoot.addChild(pickRotateBehavior);
      objRoot.addChild(transformGroup);
      objRoot.addChild(directionalLight);

/* ----------------- ���̑��̃c���[���V�[���O���t�ɒǉ�----*/
      simpleUniverse.addBranchGraph(objRoot);
   }


/* ----------------- �t�@�C���̌Ăяo��--------------------*/
   public static void main(String[] args){
      RotateLine2 rotateLine = new RotateLine2();
      MainFrame frame = new MainFrame(rotateLine, 500, 500);
   }
}







      