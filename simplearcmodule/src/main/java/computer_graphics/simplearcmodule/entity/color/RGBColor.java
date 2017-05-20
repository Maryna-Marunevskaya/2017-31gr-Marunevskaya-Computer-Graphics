package computer_graphics.simplearcmodule.entity.color;

import android.graphics.Color;

public class RGBColor {
    private int red;
    private int green;
    private int blue;

    public RGBColor(int red, int green, int blue){
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue(){
        return this.blue;
    }

    public void setBlue(int blue){
        this.blue=blue;
    }

    public int getColor(){
        return Color.rgb(this.red, this.green, this.blue);
    }

    public void setColor(int red, int green, int blue){
        this.red=red;
        this.green=green;
        this.blue=blue;
    }
}
