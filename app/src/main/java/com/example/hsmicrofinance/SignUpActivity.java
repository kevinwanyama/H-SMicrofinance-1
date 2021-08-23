package com.example.hsmicrofinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsmicrofinance.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignUpBinding mActivitySignUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySignUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(mActivitySignUpBinding.getRoot());
        mActivitySignUpBinding.loginText.setOnClickListener(this);
        mActivitySignUpBinding.RegisterBtn.setOnClickListener(this);
        mActivitySignUpBinding.TermsAndConditions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Register_btn:
                loadPackageActivity();
                break;
            case R.id.login_text:
                loadLoginActivity();
                break;
            case R.id.Terms_and_conditions:
                loadTermsAndConditionActivity();
                break;
        }
    }

    private void loadTermsAndConditionActivity() {
        Intent intent = new Intent(SignUpActivity.this,TermsAndConditionsActivity.class);
        overridePendingTransition(0,0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void loadLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        overridePendingTransition(0,0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void loadPackageActivity() {
        Intent intent = new Intent(SignUpActivity.this,PackageActivity.class);
        overridePendingTransition(0,0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}