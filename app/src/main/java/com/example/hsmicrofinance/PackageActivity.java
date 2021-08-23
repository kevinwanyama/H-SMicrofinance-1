package com.example.hsmicrofinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsmicrofinance.databinding.ActivityPackageBinding;

public class PackageActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityPackageBinding mActivityPackageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityPackageBinding = ActivityPackageBinding.inflate(getLayoutInflater());
        setContentView(mActivityPackageBinding.getRoot());
        mActivityPackageBinding.BasicButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Basic_button:
                loadBasicPackageHome();
                break;
        }

    }

    private void loadBasicPackageHome() {
        Intent intent = new Intent(PackageActivity.this,HomeActivity.class);
        overridePendingTransition(0,0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}