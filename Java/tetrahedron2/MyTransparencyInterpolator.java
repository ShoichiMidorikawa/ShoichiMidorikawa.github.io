import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;


public class MyTransparencyInterpolator extends TransformGroup{

   public MyTransparencyInterpolator(){


/* --------------- ローカル座標系の設定 -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      Transform3D transform3D = new Transform3D();
      transform3D.setScale(0.5);                           // new スケールを0.5に縮小 
      transformGroup.setTransform(transform3D);             


      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


    Color3f color3f = new Color3f(0.1f, 0.1f, 0.75f);  // 
    material.setAmbientColor(color3f);                // 環境光の設定 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // 青
    material.setDiffuseColor(color3f1);               // 拡散反射(普通の色) 

 
    material.setShininess(12.8f);                     // 光の反射具合の設定
    appearance.setMaterial(material);
 
    TransparencyAttributes transparencyAttributes =
      new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // 透明度の設定
    appearance.setTransparencyAttributes(transparencyAttributes);

/*------------------ tetrahedronの生成-------------------------*/
    Tetrahedron tetrahedron = new Tetrahedron(appearance);         

/*------------------ Capabilityの設定 --------------------*/
    appearance.setCapability(Appearance.ALLOW_MATERIAL_READ);
    appearance.setCapability(Appearance.ALLOW_MATERIAL_WRITE);

    transparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_READ);
    transparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);
    

/* --------------- アルファ値の生成 ------------------------*/
      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// 無限回
			    Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
			    					// 増えたり減ったり
			    0,					// すぐに動き始める
			    0,   				// 0.0でしばらく静止
			    8000,				// 8.0秒間の間に0.0→1.0に増加
			    4000,				// 8.0秒間加速する
			    8000,	 			// 1.0秒間1.0で停止
			    8000,				// 8.0秒間の間に1.0→0.0に減少
			    4000,				// 5.0秒間加速する
			    8000);				// 0.0秒間0.0で停止	   (B)



/* --------------- 回転させるアニメーションの定義 ------*/
      TransparencyInterpolator transparencyInterpolator = new TransparencyInterpolator(
         alpha, transparencyAttributes, 0.00f, 1.00f);


/* --------------- 描画範囲の設定 --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere(new Point3d(), 100.0);
// 　　　　　　　　　　　　　　　　　　   BoundingSphere(中心点,半径)                             

      transparencyInterpolator.setSchedulingBounds(boundingSphere);
      

/* ----------------- 物体をシーングラフに追加-------------*/
      transformGroup.addChild(tetrahedron);
      this.addChild(transformGroup);
      this.addChild(transparencyInterpolator);
   }



}







      