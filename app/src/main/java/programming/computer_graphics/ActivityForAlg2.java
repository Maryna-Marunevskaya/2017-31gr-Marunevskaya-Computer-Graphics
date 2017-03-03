package programming.computer_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class ActivityForAlg2 extends AppCompatActivity implements View.OnTouchListener{
    class DrawView extends View {
        Paint p;
        PointF p1, p2;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p1=new PointF();
            p2=new PointF();
        }
        public void setP1(float x, float y){
            p1.x=x;
            p1.y=y;
        }
        public void setP2(float x, float y){
            p2.x=x;
            p2.y=y;
        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.drawLine(p1.x,p1.y,p2.x,p2.y,p);
        }
    }
    private DrawView view;
    private int i;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(i==0){
                    view.setP1(event.getX(),event.getY());
                    i++;
                }
                else{
                    view.setP2(event.getX(),event.getY());
                    i=0;
                    view.invalidate();
                }
                break;
        }
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i=0;
        super.onCreate(savedInstanceState);
        view=new DrawView(this);
        view.setOnTouchListener(this);
        setContentView(view);
    }
}
