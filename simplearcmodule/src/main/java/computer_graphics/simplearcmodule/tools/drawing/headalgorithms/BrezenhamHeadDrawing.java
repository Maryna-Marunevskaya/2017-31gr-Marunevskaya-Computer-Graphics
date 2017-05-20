package computer_graphics.simplearcmodule.tools.drawing.headalgorithms;

import android.graphics.Canvas;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class BrezenhamHeadDrawing extends AbstractHeadDrawing {
    public BrezenhamHeadDrawing(){
        this.count=0;
        this.alg=7;
    }
    @Override
    protected void draw(float x1, float y1, float x2, float y2, Canvas canvas){
        int x=Math.round(x1);
        int y=Math.round(y1);

        int dx=Math.round(abs(x2-x1));
        int dy=Math.round(abs(y2-y1));
        int s1=Math.round(signum(x2-x1));
        int s2=Math.round(signum(y2-y1));
        boolean change=false;

        if(dy>dx){
            change=true;
            int temp=dx;
            dx=dy;
            dy=temp;
        }

        int sf=2*dy-dx;
        int sf1=2*dy;
        int sf2=2*dx;

        for(int i=1; i<=dx;i++){
            canvas.drawPoint(x, y, this.paint);
            while(sf>=0){
                if(change){
                    x+=s1;
                }
                else{
                    y+=s2;
                }
                sf-=sf2;
            }
            if(change){
                y+=s2;
            }
            else{
                x+=s1;
            }
            sf+=sf1;
        }
    }
}
