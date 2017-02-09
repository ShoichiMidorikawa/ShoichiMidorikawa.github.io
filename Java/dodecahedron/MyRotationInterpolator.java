import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;

public class MyRotationInterpolator extends BranchGroup{
   

   public MyRotationInterpolator(Appearance app){



/* --------------- �^�[�Q�b�g���W�n�̐ݒ� -------------------*/
      TransformGroup target = new TransformGroup();


/* --------------- �L�����N�^�[�̐��� ----------------------*/
      MyObject1 myObject1 = new MyObject1(app);


/* --------------- �`��͈͂̒�` --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability �̐ݒ� -----------------------*/
      target.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      target.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);


/* --------------- �A���t�@�l�̐��� ------------------------*/
      Alpha alpha = new Alpha(-1, 3000);      // 3�b��1��]�@3000 = 3000�~���b

/* --------------- ��]���̐ݒ� ---------------------------*/
      Transform3D axis = new Transform3D();
//      float q = (float)(1/Math.sqrt(2));
//      axis.setRotation(new AxisAngle4f(q, 0.0f, q, 1.f));

      // ��]�p�C���^�[�|���[�^�E�I�u�W�F�N�g�̐���
      RotationInterpolator rotationInterpolator = new RotationInterpolator(
         alpha, target, axis, 0.0f, 6.28f);

/* --------------- �`��͈͂̐ݒ� --------------------------*/
      rotationInterpolator.setSchedulingBounds(boundingSphere);

/* --------------- ���̓����V�[���O���t�ɒǉ� --------------*/
      target.addChild(rotationInterpolator);
      target.addChild(myObject1);
      this.addChild(target);

   }

}


