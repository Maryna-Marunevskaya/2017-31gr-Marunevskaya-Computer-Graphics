package computer_graphics.simplearcmodule.storage;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class CurrentPointsStorage {

    private static List<PointF> currentPoints = new ArrayList<PointF>();

    public static void addPoint(float x, float y){
        currentPoints.add(new PointF(x,y));
    }

    public static int getCount(){
        return currentPoints.size();
    }

    public static List<PointF> getPoints(){
        return currentPoints;
    }

    public static void clear(){
        currentPoints.clear();
    }
}
