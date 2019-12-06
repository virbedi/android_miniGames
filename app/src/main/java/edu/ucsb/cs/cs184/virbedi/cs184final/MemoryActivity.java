package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static edu.ucsb.cs.cs184.virbedi.cs184final.R.drawable.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

//New branch push
//Second push

class Player1{
    String name = "";
    int score = 0;
}

public class MemoryActivity extends AppCompatActivity {

    Button button101, button102, button3, button4, button5, button6, button7, button8, button9, button10,
            button11, button12;
    TextView textView, textView3;
    int counter = 0;
    int clicked = 0;
    int matched = 0;
    int lastClicked = -1;
    boolean turnOver = false;
    long startTime;
    long endTime;
    long seconds;

    Vector<Player1> PlayerList = new Vector<>();
    boolean lastPlayer = false;
    int playNumber=0;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        builder = new AlertDialog.Builder(this);
        button101 = (Button) findViewById(R.id.button101);
        button102 = (Button) findViewById(R.id.button102);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);

        Populate();



        playMemoryGame();


    }

        public void playMemoryGame() {

            textView.setText(PlayerList.get(playNumber).name);
            final ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(fire, rocket, power, spider, star, thunder, fire, rocket, power, spider, star, thunder));

            final ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(button101, button102, button3, button4, button5, button6,
                    button7, button8, button9, button10, button11, button12));

            final int cardBack = R.drawable.ic_info;
            Collections.shuffle(myList);


                for (int i = 0; i < 12; i++) {

                    buttons.get(i).setText("cardBack");
                    buttons.get(i).setTextSize(0.0f);
                    final int j = i;
                    buttons.get(i).setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {
                            if (clicked == 0)
                                startTime = System.currentTimeMillis();
                            Log.i("TIME1", String.valueOf(startTime));
                            if (buttons.get(j).getText() == "cardBack" && !turnOver) {
                                buttons.get(j).setBackgroundResource(myList.get(j));
                                buttons.get(j).setText(myList.get(j));
                                if (counter == 0)
                                    lastClicked = j;
                                clicked++;
                                counter++;
                            } else if (buttons.get(j).getText() != "cardBack") {
                                buttons.get(j).setBackgroundResource(cardBack);
                                buttons.get(j).setText("cardBack");
//                        clicked--;
                                counter--;
                            }


                            if (counter == 2) {
                                turnOver = true;
                                if (buttons.get(j).getText() == buttons.get(lastClicked).getText()) {
                                    buttons.get(j).setClickable(false);
                                    buttons.get(lastClicked).setClickable(false);
                                    turnOver = false;
                                    counter = 0;
                                    matched++;
                                }
                            } else if (counter == 0) {
                                turnOver = false;
                            }

                            if (matched == 1) {
                                String message = "";
                                endTime = System.currentTimeMillis();
                                Log.i("TIME2", String.valueOf(endTime));
                                seconds = (endTime - startTime) / 1000;
                                float score = calcScore(seconds);
                                Log.i("TIME", String.valueOf(seconds));
                                if(playNumber == PlayerList.size()-1)
                                    message = "Your took " + seconds + " seconds. Your score is "+score+". All players have played!";
                                else
                                    message = "Your took " + seconds + " seconds. Your score is "+score+". Pass the device to the next player";
                                builder.setMessage(message);

                            if(playNumber >= PlayerList.size())
                                lastPlayer = true;

                            builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if (lastPlayer) {
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                        intent.putExtra("Time",seconds);
                                        startActivity(intent);

                                    } else {

                                        playNumber += 1;
                                        Log.i("playNumber",String.valueOf(playNumber));

                                        for(int it=0;it<12;it++)
                                        {
                                            buttons.get(it).setText("");
                                            buttons.get(it).setBackgroundResource(ic_info);
                                            buttons.get(it).setClickable(true);
                                            resetVar();
                                            Collections.shuffle(myList);
                                            playMemoryGame();
                                        }
                                    }

                                }
                            });
                                AlertDialog alert = builder.create();
                                alert.show();
//                        Intent intent = new Intent(getApplicationContext(),Result.class);
//                        intent.putExtra("Time",seconds);
//                        startActivity(intent);
                            }

                        }

                    });
                }


        }

        public void resetVar(){

             counter = 0;
             clicked = 0;
             matched = 0;
             lastClicked = -1;
             turnOver = false;
             startTime=0;
             endTime=0;
             seconds=0;
        }

        public float calcScore(long seconds){

            float score = (200 - seconds)/2;
            return score;
        }

        public void Populate(){
            Player1 a = new Player1();
            a.name = "Vir";
            a.score = 0;
            PlayerList.add(a);

            Player1 b = new Player1();
            b.name = "Megh";
            b.score = 0;
            PlayerList.add(b);

//            Player1 c = new Player1();
//            c.name = "Alex";
//            c.score = 0;
//            PlayerList.add(c);
//
//            Player1 d = new Player1();
//            d.name = "Joe";
//            d.score = 0;
//            PlayerList.add(d);

        }


}
