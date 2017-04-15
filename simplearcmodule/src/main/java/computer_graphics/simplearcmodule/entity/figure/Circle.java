package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

import computer_graphics.simplearcmodule.entity.color.RGBColor;

public class Circle extends AbstractFigure {
    private PointF center;
    private float R;

    public Circle(int alg, int brushSize, float x, float y, float R, RGBColor firstColor, RGBColor secondColor){
        this.alg=alg;
        this.brushSize=brushSize;

        this.center=new PointF(x,y);
        this.R=R;

        this.firstColor =new RGBColor(firstColor.getRed(), firstColor.getGreen(), firstColor.getBlue());
        this.secondColor =new RGBColor(secondColor.getRed(), secondColor.getGreen(), secondColor.getBlue());
    }

    public PointF getCenter(){
        return this.center;
    }

    public float getR(){
        return this.R;
    }
}
