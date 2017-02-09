import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.util.*;

public class TimerBehavior extends Behavior {
   WakeupOnElapsedTime won;

    private TransformGroup transformGroup;
    private Transform3D trans = new Transform3D();

    private WakeupCriterion criterion;
    private double t = 0.0;
    private double dt = 0.01;
    private double g = 9.8; 
    private double v0 = 5.;    
    private double x = 0.0;
    private double y = 0.0;
    private double z = 0.0;

    // create a new TimerBehavior
    public TimerBehavior(TransformGroup tg, long sleep) {
       	transformGroup = tg;
        won = new WakeupOnElapsedTime(sleep);
    }

    // initialize the behavior to wakeup on a behavior post with the id
    // MouseEvent.MOUSE_CLICKED
    public void initialize() {
	
        wakeupOn(won);
    }

    // processStimulus
    public void processStimulus(java.util.Enumeration criteria) {
        t += dt;             
        y = v0*t - 0.5*g*t*t;;
        if( y < 0 ){ t = 0; y = 0;} 
        double yy = y  -0.5;
      Vector3d vector3d = new Vector3d(x, yy, z); 
      trans.setTranslation(vector3d);

	transformGroup.setTransform(trans);
	wakeupOn(won);
    }


}

