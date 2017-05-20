package computer_graphics.simplearcmodule.tools.testalgorithms.algorithms;

import static java.lang.Math.abs;

public class ParametricHeadDrawingAlgorithm extends AbstractHeadDrawingAlgorithm {
    @Override
    protected void draw(float x1, float y1, float x2, float y2){
        float absx=abs(x2-x1);
        float absy=abs(y2-y1);
        float spec=absx;

        if(absy>absx){
            spec=absy;
        }

        float dx=(x2-x1)/spec;
        float dy=(y2-y1)/spec;

        float x=x1,y=y1;

        for(int i=0; i<=(int)spec;i++){
            x+=dx;
            y+=dy;
        }
    }
}
