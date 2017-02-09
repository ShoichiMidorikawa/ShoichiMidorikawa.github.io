import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;

public class MyView extends Applet
{

	private Canvas3D canvas;			// 描画されるAWTコンポーネント
	private SimpleUniverse universe;		// シーングラフ

	public void init()
	{
		Transform3D viewPlatformTransform;
	
		canvas=new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		universe=new SimpleUniverse(canvas);
                
                BorderLayout borderLayout = new BorderLayout();
                this.setLayout(borderLayout);

		
		universe.getViewingPlatform().setNominalViewingTransform();

		universe.getViewingPlatform().setViewPlatformBehavior(createPlatformBehavior());
		universe.getViewer().getView().setFrontClipPolicy(View.VIRTUAL_EYE);
		universe.getViewer().getView().setFrontClipDistance(0.5);
		universe.getViewer().getView().setBackClipPolicy(View.VIRTUAL_EYE);
		universe.getViewer().getView().setBackClipDistance(300.0);
										
                BranchGroup root = new BranchGroup();		 
		this.add(canvas,BorderLayout.CENTER);
		
//		MyObject myObject = new MyObject(this);
//		root=myObject.buildStage(universe);
		MySphere mySphere = new MySphere(this);
		root=mySphere.createSphere(universe);

		universe.addBranchGraph(root);

										
	}


	private ViewPlatformBehavior createPlatformBehavior()
								// カメラ制御
	{
		ViewPlatformBehavior cameraBehavior;
		BoundingSphere bounds;
	
		bounds=new BoundingSphere(new Point3d(),Double.POSITIVE_INFINITY);
		
		cameraBehavior=new OrbitBehavior(canvas);
		cameraBehavior.setSchedulingBounds(bounds);
		
		return cameraBehavior;
	}

	public static void main(String[] args){
           MyView myView = new MyView();
           Frame frame = new MainFrame(myView, 500, 500);
	} 


}
