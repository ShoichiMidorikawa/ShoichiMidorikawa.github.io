import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;

public class TimerBehavior extends Behavior {
   WakeupOnElapsedTime won;

    private TransformGroup tg0, tg1, tg2, tg3, tg4, tg5;
    private TransformGroup tg6, tg7, tg8, tg9, tg10, tg11;
    private TransformGroup tg12, tg13, tg14, tg15, tg16, tg17;
    private TransformGroup tg18, tg19, tg20, tg21, tg22, tg23;

    private Transform3D trans0 = new Transform3D();
    private Transform3D trans1 = new Transform3D();
    private Transform3D trans2 = new Transform3D();
    private Transform3D trans3 = new Transform3D();
    private Transform3D trans4 = new Transform3D();
    private Transform3D trans5 = new Transform3D();
    private Transform3D trans6 = new Transform3D();
    private Transform3D trans7 = new Transform3D();
    private Transform3D trans8 = new Transform3D();
    private Transform3D trans9 = new Transform3D();
    private Transform3D trans10 = new Transform3D();
    private Transform3D trans11 = new Transform3D();

    private Transform3D trans12 = new Transform3D();
    private Transform3D trans13 = new Transform3D();
    private Transform3D trans14 = new Transform3D();
    private Transform3D trans15 = new Transform3D();
    private Transform3D trans16 = new Transform3D();
    private Transform3D trans17 = new Transform3D();

    private Transform3D trans18 = new Transform3D();
    private Transform3D trans19 = new Transform3D();
    private Transform3D trans20 = new Transform3D();
    private Transform3D trans21 = new Transform3D();
    private Transform3D trans22 = new Transform3D();
    private Transform3D trans23 = new Transform3D();


    private WakeupCriterion criterion;
    private float dt = 0.01f;
    private int  sgnx, sgny, sgnz; 

    int n = 24;
    double xp[] = new double[n];
    double yp[] = new double[n]; 
    double zp[] = new double[n];


    // create a new TimerBehavior
    public TimerBehavior(TransformGroup tg0, TransformGroup tg1, TransformGroup tg2, 
                         TransformGroup tg3, TransformGroup tg4, TransformGroup tg5, 
                         TransformGroup tg6, TransformGroup tg7, TransformGroup tg8, 
                         TransformGroup tg9, TransformGroup tg10, TransformGroup tg11,
                         TransformGroup tg12, TransformGroup tg13, TransformGroup tg14,
                         TransformGroup tg15, TransformGroup tg16, TransformGroup tg17,
                         TransformGroup tg18, TransformGroup tg19, TransformGroup tg20,
                         TransformGroup tg21, TransformGroup tg22, TransformGroup tg23, long sleep) {

       	this.tg0 = tg0;
       	this.tg1 = tg1;
       	this.tg2 = tg2;
       	this.tg3 = tg3;
       	this.tg4 = tg4;
       	this.tg5 = tg5;
       	this.tg6 = tg6;
       	this.tg7 = tg7;
       	this.tg8 = tg8;
       	this.tg9 = tg9;
       	this.tg10 = tg10;
       	this.tg11 = tg11;

       	this.tg12 = tg12;
       	this.tg13 = tg13;
       	this.tg14 = tg14;
       	this.tg15 = tg15;
       	this.tg16 = tg16;
       	this.tg17 = tg17;

       	this.tg18 = tg18;
       	this.tg19 = tg19;
       	this.tg20 = tg20;
       	this.tg21 = tg21;
       	this.tg22 = tg22;
       	this.tg23 = tg23;

        won = new WakeupOnElapsedTime(sleep);
    }


    // initialize the behavior to wakeup on a behavior post with the id
    // MouseEvent.MOUSE_CLICKED
    public void initialize() {

      xp[0] = xp[1] = xp[2] = xp[3] = xp[4] = xp[5] = 0;
      yp[0] = yp[1] = yp[2] = yp[3] = yp[4] = yp[5] = 0;
      zp[0] = zp[1] = zp[2] = zp[3] = zp[4] = zp[5] = 0;
      xp[6] = xp[7] = xp[8] = xp[9] = xp[10] = xp[11] = 0;
      yp[6] = yp[7] = yp[8] = yp[9] = yp[10] = yp[11] = 0;
      zp[6] = zp[7] = zp[8] = zp[9] = zp[10] = zp[11] = 0;
      xp[12] = xp[13] = xp[14] = xp[15] = xp[16] = xp[17] = 0;
      yp[12] = yp[13] = yp[14] = yp[15] = yp[16] = yp[17] = 0;
      zp[12] = zp[13] = zp[14] = zp[15] = zp[16] = zp[17] = 0;

      xp[18] = xp[19] = xp[20] = xp[21] = xp[22] = xp[23] = 0;
      yp[18] = yp[19] = yp[20] = yp[21] = yp[22] = yp[23] = 0;
      zp[18] = zp[19] = zp[20] = zp[21] = zp[22] = zp[23] = 0;

        wakeupOn(won);
    }

    // processStimulus to rotate the cube
    public void processStimulus(java.util.Enumeration criteria) {
            
         for(int i = 0; i < n; i=i+2){
            double rndx = Math.random();
            double rndy = Math.random();
            double rndz = Math.random();
           if(rndx >= 0.5)  sgnx = 1;
            else sgnx = -1;
            if(rndy >= 0.5)  sgny = 1;
            else sgny = -1;
            if(rndz >= 0.5)  sgnz = 1;
            else sgnz = -1;
            double dx = sgnx*0.002;
            double dy = sgny*0.002;
            double dz = sgnz*0.002;
 
            xp[i] += dx;
            yp[i] += dy;
            zp[i] += dz;
         }

          
         Vector3d vector3d[] = new Vector3d[n];
         double dist = 0.5;
         for(int i = 0; i < n; i=i+2){
            vector3d[i] = new Vector3d(xp[i] - dist, yp[i], zp[i]);
            vector3d[i+1] = new Vector3d(xp[i] + dist , yp[i], zp[i]);
         }   

     
      trans0.setTranslation(vector3d[0]);
      trans1.setTranslation(vector3d[1]);
      trans2.setTranslation(vector3d[2]);
      trans3.setTranslation(vector3d[3]);
      trans4.setTranslation(vector3d[4]);
      trans5.setTranslation(vector3d[5]);
      trans6.setTranslation(vector3d[6]);
      trans7.setTranslation(vector3d[7]);
      trans8.setTranslation(vector3d[8]);
      trans9.setTranslation(vector3d[9]);
      trans10.setTranslation(vector3d[10]);
      trans11.setTranslation(vector3d[11]);
      trans12.setTranslation(vector3d[12]);
      trans13.setTranslation(vector3d[13]);
      trans14.setTranslation(vector3d[14]);
      trans15.setTranslation(vector3d[15]);
      trans16.setTranslation(vector3d[16]);
      trans17.setTranslation(vector3d[17]);

      trans18.setTranslation(vector3d[18]);
      trans19.setTranslation(vector3d[19]);
      trans20.setTranslation(vector3d[20]);
      trans21.setTranslation(vector3d[21]);
      trans22.setTranslation(vector3d[22]);
      trans23.setTranslation(vector3d[23]);

	tg0.setTransform(trans0);
	tg1.setTransform(trans1);
	tg2.setTransform(trans2);
	tg3.setTransform(trans3);
	tg4.setTransform(trans4);
	tg5.setTransform(trans5);
	tg6.setTransform(trans6);
	tg7.setTransform(trans7);
	tg8.setTransform(trans8);
	tg9.setTransform(trans9);
	tg10.setTransform(trans10);
	tg11.setTransform(trans11);

	tg12.setTransform(trans12);
	tg13.setTransform(trans13);
	tg14.setTransform(trans14);
	tg15.setTransform(trans15);
	tg16.setTransform(trans16);
	tg17.setTransform(trans17);

	tg18.setTransform(trans18);
	tg19.setTransform(trans19);
	tg20.setTransform(trans20);
	tg21.setTransform(trans21);
	tg22.setTransform(trans22);
	tg23.setTransform(trans23);

	wakeupOn(won);
    }


}

