/*   OriginalCone.java              */
/*   IndexedTriangleArray‚Ìg—p     */
/*   color‚É‚æ‚éF‚Ã‚¯              */ 

import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;     // add

public class OriginalCone extends Shape3D {

  public OriginalCone() {
     super(createGeometry(), createAppearance());
  }


  private static Geometry createGeometry() {
    
       float r = 2.0f;  // ‹…‚Ì”¼Œa
       int n = 100;      // •ªŠ„”
       Point3f[] vertices = new Point3f[n+1];
     
       double theta = 2.0*Math.PI/n; 
       
       for(int i = 0; i < n ; i++){           
          float x = r*(float)Math.cos(theta*i);
          float z = -r*(float)Math.sin(theta*i);
          float y = -2.0f;
          vertices[i] = new Point3f(x, y, z);
       }   
       vertices[n] = new Point3f(0, 2, 0);
   
       int[] indices = new int[6*n];
  
       for(int i = 0 ; i < 3*n; i+=3){
          indices[i] =  i/3;
          indices[i+1] = i/3 + 1;
          indices[i+2] = n;
       }  
       indices[3*n-2] = 0;

       for(int i = 3*n ; i < 6*n; i+=3){
          indices[i] =  i/3 - n + 1;
          indices[i+1] = i/3 - n;
          indices[i+2] = n;
       }            
       indices[6*n-3] = 0;



      Color3f[] colors = new Color3f[1];
         colors[0] = new Color3f(0.0f, 0.0f, 1.0f);   // blue
      int[] colorIndices = new int[6*n];
    
    for(int i = 0; i < 6*n ; i++){
       colorIndices[i] = 0;
    }  

        
       GeometryInfo geometryInfo = new GeometryInfo(GeometryInfo.TRIANGLE_ARRAY);
       geometryInfo.setCoordinates(vertices);
       geometryInfo.setCoordinateIndices(indices);
       geometryInfo.setColors(colors);
       geometryInfo.setColorIndices(colorIndices);

       NormalGenerator normalGenerator = new NormalGenerator();
       normalGenerator.generateNormals(geometryInfo);
       IndexedGeometryArray geom = geometryInfo.getIndexedGeometryArray();

      return (Geometry)geom;
  }

   private static Appearance createAppearance(){
    
    Appearance appearance = new Appearance();

    Material material = new Material();
                         
    Color3f color3f = new Color3f(0.1f, 0.1f, 0.9f);  // 
    material.setAmbientColor(color3f);                // ŠÂ‹«Œõ‚Ìİ’è 
    Color3f color3f1 = new Color3f(0.0f, 0.0f, 1.0f); // Â
    material.setDiffuseColor(color3f1);               // ŠgU”½Ë(•’Ê‚ÌF) 
 
    material.setShininess(12.8f);                     // Œõ‚Ì”½Ë‹ï‡‚Ìİ’è
    appearance.setMaterial(material);

    appearance.setTransparencyAttributes(new TransparencyAttributes
        (TransparencyAttributes.BLENDED, 0.5f));
 
      return appearance;
   }

}
