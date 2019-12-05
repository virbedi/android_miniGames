package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static edu.ucsb.cs.cs184.virbedi.cs184final.R.drawable.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MemoryActivity extends AppCompatActivity {

    Button button101, button102, button3, button4, button5, button6, button7, button8, button9, button10,
            button11, button12;
    TextView textView;
    int counter = 0;
    int clicked = 0;
    int matched = 0;
    int lastClicked = -1;
    boolean turnOver = false;
    long startTime;
    long endTime;
    long seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

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

                    if (matched == 6) {
                        endTime = System.currentTimeMillis();
                        Log.i("TIME2", String.valueOf(endTime));
                        seconds = (endTime - startTime) / 1000;
                        Log.i("TIME", String.valueOf(seconds));
//                        Intent intent = new Intent(getApplicationContext(),Result.class);
//                        intent.putExtra("Time",seconds);
//                        startActivity(intent);
                    }

                }

            });
        }
    }

}
