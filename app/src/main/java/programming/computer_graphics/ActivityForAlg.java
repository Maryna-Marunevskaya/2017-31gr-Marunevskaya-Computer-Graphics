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

import static java.lang.Math.abs;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.sqrt;

public class ActivityForAlg extends AppCompatActivity implements View.OnTouchListener{
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
                float x2=p1.x;
                float y2=p1.y+R;
                float x1,y1;
                for(int i=1; i<=360;i++) {
                    x1 = x2;
                    y1 = y2;
                    x2 = (float) (R * sin(1.0*i) + p1.x);
                    y2 = (float) (R * cos(1.0*i) + p1.y);

                    float absx=abs(x2-x1);
                    float absy=abs(y2-y1);
                    float spec=absx;
                    if(absy>absx){
                        spec=absy;
                    }
                    float dx=(x2-x1)/spec;
                    float dy=(y2-y1)/spec;
                    float x=x1,y=y1;
                    for(int j=0; j<(int)spec;j++){
                        canvas.drawPoint(x,y,p);
                        x+=dx;
                        y+=dy;
                    }
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
