package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

import computer_graphics.simplearcmodule.entity.color.RGBColor;

public class Line extends AbstractFigure{
    private PointF firstPoint, secondPoint;

    public Line(int alg, int brushSize, PointF firstPoint, PointF secondPoint, RGBColor firstColor, RGBColor secondColor){
        this.alg=alg;
        this.brushSize=brushSize;

        this.firstPoint =new PointF(firstPoint.x, firstPoint.y);
        this.secondPoint =new PointF(secondPoint.x, secondPoint.y);

        this.firstColor=new RGBColor(firstColor.getRed(), firstColor.getGreen(), firstColor.getBlue());
        this.secondColor=new RGBColor(secondColor.getRed(), secondColor.getGreen(), secondColor.getBlue());
    }

    public PointF getFirstPoint(){
        return this.firstPoint;
    }

    public PointF getSecondPoint(){
        return this.secondPoint;
    }
}
