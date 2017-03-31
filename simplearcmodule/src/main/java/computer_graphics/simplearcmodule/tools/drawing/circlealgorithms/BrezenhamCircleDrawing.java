package computer_graphics.simplearcmodule.tools.drawing.circlealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Circle;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

import static java.lang.Math.sqrt;

public class BrezenhamCircleDrawing extends AbstractDrawing {
    public BrezenhamCircleDrawing(){
        this.count=2;
    }

    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points=CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        float R=(float)sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));

        this.draw(p1, R, canvas);

        FiguresStorage.addFigure(new Circle(4, p1.x, p1.y, R));
        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Circle circle=(Circle)figure;

        PointF center=circle.getCenter();

        float R=circle.getR();

        this.draw(center, R, canvas);
    }

    private void draw(PointF center, float R, Canvas canvas){
        float x=0, y=R, f=1-R;

        canvas.drawPoint(center.x, center.y+R, this.paint);
        canvas.drawPoint(center.x, center.y-R, this.paint);
        canvas.drawPoint(center.x+R, center.y, this.paint);
        canvas.drawPoint(center.x-R, center.y, this.paint);

        while(x<=y){
            if(f>0){
                y-=1;
                f+=2*(x-y)+5;
            }
            else{
                f+=2*x+3;
            }
            x+=1;
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
}
