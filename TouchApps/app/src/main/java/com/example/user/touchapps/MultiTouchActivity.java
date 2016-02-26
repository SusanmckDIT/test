package com.example.user.touchapps;/*

Author: Susan McKeever
Date: March 2014
Description: Multi Touch activity example. Test this on a real phone if possibel
to detect mult touch. Using in the emulator will only detect a single touch (mouse)   

*/


import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MultiTouchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_touch_activity_main);
		
		//Connect to the layout
		RelativeLayout myLayout = 
                (RelativeLayout)findViewById(R.id.RelativeLayout1);

		//attach a touch listener to the layout, adding callback method as an anonymous class
            myLayout.setOnTouchListener(
        		new RelativeLayout.OnTouchListener() 
        						{
        			public boolean onTouch(View v, MotionEvent touchEvent) 
        			{
        				processTouch(touchEvent);     				
        			    return true;
        			}
        		}
        );
	}

    // process each touch event
	void processTouch(MotionEvent touchEvent)
	{
	    	TextView textView1 = (TextView)findViewById(R.id.textView1);
	    	TextView textView2 = (TextView)findViewById(R.id.textView2);

	    	// Get the number of pointers (i.e. number of fingers detected on the screen)
	    	int pointerCount = touchEvent.getPointerCount();
	    	
	    	for (int i = 0; i < pointerCount; i++)
	    	{
	    		int x 			= (int) touchEvent.getX(i);
	    		int y 			= (int) touchEvent.getY(i);    		
	    		int id 			= touchEvent.getPointerId(i);
	    		int action 		= touchEvent.getActionMasked();
	    		int actionIndex = touchEvent.getActionIndex();
	    		String actionString;
	    		
	    		switch (action)
	    		{
	    			case MotionEvent.ACTION_DOWN:
	    				actionString = "DOWN";
	    				break;
						
	    			case MotionEvent.ACTION_UP:
	    				actionString = "UP";
	    				break;	
						
	    			case MotionEvent.ACTION_POINTER_DOWN:
	    				actionString = "POINTER DOWN";
	    				break;
						
	    			case MotionEvent.ACTION_POINTER_UP:
	        			actionString = "POINTER UP";
	        			break;
						
	    			case MotionEvent.ACTION_MOVE:
	    				actionString = "MOVE";
	    				break;
						
	    			default:
	    				actionString = "";
	    		}
	    		
	    		String touchStatus = "Action: " + actionString + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
	    		
				// Set the relevant text label to the latest data from the Motion Event
	    		if (id == 0)
	    			textView1.setText(touchStatus);
	    		else 
	    			textView2.setText(touchStatus);
	    	}
	}

}
