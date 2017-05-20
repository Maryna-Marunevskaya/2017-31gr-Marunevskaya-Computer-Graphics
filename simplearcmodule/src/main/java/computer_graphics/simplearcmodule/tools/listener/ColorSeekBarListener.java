package computer_graphics.simplearcmodule.tools.listener;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ColorSeekBarListener implements SeekBar.OnSeekBarChangeListener {
    private ImageView view;
    private SeekBar red, green, blue;

    public ColorSeekBarListener(ImageView view, SeekBar red, SeekBar green, SeekBar blue){
        this.view=view;
        this.red=red;
        this.green=green;
        this.blue=blue;
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.changeColor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.changeColor();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.changeColor();
    }

    private void changeColor(){
        this.view.setColorFilter(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
    }
}
