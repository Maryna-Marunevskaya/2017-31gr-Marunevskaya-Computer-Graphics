package programming.computer_graphics;

import android.graphics.PointF;

public class Figure {
    private PointF p1, p2;
    public Figure(PointF p1, PointF p2){
        this.p1=new PointF(p1.x, p1.y);
        this.p2=new PointF(p2.x, p2.y);
    }

    public PointF getFirstPoint(){
            return new PointF(this.p1.x + (this.p2.x - this.p1.x) / 2, this.p1.y);
    }

    public PointF getSecondPoint(){
            return new PointF(this.p1.x, this.p1.y + (this.p2.y - this.p1.y) / 3);
    }

    public PointF getThirdPoint(){
            return new PointF(this.p1.x + (this.p2.x - this.p1.x) / 3, this.p2.y);
    }

    public PointF getForthPoint(){
            return new PointF(this.p1.x + 2 * (this.p2.x - this.p1.x) / 3, this.p2.y);
    }
    public PointF getFifthPoint(){
            return new PointF(this.p2.x, this.p1.y + (this.p2.y - this.p1.y) / 3);
    }
}
