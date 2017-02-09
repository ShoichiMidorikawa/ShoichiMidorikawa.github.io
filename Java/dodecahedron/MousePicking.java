/* ------------------------------------------------------------------------ */
/*                                                                          */
/*  MousePickingとTransparencyInterpolator, RotationInterpolatorの組合せ    */                                   
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

/*----------------- シーングラフの構築　------------------*/
      Canvas3D canvas3D = 
          new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      this.setLayout(borderLayout);
      this.add(canvas3D, BorderLayout.CENTER);
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();



      BranchGroup objRoot = new BranchGroup();


/* ---------------- 光源の定義 --------------------------*/
      Color3f color3fD = new Color3f(1.0f, 1.0f, 1.0f);
      Vector3f vector3f = new Vector3f(-1.0f, -1.0f, -1.0f);   
      DirectionalLight directionalLight = 
               new DirectionalLight(color3fD, vector3f);


/* ----------------- 空間全体を照らす光を定義 -------------*/
      Color3f color3fA = new Color3f(1.0f, 1.0f, 1.0f);
      AmbientLight ambientLight = new AmbientLight(color3fA);

/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere(new Point3d(), 100.0);
// 　　　　　　　　　　　　　　　　　　   BoundingSphere(中心点,半径)                             
      directionalLight.setInfluencingBounds(boundingSphere);
      ambientLight.setInfluencingBounds(boundingSphere);
  
/* -------------------------------------------------------------*/
      Color3f color3f = new Color3f(1.0f, 1.0f, 0.0f);
      Background background = new Background(color3f);
      background.setApplicationBounds(boundingSphere);
      directionalLight.setInfluencingBounds(boundingSphere); 


/* --------------- ローカル座標系の設定 -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      Transform3D transform3D = new Transform3D();


      Material material = new Material();
      material.setLightingEnable(true);
      Appearance appearance = new Appearance();
      appearance.setMaterial(material);


    Color3f color3fa = new Color3f(0.1f, 0.1f, 0.9f);  // 
    material.setAmbientColor(color3fa);                // 環境光の設定 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // 青
    material.setDiffuseColor(color3f1);               // 拡散反射(普通の色) 

 
    material.setShininess(12.8f);                     // 光の反射具合の設定


    appearance.setMaterial(material);
    TransparencyAttributes transparencyAttributes =
      new TransparencyAttributes(TransparencyAttributes.FASTEST, 0.0f);

    // 透明度の設定
    appearance.setTransparencyAttributes(transparencyAttributes);


/*------------------ myObjectの生成-------------------------*/
      MyObject myObject = new MyObject(appearance); 


/*------------------ Capabilityの設定 --------------------*/
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_WRITE);  // change
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_READ);   // change
      myObject.setCapability(MyObject.ENABLE_PICK_REPORTING);  // change


/*------------------ 回転させるピッキングの定義 ----------*/
/* 　　　　　　　マウスの左ボタンを押しながら動かす       */
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 



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
      directionalLight.setInfluencingBounds(boundingSphere);
      

/* ----------------- 物体をシーングラフに追加-------------*/
      transformGroup.addChild(myObject);
      objRoot.addChild(pickRotateBehavior);
      transformGroup.addChild(transparencyInterpolator);
      objRoot.addChild(transformGroup);
      objRoot.addChild(directionalLight);
      objRoot.addChild(ambientLight);

/* ----------------- 物体側のツリーをシーングラフに追加----*/
      simpleUniverse.addBranchGraph(objRoot);
   }


/* ----------------- ファイルの呼び出し--------------------*/
   public static void main(String[] args){
      MousePicking mousePicking = new MousePicking();
      MainFrame frame = new MainFrame(mousePicking, 900, 500);
   }
}




      