package computer_graphics.simplearcmodule.tools.drawing.headalgorithms;

import android.graphics.Canvas;

import static java.lang.Math.abs;

public class ParametricHeadDrawing extends AbstractHeadDrawing {
    public ParametricHeadDrawing(){
        this.count=0;
        this.alg=6;
    }
    @Override
    protected void draw(float x1, float y1, float x2, float y2, Canvas canvas){
        float absx=abs(x2-x1);
        float absy=abs(y2-y1);
        float spec=absx;

        if(absy>absx){
            spec=absy;
        }

        float dx=(x2-x1)/spec;
        float dy=(y2-y1)/spec;

        float x=x1,y=y1;

        for(float i=0; i<=spec;i++){
            canvas.drawPoint(Math.round(x), Math.round(y), this.paint);
            x+=dx;
            y+=dy;
        }
    }
}
