/*  アニメーション  */
/*  視点の変化      */

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;

/*
<applet code ="AWTInteraction" width=600 height=600>
</applet>
*/


public class AWTInteraction extends Applet {
    TransformGroup objTrans;
    long sleep; 

    Transform3D trans = new Transform3D();

    private Canvas3D c;			// 描画されるAWTコンポーネント
    private SimpleUniverse u = null;

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();

	// Create the transform group node and initialize it to the
	// identity.  Enable the TRANSFORM_WRITE capability so that
	// our behavior code can modify it at runtime.  Add it to the
	// root of the subgraph.
	objTrans = new TransformGroup();
	objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans);


/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      DirectionalLight directionalLight = new DirectionalLight();
      directionalLight.setInfluencingBounds(boundingSphere);
      objRoot.addChild(directionalLight);


      Appearance appearance = new Appearance();
      Material material = new Material();
      appearance.setMaterial(material);


	// Create a simple shape leaf node, add it to the scene graph.
        Sphere sphere = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);

	objTrans.addChild(sphere);

	// create the TimerBehavior	
	TimerBehavior timerBehavior =
	    new TimerBehavior(objTrans, 50);  //　これが移動する球
	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
						   100.0);
	timerBehavior.setSchedulingBounds(bounds);
	objRoot.addChild(timerBehavior);

	return objRoot;
    }

    public AWTInteraction() {
    }

    public void init() {
        Transform3D viewPlatformTransform;

	c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
	u = new SimpleUniverse(c);

	setLayout(new BorderLayout());

	add("Center", c);

	u.getViewingPlatform().setNominalViewingTransform();

	u.getViewingPlatform().setViewPlatformBehavior(createPlatformBehavior());
	u.getViewer().getView().setFrontClipPolicy(View.VIRTUAL_EYE);
	u.getViewer().getView().setFrontClipDistance(0.5);
	u.getViewer().getView().setBackClipPolicy(View.VIRTUAL_EYE);
	u.getViewer().getView().setBackClipDistance(300.0);

        BranchGroup root = new BranchGroup();		 
	this.add(c,BorderLayout.CENTER);
		
	BranchGroup scene = createSceneGraph();
	scene.setCapability( BranchGroup.ALLOW_BOUNDS_READ );

      TransformGroup transformGroup = new TransformGroup();

      DrawLine2 drawLine2 = new DrawLine2();   // リサージュ図形の軌跡の読み込み
      Transform3D transform3D = new Transform3D();
      transformGroup.setTransform(transform3D);
      transformGroup.addChild(drawLine2);

      scene.addChild(transformGroup);

	u.addBranchGraph(scene);



    }

    public void destroy() {
	u.cleanup();
    }
    

    private ViewPlatformBehavior createPlatformBehavior()
								// カメラ制御
    {
	ViewPlatformBehavior cameraBehavior;
	BoundingSphere bounds;

	bounds=new BoundingSphere(new Point3d(),Double.POSITIVE_INFINITY);
	
	cameraBehavior=new OrbitBehavior(c);
	cameraBehavior.setSchedulingBounds(bounds);
	
	return cameraBehavior;
    }



    //
    // The following allows HelloUniverse to be run as an application
    // as well as an applet
    //
    public static void main(String[] args) {
	new MainFrame(new AWTInteraction(), 512, 512);
    }
}
