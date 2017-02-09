import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.applet.MainFrame;

public class MousePicking extends Applet{

/*
<applet code="MousePicking"  width=900 height=500>
</applet>
*/
 

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


/*------------------ myObjectの生成-------------------------*/
      MyObject myObject = new MyObject();
 

/*------------------ Capabilityの設定 --------------------*/
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_WRITE);  // change
      myObject.setCapability(MyObject.ALLOW_TRANSFORM_READ);   // change
      myObject.setCapability(MyObject.ENABLE_PICK_REPORTING);  // change


/*------------------ 回転させるピッキングの定義 ----------*/
/* 　　　　　　　マウスの左ボタンを押しながら動かす       */
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 


/*------------------ ズームさせるピッキングの定義 ----------*/
/*        Altキーとともにマウスの左ボタンを押しながら動かす */              
      PickZoomBehavior pickZoomBehavior = new PickZoomBehavior(
         objRoot, canvas3D, boundingSphere); 


/*------------------ 移動させるピッキングの定義 ----------*/
/*               マウスの右ボタンを押しながら動かす　　　 */
      PickTranslateBehavior pickTranslateBehavior = new PickTranslateBehavior(
         objRoot, canvas3D, boundingSphere); 
      

/* ----------------- 物体をシーングラフに追加-------------*/
      objRoot.addChild(pickRotateBehavior);
      objRoot.addChild(pickZoomBehavior);
      objRoot.addChild(pickTranslateBehavior);
      objRoot.addChild(myObject);
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

      