import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.Sphere;

public class HeavenlyBody extends Background
{
	public HeavenlyBody(int divisions,Appearance appearance)
	{
		BranchGroup geometry;
		Sphere heaven;
	
		heaven=new Sphere(1.0f,
		    Sphere.GENERATE_TEXTURE_COORDS | Sphere.GENERATE_NORMALS_INWARD,
		    divisions,appearance);						// (A)
		
		geometry=new BranchGroup();
		geometry.addChild(heaven);
		setGeometry(geometry);							// (B)
		
		setApplicationBounds(new BoundingSphere(
		    new Point3d(),Double.POSITIVE_INFINITY));
	}
}
