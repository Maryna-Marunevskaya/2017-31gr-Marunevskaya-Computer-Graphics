package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

public class Line extends AbstractFigure{
    private PointF p1, p2;

    public Line(int alg, float x1, float y1, float x2, float y2){
        this.alg=alg;
        this.p1=new PointF(x1,y1);
        this.p2=new PointF(x2,y2);
    }

    public PointF getP1(){
        return this.p1;
    }

    public PointF getP2(){
        return this.p2;
    }
}
