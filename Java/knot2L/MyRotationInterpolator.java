import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame;


/*
<applet code="MyRotationInterpolator.class" width="1000" height="600">
</applet>
*/



public class MyRotationInterpolator extends Applet{
   
   public MyRotationInterpolator(){


/* --------------- シーングラフの構築 --------------------*/
      Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      this.setLayout(borderLayout);
      this.add(canvas3D, BorderLayout.CENTER);
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
      BranchGroup objRoot = new BranchGroup();

/* --------------- 光源の定義 -----------------------------*/
      DirectionalLight directionalLight = new DirectionalLight();

/* --------------- ローカル座標系の設定 -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      TransformGroup transformGroup2 = new TransformGroup();

      Transform3D transform3D = new Transform3D();
      Transform3D transform3D2 = new Transform3D();


/* --------------- キャラクターの生成 ----------------------*/
      DrawLine drawLine = new DrawLine();
      DrawLine2 drawLine2 = new DrawLine2();

/* --------------- 描画範囲の定義 --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability の設定 -----------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      transformGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

/* --------------- アルファ値の生成 ------------------------*/
      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// 無限回
			    Alpha.INCREASING_ENABLE,
			    0,					
			    0,					
			    4000,				
			    0,				
			    0,	 			
			    0,				
			    0,				
			    0);				




     Vector3d posm = new Vector3d(-0.5, 0.0, 0.0);
     Transform3D t3dm = new Transform3D();
     t3dm.set(posm);
     TransformGroup transm = new TransformGroup(t3dm);

     Vector3d posp = new Vector3d(0.5, 0.0, 0.0);
     Transform3D t3dp = new Transform3D();
     t3dp.set(posp);
     TransformGroup transp = new TransformGroup(t3dp);
  


/* --------------- 回転させるアニメーションの定義 ------*/
      RotationInterpolator rotationInterpolator = new RotationInterpolator(
         alpha, transformGroup, transform3D, 0.00f, 3.14f);

      RotationInterpolator rotationInterpolator2 = new RotationInterpolator(
         alpha, transformGroup2, transform3D2, 0.00f, 3.14f);


/* --------------- 描画範囲の設定 --------------------------*/
      rotationInterpolator.setSchedulingBounds(boundingSphere);
      rotationInterpolator2.setSchedulingBounds(boundingSphere);
      directionalLight.setInfluencingBounds(boundingSphere);

/* --------------- 物体等をシーングラフに追加 --------------*/
      transformGroup.addChild(rotationInterpolator);
      transformGroup.addChild(drawLine);
      transformGroup2.addChild(rotationInterpolator2);
      transformGroup2.addChild(drawLine2);
      transm.addChild(transformGroup);
      transp.addChild(transformGroup2);
      objRoot.addChild(transm);
      objRoot.addChild(transp);
      objRoot.addChild(directionalLight);

/* --------------- 物体側のツリーをシーングラフに追加 ------*/
      simpleUniverse.addBranchGraph(objRoot);
   }


/* --------------- 作成したクラスファイルの呼び出し --------*/
   public static void main(String args[]){
      MyRotationInterpolator rotation = new MyRotationInterpolator();
      MainFrame mainFrame = new MainFrame(rotation, 800, 500);
   }
}


