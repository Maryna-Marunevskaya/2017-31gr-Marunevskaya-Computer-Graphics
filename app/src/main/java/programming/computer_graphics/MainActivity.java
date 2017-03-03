package programming.computer_graphics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button alg1;
    Button alg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alg1=(Button)findViewById(R.id.button1);
        alg2=(Button)findViewById(R.id.button2);
        alg1.setOnClickListener(this);
        alg2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(this, ActivityForAlg1.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, ActivityForAlg2.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
