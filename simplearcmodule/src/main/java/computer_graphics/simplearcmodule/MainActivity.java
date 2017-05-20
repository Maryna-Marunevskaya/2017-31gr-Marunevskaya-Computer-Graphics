package computer_graphics.simplearcmodule;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import computer_graphics.simplearcmodule.storage.CurrentPointsStorage;
import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.HeadStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.storage.ViewStorage;
import computer_graphics.simplearcmodule.tools.listener.ColorSeekBarListener;
import computer_graphics.simplearcmodule.tools.testalgorithms.TestAlgorithms;
import computer_graphics.simplearcmodule.tools.listener.TouchListener;
import computer_graphics.simplearcmodule.tools.view.BasicView;

public class MainActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BasicView bv=new BasicView(this);
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.layout);
        rl.addView(bv);
        TouchListener tl=new TouchListener();
        bv.setOnTouchListener(tl);
        ViewStorage.setBasicView(bv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ((MenuItem)menu.findItem(R.id.two_color)).setEnabled(false);
        ((MenuItem)menu.findItem(R.id.test_algorithms)).setEnabled(false);
        ((MenuItem)menu.findItem(R.id.parametric_draw_head)).setEnabled(false);
        ((MenuItem)menu.findItem(R.id.brezenham_draw_head)).setEnabled(false);
        this.menu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.parametric_line_alg:
            {
                ToolsStorage.setCurrentAlgorithm(1);
                break;
            }
            case R.id.brezenham_line_alg:
            {
                ToolsStorage.setCurrentAlgorithm(2);
                break;
            }
            case R.id.parametric_circle_alg:
            {
                ToolsStorage.setCurrentAlgorithm(3);
                break;
            }
            case R.id.brezenham_circle_alg:
            {
                ToolsStorage.setCurrentAlgorithm(4);
                break;
            }
            case R.id.bezier_curve_alg_menu: {
                ToolsStorage.setCurrentAlgorithm(5);
                LayoutInflater inflater =(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout=inflater.inflate(R.layout.number_for_bezier_curve_dialog, (ViewGroup)findViewById(R.id.number_for_bezier_curve_dialog));
                final AlertDialog.Builder builder=new AlertDialog.Builder(this).setView(layout);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                final EditText number=(EditText)layout.findViewById(R.id.number_for_bezier_curve_edit_text);
                Button okButton = (Button)layout.findViewById(R.id.ok_number_for_bezier_curve_button);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            ToolsStorage.setBezierCurveCount(Integer.parseInt(String.valueOf(number.getText())));
                        } catch(Exception e){};
                        alertDialog.cancel();
                    }
                });
                break;
            }

            case R.id.load_head_file: {
                HeadStorage.read("simplearcmodule", "african_head.obj");
                if(HeadStorage.getHead()!=null){
                    this.menu.findItem(R.id.test_algorithms).setEnabled(true);
                    this.menu.findItem(R.id.parametric_draw_head).setEnabled(true);
                    this.menu.findItem(R.id.brezenham_draw_head).setEnabled(true);
                }
                else{
                    this.menu.findItem(R.id.test_algorithms).setEnabled(false);
                    this.menu.findItem(R.id.parametric_draw_head).setEnabled(false);
                    this.menu.findItem(R.id.brezenham_draw_head).setEnabled(false);
                }
                break;
            }
            case R.id.test_algorithms:{
                TestAlgorithms.test(getApplicationContext());
                break;
            }
            case R.id.parametric_draw_head:{
                ToolsStorage.setCurrentAlgorithm(6);
                FiguresStorage.clear();
                ViewStorage.getBasicView().invalidate();
                break;
            }
            case R.id.brezenham_draw_head:{
                ToolsStorage.setCurrentAlgorithm(7);
                FiguresStorage.clear();
                ViewStorage.getBasicView().invalidate();
                break;
            }
            case R.id.brush_size:{
                LayoutInflater inflater =(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout=inflater.inflate(R.layout.brush_size_dialog, (ViewGroup)findViewById(R.id.brush_size_dialog));
                final AlertDialog.Builder brushSizeBuilder=new AlertDialog.Builder(this).setView(layout);
                final AlertDialog brushSizeAlertDialog=brushSizeBuilder.create();
                brushSizeAlertDialog.show();
                final EditText brushSize=(EditText)layout.findViewById(R.id.brush_size_edit_text);
                Button okButton = (Button)layout.findViewById(R.id.ok_brush_size_button);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            ToolsStorage.setBrushSize(Integer.parseInt(String.valueOf(brushSize.getText())));
                        } catch(Exception e){};
                        brushSizeAlertDialog.cancel();
                    }
                });
                break;
            }
            case R.id.use_two_color:
            {
                item.setChecked(!item.isChecked());
                this.menu.findItem(R.id.one_color).setEnabled(!item.isChecked());
                this.menu.findItem(R.id.two_color).setEnabled(item.isChecked());
                if(!item.isChecked()){
                    ToolsStorage.setOneColorMode();
                }
                break;
            }
            case R.id.one_color:{
                LayoutInflater inflater =(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout=inflater.inflate(R.layout.one_color_dialog, (ViewGroup)findViewById(R.id.one_color_dialog));
                final AlertDialog.Builder oneColorBuilder=new AlertDialog.Builder(this).setView(layout);
                final AlertDialog oneColorAlertDialog=oneColorBuilder.create();
                oneColorAlertDialog.show();
                final ImageView oneColorView=(ImageView)layout.findViewById(R.id.one_color_view);
                final SeekBar oneRedColor=(SeekBar)layout.findViewById(R.id.one_red_seekbar);
                final SeekBar oneGreenColor=(SeekBar)layout.findViewById(R.id.one_green_seekbar);
                final SeekBar oneBlueColor=(SeekBar)layout.findViewById(R.id.one_blue_seekbar);

                ColorSeekBarListener csbl=new ColorSeekBarListener(oneColorView, oneRedColor, oneGreenColor, oneBlueColor);

                oneRedColor.setOnSeekBarChangeListener(csbl);
                oneGreenColor.setOnSeekBarChangeListener(csbl);
                oneBlueColor.setOnSeekBarChangeListener(csbl);

                Button okButton = (Button)layout.findViewById(R.id.ok_one_color_button);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            ToolsStorage.setFirstColor(oneRedColor.getProgress(), oneGreenColor.getProgress(), oneBlueColor.getProgress());
                            ToolsStorage.setSecondColor(oneRedColor.getProgress(), oneGreenColor.getProgress(), oneBlueColor.getProgress());
                        } catch(Exception e){};
                        oneColorAlertDialog.cancel();
                    }
                });
                break;
            }
            case R.id.clear:
            {
                FiguresStorage.clear();
                break;
            }
            case R.id.clear_current:
            {
                CurrentPointsStorage.clear();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
