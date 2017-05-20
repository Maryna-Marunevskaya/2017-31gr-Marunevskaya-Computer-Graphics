package computer_graphics.simplearcmodule.tools.drawing.linealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import static java.lang.Math.abs;

public class ParametricLineDrawing extends AbstractLineDrawing {
    public ParametricLineDrawing(){
        this.count=2;
        this.alg=1;
    }

    @Override
    protected void draw(PointF p1, PointF p2, Canvas canvas){
        float absx=abs(p2.x-p1.x);
        float absy=abs(p2.y-p1.y);
        float lineLength=absx;

        if(absy>absx){
            lineLength=absy;
        }

        float dx=(p2.x-p1.x)/lineLength;
        float dy=(p2.y-p1.y)/lineLength;

        float x=p1.x,y=p1.y;

        int ilineLength1=(int)lineLength;

        for(int i=0; i<=ilineLength1;i++){
            canvas.drawPoint(Math.round(x), Math.round(y), this.paint);
            x+=dx;
            y+=dy;
        }
    }
}