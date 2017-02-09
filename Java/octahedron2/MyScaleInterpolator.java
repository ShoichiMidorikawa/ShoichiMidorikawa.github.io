import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;


public class MyScaleInterpolator extends TransformGroup{
   
   public MyScaleInterpolator(){



/* --------------- ���[�J�����W�n�̐ݒ� -------------------*/
      TransformGroup transformGroup = new TransformGroup();

      Transform3D transform3D = new Transform3D();

/* --------------- �L�����N�^�[�̐��� ----------------------*/
      Hexahedron hexahedron = new Hexahedron();

/* --------------- �`��͈͂̒�` --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability �̐ݒ� -----------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

/* --------------- �A���t�@�l�̐��� ------------------------*/
      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// ������
			    Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
			    				// �������茸������
			    0,				// �����ɓ����n�߂�
			    1000,			// 0.0�ł��΂炭�Î~
			    5000,			// 3.0�b�Ԃ̊Ԃ�0.0��1.0�ɑ���
			    1500,			// 1.5�b�ԉ�������
			    5000,	 		// 1.0�b��1.0�Œ�~
			    5000,			// 3.0�b�Ԃ̊Ԃ�1.0��0.0�Ɍ���
			    1500,			// 1.5�b�ԉ�������
			    5000);			// 1.0�b��1.0�Œ�~	   (B)




/* --------------- �g��E�k���A�j���[�V�����̒�` ------*/
      ScaleInterpolator scaleInterpolator = new ScaleInterpolator(
         alpha, transformGroup, transform3D, 0.338f, 0.993f);


/* --------------- �`��͈͂̐ݒ� --------------------------*/
      scaleInterpolator.setSchedulingBounds(boundingSphere);

/* --------------- ���̓����V�[���O���t�ɒǉ� --------------*/
      transformGroup.addChild(scaleInterpolator);
      transformGroup.addChild(hexahedron);
      this.addChild(transformGroup);


   }

}


