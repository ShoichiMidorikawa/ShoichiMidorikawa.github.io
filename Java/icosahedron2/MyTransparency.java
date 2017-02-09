import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;

public class MyTransparency extends TransformGroup{
   

   public MyTransparency(){

/* --------------- ターゲット座標系の設定 -------------------*/
      TransformGroup target = new TransformGroup();

      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


      Color3f color3fa = new Color3f(0.1f, 0.9f, 0.1f);  // 
      material.setAmbientColor(color3fa);                // 環境光の設定 
      Color3f color3f1 = new Color3f(0.0f, 1.0f, 0.0f);  // 緑
      material.setDiffuseColor(color3f1);                // 拡散反射(普通の色) 

      material.setShininess(12.8f);                     // 光の反射具合の設定

      appearance.setMaterial(material);
      TransparencyAttributes transparencyAttributes =
         new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // 透明度の設定
    appearance.setTransparencyAttributes(transparencyAttributes);


/* --------------- キャラクターの生成 ----------------------*/
      Icosahedron icosahedron = new Icosahedron(appearance);


/* --------------- 描画範囲の定義 --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();


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
			    1000,	 			// 1.0秒間1.0で停止
			    8000,				// 8.0秒間の間に1.0→0.0に減少
			    4000,				// 5.0秒間加速する
			    0000);				// 0.0秒間0.0で停止	   (B)



/* --------------- 透明度変化インターポレータの定義 ------*/
      TransparencyInterpolator transparencyInterpolator = new TransparencyInterpolator(
         alpha, transparencyAttributes, 0.00f, 1.00f);


/* --------------- 描画範囲の設定 --------------------------*/
      transparencyInterpolator.setSchedulingBounds(boundingSphere);
//      directionalLight.setInfluencingBounds(boundingSphere);



/* ----------------- 物体をシーングラフに追加-------------*/

/*     
      transformGroup.addChild(transparencyInterpolator);
      objRoot.addChild(transformGroup);
      objRoot.addChild(directionalLight);
      objRoot.addChild(ambientLight);
*/





/* --------------- 物体等をシーングラフに追加 --------------*/
      target.addChild(transparencyInterpolator);
      target.addChild(icosahedron);
      this.addChild(target);

   }

}


