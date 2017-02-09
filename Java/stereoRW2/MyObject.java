/*                                       */
/*         ëæózåıÇóÅÇ—ÇΩínãÖ            */
/*                                       */
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
		BranchGroup stage,athletics;
	
		stage=new BranchGroup();
		
		athletics=new BranchGroup();

                TransformGroup transformGroup = new TransformGroup();


                Appearance appO = new Appearance();
                Color3f ambientColourO = new Color3f(1.0f, 1.0f, 1.0f);
                Color3f emissiveColourO = new Color3f(0.0f, 0.0f, 0.0f);
                Color3f specularColourO = new Color3f(0.0f, 0.0f, 0.0f);
                Color3f diffuseColourO = new Color3f(0.0f, 1.0f, 1.0f);
                float shininessO = 20.0f;
                appO.setMaterial(new Material(ambientColourO, emissiveColourO,
                diffuseColourO, specularColourO, shininessO));

                Sphere mySphere = new Sphere(0.03f, Sphere.GENERATE_NORMALS, appO);
		transformGroup.addChild(mySphere);
                athletics.addChild(transformGroup);
             
                BoundingSphere boundingSphere = new BoundingSphere();

                Color3f color3f = new Color3f(0.0f, 1.0f, 1.0f);
                Vector3f vector3f = new Vector3f(1.0f, 0.0f, 0.0f);
                DirectionalLight directionalLight = new DirectionalLight(color3f, vector3f);

                directionalLight.setInfluencingBounds(boundingSphere);  
                
                stage.addChild(directionalLight);           
   
		stage.addChild(athletics);
		
		return stage;
	}


}
