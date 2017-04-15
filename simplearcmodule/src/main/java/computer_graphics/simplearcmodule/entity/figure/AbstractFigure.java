package computer_graphics.simplearcmodule.entity.figure;

import computer_graphics.simplearcmodule.entity.color.RGBColor;

public class AbstractFigure {
    protected int alg, brushSize;

    protected RGBColor firstColor, secondColor;

    public int getAlg(){
        return this.alg;
    }

    public int getBrushSize(){
        return this.brushSize;
    }

    public RGBColor getFirstColor(){
        return this.firstColor;
    }

    public RGBColor getSecondColor(){
        return this.secondColor;
    }
}
