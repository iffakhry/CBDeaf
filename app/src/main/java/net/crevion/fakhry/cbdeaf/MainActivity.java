package net.crevion.fakhry.cbdeaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btSalam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSalam = (Button) findViewById(R.id.btSalam);

        btSalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salamIntent = new Intent(view.getContext(), SalamActivity.class);
                startActivity(salamIntent);
            }
        });
    }
}
