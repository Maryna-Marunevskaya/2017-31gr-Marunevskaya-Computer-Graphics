package computer_graphics.simplearcmodule.tools.drawing.beziercurvealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.BezierCurve;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

public class BezierCurveDrawing extends AbstractDrawing {
    public BezierCurveDrawing(){
        this.count=3;
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
        this.draw(points, canvas);
    }

    private void draw(List<PointF> points, Canvas canvas){
        PointF arr[]=new PointF[this.count];

        for(float t=0; t<=1; t+=0.00001){

            for(int i=0; i<this.count; i++){
                arr[i]=new PointF(points.get(i).x, points.get(i).y);
            }
            for(int j=this.count-2; j>=0;j--){
                for(int i=0; i<=j; i++){
                    arr[i].x=arr[i].x+t*(arr[i+1].x-arr[i].x);
                    arr[i].y=arr[i].y+t*(arr[i+1].y-arr[i].y);
                }
            }
            canvas.drawPoint(arr[0].x,arr[0].y,this.paint);
        }
    }
}
