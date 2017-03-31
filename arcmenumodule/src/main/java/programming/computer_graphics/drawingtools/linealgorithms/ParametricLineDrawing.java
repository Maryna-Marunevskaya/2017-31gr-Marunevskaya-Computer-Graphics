package programming.computer_graphics.drawingtools.linealgorithms;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import programming.computer_graphics.drawingtools.AbstractDrawing;

import static java.lang.Math.abs;

public class ParametricLineDrawing extends AbstractDrawing {
    public ParametricLineDrawing(Context context) {
        super(context);
    }

    @Override
    protected void drawAlg(Paint paint, Canvas canvas){
            canvas.drawColor(Color.WHITE);
            PointF p1=points.get(0);
            PointF p2=points.get(1);

            float absx=abs(p2.x-p1.x);
            float absy=abs(p2.y-p1.y);
            float spec=absx;
            if(absy>absx){
                spec=absy;
            }
            float dx=(p2.x-p1.x)/spec;
            float dy=(p2.y-p1.y)/spec;
            float x=p1.x,y=p1.y;
            for(int i=0; i<=(int)spec;i++){
                canvas.drawPoint(x,y,paint);
                x+=dx;
                y+=dy;
            }
            this.counter=0;
            this.points.clear();
    }
}
