import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;

public class MyRotationInterpolator extends BranchGroup{
   

   public MyRotationInterpolator(Appearance app){



/* --------------- ターゲット座標系の設定 -------------------*/
      TransformGroup target = new TransformGroup();


/* --------------- キャラクターの生成 ----------------------*/
      MyObject1 myObject1 = new MyObject1(app);


/* --------------- 描画範囲の定義 --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability の設定 -----------------------*/
      target.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      target.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);


/* --------------- アルファ値の生成 ------------------------*/
      Alpha alpha = new Alpha(-1, 3000);      // 3秒で1回転　3000 = 3000ミリ秒

/* --------------- 回転軸の設定 ---------------------------*/
      Transform3D axis = new Transform3D();
//      float q = (float)(1/Math.sqrt(2));
//      axis.setRotation(new AxisAngle4f(q, 0.0f, q, 1.f));

      // 回転用インターポレータ・オブジェクトの生成
      RotationInterpolator rotationInterpolator = new RotationInterpolator(
         alpha, target, axis, 0.0f, 6.28f);

/* --------------- 描画範囲の設定 --------------------------*/
      rotationInterpolator.setSchedulingBounds(boundingSphere);

/* --------------- 物体等をシーングラフに追加 --------------*/
      target.addChild(rotationInterpolator);
      target.addChild(myObject1);
      this.addChild(target);

   }

}


