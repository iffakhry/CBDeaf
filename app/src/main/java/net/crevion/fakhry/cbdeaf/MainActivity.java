package net.crevion.fakhry.cbdeaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btSalam, btPerkenalan, btTolong, btMenulis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSalam = (Button) findViewById(R.id.btSalam);
        btPerkenalan = (Button) findViewById(R.id.btPerkenalan);
        btTolong = (Button) findViewById(R.id.btTolong);
        btMenulis = (Button) findViewById(R.id.btMenulis);

//        btSalam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent salamIntent = new Intent(view.getContext(), SalamActivity.class);
//                startActivity(salamIntent);
//            }
//        });
//
//        btPerkenalan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent perkenalanIntent = new Intent(view.getContext(), PerkenalanActivity.class);
//                startActivity(perkenalanIntent);
//            }
//        });
//
//        btTolong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent tolongIntent = new Intent(view.getContext(), TolongActivity.class);
//                startActivity(tolongIntent);
//            }
//        });
//
//        btMenulis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent menulisIntent = new Intent(view.getContext(), MenulisActivity.class);
//                startActivity(menulisIntent);
//            }
//        });
    }
}
