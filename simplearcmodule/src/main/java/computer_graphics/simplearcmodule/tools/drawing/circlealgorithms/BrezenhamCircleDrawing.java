package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

public class BrezenhamCircleDrawing extends AbstractCircleDrawing {
    public BrezenhamCircleDrawing(){
        this.count=2;
        this.alg=4;
    }

    @Override
    protected void draw(PointF center, float R, Canvas canvas){
        int x=0, y=Math.round(R), f=Math.round(1-R), incrE=3, incrSE=Math.round(5-2*R);

        canvas.drawPoint(Math.round(center.x), Math.round(center.y+R), this.paint);
        canvas.drawPoint(Math.round(center.x), Math.round(center.y-R), this.paint);
        canvas.drawPoint(Math.round(center.x+R), Math.round(center.y), this.paint);
        canvas.drawPoint(Math.round(center.x-R), Math.round(center.y), this.paint);

        while(x<=y){
            if(f>0){
                y-=1;
                f+=incrSE;
                incrSE+=4;
            }
            else{
                f+=incrE;
                incrSE+=2;
            }
            incrE+=2;
            x+=1;
            this.drawPoints(center, x, y, canvas);
        }
    }
}
