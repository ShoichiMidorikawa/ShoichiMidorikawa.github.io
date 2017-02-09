import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.Sphere;

public class MyBackground extends TransformGroup
{
	Applet applet;

	public MyBackground(Applet applet)
	{
		this.applet=applet;
                this.addChild(createHeaven());
	}

	// 舞台の作成


	// 背景関連の構築

	private Node createHeaven()
	{
		HeavenlyBody heaven;
		Appearance appearance;
	
		appearance=new Appearance();
		appearance.setTexture(loadTexture("StarsMap.jpg",TextureLoader.Y_UP));
		heaven = new HeavenlyBody(30,appearance);
		
		return heaven;
	}

	// テクスチャの読み込み

	private Texture loadTexture(String filename)
	{
		return loadTexture(filename,0);			
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


