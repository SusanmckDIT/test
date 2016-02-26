/**************************************************************

Android provides support for Common Gestures  using
GestureListener (or SimpleGestureListner if you're only
using some in your activity

Demo here shows how the various gestures are automatically 
recognised in Android.. onFling(), onLongPress() etc

****************************************************************/

package com.example.user.touchapps;

import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;

public class CommonGesturesDemo extends Activity
     implements GestureDetector.OnGestureListener
{

	private TextView gestureText;
	private GestureDetector gDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_gestures);
		
		gestureText = (TextView)findViewById(R.id.gestureStatusText);
		
		// create a gesture detector, passing it a gesture listener
		this.gDetector = new GestureDetector(this,this);
	}

	@Override 
	public boolean onTouchEvent(MotionEvent event) 
	{ 
		 this.gDetector.onTouchEvent(event);
		 		 // Be sure to call the superclass implementation
		 return super.onTouchEvent(event);
	}
      @Override
    public boolean onDown(MotionEvent event) 
    { 
         gestureText.setText ("onDown"); 
         return true;
    }

      @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, 
             float velocityX, float velocityY) 
    {
         gestureText.setText("onFling");
         return true;
     }

      @Override
      public void onLongPress(MotionEvent event) 
      {
          gestureText.setText("onLongPress"); 
      }

      @Override
      public boolean onScroll(MotionEvent e1, MotionEvent e2, 
                float distanceX, float distanceY) 
      {
          gestureText.setText("onScroll");
          return true;
      }
    
      @Override
      public void onShowPress(MotionEvent event) 
      {
          gestureText.setText("onShowPress");
      }

      @Override
      public boolean onSingleTapUp(MotionEvent event) 
      {
          gestureText.setText("onSingleTapUp");
          return true;
      }
    
	

} // end class