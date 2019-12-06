package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    TextView Player1 = findViewById(R.id.player1);
    TextView Player2 = findViewById(R.id.player2);
    TextView Player3 = findViewById(R.id.player3);
    TextView Player4 = findViewById(R.id.player4);
    TextView Player5 = findViewById(R.id.player5);
    TextView Player6 = findViewById(R.id.player6);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

    }

    public void setName(int counter, String name){

        String disp = counter +". "+name;
        switch(counter){
            case 1: Player1.setText(disp);
                break;
            case 2: Player2.setText(disp);
                break;
            case 3: Player3.setText(disp);
                break;
            case 4: Player4.setText(disp);
                break;
            case 5: Player5.setText(disp);
                break;
            case 6: Player6.setText(disp);
                break;
        }

    }
}
