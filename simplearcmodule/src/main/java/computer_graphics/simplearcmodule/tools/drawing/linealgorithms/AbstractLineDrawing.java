package computer_graphics.simplearcmodule.tools.drawing.linealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Line;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

public abstract class AbstractLineDrawing extends AbstractDrawing {
    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points=CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        this.draw(p1, p2, canvas);

        FiguresStorage.addFigure(new Line(this.alg,(int)this.paint.getStrokeWidth(), p1, p2, ToolsStorage.getFirstColor(), ToolsStorage.getSecondColor()));

        CurrentPointsStorage.clear();
    }
    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Line line=(Line)figure;

        PointF p1=line.getFirstPoint();
        PointF p2=line.getSecondPoint();

        this.paint.setStrokeWidth(line.getBrushSize());
        this.paint.setColor(line.getFirstColor().getColor());

        this.draw(p1, p2, canvas);
    }
    protected abstract void draw(PointF p1, PointF p2, Canvas canvas);
}
