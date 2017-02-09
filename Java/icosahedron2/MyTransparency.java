import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;

public class MyTransparency extends TransformGroup{
   

   public MyTransparency(){

/* --------------- �^�[�Q�b�g���W�n�̐ݒ� -------------------*/
      TransformGroup target = new TransformGroup();

      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


      Color3f color3fa = new Color3f(0.1f, 0.9f, 0.1f);  // 
      material.setAmbientColor(color3fa);                // �����̐ݒ� 
      Color3f color3f1 = new Color3f(0.0f, 1.0f, 0.0f);  // ��
      material.setDiffuseColor(color3f1);                // �g�U����(���ʂ̐F) 

      material.setShininess(12.8f);                     // ���̔��ˋ�̐ݒ�

      appearance.setMaterial(material);
      TransparencyAttributes transparencyAttributes =
         new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // �����x�̐ݒ�
    appearance.setTransparencyAttributes(transparencyAttributes);


/* --------------- �L�����N�^�[�̐��� ----------------------*/
      Icosahedron icosahedron = new Icosahedron(appearance);


/* --------------- �`��͈͂̒�` --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();


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
//      directionalLight.setInfluencingBounds(boundingSphere);



/* ----------------- ���̂��V�[���O���t�ɒǉ�-------------*/

/*     
      transformGroup.addChild(transparencyInterpolator);
      objRoot.addChild(transformGroup);
      objRoot.addChild(directionalLight);
      objRoot.addChild(ambientLight);
*/





/* --------------- ���̓����V�[���O���t�ɒǉ� --------------*/
      target.addChild(transparencyInterpolator);
      target.addChild(icosahedron);
      this.addChild(target);

   }

}


