package net.crevion.fakhry.cbdeaf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SalamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salam);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new SalamGridAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SalamActivity.this, "" + position, Toast.LENGTH_SHORT).show();

            }
        }
        );

    }
}
