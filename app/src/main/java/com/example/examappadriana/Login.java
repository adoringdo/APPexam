package com.example.examappadriana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextInputEditText usernameText, passwordText;
        Button buttonLogin;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.loginBtn);
        TextView errorMessage = findViewById(R.id.loginError);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve entered username and password
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

                // Implement authentication logic here
                if (username.equals("Admin") && password.equals("12345")) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                } else {
                    errorMessage.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}