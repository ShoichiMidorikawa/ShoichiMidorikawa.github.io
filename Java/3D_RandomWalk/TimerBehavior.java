import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;

public class TimerBehavior extends Behavior {
   WakeupOnElapsedTime won;

    private TransformGroup tg0, tg1, tg2, tg3, tg4;
    private Transform3D trans0 = new Transform3D();
    private Transform3D trans1 = new Transform3D();
    private Transform3D trans2 = new Transform3D();
    private Transform3D trans3 = new Transform3D();
    private Transform3D trans4 = new Transform3D();

    private WakeupCriterion criterion;
    private float dt = 0.01f;
    private int  sgnx, sgny, sgnz; 

    int n = 5;
    double xp[] = new double[n];
    double yp[] = new double[n]; 
    double zp[] = new double[n];


    // create a new TimerBehavior
    public TimerBehavior(TransformGroup tg0, TransformGroup tg1, TransformGroup tg2, 
                         TransformGroup tg3, TransformGroup tg4, long sleep) {
       	this.tg0 = tg0;
       	this.tg1 = tg1;
       	this.tg2 = tg2;
       	this.tg3 = tg3;
       	this.tg4 = tg4;
        won = new WakeupOnElapsedTime(sleep);
    }


    // initialize the behavior to wakeup on a behavior post with the id
    // MouseEvent.MOUSE_CLICKED
    public void initialize() {

      xp[0] = xp[1] = xp[2] = xp[3] = xp[4] = 0;
      yp[0] = yp[1] = yp[2] = yp[3] = yp[4] = 0;
      zp[0] = zp[1] = zp[2] = zp[3] = zp[4] = 0;
	
        wakeupOn(won);
    }

    // processStimulus to rotate the cube
    public void processStimulus(java.util.Enumeration criteria) {
            
         for(int i = 0; i < n; i++){
            double rndx = Math.random();
            double rndy = Math.random();
            double rndz = Math.random();
           if(rndx >= 0.5)  sgnx = 1;
            else sgnx = -1;
            if(rndy >= 0.5)  sgny = 1;
            else sgny = -1;
            if(rndz >= 0.5)  sgnz = 1;
            else sgnz = -1;
            double dx = sgnx*0.005;
            double dy = sgny*0.005;
            double dz = sgnz*0.005;
 
            xp[i] += dx;
            yp[i] += dy;
            zp[i] += dz;
         }

         Vector3d vector3d[] = new Vector3d[n];
         for(int i = 0; i < n; i++){
            vector3d[i] = new Vector3d(xp[i], yp[i], zp[i]);
         }   
     
      trans0.setTranslation(vector3d[0]);
      trans1.setTranslation(vector3d[1]);
      trans2.setTranslation(vector3d[2]);
      trans3.setTranslation(vector3d[3]);
      trans4.setTranslation(vector3d[4]);

	tg0.setTransform(trans0);
	tg1.setTransform(trans1);
	tg2.setTransform(trans2);
	tg3.setTransform(trans3);
	tg4.setTransform(trans4);

   
	wakeupOn(won);
    }


}

