package edu.ucsb.cs.cs184.virbedi.cs184final;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlayerActivity extends AppCompatActivity {

    TextView Player1;
    TextView Player2;
    TextView Player3;
    TextView Player4;
    TextView Player5;
    TextView Player6;

    FloatingActionButton fab;
    AlertDialog.Builder builder;
    View view;
    LayoutInflater layoutInflater;
    EditText myInput;
    int counter=0;
    String name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Player1 = findViewById(R.id.player1);
        Player2 = findViewById(R.id.player2);
        Player3 = findViewById(R.id.player3);
        Player4 = findViewById(R.id.player4);
        Player5 = findViewById(R.id.player5);
        Player6 = findViewById(R.id.player6);
        fab = findViewById(R.id.fab);
        builder = new AlertDialog.Builder(this);
        layoutInflater = this.getLayoutInflater();




        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                view = layoutInflater.inflate(R.layout.activity_dialog, null);
                myInput = view.findViewById(R.id.playerET);
                builder
                        .setTitle("New player")
                        .setMessage("Input new player's name (max 6 players")
                        .setView(view)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    counter++;
                                    name = myInput.getText().toString();
                                    setName(counter,name);

                            }
                        })
                        .setNegativeButton("Cancel", null);

                AlertDialog alert = builder.create();
                alert.show();



            }
        });

        view = null;

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
