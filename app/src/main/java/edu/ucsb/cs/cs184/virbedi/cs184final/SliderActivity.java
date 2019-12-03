package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Vector;

public class SliderActivity extends AppCompatActivity {

    private SeekBar bullsEyeBar;
    TextView TargetValueDisplay;
    TextView CurrentScore;
    Button GoButton;

    int userValue;
    int targetValue;
    Vector scores = new Vector();
    int NumOfPlayers = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        //Hello world



        TargetValueDisplay = findViewById(R.id.TargetValue);

        CurrentScore =findViewById(R.id.text_home);
        CurrentScore.setText("Score: "+ 0);

        GoButton = findViewById(R.id.button);
        String buttonText = "Go!";
        GoButton.setText(buttonText);

                //Set bulls eye bar to middle value
                bullsEyeBar = findViewById(R.id.seekBar);
        bullsEyeBar.setMax(100);
        bullsEyeBar.setProgress(50);

        //Initialize all player scores to 0
        for (int i = 0 ; i<NumOfPlayers; i++){
            scores.add(0);
        }

        SetTarget();

        GoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                PlaySliderGame();
            }
        });



    }



    public void SetTarget(){
        // Sets a random target Value
        Random r = new Random();
        int low = 10;
        int high = 100;
        targetValue = r.nextInt(high-low) + low;
        String text = "" + targetValue;

        TargetValueDisplay.setText(text);
    }

    public void PlaySliderGame(){
        int score = 0;

        int userValue = bullsEyeBar.getProgress();

        score = 100 - Math.abs(targetValue-userValue);

        String text = "Score: " + score ;

        CurrentScore.setText(text);

        bullsEyeBar.setProgress(50);
        SetTarget();


    }
}
