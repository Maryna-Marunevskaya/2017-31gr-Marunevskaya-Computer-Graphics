package programming.computer_graphics.storage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

import programming.computer_graphics.drawingtools.AbstractDrawing;
import programming.computer_graphics.drawingtools.linealgorithms.ParametricLineDrawing;

public class ToolsStorage {
    private static Paint brush=new Paint();
    private static AbstractDrawing drawing;

    static{
        brush.setColor(Color.BLACK);
        brush.setStrokeWidth(0);
    }
    public static Paint getBrush(){
        return brush;
    }
    public static void setBrushSize(int brushSize){
        brush.setStrokeWidth(brushSize);
    };
    public static AbstractDrawing getDrawing(){
        return drawing;
    }

    public static void createInitDrawing(Context context){
        drawing=new ParametricLineDrawing(context);
        drawing.setCount(2);
    }

    public static void createParametricLineDrawing(Context context){
        drawing=new ParametricLineDrawing(context);
        drawing.setCount(2);
    }
}
