package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ScoreActivity extends AppCompatActivity {

    TextView P1Name;
    TextView P1Score;

    TextView P2Name;
    TextView P2Score;

    TextView P3Name;
    TextView P3Score;

    TextView P4Name;
    TextView P4Score;

    TextView P5Name;
    TextView P5Score;

    TextView P6Name;
    TextView P6Score;

    ArrayList<PlayerActivity.globalPlayer> playerList = new ArrayList<>();
    int Round;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

         P1Name = findViewById(R.id.textView1_1);
         P1Score = findViewById(R.id.textView1_2);

         P2Name = findViewById(R.id.textView2_1);
         P2Score = findViewById(R.id.textView2_2);


         P3Name = findViewById(R.id.textView3_1);
         P3Score = findViewById(R.id.textView3_2);


         P4Name = findViewById(R.id.textView4_1);
         P4Score = findViewById(R.id.textView4_2);


         P5Name = findViewById(R.id.textView5_1);
         P5Score = findViewById(R.id.textView5_2);

         P6Name = findViewById(R.id.textView6_1);
         P6Score = findViewById(R.id.textView6_2);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);


                startActivity(intent);
            }
        });


        playerList = (ArrayList<PlayerActivity.globalPlayer>)getIntent().getSerializableExtra("playerList");
        Round = getIntent().getIntExtra("Round",0);

        Collections.sort(playerList, new Comparator<PlayerActivity.globalPlayer>() {
            @Override
            public int compare(PlayerActivity.globalPlayer o1, PlayerActivity.globalPlayer o2) {
                return o2.score - o1.score;
            }
        });

        P1Name.setText(playerList.get(0).name);
        P1Score.setText(playerList.get(0).score);

//        for (int i =0; i<playerList.size(); i++){
//            switch (i){
//                case 0: P1Name.setText(playerList.get(i).name);
//                        P1Score.setText(playerList.get(i).score);
//                    break;
//                case 1: P2Name.setText(playerList.get(i).name);
//                        P2Score.setText(playerList.get(i).score);
//                    break;
//                case 2: P3Name.setText(playerList.get(i).name);
//                        P3Score.setText(playerList.get(i).score);
//                    break;
//                case 3: P4Name.setText(playerList.get(i).name);
//                        P4Score.setText(playerList.get(i).score);
//                    break;
//                case 4: P5Name.setText(playerList.get(i).name);
//                        P5Score.setText(playerList.get(i).score);
//                    break;
//                case 5: P6Name.setText(playerList.get(i).name);
//                        P6Score.setText(playerList.get(i).score);
//                    break;
//
//            }
//
//        }

    }

}
