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

import static java.lang.Math.abs;

public class ParametricLineDrawing extends AbstractDrawing {
    public ParametricLineDrawing(){
        this.count=2;
    }

    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points=CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        this.draw(p1, p2, canvas);

        FiguresStorage.addFigure(new Line(1,(int)this.paint.getStrokeWidth(), p1.x, p1.y, p2.x, p2.y, ToolsStorage.getFirstColor(), ToolsStorage.getSecondColor()));

        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Line line=(Line)figure;

        PointF p1=line.getFirstPoint();
        PointF p2=line.getSecondPoint();

        this.paint.setStrokeWidth(line.getBrushSize());

        this.draw(p1, p2, canvas);
    }

    private void draw(PointF p1, PointF p2, Canvas canvas){
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
            canvas.drawPoint(x, y, this.paint);
            x+=dx;
            y+=dy;
        }
    }
}