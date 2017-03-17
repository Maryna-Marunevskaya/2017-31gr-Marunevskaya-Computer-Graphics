package programming.computer_graphics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ChoiceActivityForAlg5 extends AppCompatActivity implements View.OnClickListener{
    Button algf5;
    SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_for_alg5);
        algf5=(Button)findViewById(R.id.buttonf5);
        algf5.setOnClickListener(this);
        sb=(SeekBar)findViewById(R.id.seekBar);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonf5:
                int num=sb.getProgress();
                if(num>=2) {
                    Intent intent = new Intent(this, ActivityForAlg5.class);
                    intent.putExtra("num", num);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
