package computer_graphics.simplearcmodule.tools.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;

public abstract class AbstractDrawing {
    protected int count;
    protected Paint paint;

    public void setPaint(Paint paint){
        this.paint=paint;
    }

    public int getCount(){
        return this.count;
    }

    public abstract void drawAlg(Canvas canvas);

    public abstract void drawFigure(Canvas canvas, AbstractFigure figure);
}
