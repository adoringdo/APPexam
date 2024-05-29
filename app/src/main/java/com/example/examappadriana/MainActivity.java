package com.example.examappadriana;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



public String[] randomPic = {"dog", "cat", "panda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView myImageView = (ImageView) findViewById(R.id.greetingPic);
        final int randomNr = new Random().nextInt(3); // [0, 60] + 20 => [20, 80]
        myImageView.setImageResource(getResources().getIdentifier(randomPic[randomNr], "drawable", getPackageName()));

    }
}