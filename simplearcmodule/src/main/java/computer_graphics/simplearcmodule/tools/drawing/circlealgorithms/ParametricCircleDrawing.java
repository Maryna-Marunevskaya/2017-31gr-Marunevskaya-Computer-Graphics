package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import static java.lang.Math.sqrt;

public class ParametricCircleDrawing extends AbstractCircleDrawing {
    public ParametricCircleDrawing(){
        this.count=2;
        this.alg=3;
    }

    @Override
    protected void draw(PointF center, float R, Canvas canvas){
        float sp=(float)(R/sqrt(2.0));

        float x=0, y;

        for(; x<=sp;x++) {
            y = (float) (sqrt(R * R - x * x));
            this.drawPoints(center, x, y, canvas);
        }
    }
}
