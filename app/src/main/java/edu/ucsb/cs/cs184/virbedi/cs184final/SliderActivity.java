package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.DialogInterface;

import android.content.Intent;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

class Player{
    String name = "";
    int score = 0;
}

public class SliderActivity extends AppCompatActivity {

    private SeekBar bullsEyeBar;
    TextView TargetValueDisplay;
    TextView Countdown;
    TextView NameDisplay;
    TextView RoundDisplay;
    Button GoButton;
    Button EndButton;
    int Round;
    int playerNumber = 0;
    int targetValue;
    ArrayList<PlayerActivity.globalPlayer> playerList = new ArrayList<>();
    boolean lastPlayer = false;

    AlertDialog.Builder builder;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        //Declare display elements
        TargetValueDisplay = findViewById(R.id.TargetValue);

        NameDisplay = findViewById(R.id.NameDisplay);
        RoundDisplay = findViewById(R.id.RoundDisplay);
        TargetValueDisplay = findViewById(R.id.TargetValue);
        Countdown =findViewById(R.id.timer);
        GoButton = findViewById(R.id.button);
        bullsEyeBar = findViewById(R.id.seekBar);

        EndButton = findViewById(R.id.endButton);

        builder = new AlertDialog.Builder(this);

        //Set initial text elements
        Countdown.setText("Score: "+ 0);
        String buttonText = "Go!";
        GoButton.setText(buttonText);
        String sliderGame = "Slider Game";
        builder.setTitle(sliderGame);

        //Set bulls eye bar to middle value for start of the game

        bullsEyeBar.setMax(100);
        bullsEyeBar.setProgress(50);

        //Populate(); Test with fake players
        playerList = (ArrayList<PlayerActivity.globalPlayer>)getIntent().getSerializableExtra("playerList");
        Round = getIntent().getIntExtra("Round",0);
        Round++;
        String roundString = "Round: " + Round;
        RoundDisplay.setText(roundString);
        initial();

        GoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                PlaySliderGame();
            }
        });

        EndButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EndGame();
            }
        });


    }
    public void initial(){
        NameDisplay.setText(playerList.get(playerNumber).name);
        SetTarget();
        //Add code for startCountdown
        StartTimer();
    }



    public void SetTarget(){
        // Sets a random target Value
        Random r = new Random();
        int low = 10;
        int high = 99;
        targetValue = r.nextInt(high-low) + low;
        String text = "Get slider to: " + targetValue;

        TargetValueDisplay.setText(text);
    }

    public void PlaySliderGame(){
        int score = 0;

        String message;
        int userValue = bullsEyeBar.getProgress();

        score = 100 - Math.abs(targetValue-userValue);


        bullsEyeBar.setProgress(50);
        SetTarget();

        playerList.get(playerNumber).score += score;

        if(playerNumber<playerList.size()-1){
            lastPlayer = false;
            message = "Your score is "+ score +". Press Yes when "
                    +playerList.get(playerNumber+1).name + " is ready";
        }else {
            message = "Your score is "+ score + ". Press Yes to go to the next round";
            lastPlayer = true;
        }

        builder.setMessage(message);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(lastPlayer){
                    //Add code to go to next game

                    Intent intent = new Intent(getApplicationContext(),MemoryActivity.class);
                    intent.putExtra("playerList",playerList);
                    intent.putExtra("Round",Round);
                    startActivity(intent);
                }
                else {
                    playerNumber += 1;
                    initial();
                }

            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }

    public void StartTimer(){

        new CountDownTimer(10000, 1000){
            int counter = 10;
            public void onTick(long millisUntilFinished){
                String display = "Time remaining: " + counter;
                Countdown.setText(display);
                counter--;
            }
            public void onFinish(){
                PlaySliderGame();
            }
        }.start();
    }

//    public void Populate(){
//        Player a = new Player();
//        a.name = "Vir";
//        a.score = 0;
//        playerList.add(a);
//
//        Player b = new Player();
//        b.name = "Megh";
//        b.score = 0;
//        playerList.add(b);
//
//        Player c = new Player();
//        c.name = "Alex";
//        c.score = 0;
//        playerList.add(c);
//
//        Player d = new Player();
//        d.name = "Joe";
//        d.score = 0;
//        playerList.add(d);
//
//    }

    public void EndGame(){
        Intent intent = new Intent(getApplicationContext(),ScoreActivity.class);
        intent.putExtra("playerList",playerList);
        intent.putExtra("Round",Round);
        startActivity(intent);

    }


}