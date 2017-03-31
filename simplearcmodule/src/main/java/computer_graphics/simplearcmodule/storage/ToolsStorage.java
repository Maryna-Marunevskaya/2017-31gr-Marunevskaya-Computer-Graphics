package computer_graphics.simplearcmodule.storage;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.HashMap;
import java.util.Map;

import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;
import computer_graphics.simplearcmodule.tools.drawing.circlealgorithms.BrezenhamCircleDrawing;
import computer_graphics.simplearcmodule.tools.drawing.circlealgorithms.ParametricCircleDrawing;
import computer_graphics.simplearcmodule.tools.drawing.linealgorithms.BrezenhamLineDrawing;
import computer_graphics.simplearcmodule.tools.drawing.linealgorithms.ParametricLineDrawing;

public class ToolsStorage {

    private static int currentAlgorithm=1;
    private static Paint brush=new Paint();
    private static Map<Integer, AbstractDrawing> drawingTools=new HashMap<Integer, AbstractDrawing>();

    static{
        brush.setColor(Color.BLACK);
        brush.setStrokeWidth(0);

        drawingTools.put(1, new ParametricLineDrawing());
        drawingTools.get(1).setPaint(brush);
        drawingTools.put(2, new BrezenhamLineDrawing());
        drawingTools.get(2).setPaint(brush);
        drawingTools.put(3, new ParametricCircleDrawing());
        drawingTools.get(3).setPaint(brush);
        drawingTools.put(4, new BrezenhamCircleDrawing());
        drawingTools.get(4).setPaint(brush);
    }

    public static AbstractDrawing getDrawing(){
        return drawingTools.get(currentAlgorithm);
    }

    public static AbstractDrawing getDrawing(int drawing){
        return drawingTools.get(drawing);
    }

    public static void setCurrentAlgorithm(int ca){
        currentAlgorithm=ca;

        CurrentPointsStorage.clear();
    }
}
