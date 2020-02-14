package com.example.myltalearning.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myltalearning.Helper.EditTextValidation;
import com.example.myltalearning.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {
    private TextInputLayout etEmail, etPassword;
    private FloatingActionButton fabSignIn;
    private HashMap<String, TextInputLayout> errorMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initComponents();
    }

    private void initComponents() {


        etEmail = findViewById(R.id.et_sign_in_email);
        etPassword = findViewById(R.id.et_sign_in_password);
        fabSignIn = findViewById(R.id.fab_sign_in);

        errorMap = new HashMap<>();
        errorMap.put("Email", etEmail);
        errorMap.put("Password", etPassword);

        fabSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private boolean isSignInDetailsValid() {
        if (EditTextValidation.isEmpty(etEmail) | EditTextValidation.isEmpty(etPassword)) {
            return false;
        }
        return true;
    }

    private void signIn() {
        if (isSignInDetailsValid()) {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void showSignUpForm(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}
