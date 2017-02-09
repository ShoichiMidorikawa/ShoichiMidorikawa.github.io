import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;


public class MyTransparencyInterpolator extends TransformGroup{

   public MyTransparencyInterpolator(){


/* --------------- ���[�J�����W�n�̐ݒ� -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      Transform3D transform3D = new Transform3D();
      transform3D.setScale(0.5);                           // new �X�P�[����0.5�ɏk�� 
      transformGroup.setTransform(transform3D);             


      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


    Color3f color3f = new Color3f(0.1f, 0.1f, 0.75f);  // 
    material.setAmbientColor(color3f);                // �����̐ݒ� 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // ��
    material.setDiffuseColor(color3f1);               // �g�U����(���ʂ̐F) 

 
    material.setShininess(12.8f);                     // ���̔��ˋ�̐ݒ�
    appearance.setMaterial(material);
 
    TransparencyAttributes transparencyAttributes =
      new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // �����x�̐ݒ�
    appearance.setTransparencyAttributes(transparencyAttributes);

/*------------------ tetrahedron�̐���-------------------------*/
    Tetrahedron tetrahedron = new Tetrahedron(appearance);         

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
			    8000,	 			// 1.0�b��1.0�Œ�~
			    8000,				// 8.0�b�Ԃ̊Ԃ�1.0��0.0�Ɍ���
			    4000,				// 5.0�b�ԉ�������
			    8000);				// 0.0�b��0.0�Œ�~	   (B)



/* --------------- ��]������A�j���[�V�����̒�` ------*/
      TransparencyInterpolator transparencyInterpolator = new TransparencyInterpolator(
         alpha, transparencyAttributes, 0.00f, 1.00f);


/* --------------- �`��͈͂̐ݒ� --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere(new Point3d(), 100.0);
// �@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@   BoundingSphere(���S�_,���a)                             

      transparencyInterpolator.setSchedulingBounds(boundingSphere);
      

/* ----------------- ���̂��V�[���O���t�ɒǉ�-------------*/
      transformGroup.addChild(tetrahedron);
      this.addChild(transformGroup);
      this.addChild(transparencyInterpolator);
   }



}







      