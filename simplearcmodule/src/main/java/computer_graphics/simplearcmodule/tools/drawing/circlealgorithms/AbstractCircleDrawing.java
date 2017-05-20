package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Circle;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

import static java.lang.Math.sqrt;

public abstract class AbstractCircleDrawing extends AbstractDrawing {
    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points= CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        float R=(float)sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));

        this.draw(p1, R, canvas);

        FiguresStorage.addFigure(new Circle(this.alg,(int)this.paint.getStrokeWidth(), p1, R, ToolsStorage.getFirstColor(), ToolsStorage.getSecondColor()));
        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Circle circle=(Circle)figure;

        PointF center=circle.getCenter();

        float R=circle.getR();

        this.paint.setStrokeWidth(circle.getBrushSize());
        this.paint.setColor(circle.getFirstColor().getColor());

        this.draw(center, R, canvas);
    }
    protected void drawPoints(PointF center, float x, float y, Canvas canvas){
        canvas.drawPoint(Math.round(center.x+x), Math.round(center.y+y), this.paint);
        canvas.drawPoint(Math.round(center.x-x), Math.round(center.y+y), this.paint);
        canvas.drawPoint(Math.round(center.x+x), Math.round(center.y-y), this.paint);
        canvas.drawPoint(Math.round(center.x-x), Math.round(center.y-y), this.paint);
        canvas.drawPoint(Math.round(center.x+y), Math.round(center.y+x), this.paint);
        canvas.drawPoint(Math.round(center.x-y), Math.round(center.y+x), this.paint);
        canvas.drawPoint(Math.round(center.x+y), Math.round(center.y-x), this.paint);
        canvas.drawPoint(Math.round(center.x-y), Math.round(center.y-x), this.paint);
    }
    protected abstract void draw(PointF center, float R, Canvas canvas);
}
