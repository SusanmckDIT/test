package com.example.user.drawing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class MainActivityWithoutPath extends Activity {

    MyView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
        }

    public class MyView extends View
    {
        public MyView(Context context) {
            super(context);
        }

        ArrayList<Rect> lines= new ArrayList<Rect>();
        int x1, y1;
        int x2, y2;
        boolean drawing=false;

        @Override
        protected void onDraw(Canvas canvas)
        {
            // TODO Auto-generated method stub
            super.onDraw(canvas);

            canvas.drawColor(Color.YELLOW);

            Paint p= new Paint();
            Path myPath = new Path();
            p.setColor(Color.BLACK);

            if (drawing)
                canvas.drawLine(x1, y1, x2, y2, p);
            else
                for (int i=0; i<lines.size(); i++)
                {

                    Rect currline= lines.get(i);
                    canvas.drawLine(currline.left, currline.top, currline.right, currline.bottom, p);
                    Log.i("Test", "point on the ")
                }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            boolean result=false;
            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    x1=x2= (int)event.getX();
                    y1=y2= (int)event.getY();
                    drawing=true;
                    result=true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    x2= (int)event.getX();
                    y2= (int)event.getY();
                    result=true;
                    break;
                case MotionEvent.ACTION_UP:
                    x2= (int)event.getX();
                    y2= (int)event.getY();
                    lines.add(new Rect(x1, y1, x2, y2));
                    drawing=false;
                    result=true;
                    break;
            }

            if (result) invalidate();
            return result;
        }
    }
}