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

import java.awt.event.*;
import java.util.*;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;

/*
<applet code ="AWTInteraction" width=800 height=650>
</applet>
*/


public class AWTInteraction extends Applet {
    TransformGroup objTrans0, objTrans1, objTrans2, objTrans3, objTrans4;
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
	objTrans0 = new TransformGroup();
	objTrans0.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans0);

	objTrans1 = new TransformGroup();
	objTrans1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans1);

	objTrans2 = new TransformGroup();
	objTrans2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans2);

	objTrans3 = new TransformGroup();
	objTrans3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans3);

	objTrans4 = new TransformGroup();
	objTrans4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans4);

/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      DirectionalLight directionalLight = new DirectionalLight();
      directionalLight.setInfluencingBounds(boundingSphere);
      objRoot.addChild(directionalLight);


      Appearance appearance = new Appearance();
      Material material = new Material();
      appearance.setMaterial(material);


	// Create a simple shape leaf node, add it to the scene graph.
        Sphere sphere0 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere1 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere2 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere3 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere4 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);

	objTrans0.addChild(sphere0);
	objTrans1.addChild(sphere1);
	objTrans2.addChild(sphere2);
	objTrans3.addChild(sphere3);
	objTrans4.addChild(sphere4);

	// create the TimerBehavior	
	TimerBehavior timerBehavior =
	    new TimerBehavior(objTrans0, objTrans1, objTrans2,  objTrans3,  objTrans4, 20);  //　更新
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


    Appearance appO = new Appearance();
    Color3f ambientColourO = new Color3f(1.0f, 0.0f, 0.0f);
    Color3f emissiveColourO = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f specularColourO = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f diffuseColourO = new Color3f(1.0f, 0.0f, 0.0f);
    float shininessO = 20.0f;
    appO.setMaterial(new Material(ambientColourO, emissiveColourO,
        diffuseColourO, specularColourO, shininessO));

        TransformGroup transformGroup = new TransformGroup();

        Sphere sphereO = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appO);

        Transform3D transform3D = new Transform3D();
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(sphereO);

        scene.addChild(transformGroup);


       TransformGroup transformGroupL = new TransformGroup();
       DrawLine drawLine = new DrawLine();   // 直線の読み込み
       Transform3D transform3DL = new Transform3D();
       transformGroupL.setTransform(transform3DL);
       transformGroupL.addChild(drawLine);
       scene.addChild(transformGroupL);

       TransformGroup transformGroupZX = new TransformGroup();
       RectangleZX rectangleZX = new RectangleZX();   // 平面の読み込み
       Transform3D transform3DZX = new Transform3D();
       transformGroupZX.setTransform(transform3DZX);
       transformGroupZX.addChild(rectangleZX);
       scene.addChild(transformGroupZX);

       TransformGroup transformGroupYZ = new TransformGroup();
       RectangleYZ rectangleYZ = new RectangleYZ();   // 平面の読み込み
       Transform3D transform3DYZ = new Transform3D();
       transformGroupYZ.setTransform(transform3DYZ);
       transformGroupYZ.addChild(rectangleYZ);
       scene.addChild(transformGroupYZ);

       TransformGroup transformGroupXY = new TransformGroup();
       RectangleXY rectangleXY = new RectangleXY();   // 平面の読み込み
       Transform3D transform3DXY = new Transform3D();
       transformGroupXY.setTransform(transform3DXY);
       transformGroupXY.addChild(rectangleXY);
       scene.addChild(transformGroupXY);


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
