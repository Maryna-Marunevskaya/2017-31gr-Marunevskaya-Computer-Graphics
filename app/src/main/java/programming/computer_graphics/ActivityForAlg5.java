package programming.computer_graphics;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class ActivityForAlg5 extends AppCompatActivity implements View.OnTouchListener{
    class DrawView extends View {
        Paint p;
        List<PointF> points;
        int count,num;

        public DrawView(Context context, int num) {
            super(context);
            p = new Paint();
            points = new ArrayList<>();
            count=0;
            this.num=num;
        }

        public void addPoint(float x, float y){
            PointF p=new PointF(x,y);
            count++;
            points.add(p);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(1);
            if(count==num) {
                for(float t=0; t<=1; t+=0.00001){
                    PointF arr[]=new PointF[num];
                    for(int i=0; i<num; i++){
                        arr[i]= points.get(i);
                    }
                    for(int j=num-2; j>=0;j--){
                        for(int i=0; i<=j; i++){
                            arr[i].x=arr[i].x+t*(arr[i+1].x-arr[i].x);
                            arr[i].y=arr[i].y+t*(arr[i+1].y-arr[i].y);
                        }
                    }
                    canvas.drawPoint(arr[0].x,arr[0].y,p);
                }
               // canvas.drawText(s,0,s.length(),150,150,p);
                count=0;
                points.clear();
            }
        }
    }
    private DrawView view;
    private int i, num;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.addPoint(event.getX(),event.getY());
                i+=1;
                if(i==num){
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
        Intent intent = getIntent();
        num=intent.getIntExtra("num",2);
        view=new DrawView(this, num);
        view.setOnTouchListener(this);
        setContentView(view);
    }
}
