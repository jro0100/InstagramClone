package com.example.insta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText etUser;
    private EditText etPass;
    private EditText etEmail;
    private Button btnSignupSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        btnSignupSubmit = findViewById(R.id.btnSignupSubmit);
        btnSignupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick SignupSubmit button");
                String username = etUser.getText().toString();
                String password = etPass.getText().toString();
                String email = etEmail.getText().toString();
                signupUser(username, password, email);
            }
        });
    }

    private void signupUser(String username, String password, String email) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    goMainActivity();
                    Toast.makeText(SignUpActivity.this, "Signup Success!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "Issue with sign up", e);
                    Toast.makeText(SignUpActivity.this, "Issue with sign up!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}