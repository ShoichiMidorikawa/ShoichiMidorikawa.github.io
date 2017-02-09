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
    TransformGroup objTrans2;
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

	objTrans2 = new TransformGroup();
	objTrans2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans2);



/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      
/* -------------- 並行に進む光を定義 ----------------*/
      Color3f color3f = new Color3f(1.0f, 1.0f, 0.0f);
      Vector3f vector3f = new Vector3f(1.0f, -1.0f, 0.0f);
      DirectionalLight directionalLight = 
         new DirectionalLight(color3f,  vector3f);
      directionalLight.setInfluencingBounds(boundingSphere);

      objRoot.addChild(directionalLight);


    Appearance app = new Appearance();
    Color3f ambientColour = new Color3f(1.0f, 0.0f, 0.0f);
    Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f diffuseColour = new Color3f(1.0f, 0.0f, 0.0f);
    float shininess = 20.0f;
    app.setMaterial(new Material(ambientColour, emissiveColour,
        diffuseColour, specularColour, shininess));

	// Create a simple shape leaf node, add it to the scene graph.
        Sphere sphere = new Sphere(0.05f, Sphere.GENERATE_NORMALS, app);

      Appearance app2 = new Appearance();
      Color3f ambientColour2 = new Color3f(0.0f, 0.0f, 0.0f);
      Color3f emissiveColour2 = new Color3f(0.0f, 0.0f, 0.0f);
      Color3f specularColour2 = new Color3f(0.0f, 0.0f, 0.0f);
      Color3f diffuseColour2 = new Color3f(0.1f, 0.1f, 0.1f);
      float shininess2 = 20.0f;
      Material mat2 = new Material(ambientColour2, emissiveColour2,
        diffuseColour2, specularColour2, shininess2);
      app2.setMaterial(mat2);

        Cylinder cylinder = new Cylinder(0.05f, 0.001f, Cylinder.GENERATE_NORMALS, app2);

	objTrans.addChild(sphere);
	objTrans2.addChild(cylinder);

	// create the TimerBehavior	
	TimerBehavior timerBehavior =
	    new TimerBehavior(objTrans, 20);  //


	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
						   100.0);
	timerBehavior.setSchedulingBounds(bounds);
	objRoot.addChild(timerBehavior);


	TimerBehavior2 timerBehavior2 =
	    new TimerBehavior2(objTrans2, 20);  //
//	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
	timerBehavior2.setSchedulingBounds(bounds);
	objRoot.addChild(timerBehavior2);

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

      Rectangle rectangle = new Rectangle();   // リサージュ図形の軌跡の読み込み
      Transform3D transform3D = new Transform3D();
      transformGroup.setTransform(transform3D);
      transformGroup.addChild(rectangle);

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
