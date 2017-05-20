package programming.computer_graphics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button alg;
    Button alg1;
    Button alg2;
    Button alg3;
    Button alg4;
    Button alg5;
    Button cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alg=(Button)findViewById(R.id.button);
        alg1=(Button)findViewById(R.id.button1);
        alg2=(Button)findViewById(R.id.button2);
        alg3=(Button)findViewById(R.id.button3);
        alg4=(Button)findViewById(R.id.button4);
        alg5=(Button)findViewById(R.id.button5);
        cr=(Button)findViewById(R.id.cr);
        alg.setOnClickListener(this);
        alg1.setOnClickListener(this);
        alg2.setOnClickListener(this);
        alg3.setOnClickListener(this);
        alg4.setOnClickListener(this);
        alg5.setOnClickListener(this);
        cr.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cr:
                Intent intentC = new Intent(this, Cr.class);
                startActivity(intentC);
                break;
            case R.id.button:
                Intent intent = new Intent(this, ActivityForAlg.class);
                startActivity(intent);
                break;
            case R.id.button1:
                Intent intent1 = new Intent(this, ActivityForAlg1.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, ActivityForAlg2.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, ActivityForAlg3.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(this, ActivityForAlg4.class);
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(this, ChoiceActivityForAlg5.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
