package com.example.user.drawing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivityLinesDisappear extends Activity {

    MyView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
        }

    public class MyView extends View {

        private Paint paint;
        private PointF startPoint, endPoint;
        private boolean isDrawing;

        public MyView(Context context) {
            super(context);
            init();
        }

        private void init() {
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            if (isDrawing) {
                canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, paint);
            }
        }


        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startPoint = new PointF(event.getX(), event.getY());
                    endPoint = new PointF();
                    isDrawing = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (isDrawing) {
                        endPoint.x = event.getX();
                        endPoint.y = event.getY();
                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (isDrawing) {
                        endPoint.x = event.getX();
                        endPoint.y = event.getY();
                        isDrawing = false;
                        invalidate();
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    } // end View
}