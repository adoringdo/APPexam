package com.example.examappadriana;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
        final int randomNr = new Random().nextInt(3);
        myImageView.setImageResource(getResources().getIdentifier(randomPic[randomNr], "drawable", getPackageName()));


        Button buttonBack = findViewById(R.id.backBtn);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button buttonText = findViewById(R.id.textBtn);
        buttonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TextWindow.class));
            }
        });


        EditText celsius = (EditText)findViewById(R.id.celsiusText);
        EditText fahren = (EditText)findViewById(R.id.farText);
        TextView celsiusValue = (TextView) findViewById(R.id.celsiusText2);
        TextView fahrenValue = (TextView)findViewById(R.id.farText2);

        Button buttonCalculate = findViewById(R.id.calculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (celsius.length() != 0){

                    double c = Double.parseDouble(celsius.getText().toString());

                double cTOf = (c * 9 / 5) + 32;


                fahrenValue.setText(String.valueOf(cTOf));
            }

                if (fahren.length() != 0) {
                    double f = Double.parseDouble(fahren.getText().toString());

                    double fTOc = ((f - 32) * 5) / 9;


                    celsiusValue.setText(String.valueOf(fTOc));

                }
            }
        });




    }
}