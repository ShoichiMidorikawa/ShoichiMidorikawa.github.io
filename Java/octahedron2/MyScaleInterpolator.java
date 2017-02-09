import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;


public class MyScaleInterpolator extends TransformGroup{
   
   public MyScaleInterpolator(){



/* --------------- ローカル座標系の設定 -------------------*/
      TransformGroup transformGroup = new TransformGroup();

      Transform3D transform3D = new Transform3D();

/* --------------- キャラクターの生成 ----------------------*/
      Hexahedron hexahedron = new Hexahedron();

/* --------------- 描画範囲の定義 --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability の設定 -----------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

/* --------------- アルファ値の生成 ------------------------*/
      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// 無限回
			    Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
			    				// 増えたり減ったり
			    0,				// すぐに動き始める
			    1000,			// 0.0でしばらく静止
			    5000,			// 3.0秒間の間に0.0→1.0に増加
			    1500,			// 1.5秒間加速する
			    5000,	 		// 1.0秒間1.0で停止
			    5000,			// 3.0秒間の間に1.0→0.0に減少
			    1500,			// 1.5秒間加速する
			    5000);			// 1.0秒間1.0で停止	   (B)




/* --------------- 拡大・縮小アニメーションの定義 ------*/
      ScaleInterpolator scaleInterpolator = new ScaleInterpolator(
         alpha, transformGroup, transform3D, 0.338f, 0.993f);


/* --------------- 描画範囲の設定 --------------------------*/
      scaleInterpolator.setSchedulingBounds(boundingSphere);

/* --------------- 物体等をシーングラフに追加 --------------*/
      transformGroup.addChild(scaleInterpolator);
      transformGroup.addChild(hexahedron);
      this.addChild(transformGroup);


   }

}


