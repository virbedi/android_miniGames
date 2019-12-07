package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;



public class ScoreActivity extends AppCompatActivity {

    TextView P1Name = findViewById(R.id.textView1_1);
    TextView P1Score = findViewById(R.id.textView1_2);

    TextView P2Name = findViewById(R.id.textView2_1);
    TextView P2Score = findViewById(R.id.textView2_2);


    TextView P3Name = findViewById(R.id.textView3_1);
    TextView P3Score = findViewById(R.id.textView3_2);


    TextView P4Name = findViewById(R.id.textView4_1);
    TextView P4Score = findViewById(R.id.textView4_2);


    TextView P5Name = findViewById(R.id.textView5_1);
    TextView P5Score = findViewById(R.id.textView5_2);

    TextView P6Name = findViewById(R.id.textView6_1);
    TextView P6Score = findViewById(R.id.textView6_2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
