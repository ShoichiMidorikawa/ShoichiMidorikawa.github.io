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
<applet code ="AWTInteraction.class" width=800 height=670>
</applet>
*/


public class AWTInteraction extends Applet implements ActionListener{

    Button button = new Button("   START   ");
    TimerBehavior tb;
    BranchGroup scene, scene2, objRoot, objRoot2;  
    boolean bl = false;    

    private Canvas3D canvas3D;
    private SimpleUniverse universe;
    private boolean isStandalone = false;

    TransformGroup objTrans0, objTrans1, objTrans2, objTrans3, objTrans4, objTrans5;
    TransformGroup objTrans6, objTrans7, objTrans8, objTrans9, objTrans10, objTrans11;
    TransformGroup objTrans12, objTrans13, objTrans14, objTrans15, objTrans16, objTrans17;
    TransformGroup objTrans18, objTrans19, objTrans20, objTrans21, objTrans22, objTrans23;

    long sleep; 
    double x, y, z;
    Transform3D trans = new Transform3D();

    Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
    SimpleUniverse u = new SimpleUniverse(c);
    TimerBehavior timerBehavior;


    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	objRoot = new BranchGroup();

	// Create the transform group node and initialize it to the
	// identity.  Enable the TRANSFORM_WRITE capability so that
	// our behavior code can modify it at runtime.  Add it to the
	// root of the subgraph.

        Vector3d vecm = new Vector3d(-0.5, 0, 0);
        Vector3d vecp = new Vector3d(0.5, 0, 0);

        Transform3D t3dm = new Transform3D();
        Transform3D t3dp = new Transform3D();

        t3dm.setTranslation(vecm);
        t3dp.setTranslation(vecp);


	objTrans0 = new TransformGroup(t3dm);
	objTrans1 = new TransformGroup(t3dp);
	objTrans2 = new TransformGroup(t3dm);
	objTrans3 = new TransformGroup(t3dp);
	objTrans4 = new TransformGroup(t3dm);
	objTrans5 = new TransformGroup(t3dp);
	objTrans6 = new TransformGroup(t3dm);
	objTrans7 = new TransformGroup(t3dp);
	objTrans8 = new TransformGroup(t3dm);
	objTrans9 = new TransformGroup(t3dp);
	objTrans10 = new TransformGroup(t3dm);
	objTrans11 = new TransformGroup(t3dp);
	objTrans12 = new TransformGroup(t3dm);
	objTrans13 = new TransformGroup(t3dp);
	objTrans14 = new TransformGroup(t3dm);
	objTrans15 = new TransformGroup(t3dp);
	objTrans16 = new TransformGroup(t3dm);
	objTrans17 = new TransformGroup(t3dp);
	objTrans18 = new TransformGroup(t3dm);
	objTrans19 = new TransformGroup(t3dp);
	objTrans20 = new TransformGroup(t3dm);
	objTrans21 = new TransformGroup(t3dp);
	objTrans22 = new TransformGroup(t3dm);
	objTrans23 = new TransformGroup(t3dp);



	objTrans0.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans6.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans7.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans8.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans9.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans10.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans11.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans12.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans13.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans14.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans15.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans16.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans17.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans18.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans19.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans20.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans21.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans22.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objTrans23.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);


        objRoot.addChild(objTrans0);
        objRoot.addChild(objTrans1);
        objRoot.addChild(objTrans2);
        objRoot.addChild(objTrans3);
        objRoot.addChild(objTrans4);
        objRoot.addChild(objTrans5);
        objRoot.addChild(objTrans6);
        objRoot.addChild(objTrans7);
        objRoot.addChild(objTrans8);
        objRoot.addChild(objTrans9);
        objRoot.addChild(objTrans10);
        objRoot.addChild(objTrans11);
        objRoot.addChild(objTrans12);
        objRoot.addChild(objTrans13);
        objRoot.addChild(objTrans14);
        objRoot.addChild(objTrans15);
        objRoot.addChild(objTrans16);
        objRoot.addChild(objTrans17);
        objRoot.addChild(objTrans18);
        objRoot.addChild(objTrans19);
        objRoot.addChild(objTrans20);
        objRoot.addChild(objTrans21);
        objRoot.addChild(objTrans22);
        objRoot.addChild(objTrans23);


/*------------------ 光源に関する設定  --------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();
      DirectionalLight directionalLight = new DirectionalLight();
      directionalLight.setInfluencingBounds(boundingSphere);
      objRoot.addChild(directionalLight);

      Color3f color = new Color3f(1.0f, 0.0f, 0.0f);

      Appearance appearance = new Appearance();
      Material material = new Material();
      material.setDiffuseColor(color);
      material.setShininess(128.0f);
      appearance.setMaterial(material);


	// Create a simple shape leaf node, add it to the scene graph.
        float r = 0.02f;
        Sphere sphere0 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere1 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere2 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere3 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere4 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere5 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere6 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere7 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere8 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere9 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere10 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere11 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere12 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere13 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere14 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere15 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere16 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere17 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere18 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere19 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere20 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere21 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere22 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere23 = new Sphere(r, Sphere.GENERATE_NORMALS, appearance);

        Sphere sphere24 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);
        Sphere sphere25 = new Sphere(0.05f, Sphere.GENERATE_NORMALS, appearance);


	objTrans0.addChild(sphere0);
	objTrans1.addChild(sphere1);
	objTrans2.addChild(sphere2);
	objTrans3.addChild(sphere3);
	objTrans4.addChild(sphere4);
	objTrans5.addChild(sphere5);
	objTrans6.addChild(sphere6);
	objTrans7.addChild(sphere7);
	objTrans8.addChild(sphere8);
	objTrans9.addChild(sphere9);
	objTrans10.addChild(sphere10);
	objTrans11.addChild(sphere11);
	objTrans12.addChild(sphere12);
	objTrans13.addChild(sphere13);
	objTrans14.addChild(sphere14);
	objTrans15.addChild(sphere15);
	objTrans16.addChild(sphere16);
	objTrans17.addChild(sphere17);
	objTrans18.addChild(sphere18);
	objTrans19.addChild(sphere19);
	objTrans20.addChild(sphere20);
	objTrans21.addChild(sphere21);
	objTrans22.addChild(sphere22);
	objTrans23.addChild(sphere23);

//	objTrans24.addChild(trgm);
//	objTrans25.addChild(trgp);


	// create the TimerBehavior	
	timerBehavior =
	    new TimerBehavior(objTrans0, objTrans1, objTrans2,  objTrans3,  objTrans4, objTrans5,
                              objTrans6, objTrans7, objTrans8, objTrans9, objTrans10, objTrans11, 
                              objTrans12, objTrans13, objTrans14, objTrans15, objTrans16, objTrans17,
                              objTrans18, objTrans19, objTrans20, objTrans21, objTrans22, objTrans23, 20);
                            //  objTrans24, objTrans25, 26);

	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
						   100.0);

	timerBehavior.setSchedulingBounds(bounds);
	objRoot.addChild(timerBehavior);
	return objRoot;
    }


    public AWTInteraction() {
    }

    public void init() {
       setLayout(new BorderLayout());
       add("Center", c);

       Panel p = new Panel();
       p.add(button);
       add("North", p);
       button.addActionListener(this);

	
	u.getViewingPlatform().setNominalViewingTransform();

	u.getViewer().getView().setFrontClipPolicy(View.VIRTUAL_EYE);
	u.getViewer().getView().setFrontClipDistance(0.5);
	u.getViewer().getView().setBackClipPolicy(View.VIRTUAL_EYE);
	u.getViewer().getView().setBackClipDistance(300.0);

        BranchGroup root = new BranchGroup();		 
	this.add(c,BorderLayout.CENTER);
		
	scene = createSceneGraph();
	objRoot.setCapability( BranchGroup.ALLOW_BOUNDS_READ );
        objRoot.setCapability(BranchGroup.ALLOW_DETACH);      

        timerBehavior.setEnable(false);
        u.getLocale().removeBranchGraph(objRoot); // 停止 
 	u.addBranchGraph(scene);     

    }

    public void destroy() {
	u.cleanup();
    }


    public void actionPerformed(ActionEvent evt){
          tb = timerBehavior; 

          if(bl == true){     // アニメーションの停止
             button.setLabel("  RESTART  ");
             tb.setEnable(false);
             u.getLocale().removeBranchGraph(objRoot);
             bl = false;
             u.addBranchGraph(scene);
          } 
          else {             //　アニメーションの再開
             button.setLabel("   STOP   ");
             u.getLocale().removeBranchGraph(scene);            
	     scene = createSceneGraph();
	     objRoot.setCapability( BranchGroup.ALLOW_BOUNDS_READ );
             objRoot.setCapability(BranchGroup.ALLOW_DETACH);        
             u.addBranchGraph(scene);
             bl = true;   
          } 

    }



    //
    // The following allows HelloUniverse to be run as an application
    // as well as an applet
    //
    public static void main(String[] args) {
	new MainFrame(new AWTInteraction(), 512, 512);
    }
}
