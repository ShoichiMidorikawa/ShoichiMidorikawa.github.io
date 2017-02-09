// Å@Viewéãì_ÇÃê›íË 
// 
//  
//                      

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;


/*
<applet code="SwitchTest" width=900 height=500>
</applet>
*/



public class SwitchTest extends Applet {
  private Switch switchNode = null;
  private BitSet bitset = null;
  private Canvas3D canvas3D;

  private boolean isStandalone = false;

  public SwitchTest() {
    this.setLayout(new BorderLayout());

    Panel panel = new Panel();
    this.add(panel, BorderLayout.SOUTH);

    Checkbox check1 = new Checkbox("â~");
    check1.addItemListener( new ItemListener() {
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
    panel.add(check1);

    Checkbox check2 = new Checkbox("ë»â~");
    check2.addItemListener( new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
          bitset.set(1);
        } else if (state == ItemEvent.DESELECTED) {
          bitset.clear(1);
        }
        switchNode.setChildMask(bitset);
      }
    });
    panel.add(check2);

    Checkbox check3 = new Checkbox("ï˙ï®ê¸");
    check3.addItemListener( new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
          bitset.set(2);
        } else if (state == ItemEvent.DESELECTED) {
          bitset.clear(2);
        }
        switchNode.setChildMask(bitset);
      }
    });
    panel.add(check3);

    Checkbox check4 = new Checkbox("ëoã»ê¸");
    check4.addItemListener( new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
          bitset.set(3);
        } else if (state == ItemEvent.DESELECTED) {
          bitset.clear(3);
        }
        switchNode.setChildMask(bitset);
      }
    });
    panel.add(check4);




    Transform3D viewPlatformTransform;

    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    canvas3D = new Canvas3D(config);
    this.add(canvas3D, BorderLayout.CENTER);
    BoundingSphere boundingSphere = new BoundingSphere( new Point3d(), 100.0 );

    SimpleUniverse universe = new SimpleUniverse(canvas3D);

    universe.getViewingPlatform().setNominalViewingTransform();  
    BranchGroup scene = createSceneGraph();

    Transform3D viewTransform = new Transform3D();
    Vector3d v0 = new Vector3d(0., 0.7, 5.0);
    viewTransform.setTranslation(v0);

    Transform3D transform3D2 = new Transform3D();
    transform3D2.rotX(-Math.PI/40.0);
    
    viewTransform.mul(transform3D2);    

    //universe.getViewingPlatform().setNominalViewingTransform();
    universe.getViewingPlatform().getViewPlatformTransform().setTransform(viewTransform);

    universe.getViewingPlatform().setViewPlatformBehavior(createPlatformBehavior());
    universe.getViewer().getView().setFrontClipPolicy(View.VIRTUAL_EYE);
    universe.getViewer().getView().setFrontClipDistance(0.5);
    universe.getViewer().getView().setBackClipPolicy(View.VIRTUAL_EYE);
    universe.getViewer().getView().setBackClipDistance(300.0);    
    universe.addBranchGraph(scene);
  }

  private ViewPlatformBehavior createPlatformBehavior()
							// ÉJÉÅÉâêßå‰
     {
	ViewPlatformBehavior cameraBehavior;
	BoundingSphere bounds;

	bounds=new BoundingSphere(new Point3d(),Double.POSITIVE_INFINITY);
	
	cameraBehavior=new OrbitBehavior(canvas3D);
	cameraBehavior.setSchedulingBounds(bounds);
	
	return cameraBehavior;
     }


  private BranchGroup createSceneGraph() {
    BranchGroup root = new BranchGroup();
    
    BoundingSphere boundingSphere = new BoundingSphere( new Point3d(), 100.0 );
    
    DirectionalLight light =
      new DirectionalLight( new Color3f(1.0f, 1.0f, 1.0f),
                            new Vector3f(-0.57f, -0.57f, -0.57f) );
    light.setInfluencingBounds(boundingSphere);
    root.addChild(light);
    
    AmbientLight alight = new AmbientLight();
    alight.setInfluencingBounds(boundingSphere);
    root.addChild(alight);
    
    Transform3D t3d = new Transform3D();
    TransformGroup trans = new TransformGroup(t3d);
    
    bitset = new BitSet(4);
//    for (int i=0; i<4; i++) bitset.set(i);
    
    switchNode = new Switch(Switch.CHILD_MASK, bitset);
    switchNode.setCapability(Switch.ALLOW_SWITCH_READ);
    switchNode.setCapability(Switch.ALLOW_SWITCH_WRITE);
    trans.addChild(switchNode);
    
    switchNode.addChild(MyObject1.createObject()); // Tetrahedron
    switchNode.addChild(MyObject2.createObject()); // Red sphere    
    switchNode.addChild(MyObject3.createObject()); // Color Cube
    switchNode.addChild(MyObject4.createObject()); // Color Cube

    MyObject myObject = new MyObject();
    trans.addChild(myObject);

    root.addChild(trans);
    
    return root;
  }
  

  public static void main(String[] args) {
    SwitchTest applet = new SwitchTest();
    Frame frame = new MainFrame(applet, 900, 600);
  }
}
