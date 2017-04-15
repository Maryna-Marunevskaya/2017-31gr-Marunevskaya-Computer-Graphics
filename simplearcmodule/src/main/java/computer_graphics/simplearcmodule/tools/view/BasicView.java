package computer_graphics.simplearcmodule.tools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.AbstractFigure;
import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;

public class BasicView extends View {
    public BasicView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        List<AbstractFigure> figures=FiguresStorage.getFigures();

        for(AbstractFigure figure: figures){
            ToolsStorage.getDrawing(figure.getAlg()).drawFigure(canvas, figure);
        }

        ToolsStorage.returnBrushToBrushSize();
        ToolsStorage.returnToBezierCurveCount();

        if(ToolsStorage.getDrawing().getCount()== CurrentPointsStorage.getCount()){
            ToolsStorage.getDrawing().drawAlg(canvas);
        }
    }
}
