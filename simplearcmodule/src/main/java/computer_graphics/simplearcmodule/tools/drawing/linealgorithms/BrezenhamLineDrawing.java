package computer_graphics.simplearcmodule.tools.drawing.linealgorithms;

import android.graphics.Canvas;
import android.graphics.PointF;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class BrezenhamLineDrawing extends AbstractLineDrawing {
    public BrezenhamLineDrawing(){
        this.count=2;
        this.alg=2;
    }
    @Override
    protected void draw(PointF p1, PointF p2, Canvas canvas){
        int x=Math.round(p1.x);
        int y=Math.round(p1.y);

        int dx=Math.round(abs(p2.x-p1.x));
        int dy=Math.round(abs(p2.y-p1.y));
        int s1=Math.round(signum(p2.x-p1.x));
        int s2=Math.round(signum(p2.y-p1.y));
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
