package com.example.user.touchapps;/*
         * Author:Susan McKeever
		 * Date:  March 2014
		 * Processes touch events based on a single pointer (finger) on the screen
         		 
*/

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.Toast;

public class SingleTouchActivity extends Activity
{

			// attributes - needed for lab work
            float x1,x2;
            float y1, y2;
            long startTime;
            long endTime;
			long totalTime;
			
            @Override
            protected void onCreate(Bundle savedInstanceState)
            {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.single_touch_activity_main);
            }
          
            // onTouchEvent () method gets called when User performs any touch event on screen 
           // Method to handle touch event like left to right swap and right to left swap
            public boolean onTouchEvent(MotionEvent touchevent)
            {
                switch (touchevent.getAction())
				{
                     // when user first touches the screen, "DOWN" action is the action from MotionEvent
					case MotionEvent.ACTION_DOWN:
                    {
						Toast.makeText(this, "Down action detected", Toast.LENGTH_LONG).show();
                         break;
					}
                            
					case MotionEvent.ACTION_UP:
                    {
						// when user lifts finger from screen, "UP" action is the action from MotionEvent
						Toast.makeText(this, "Up action detected", Toast.LENGTH_LONG).show();
					}
				} // end switch
                return false;
            }  // end onTouchEvent
  
}