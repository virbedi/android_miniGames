package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

    int playerNumber = 0;
    int targetValue;
    Vector<Player> PlayerList = new Vector<>();
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

        Populate();
        initial();

        GoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                PlaySliderGame();
            }
        });



    }
    public void initial(){
        NameDisplay.setText(PlayerList.get(playerNumber).name);
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

        if(playerNumber<PlayerList.size()){
            lastPlayer = false;
            message = "Your score is "+ score +". Press Yes when "
                    +PlayerList.get(playerNumber+1).name + " is ready";
        }else {
            message = "Your score is "+ score + "Press Yes to go to the next round";
            lastPlayer = true;
        }

        builder.setMessage(message);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(lastPlayer){
                    //Add code to go to next game
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

    public void Populate(){
        Player a = new Player();
        a.name = "Vir";
        a.score = 0;
        PlayerList.add(a);

        Player b = new Player();
        b.name = "Megh";
        b.score = 0;
        PlayerList.add(b);

        Player c = new Player();
        c.name = "Alex";
        c.score = 0;
        PlayerList.add(c);

        Player d = new Player();
        d.name = "Joe";
        d.score = 0;
        PlayerList.add(d);

    }
}
