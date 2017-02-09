/* ------------------------------------------------------------------------ */
/*                                                                          */
/*  MousePicking��TransparencyInterpolator, RotationInterpolator�̑g����    */                                   
/*                                                                          */
/* ------------------------------------------------------------------------ */

import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.applet.MainFrame;

/*
<applet code="MousePicking" width=900 height=500>
</applet>
*/


public class MousePicking extends Applet{

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


/* --------------- ���[�J�����W�n�̐ݒ� -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      Transform3D transform3D = new Transform3D();


      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


    Color3f color3fa = new Color3f(0.1f, 0.1f, 0.9f);  // 
    material.setAmbientColor(color3fa);                // �����̐ݒ� 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // ��
    material.setDiffuseColor(color3f1);               // �g�U����(���ʂ̐F) 

 
    material.setShininess(12.8f);                     // ���̔��ˋ�̐ݒ�


    appearance.setMaterial(material);
    TransparencyAttributes transparencyAttributes =
      new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // �����x�̐ݒ�
    appearance.setTransparencyAttributes(transparencyAttributes);


/*------------------ myObject�̐���-------------------------*/
      MyObject myObject = new MyObject(appearance); 


/*------------------ Capability�̐ݒ� --------------------*/
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_WRITE);  // change
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_READ);   // change
      myObject.setCapability(MyObject.ENABLE_PICK_REPORTING);  // change


/*------------------ ��]������s�b�L���O�̒�` ----------*/
/* �@�@�@�@�@�@�@�}�E�X�̍��{�^���������Ȃ��瓮����       */
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 



/*------------------ Capability�̐ݒ� --------------------*/
    appearance.setCapability(Appearance.ALLOW_MATERIAL_READ);
    appearance.setCapability(Appearance.ALLOW_MATERIAL_WRITE);

    transparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_READ);
    transparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);
    

/* --------------- �A���t�@�l�̐��� ------------------------*/
      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// ������
			    Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
			    					// �������茸������
			    0,					// �����ɓ����n�߂�
			    0,   				// 0.0�ł��΂炭�Î~
			    8000,				// 8.0�b�Ԃ̊Ԃ�0.0��1.0�ɑ���
			    4000,				// 8.0�b�ԉ�������
			    1000,	 			// 1.0�b��1.0�Œ�~
			    8000,				// 8.0�b�Ԃ̊Ԃ�1.0��0.0�Ɍ���
			    4000,				// 5.0�b�ԉ�������
			    0000);				// 0.0�b��0.0�Œ�~	   (B)



/* --------------- �����x�ω��C���^�[�|���[�^�̒�` ------*/
      TransparencyInterpolator transparencyInterpolator = new TransparencyInterpolator(
         alpha, transparencyAttributes, 0.00f, 1.00f);


/* --------------- �`��͈͂̐ݒ� --------------------------*/
      transparencyInterpolator.setSchedulingBounds(boundingSphere);
      directionalLight.setInfluencingBounds(boundingSphere);
      

/* ----------------- ���̂��V�[���O���t�ɒǉ�-------------*/
      transformGroup.addChild(myObject);
      objRoot.addChild(pickRotateBehavior);
      transformGroup.addChild(transparencyInterpolator);
      objRoot.addChild(transformGroup);
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




      