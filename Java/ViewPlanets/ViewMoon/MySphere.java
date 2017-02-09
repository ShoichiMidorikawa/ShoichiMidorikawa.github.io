import java.applet.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;

public class MySphere extends TransformGroup
{
           SimpleUniverse universe; 
	   Applet applet;
  
	public MySphere(Applet applet)
	{
		this.applet=applet;
		
                this.addChild(createSphere(universe));

    	}
  

	public BranchGroup createSphere(SimpleUniverse universe)
	{
                BranchGroup stage;
		stage=new BranchGroup();

		TransformGroup transform;
		Transform3D translation;
		Appearance appearance;
                Sphere sphere;
	
		translation=new Transform3D();
		translation.setTranslation(new Vector3d(0.0,0.0,0.0));

                Transform3D transform3D = new Transform3D();
                transform3D.rotY(Math.PI/3); 
                transform3D.setScale(0.6);                  // new スケールを0.6に縮小 

                translation.mul(transform3D);               

		transform=new TransformGroup(translation);

                		
		appearance=new Appearance();
		appearance.setTexture(loadTexture("MoonMap2-3.gif"));
		
		
		sphere=new Sphere(0.4f,
		    Sphere.GENERATE_TEXTURE_COORDS,appearance);
		transform.addChild(sphere);
                stage.addChild(transform);		


		return stage;
	}

	// テクスチャの読み込み

	private Texture loadTexture(String filename)
	{
		return loadTexture(filename,0);			// 特に指定(flag)なしの場合
	}

	private Texture loadTexture(String filename,int flags)
	{
		Texture texture;
		URL location;
	
		try {
			location=new URL(applet.getCodeBase(),filename);
			texture=new TextureLoader(location,flags,applet).getTexture();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
			
			texture=null;
		}
		
		return texture;
	}
}
