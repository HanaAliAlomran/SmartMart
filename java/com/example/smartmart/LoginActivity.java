package com.example.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import database.DatabaseHelper;
public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    Button btn_to_sign_up;
    EditText ed_user;
    EditText ed_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login= findViewById(R.id.btnSignUp);
        btn_to_sign_up= findViewById(R.id.buttonToGoToSignUp);
        ed_user= findViewById(R.id.editTextName);
        ed_pass= findViewById(R.id.editTextTextPassword);
        // ...

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_user.getText().toString().isEmpty() || ed_pass.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill the login form", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the user exists in the database
                    DatabaseHelper databaseHelper = new DatabaseHelper(LoginActivity.this);
                    boolean userExists = databaseHelper.checkUserExistsByEmail(ed_user.getText().toString());
                    if (userExists) {
                        // Validate login
                        boolean loginSuccess = databaseHelper.loginUserByEmail(
                                ed_user.getText().toString(),
                                ed_pass.getText().toString()
                        );
                        if (loginSuccess) {
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User does not exist", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

// ...



        //if the user do not have account it will go the sign up activity
        btn_to_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(intent);



            }});

    }
}