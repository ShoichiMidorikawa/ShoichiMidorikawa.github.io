import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.applet.MainFrame;

public class MousePicking extends Applet{

/*
<applet code="MousePicking"  width=900 height=500>
</applet>
*/
 

   public MousePicking(){

/*----------------- �V�[���O���t�̍\�z�@------------------*/
      Canvas3D canvas3D = 
          new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      this.setLayout(borderLayout);
      this.add(canvas3D, BorderLayout.CENTER);
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
      BranchGroup objRoot = new BranchGroup();


/* ---------------- �����̒�` --------------------------*/
      Color3f color3fD = new Color3f(1.0f, 1.0f, 1.0f);
      Vector3f vector3f = new Vector3f(-1.0f, -1.0f, -1.0f);   
      DirectionalLight directionalLight = 
               new DirectionalLight(color3fD, vector3f);


/* ----------------- ��ԑS�̂��Ƃ炷�����` -------------*/
      Color3f color3fA = new Color3f(1.0f, 1.0f, 1.0f);
      AmbientLight ambientLight = new AmbientLight(color3fA);

/*------------------ �����Ɋւ���ݒ�  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere(new Point3d(), 100.0);
// �@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@   BoundingSphere(���S�_,���a)                             
      directionalLight.setInfluencingBounds(boundingSphere);
      ambientLight.setInfluencingBounds(boundingSphere);
  

/* -------------------------------------------------------------*/
      Color3f color3f = new Color3f(1.0f, 1.0f, 0.0f);
      Background background = new Background(color3f);
      background.setApplicationBounds(boundingSphere);
      directionalLight.setInfluencingBounds(boundingSphere); 


/*------------------ myObject�̐���-------------------------*/
      MyObject myObject = new MyObject();
 

/*------------------ Capability�̐ݒ� --------------------*/
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_WRITE);  // change
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_READ);   // change
      myObject.setCapability(MyObject.ENABLE_PICK_REPORTING);  // change


/*------------------ ��]������s�b�L���O�̒�` ----------*/
/* �@�@�@�@�@�@�@�}�E�X�̍��{�^���������Ȃ��瓮����       */
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 


/*------------------ �Y�[��������s�b�L���O�̒�` ----------*/
/*        Alt�L�[�ƂƂ��Ƀ}�E�X�̍��{�^���������Ȃ��瓮���� */              
      PickZoomBehavior pickZoomBehavior = new PickZoomBehavior(
         objRoot, canvas3D, boundingSphere); 


/*------------------ �ړ�������s�b�L���O�̒�` ----------*/
/*               �}�E�X�̉E�{�^���������Ȃ��瓮�����@�@�@ */
      PickTranslateBehavior pickTranslateBehavior = new PickTranslateBehavior(
         objRoot, canvas3D, boundingSphere); 
      

/* ----------------- ���̂��V�[���O���t�ɒǉ�-------------*/
      objRoot.addChild(pickRotateBehavior);
      objRoot.addChild(pickZoomBehavior);
      objRoot.addChild(pickTranslateBehavior);
      objRoot.addChild(myObject);
      objRoot.addChild(directionalLight);
      objRoot.addChild(ambientLight);


/* ----------------- ���̑��̃c���[���V�[���O���t�ɒǉ�----*/
      simpleUniverse.addBranchGraph(objRoot);
   }


/* ----------------- �t�@�C���̌Ăяo��--------------------*/
   public static void main(String[] args){
      MousePicking mousePicking = new MousePicking();
      MainFrame frame = new MainFrame(mousePicking, 900, 500);
   }
}

      