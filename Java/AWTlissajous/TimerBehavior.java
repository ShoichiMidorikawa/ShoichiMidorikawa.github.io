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
    private float angle = 0.0f;

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

    // processStimulus to rotate the cube
    public void processStimulus(java.util.Enumeration criteria) {
            
	angle += Math.toRadians(0.5);   

      double r = 0.5;
        double x = r*Math.sin(6*angle);
        double y = r*Math.sin(8*angle);
        double z = r*Math.cos(10*angle);

      Vector3d vector3d = new Vector3d(x, y, z); 
     
      trans.setTranslation(vector3d);


	transformGroup.setTransform(trans);
	wakeupOn(won);
    }


}

