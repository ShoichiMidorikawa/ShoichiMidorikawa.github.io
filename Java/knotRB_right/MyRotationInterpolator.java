import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;

import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;



/*
<applet code="MyRotationInterpolator.class" width="1000" height="600">
</applet>
*/

public class MyRotationInterpolator extends Applet implements ActionListener{
   
      Button button = new Button("   START   ");
      boolean bl = false;


     /* --------------- シーングラフの構築 --------------------*/
      Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      BranchGroup objRoot = new BranchGroup();

      private boolean isStandalone = false; 


//      RotationInterpolator rotationInterpolator;
//      TransformGroup transformGroup;

      Alpha alpha = new Alpha();
      
//      Transform3D transform3D = new Transform3D();

      int loopCount;
  



   public MyRotationInterpolator(){
      this.setLayout(borderLayout);
      loopCount = (this.alpha).getLoopCount();

      Panel p = new Panel();
      p.add(button);
      add("North", p);
      button.addActionListener(this);

      this.add(canvas3D, BorderLayout.CENTER);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
    
      objRoot.setCapability(BranchGroup.ALLOW_BOUNDS_READ);
      objRoot.setCapability(BranchGroup.ALLOW_DETACH);      


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
//      Alpha alpha = new Alpha();


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




     Vector3d posm = new Vector3d(-0.05, 0.0, 0.0);
     Transform3D t3dm = new Transform3D();
     t3dm.set(posm);
     TransformGroup transm = new TransformGroup(t3dm);

     Vector3d posp = new Vector3d(0.05, 0.0, 0.0);
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
         alpha.setStartTime(System.currentTimeMillis());         
         alpha.setLoopCount(0);
         bl = true; 
   }

   public void actionPerformed(ActionEvent evt){

      if(bl == true){
         button.setLabel("  STOP  ");
         alpha.setStartTime(System.currentTimeMillis());         
         alpha.setLoopCount(loopCount);
         bl = false; 
      }
      else{
         button.setLabel("   START   ");
         alpha.setStartTime(System.currentTimeMillis());
         alpha.setLoopCount(0);
         bl = true;
      }        
   } 


/* --------------- 作成したクラスファイルの呼び出し --------*/
   public static void main(String args[]){
      MyRotationInterpolator rotation = new MyRotationInterpolator();
      MainFrame mainFrame = new MainFrame(rotation, 800, 500);
   }
}


