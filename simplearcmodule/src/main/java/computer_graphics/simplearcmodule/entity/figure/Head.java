package computer_graphics.simplearcmodule.entity.figure;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class Head {
    private List<PointF> v;
    private List<ArrayList<Integer>> f;

    public Head(List<PointF> v, List<ArrayList<Integer>> f){
        this.v=v;
        this.f=f;
    }

    public List<PointF> getV(){
        return this.v;
    }

    public List<ArrayList<Integer>> getF(){
        return this.f;
    }
}
