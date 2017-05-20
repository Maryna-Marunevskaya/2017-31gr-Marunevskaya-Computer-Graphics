package computer_graphics.simplearcmodule.tools.testalgorithms;

import android.content.Context;
import android.graphics.PointF;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.Head;
import computer_graphics.simplearcmodule.storage.HeadStorage;
import computer_graphics.simplearcmodule.storage.ViewStorage;
import computer_graphics.simplearcmodule.tools.testalgorithms.algorithms.BrezenhamHeadDrawingAlgorithm;
import computer_graphics.simplearcmodule.tools.testalgorithms.algorithms.ParametricHeadDrawingAlgorithm;

public class TestAlgorithms {
    public static void test(Context context){
        Head head= HeadStorage.getHead();
        List<PointF> v=head.getV();
        List<ArrayList<Integer>> f=head.getF();

        float width= ViewStorage.getBasicView().getWidth();
        float height=ViewStorage.getBasicView().getHeight();
        float min=Math.min(width, height);

        ParametricHeadDrawingAlgorithm phda=new ParametricHeadDrawingAlgorithm();
        BrezenhamHeadDrawingAlgorithm bhda=new BrezenhamHeadDrawingAlgorithm();

        long time1=System.currentTimeMillis();
        bhda.drawHead(v,f,min);
        long time2=System.currentTimeMillis();

        Toast.makeText(context, "B "+Long.toString(time2-time1), Toast.LENGTH_LONG).show();

        time1=System.currentTimeMillis();
        phda.drawHead(v,f,min);
        time2=System.currentTimeMillis();

        Toast.makeText(context, "P "+Long.toString(time2-time1), Toast.LENGTH_LONG).show();
    }
}
