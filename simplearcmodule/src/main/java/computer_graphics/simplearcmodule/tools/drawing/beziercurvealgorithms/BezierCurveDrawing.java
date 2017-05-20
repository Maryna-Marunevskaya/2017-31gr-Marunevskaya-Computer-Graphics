package computer_graphics.simplearcmodule.tools.drawing.beziercurvealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.BezierCurve;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

import static java.lang.Math.abs;

public class BezierCurveDrawing extends AbstractDrawing {
    public BezierCurveDrawing(){
        this.count=3;
        this.alg=5;
    }

    public void setCount(int count){
        this.count=count;
    }

    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points= CurrentPointsStorage.getPoints();

        this.draw(points, canvas);

        FiguresStorage.addFigure(new BezierCurve(5, (int)this.paint.getStrokeWidth(), points, ToolsStorage.getFirstColor(), ToolsStorage.getSecondColor()));
        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        BezierCurve bezierCurve=(BezierCurve)figure;

        List<PointF> points=bezierCurve.getPoints();

        this.setCount(points.size());
        this.paint.setStrokeWidth((int)bezierCurve.getBrushSize());
        this.paint.setColor(bezierCurve.getFirstColor().getColor());

        this.draw(points, canvas);
    }

    private void draw(List<PointF> points, Canvas canvas){
        PointF arr[] = new PointF[this.count];
        PointF savepoint = new PointF(points.get(0).x, points.get(0).y);

        for (float t = 0; t <= 1; t += 0.01) {
            for (int i = 0; i < this.count; i++) {
                arr[i] = new PointF(points.get(i).x, points.get(i).y);
            }
            for (int j = this.count - 2; j >= 0; j--) {
                for (int i = 0; i <= j; i++) {
                    arr[i].x = arr[i].x + t * (arr[i + 1].x - arr[i].x);
                    arr[i].y = arr[i].y + t * (arr[i + 1].y - arr[i].y);
                }
            }
            this.draw(savepoint, arr[0].x, arr[0].y, canvas);
            savepoint.x=arr[0].x;
            savepoint.y=arr[0].y;
        }
    }

    private void draw(PointF p1, float x2, float y2, Canvas canvas){
        float absx=abs(x2-p1.x);
        float absy=abs(y2-p1.y);
        float lineLength=absx;

        if(absy>absx){
            lineLength=absy;
        }

        float dx=(x2-p1.x)/lineLength;
        float dy=(y2-p1.y)/lineLength;

        float x=p1.x,y=p1.y;

        int ilineLength1=(int)lineLength;

        for(int i=0; i<=ilineLength1;i++){
            canvas.drawPoint(Math.round(x), Math.round(y), this.paint);
            x+=dx;
            y+=dy;
        }
    }
}
