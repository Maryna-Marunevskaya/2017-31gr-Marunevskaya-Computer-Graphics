package computer_graphics.simplearcmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import computer_graphics.simplearcmodule.storage.FiguresStorage;
import computer_graphics.simplearcmodule.storage.ToolsStorage;
import computer_graphics.simplearcmodule.storage.ViewStorage;
import computer_graphics.simplearcmodule.tools.touchlistener.TouchListener;
import computer_graphics.simplearcmodule.tools.view.BasicView;

public class MainActivity extends AppCompatActivity {

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
                Toast.makeText(this, "Parametric Line", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.brezenham_line_alg:
            {
                ToolsStorage.setCurrentAlgorithm(2);
                Toast.makeText(this, "Brezenham Line", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.parametric_circle_alg:
            {
                ToolsStorage.setCurrentAlgorithm(3);
                Toast.makeText(this, "Parametric Circle", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.brezenham_circle_alg:
            {
                ToolsStorage.setCurrentAlgorithm(4);
                Toast.makeText(this, "Brezenham Circle", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.clear:
            {
                FiguresStorage.clear();
                Toast.makeText(this, "Clear", Toast.LENGTH_LONG).show();
                break;
            }
        }

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
