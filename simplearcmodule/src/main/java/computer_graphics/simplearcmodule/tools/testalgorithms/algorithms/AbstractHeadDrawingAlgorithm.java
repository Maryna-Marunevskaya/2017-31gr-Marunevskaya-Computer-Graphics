package computer_graphics.simplearcmodule.tools.testalgorithms.algorithms;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHeadDrawingAlgorithm {
    public void drawHead(List<PointF> v, List<ArrayList<Integer>> f, float min){
        for(ArrayList l: f){
            for(int i=0; i<3; i++){
                PointF p1=v.get((int)l.get(i));
                PointF p2=v.get((int)l.get((i+1)%3));
                float x1 = (float)((p1.x+1.0)*min/2.0);
                float y1 = (float)(1.5*min-(p1.y+1.0)*min/2.0);
                float x2 = (float)((p2.x+1.0)*min/2.0);
                float y2 = (float)(1.5*min-(p2.y+1.0)*min/2.0);
                this.draw(x1, y1, x2, y2);
            }
        }
    }
    protected abstract void draw(float x1, float y1, float x2, float y2);
}
