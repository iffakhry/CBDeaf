package net.crevion.fakhry.cbdeaf;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Locale;

public class PerkenalanActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    GridView perkenalanGridView;
    private TextToSpeech tts;

    String[] gridViewString = {
            "Siapa nama anda?",
            "Senang berkenalan dengan anda",
            "Anda tinggal dimana?"
    } ;

    int[] gridViewImageId = {
            R.drawable.speaker2,
            R.drawable.speaker2,
            R.drawable.speaker2
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perkenalan);

        tts = new TextToSpeech(this, this);

        PerkenalanGridAdapter perkenalanGridAdapter = new PerkenalanGridAdapter(PerkenalanActivity.this, gridViewString, gridViewImageId);
        perkenalanGridView = (GridView) findViewById(R.id.perkenalan_gridview);
        perkenalanGridView.setAdapter(perkenalanGridAdapter);

        perkenalanGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @TargetApi(Build.VERSION_CODES.LOLLIPOP)
             @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 speakOut(gridViewString[position]);
                 Toast.makeText(PerkenalanActivity.this, "" + gridViewString[position], Toast.LENGTH_SHORT).show();
             }
         }
        );
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
