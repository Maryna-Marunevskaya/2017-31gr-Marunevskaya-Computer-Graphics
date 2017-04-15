package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Circle;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;

import static java.lang.Math.sqrt;

public class ParametricCircleDrawing extends AbstractCircleDrawing {
    public ParametricCircleDrawing(){
        this.count=2;
    }

    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points= CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        float R=(float)sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));

        this.draw(p1, R, canvas);

        FiguresStorage.addFigure(new Circle(3,(int)this.paint.getStrokeWidth(), p1.x, p1.y, R, ToolsStorage.getFirstColor(), ToolsStorage.getSecondColor()));
        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Circle circle=(Circle)figure;

        PointF center=circle.getCenter();

        float R=circle.getR();

        this.paint.setStrokeWidth(circle.getBrushSize());

        this.draw(center, R, canvas);
    }

    private void draw(PointF center, float R, Canvas canvas){
        float sp=(float)(R/sqrt(2.0));

        float x=0, y;

        for(; x<=sp;x++) {
            y = (float) (sqrt(R * R - x * x));
            this.drawPoints(center, x, y, canvas);
        }
    }
}
