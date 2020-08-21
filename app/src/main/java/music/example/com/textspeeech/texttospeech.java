package music.example.com.textspeeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class texttospeech extends AppCompatActivity {
    private TextToSpeech tts;
    private EditText text;
    private SeekBar pitch;
    private SeekBar speed;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeech);
        button=(Button)findViewById(R.id.button2);
        //Android provides TextToSpeech class for this purpose. In order to use this class,
        // you need to instantiate an object of this class and also specify the initListener.
        tts =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        button.setEnabled(true);
                    }
                }else{
                    Log.e("TTS","INITIALIZATION FAILED");

                    }
                }



        });
        text=findViewById(R.id.editText);
        pitch=findViewById(R.id.seekBar);
        speed=findViewById(R.id.seekBar2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();

            }
        });

    }public void speak(){
        String text1=text.getText().toString();
        float pitch1=(float)pitch.getProgress()/50;
        if(pitch1<0.1)pitch1 = 0.1f;
        float speed1=(float) speed.getProgress()/50;
        if(speed1<0.1) pitch1=0.1f;
        tts.setPitch(pitch1);
        tts.setPitch(speed1);
        tts.speak(text1,TextToSpeech.QUEUE_FLUSH,null);


    }

    @Override
    protected void onDestroy() {
        if(tts!=null){
            tts.stop();

            tts.shutdown();
        }
        super.onDestroy();
    }
}
