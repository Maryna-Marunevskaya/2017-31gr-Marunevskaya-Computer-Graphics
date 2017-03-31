package computer_graphics.simplearcmodule.tools.touchlistener;

import android.view.MotionEvent;
import android.view.View;

import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.storage.ViewStorage;

public class TouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                CurrentPointsStorage.addPoint(event.getX(),event.getY());
                if(ToolsStorage.getDrawing().getCount()== CurrentPointsStorage.getCount()){
                    ViewStorage.getBasicView().invalidate();
                }
                break;
        }
        return true;
    }
}
