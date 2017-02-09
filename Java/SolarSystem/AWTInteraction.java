/*  アニメーション 惑星の運動 */
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
<applet code ="AWTInteraction" width=1000 height=800>
</applet>
*/


public class AWTInteraction extends Applet{

    private Switch switchNode = null;
    private BitSet bitset = null;

    BranchGroup scene2, objRoot2;   //太陽

    TransformGroup objTrans;
    long sleep; 

    Transform3D trans = new Transform3D();

    Canvas3D c;			// 描画されるAWTコンポーネント
    SimpleUniverse u;


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
      
/* -------------- 並行に進む光を定義 ----------------*/
      Color3f color3f = new Color3f(0.0f, 1.0f, 1.0f);
      Vector3f vector3f = new Vector3f(1.0f, 0.0f, 0.0f);
      DirectionalLight directionalLight = new DirectionalLight(color3f, vector3f);
      directionalLight.setInfluencingBounds(boundingSphere);  
                
      objTrans.addChild(directionalLight);   //objTrans は　timerBehaviorに従って回転する。        



    Appearance app = new Appearance();
    Color3f ambientColour = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f specularColour = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f diffuseColour = new Color3f(0.0f, 1.0f, 1.0f);
    float shininess = 20.0f;
    app.setMaterial(new Material(ambientColour, emissiveColour,
        diffuseColour, specularColour, shininess));


/* --------------  地球　-----------------*/
	// Create a simple shape leaf node, add it to the scene graph.
        Sphere sphere = new Sphere(0.03f, Sphere.GENERATE_NORMALS, app);

	objTrans.addChild(sphere);

	// create the TimerBehavior	
	TimerBehavior timerBehavior =
	    new TimerBehavior(objTrans, 1);  //


	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
						   100.0);

        
	timerBehavior.setSchedulingBounds(bounds);
	objRoot.addChild(timerBehavior);

	return objRoot;
    }



    public BranchGroup createSceneGraph2(){
	objRoot2 = new BranchGroup();
        return objRoot2;
    }



    public AWTInteraction() {
    }

    public void init() {

        Transform3D viewPlatformTransform;

	c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
	u = new SimpleUniverse(c);

       add("Center", c);
       setLayout(new BorderLayout());
       Panel p = new Panel();
       p.setLayout(new GridLayout(3,1,0,0));
       p.add(new Label("")); 
       Checkbox check = new Checkbox("軌道", true);
       p.add(check);
       add("West", p); 

       check.addItemListener( new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
             int state = e.getStateChange();
             if (state == ItemEvent.SELECTED) {
                bitset.set(0);
             } else if (state == ItemEvent.DESELECTED) {
               bitset.clear(0);
             }
             switchNode.setChildMask(bitset);
          }
       });







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

      scene.addChild(transformGroup);

	u.addBranchGraph(scene);


/*---------------　太陽　----------------------------*/
        Appearance appO = new Appearance();
        Color3f ambientColourO = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f emissiveColourO = new Color3f(1.0f, 1.0f, 0.0f);
        Color3f specularColourO = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f diffuseColourO = new Color3f(0.0f, 0.0f, 0.0f);
        float shininessO = 20.0f;
        appO.setMaterial(new Material(ambientColourO, emissiveColourO,
        diffuseColourO, specularColourO, shininessO));

        transformGroup = new TransformGroup();
        Sphere sphereO = new Sphere(0.07f, Sphere.GENERATE_NORMALS, appO); // 太陽
        transformGroup.addChild(sphereO);

/*------------------  線画の生成-------------------------*/
      Transform3D transform3D = new Transform3D();
      transformGroup.setTransform(transform3D);
      
       bitset = new BitSet(1);
       bitset.set(0);
    
       switchNode = new Switch(Switch.CHILD_MASK, bitset);
       switchNode.setCapability(Switch.ALLOW_SWITCH_READ);
       switchNode.setCapability(Switch.ALLOW_SWITCH_WRITE);
       transformGroup.addChild(switchNode);

       MyObject1 myObject1 = new MyObject1();         // 地球軌道   
       switchNode.addChild(myObject1.createObject()); // Orbit of the Earth        


        scene2 = createSceneGraph2();
        scene2.addChild(transformGroup);

        u.addBranchGraph(scene2);


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



    public void actionPerformed(ActionEvent evt){
     }



    //
    // The following allows HelloUniverse to be run as an application
    // as well as an applet
    //
    public static void main(String[] args) {
	new MainFrame(new AWTInteraction(), 512, 512);
    }
}
