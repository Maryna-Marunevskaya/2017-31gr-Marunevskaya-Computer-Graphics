package computer_graphics.simplearcmodule.tools.drawing.headalgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Head;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.HeadStorage;
import computer_graphics.simplearcmodule.storage.ViewStorage;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;

public abstract class AbstractHeadDrawing extends AbstractDrawing {
    @Override
    public void drawAlg(Canvas canvas){
        Head head= HeadStorage.getHead();

        List<PointF> v=head.getV();
        List<ArrayList<Integer>> f=head.getF();

        float width=canvas.getWidth();
        float height=canvas.getHeight();

        float min=Math.min(width, height);

        long time1=System.currentTimeMillis();

        for(ArrayList l: f){
            for(int i=0; i<3; i++){
                PointF p1=v.get((int)l.get(i));
                PointF p2=v.get((int)l.get((i+1)%3));
                float x1 = (float)((p1.x+1.0)*min/2.0);
                float y1 = (float)(1.5*min-(p1.y+1.0)*min/2.0);
                float x2 = (float)((p2.x+1.0)*min/2.0);
                float y2 = (float)(1.5*min-(p2.y+1.0)*min/2.0);
                this.draw(x1, y1, x2, y2, canvas);
            }
        }

        long time2=System.currentTimeMillis();

        Toast.makeText(ViewStorage.getBasicView().getContext(), "Alg "+Long.toString(time2-time1), Toast.LENGTH_LONG).show();
        CurrentPointsStorage.clear();
    }
    @Override
    public void drawFigure(Canvas canvas, AbstractFigure figure){
    }
    protected abstract void draw(float x1, float y1, float x2, float y2, Canvas canvas);
}
