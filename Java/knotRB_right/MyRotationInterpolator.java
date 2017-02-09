import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;

import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior;



/*
<applet code="MyRotationInterpolator.class" width="1000" height="600">
</applet>
*/

public class MyRotationInterpolator extends Applet implements ActionListener{
   
      Button button = new Button("   START   ");
      boolean bl = false;


     /* --------------- �V�[���O���t�̍\�z --------------------*/
      Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
      BorderLayout borderLayout = new BorderLayout();
      SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
      BranchGroup objRoot = new BranchGroup();

      private boolean isStandalone = false; 


//      RotationInterpolator rotationInterpolator;
//      TransformGroup transformGroup;

      Alpha alpha = new Alpha();
      
//      Transform3D transform3D = new Transform3D();

      int loopCount;
  



   public MyRotationInterpolator(){
      this.setLayout(borderLayout);
      loopCount = (this.alpha).getLoopCount();

      Panel p = new Panel();
      p.add(button);
      add("North", p);
      button.addActionListener(this);

      this.add(canvas3D, BorderLayout.CENTER);
      simpleUniverse.getViewingPlatform().setNominalViewingTransform();
    
      objRoot.setCapability(BranchGroup.ALLOW_BOUNDS_READ);
      objRoot.setCapability(BranchGroup.ALLOW_DETACH);      


/* --------------- �����̒�` -----------------------------*/
      DirectionalLight directionalLight = new DirectionalLight();

/* --------------- ���[�J�����W�n�̐ݒ� -------------------*/
      TransformGroup transformGroup = new TransformGroup();
      TransformGroup transformGroup2 = new TransformGroup();

      Transform3D transform3D = new Transform3D();
      Transform3D transform3D2 = new Transform3D();


/* --------------- �L�����N�^�[�̐��� ----------------------*/
      DrawLine drawLine = new DrawLine();
      DrawLine2 drawLine2 = new DrawLine2();

/* --------------- �`��͈͂̒�` --------------------------*/
      BoundingSphere boundingSphere = new BoundingSphere();

/* --------------- Capability �̐ݒ� -----------------------*/
      transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      transformGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

/* --------------- �A���t�@�l�̐��� ------------------------*/
//      Alpha alpha = new Alpha();


			alpha = new Alpha(-1,			// ������
			    Alpha.INCREASING_ENABLE,
			    0,					
			    0,					
			    4000,				
			    0,				
			    0,	 			
			    0,				
			    0,				
			    0);				




     Vector3d posm = new Vector3d(-0.05, 0.0, 0.0);
     Transform3D t3dm = new Transform3D();
     t3dm.set(posm);
     TransformGroup transm = new TransformGroup(t3dm);

     Vector3d posp = new Vector3d(0.05, 0.0, 0.0);
     Transform3D t3dp = new Transform3D();
     t3dp.set(posp);
     TransformGroup transp = new TransformGroup(t3dp);
  


/* --------------- ��]������A�j���[�V�����̒�` ------*/
      RotationInterpolator rotationInterpolator = new RotationInterpolator(
         alpha, transformGroup, transform3D, 0.00f, 3.14f);

      RotationInterpolator rotationInterpolator2 = new RotationInterpolator(
         alpha, transformGroup2, transform3D2, 0.00f, 3.14f);


/* --------------- �`��͈͂̐ݒ� --------------------------*/
      rotationInterpolator.setSchedulingBounds(boundingSphere);
      rotationInterpolator2.setSchedulingBounds(boundingSphere);
      directionalLight.setInfluencingBounds(boundingSphere);

/* --------------- ���̓����V�[���O���t�ɒǉ� --------------*/
      transformGroup.addChild(rotationInterpolator);
      transformGroup.addChild(drawLine);
      transformGroup2.addChild(rotationInterpolator2);
      transformGroup2.addChild(drawLine2);
      transm.addChild(transformGroup);
      transp.addChild(transformGroup2);
      objRoot.addChild(transm);
      objRoot.addChild(transp);
      objRoot.addChild(directionalLight);

/* --------------- ���̑��̃c���[���V�[���O���t�ɒǉ� ------*/
      simpleUniverse.addBranchGraph(objRoot);
         alpha.setStartTime(System.currentTimeMillis());         
         alpha.setLoopCount(0);
         bl = true; 
   }

   public void actionPerformed(ActionEvent evt){

      if(bl == true){
         button.setLabel("  STOP  ");
         alpha.setStartTime(System.currentTimeMillis());         
         alpha.setLoopCount(loopCount);
         bl = false; 
      }
      else{
         button.setLabel("   START   ");
         alpha.setStartTime(System.currentTimeMillis());
         alpha.setLoopCount(0);
         bl = true;
      }        
   } 


/* --------------- �쐬�����N���X�t�@�C���̌Ăяo�� --------*/
   public static void main(String args[]){
      MyRotationInterpolator rotation = new MyRotationInterpolator();
      MainFrame mainFrame = new MainFrame(rotation, 800, 500);
   }
}


