import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.applet.*;

public class TimerBehavior extends Behavior {
   WakeupOnElapsedTime won;

    private TransformGroup tg;
    private Transform3D trans0 = new Transform3D();
    private Transform3D trans = new Transform3D();
    private Transform3D trans2 = new Transform3D();

    private WakeupCriterion criterion;
    private double dt = 0.002;
    private double r = 0.7;
    private double rs = r*r;
    private double r2, r2s, r3, r3s, r4, r4s;
    private double rq, r2q, r3q, r4q;
    private double x, y, z, x0, y0, z0;
    private double x2,y2, z2;
    private double x3, y3, z3;
    private double x4, y4, z4;

    private Vector3f vector3f, vector3f0;
    private Color3f c3f;

    private double vx;
    private double vy;
    private double vz;
    private double kx1, kx2, kx3, kx4, kx;
    private double ky1, ky2, ky3, ky4, ky;
    private double kz1, kz2, kz3, kz4, kz;
    private double kvx1, kvx2, kvx3, kvx4, kvx;
    private double kvy1, kvy2, kvy3, kvy4, kvy;
    private double kvz1, kvz2, kvz3, kvz4, kvz;

    BoundingSphere boundingSphere;


    // create a new TimerBehavior
    public TimerBehavior(TransformGroup tg,long sleep) {
       	this.tg = tg;
        won = new WakeupOnElapsedTime(sleep);
    }



    // initialize the behavior to wakeup on a behavior post with the id
    // MouseEvent.MOUSE_CLICKED
    public void initialize() {
        x = r;
        y = 0;
        z = 0;
 
        vx = 0;
        vy = 1.0;
        vz = 0;      
	
        wakeupOn(won);
    }

    // processStimulus to rotate the cube
    public void processStimulus(java.util.Enumeration criteria) {

        x0 = x; y0 = y;            

        // Runge-Kutta method        
        rs = x*x + y*y; r = Math.sqrt(rs); rq = rs*r;
        kvx1 = F.kva(rq, x)*dt; kvy1 = F.kva(rq, y)*dt;//  kvz = F.kva(rq, z)*dt; 
        kx1 = vx*dt;  ky1 = vy*dt; // kz1 = vz*dt;

        kx2 = F.ka(vx, kvx1)*dt; ky2 = F.ka(vy, kvy1)*dt; //kz2 = F.ka(vz, kvz1)*dt;
        x2 = x + kx1/2.; y2 = y + ky1/2.;  // z2 = z + kz1/2.;
 
        r2s = x2*x2 + y2*y2; r2 = Math.sqrt(r2s); r2q = r2s*r2;
        kvx2 = F.kva(r2q, x2)*dt; kvy2 = F.kva(r2q, y2)*dt;//  kvz2 = F.kva(r2q, z2)*dt; 

        kx3 = F.ka(vx, kvx2)*dt; ky3 = F.ka(vy, kvy2)*dt; //kz3 = F.ka(vz, kvz2)*dt;
        x3 = x + kx2/2.; y3 = y + ky2/2.; z3 = // z + z + kz2/2.;
        r3s = x3*x3 + y3*y3; r3 = Math.sqrt(r3s); r3q = r3s*r3;
        kvx3 = F.kva(r3q, x3)*dt; kvy3 = F.kva(r3q, y3)*dt;//  kvz3 = F.kva(r3q, z3)*dt;   

        kx4 = F.ka(vx, 2.*kvx3)*dt; ky4 = F.ka(vy, 2.*kvy3)*dt; //kz4 = F.ka(vz, 2.*kvz3)*dt;
        x4 = x + kx3; y4 = y + ky3; // z4 = z + kz3;
        r4s = x4*x4 + y4*y4; r4 = Math.sqrt(r4s); r4q = r4s*r4;
        kvx4 = F.kva(r4q, x4)*dt; kvy4 = F.kva(r4q, y4)*dt;//  kvz4 = F.kva(r4q, z4)*dt; 

        kvx = (kvx1 + 2.*kvx2 + 2.*kvx3 + kvx4)/6.; 
        kvy = (kvy1 + 2.*kvy2 + 2.*kvy3 + kvy4)/6.;   //  kvz = (kvz1 + 2.*kvz2 + 2.*kvz3 + kvz4)/6.;

        kx = (kx1 + 2.*kx2 + 2.*kx3 + kx4)/6.;
        ky = (ky1 + 2.*ky2 + 2.*ky3 + ky4)/6.;        //  kz = (kz1 + 2.*kz2 + 2.*kz3 + kz4)/6.;
        
        x += kx; y += ky;  // z += kz;         
        vx += kvx; vy += kvy;  // vz += kvz;  
     
//        double H= (vx*vx + vy*vy +vz*vz)/2. - 1./r;             
//        System.out.println("H = " + H);      


        Vector3d vector3d = new Vector3d(x, y, 0); 


        double st = (x0*y - y0*x)/r/Math.sqrt(x*x+y*y);
        double theta = Math.asin(st);

        trans0.rotZ(theta); 
        trans.setTranslation(vector3d);
        trans.mul(trans0);
        
      	tg.setTransform(trans);
         

	wakeupOn(won);
    }
}


class F{
   static double a, va, ka;
   double rq;

   public static double ka(double va, double kva){
       va = va + kva/2.0;
       return va;
   }

   public static double kva(double rq, double a){
       ka = -a/rq;
       return ka;               
   }   
}
