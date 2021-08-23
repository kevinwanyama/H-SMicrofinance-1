package com.example.hsmicrofinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hsmicrofinance.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding mActivityLoginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mActivityLoginBinding.getRoot());

        loadSignUpActivity();
        loadPackageActivity();

    }

    private void loadSignUpActivity() {
        mActivityLoginBinding.signupText.setOnClickListener(v->{
            Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
            overridePendingTransition(0,0);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });
    }
    private void loadPackageActivity() {
        mActivityLoginBinding.loginBtn.setOnClickListener(v->{
            Intent intent = new Intent(LoginActivity.this,PackageActivity.class);
            overridePendingTransition(0,0);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });
    }

}