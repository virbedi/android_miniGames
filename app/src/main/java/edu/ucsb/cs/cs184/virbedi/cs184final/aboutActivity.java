package edu.ucsb.cs.cs184.virbedi.cs184final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView About = findViewById(R.id.AboutText);
        String text = "How to play \n"
                +"\n"
                +"Memory Game: \n"
                +"Click on an icon to reveal an image and match all 6 images with their pairs. \nIf an incorrect pair is chosen, only two icons will be displayed \n"
                +"The faster you match all six pairs, the more points you get \n"
                +" \n"
                +"Slider Game: \n"
                +"Get the slider as close to the target value as possible before the time runs out. \nThe closer you are, the more points you get"
                ;

        About.setText(text);
    }
}
