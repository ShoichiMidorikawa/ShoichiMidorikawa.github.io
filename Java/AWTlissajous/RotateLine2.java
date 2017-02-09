import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.applet.MainFrame;

public class RotateLine2 extends Applet{

   public RotateLine2(){

/*----------------- シーングラフの構築　------------------*/
      Canvas3D canvas3D = 
          new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      this.setLayout(borderLayout);
      this.add(canvas3D, BorderLayout.CENTER);
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
      BranchGroup objRoot = new BranchGroup();

/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      DirectionalLight directionalLight = new DirectionalLight();
      directionalLight.setInfluencingBounds(boundingSphere);

      TransformGroup transformGroup = new TransformGroup();


/*------------------  線画の生成-------------------------*/
      DrawLine2 drawLine2 = new DrawLine2();


      Transform3D transform3D = new Transform3D();
      transformGroup.setTransform(transform3D);
      transformGroup.addChild(drawLine2);


/*------------------ Capabilityの設定 --------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      transformGroup.setCapability(TransformGroup.ENABLE_PICK_REPORTING);

/*------------------ 回転させるピッキングの定義 ----------*/
      PickRotateBehavior pickRotateBehavior = new PickRotateBehavior(
         objRoot, canvas3D, boundingSphere); 


/* ----------------- 物体をシーングラフに追加-------------*/
      objRoot.addChild(pickRotateBehavior);
      objRoot.addChild(transformGroup);
      objRoot.addChild(directionalLight);

/* ----------------- 物体側のツリーをシーングラフに追加----*/
      simpleUniverse.addBranchGraph(objRoot);
   }


/* ----------------- ファイルの呼び出し--------------------*/
   public static void main(String[] args){
      RotateLine2 rotateLine = new RotateLine2();
      MainFrame frame = new MainFrame(rotateLine, 500, 500);
   }
}







      