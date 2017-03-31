package computer_graphics.simplearcmodule.storage;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;

public class FiguresStorage {
    private static List<AbstractFigure> figures=new ArrayList<AbstractFigure>();

    public static void addFigure(AbstractFigure figure){
        figures.add(figure);
    }

    public static List<AbstractFigure> getFigures(){
        return figures;
    }

    public static void clear(){
        figures.clear();
        CurrentPointsStorage.clear();
        ViewStorage.getBasicView().invalidate();
    }
}
