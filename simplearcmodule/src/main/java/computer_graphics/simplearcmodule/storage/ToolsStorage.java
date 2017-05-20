package computer_graphics.simplearcmodule.storage;

import android.graphics.Paint;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import computer_graphics.simplearcmodule.entity.color.RGBColor;
import computer_graphics.simplearcmodule.tools.drawing.AbstractDrawing;
import computer_graphics.simplearcmodule.tools.drawing.beziercurvealgorithms.BezierCurveDrawing;
import computer_graphics.simplearcmodule.tools.drawing.circlealgorithms.BrezenhamCircleDrawing;
import computer_graphics.simplearcmodule.tools.drawing.circlealgorithms.ParametricCircleDrawing;
import computer_graphics.simplearcmodule.tools.drawing.headalgorithms.BrezenhamHeadDrawing;
import computer_graphics.simplearcmodule.tools.drawing.headalgorithms.ParametricHeadDrawing;
import computer_graphics.simplearcmodule.tools.drawing.linealgorithms.BrezenhamLineDrawing;
import computer_graphics.simplearcmodule.tools.drawing.linealgorithms.ParametricLineDrawing;

public class ToolsStorage {

    private static int currentAlgorithm=1, brushSize=0, bezierCurveCount=3;
    private static Paint brush=new Paint();
    private static RGBColor firstColor =new RGBColor(0, 0, 0), secondColor =new RGBColor(0, 0, 0);
    private static Map<Integer, AbstractDrawing> drawingTools=new HashMap<Integer, AbstractDrawing>();

    static{
        brush.setColor(firstColor.getColor());
        brush.setStrokeWidth(brushSize);

        drawingTools.put(1, new ParametricLineDrawing());
        drawingTools.get(1).setPaint(brush);
        drawingTools.put(2, new BrezenhamLineDrawing());
        drawingTools.get(2).setPaint(brush);
        drawingTools.put(3, new ParametricCircleDrawing());
        drawingTools.get(3).setPaint(brush);
        drawingTools.put(4, new BrezenhamCircleDrawing());
        drawingTools.get(4).setPaint(brush);
        drawingTools.put(5, new BezierCurveDrawing());
        drawingTools.get(5).setPaint(brush);

        drawingTools.put(6, new ParametricHeadDrawing());
        drawingTools.get(6).setPaint(brush);
        drawingTools.put(7, new BrezenhamHeadDrawing());
        drawingTools.get(7).setPaint(brush);
    }

    public static void setCurrentAlgorithm(int ca){
        currentAlgorithm=ca;
        CurrentPointsStorage.clear();
    }

    public static int getBrushSize(){
        return brushSize;
    }

    public static void setBrushSize(int size){
        brushSize=size;
        brush.setStrokeWidth(brushSize);
    }

    public static void returnBrushToCurrentBrushSize(){

        brush.setStrokeWidth(brushSize);
    }

    public static void setBezierCurveCount(int count){
        if(bezierCurveCount<2){
            bezierCurveCount=2;
            Toast.makeText(ViewStorage.getBasicView().getContext(), "Количество точек кривой Безье должно быть >=2", Toast.LENGTH_LONG).show();
        }
        else{
            bezierCurveCount=count;
        }
        ((BezierCurveDrawing)drawingTools.get(5)).setCount(bezierCurveCount);
    }

    public static void returnToCurrentBezierCurveCount(){
        ((BezierCurveDrawing)drawingTools.get(5)).setCount(bezierCurveCount);
    }

    public static void returnToCurrentBrushColor(){
        brush.setColor(firstColor.getColor());
    }

    public static RGBColor getFirstColor(){
        return firstColor;
    }

    public static void setFirstColor(int red, int green, int blue){
        firstColor.setColor(red, green, blue);
        brush.setColor(firstColor.getColor());
    }

    public static RGBColor getSecondColor(){
        return secondColor;
    }

    public static void setSecondColor(int red, int green, int blue){
        secondColor.setColor(red, green, blue);
    }

    public static void setOneColorMode(){
        secondColor.setColor(firstColor.getRed(), firstColor.getGreen(), firstColor.getBlue());
    }

    public static AbstractDrawing getDrawing(){
        return drawingTools.get(currentAlgorithm);
    }

    public static AbstractDrawing getDrawing(int drawing){
        return drawingTools.get(drawing);
    }
}
