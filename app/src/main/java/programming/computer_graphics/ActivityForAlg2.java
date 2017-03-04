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

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class ActivityForAlg2 extends AppCompatActivity implements View.OnTouchListener{
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
                float x=p1.x;
                float y=p1.y;
                float dx=abs(p2.x-p1.x);
                float dy=abs(p2.y-p1.y);
                float s1=signum(p2.x-p1.x);
                float s2=signum(p2.y-p1.y);
                boolean change=false;
                if(dy>dx){
                    change=true;
                    float temp=dx;
                    dx=dy;
                    dy=temp;
                }
                float sf=2*dy-dx;
                float sf1=2*dy;
                float sf2=2*dx;
                for(float i=1; i<=dx;i++){
                    canvas.drawPoint(x,y,p);
                    while(sf>=0){
                        if(change){
                            x+=s1;
                        }
                        else{
                            y+=s2;
                        }
                        sf-=sf2;
                    }
                    if(change){
                        y+=s2;
                    }
                    else{
                        x+=s1;
                    }
                    sf+=sf1;
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
