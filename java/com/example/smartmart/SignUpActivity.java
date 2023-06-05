package com.example.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import database.DatabaseHelper;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    Button btn_signUp;
    Button btn_to_login;
    EditText ed_userName;
    EditText ed_passforSignUp;
    EditText ed_Retype_pass;
    EditText ed_Email;
    Button pickDateBtn;
    TextView selectedDateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_signUp= findViewById(R.id.btnSignUp);
        btn_to_login= findViewById(R.id.buttonToGoToSignUp);

        ed_userName= findViewById(R.id.editTextName);
        ed_Email= findViewById(R.id.editTextEmail);
        ed_passforSignUp= findViewById(R.id.editTextTextPassword);
        ed_Retype_pass= findViewById(R.id.editTextRePassword);
        pickDateBtn = findViewById(R.id.Button);
        selectedDateTV = findViewById(R.id.EditDate);
        //if the user have account it will go the LOG IN activity

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_userName.getText().toString().isEmpty() || ed_passforSignUp.getText().toString().isEmpty() || ed_Retype_pass.getText().toString().isEmpty() || ed_Email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill the sign-up form", Toast.LENGTH_SHORT).show();
                } else if (!ed_passforSignUp.getText().toString().equals(ed_Retype_pass.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert user data into the database
                    DatabaseHelper databaseHelper = new DatabaseHelper(SignUpActivity.this);
                    boolean success = databaseHelper.insertUser(
                            ed_userName.getText().toString(),
                            ed_passforSignUp.getText().toString(),
                            ed_Email.getText().toString()
                    );
                    if (success) {
                        Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error occurred while registering user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        //passing context.
                        SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // Set date.
                                selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        //if the user have account it will go the LOG IN activity
        btn_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }});

    }
}




