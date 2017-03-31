package programming.computer_graphics.drawingtools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import programming.computer_graphics.storage.ToolsStorage;
public abstract class AbstractDrawing extends View {
    protected int count, counter;
    protected List<PointF> points;
    public AbstractDrawing(Context context) {
        super(context);
    }
    public void setCount(int count){
        this.count=count;
        this.counter=0;
        this.points=new ArrayList<>();
    }
    public void addPoint(float x, float y){
        this.points.add(new PointF(x,y));
        this.counter+=1;
        if(this.counter==this.count){
            this.invalidate();
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        if(this.counter==this.count){
            drawAlg(ToolsStorage.getBrush(),canvas);
        }
    }
    protected abstract void drawAlg(Paint paint, Canvas canvas);
}
