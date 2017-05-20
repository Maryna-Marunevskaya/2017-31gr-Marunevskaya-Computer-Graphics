package computer_graphics.simplearcmodule.storage;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.color.RGBColor;
import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.entity.figure.Circle;
import computer_graphics.simplearcmodule.entity.figure.Line;

public class FiguresStorage {
    private static List<AbstractFigure> figures=new ArrayList<AbstractFigure>();

    static{
        addFigure(new Line(2,0, new PointF(500,150), new PointF(1000,1600), new RGBColor(255,0,0), new RGBColor(0,0,0)));
        addFigure(new Line(1,0, new PointF(500,150), new PointF(1000,1600), new RGBColor(0,255,0), new RGBColor(255,0,0)));

        addFigure(new Circle(3, 0, new PointF(750, 750), 150, new RGBColor(255,0,0), new RGBColor(0,0,0)));
        addFigure(new Circle(4, 0, new PointF(750, 750), 150, new RGBColor(0,255,0), new RGBColor(255,0,0)));

        addFigure(new Circle(4, 0, new PointF(950, 950), 150, new RGBColor(0,255,0), new RGBColor(255,0,0)));
        addFigure(new Circle(3, 0, new PointF(950, 950), 150, new RGBColor(255,0,0), new RGBColor(0,0,0)));

        addFigure(new Circle(3, 0, new PointF(300, 1000), 150, new RGBColor(255,0,0), new RGBColor(0,0,0)));
        addFigure(new Circle(4, 0, new PointF(300, 1000), 150, new RGBColor(0,255,0), new RGBColor(255,0,0)));

        addFigure(new Circle(4, 0, new PointF(500, 500), 150, new RGBColor(0,255,0), new RGBColor(255,0,0)));
        addFigure(new Circle(3, 0, new PointF(500, 500), 150, new RGBColor(255,0,0), new RGBColor(0,0,0)));

    }

    public static void addFigure(AbstractFigure figure){
        figures.add(figure);
    }

    public static List<AbstractFigure> getFigures(){
        return figures;
    }

    public static void clear(){
        figures.clear();
        ViewStorage.getBasicView().invalidate();
    }
}
