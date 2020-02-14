package com.example.myltalearning.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myltalearning.Helper.EditTextValidation;
import com.example.myltalearning.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private TextInputLayout etFirstName, etFamilyName, etEmail, etPassword, etConfirmPassword;
    private Button btnGetStarted;
    private HashMap<String, TextInputLayout> errorMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initComponents();
    }

    private void initComponents() {

        etFirstName = findViewById(R.id.et_firstName);
        etFamilyName = findViewById(R.id.et_familyName);
        etEmail = findViewById(R.id.et_sign_up_email);
        etPassword = findViewById(R.id.et_sign_up_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);

        errorMap = new HashMap<>();
        errorMap.put("firstName", etFirstName);
        errorMap.put("familyName", etFamilyName);
        errorMap.put("email", etEmail);
        errorMap.put("password", etPassword);

        btnGetStarted = findViewById(R.id.btn_get_started);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private boolean isSignUpDetailsValid() {
        if (EditTextValidation.isEmpty(etFirstName) | EditTextValidation.isEmpty(etFamilyName) |
                EditTextValidation.isEmpty(etEmail) | EditTextValidation.isEmpty(etPassword) |
                EditTextValidation.isEmpty(etConfirmPassword)) {
            return false;
        }
        return true;
    }

    private boolean isPasswordConfirmed() {
        return etPassword.getEditText().getText().toString().trim().equals(etConfirmPassword.getEditText()
                .getText().toString().trim());
    }

    private void signUp() {

        if (isSignUpDetailsValid() && isPasswordConfirmed()) {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        } else if (!isPasswordConfirmed()) {
            etConfirmPassword.setError("Password did not match !");
        }

    }

}
