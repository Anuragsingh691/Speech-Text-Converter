package music.example.com.textspeeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button5=(Button)findViewById(R.id.button3);
        button5.setOnClickListener(this);
        button6=(Button)findViewById(R.id.button4);
        button6.setOnClickListener(this);
    }
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button3:
                Intent myIntent1 = new Intent(this, texttospeech.class);
                startActivity(myIntent1);
                // do your code
                break;

            case R.id.button4:
                Intent myIntent2 = new Intent(this, speechtotext.class);
                startActivity(myIntent2);
                // do your code
                break;


            default:
                break;
        }

        // default method for handling onClick Events..

    }
}
