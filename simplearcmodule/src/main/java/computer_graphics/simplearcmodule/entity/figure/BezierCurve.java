package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.color.RGBColor;

public class BezierCurve extends AbstractFigure {
    private List<PointF> points;
    public BezierCurve(int alg, int brushSize, List<PointF> points, RGBColor firstColor, RGBColor secondColor){
        this.alg=alg;
        this.brushSize=brushSize;

        this.points=new ArrayList<PointF>();

        for(PointF point: points) {
            this.points.add(new PointF(point.x, point.y));
        }

        this.firstColor=new RGBColor(firstColor.getRed(), firstColor.getGreen(), firstColor.getBlue());
        this.secondColor=new RGBColor(secondColor.getRed(), secondColor.getGreen(), secondColor.getBlue());
    }

    public List<PointF> getPoints(){
        return this.points;
    }
}
