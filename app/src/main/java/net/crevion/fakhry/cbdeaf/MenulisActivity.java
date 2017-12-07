package net.crevion.fakhry.cbdeaf;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MenulisActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener{

    private EditText edittext_input_kalimat;
    private Button btUcap;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulis);

        edittext_input_kalimat = (EditText)findViewById(R.id.edittext_input_kalimat);
        btUcap = (Button) findViewById(R.id.btUcap);

        btUcap.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                String inputKalimat = edittext_input_kalimat.getText().toString();
                speakOut(inputKalimat);
                Toast.makeText(MenulisActivity.this, "" + inputKalimat, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(new Locale("id", "ID"));

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
//                btnSpeak.setEnabled(true);
//                speakOut("Hello");
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(String kalimat) {
        tts.setSpeechRate(1.0f);
        tts.speak(kalimat, TextToSpeech.QUEUE_FLUSH, null,"id1");
    }
}
