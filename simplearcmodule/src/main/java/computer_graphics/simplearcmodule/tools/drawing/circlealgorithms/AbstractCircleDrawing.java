package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

public abstract class AbstractCircleDrawing extends AbstractDrawing {
    protected void drawPoints(PointF center, float x, float y, Canvas canvas){
        canvas.drawPoint(center.x+x, center.y+y, this.paint);
        canvas.drawPoint(center.x-x, center.y+y, this.paint);
        canvas.drawPoint(center.x+x, center.y-y, this.paint);
        canvas.drawPoint(center.x-x, center.y-y, this.paint);
        canvas.drawPoint(center.x+y, center.y+x, this.paint);
        canvas.drawPoint(center.x-y, center.y+x, this.paint);
        canvas.drawPoint(center.x+y, center.y-x, this.paint);
        canvas.drawPoint(center.x-y, center.y-x, this.paint);
    }
}
