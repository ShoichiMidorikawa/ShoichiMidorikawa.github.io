import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;

class MyObject extends Object
{
	private Applet applet;

	public MyObject(Applet applet)
	{
		this.applet=applet;
	}

	// ïëë‰ÇÃçÏê¨

	public BranchGroup buildStage()
	{
		BranchGroup stage,athletics,setting;
	
		stage=new BranchGroup();
		
		athletics=new BranchGroup();



		stage.addChild(athletics);
		
		setting=new BranchGroup();

                MyBackground myBackground = new MyBackground(applet);
		setting.addChild(myBackground);
		stage.addChild(setting);
		
		return stage;
	}


}
