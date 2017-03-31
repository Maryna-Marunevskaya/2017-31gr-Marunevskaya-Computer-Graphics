package computer_graphics.simplearcmodule.tools.drawing.linealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Line;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class BrezenhamLineDrawing extends AbstractDrawing {
    public BrezenhamLineDrawing(){
        this.count=2;
    }

    @Override
    public void drawAlg(Canvas canvas){
        List<PointF> points= CurrentPointsStorage.getPoints();

        PointF p1=points.get(0);
        PointF p2=points.get(1);

        this.draw(p1, p2, canvas);

        FiguresStorage.addFigure(new Line(2, p1.x, p1.y, p2.x, p2.y));

        CurrentPointsStorage.clear();
    }

    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
        Line line=(Line)figure;

        PointF p1=line.getP1();
        PointF p2=line.getP2();

        this.draw(p1, p2, canvas);
    }

    private void draw(PointF p1, PointF p2, Canvas canvas){
        float x=p1.x;
        float y=p1.y;

        float dx=abs(p2.x-p1.x);
        float dy=abs(p2.y-p1.y);
        float s1=signum(p2.x-p1.x);
        float s2=signum(p2.y-p1.y);
        boolean change=false;

        if(dy>dx){
            change=true;
            float temp=dx;
            dx=dy;
            dy=temp;
        }

        float sf=2*dy-dx;
        float sf1=2*dy;
        float sf2=2*dx;

        for(float i=1; i<=dx;i++){
            canvas.drawPoint(x, y, this.paint);
            while(sf>=0){
                if(change){
                    x+=s1;
                }
                else{
                    y+=s2;
                }
                sf-=sf2;
            }
            if(change){
                y+=s2;
            }
            else{
                x+=s1;
            }
            sf+=sf1;
        }
    }
}
