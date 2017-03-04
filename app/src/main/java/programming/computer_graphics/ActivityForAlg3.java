package programming.computer_graphics;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import static java.lang.Math.sqrt;

public class ActivityForAlg3 extends AppCompatActivity implements View.OnTouchListener{
    class DrawView extends View {
        Paint p;
        PointF p1, p2;
        int count;

        public DrawView(Context context) {
            super(context);
            count=0;
            p = new Paint();
            p1=new PointF();
            p2=new PointF();
        }
        public void setP1(float x, float y){
            p1.x=x;
            p1.y=y;
            count++;
        }
        public void setP2(float x, float y){
            p2.x=x;
            p2.y=y;
            count++;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(1);
            if(count==2) {
                float R=(float)sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
                float sp=(float)(R/sqrt(2.0));
                for(float x=0; x<=sp;x++){
                    float y=(float)(sqrt(R*R-x*x));
                    canvas.drawPoint(p1.x+x,p1.y+y,p);
                    canvas.drawPoint(p1.x+y,p1.y+x,p);
                    canvas.drawPoint(p1.x+y,p1.y-x,p);
                    canvas.drawPoint(p1.x+x,p1.y-y,p);
                    canvas.drawPoint(p1.x-x,p1.y-y,p);
                    canvas.drawPoint(p1.x-y,p1.y-x,p);
                    canvas.drawPoint(p1.x-y,p1.y+x,p);
                    canvas.drawPoint(p1.x-x,p1.y+y,p);
                }
                count=0;
            }
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
