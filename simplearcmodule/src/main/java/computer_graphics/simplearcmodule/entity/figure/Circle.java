package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

public class Circle extends AbstractFigure {
    private PointF center;
    private float R;

    public Circle(int alg, float x, float y, float R){
        this.alg=alg;
        this.center=new PointF(x,y);
        this.R=R;
    }

    public PointF getCenter(){
        return this.center;
    }

    public float getR(){
        return this.R;
    }
}
