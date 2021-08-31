package com.example.hsmicrofinance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.hsmicrofinance.databinding.ActivityHomeBinding;
import com.example.hsmicrofinance.viewmodels.LoanPackageViewModel;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "HomeActivity";
    private ActivityHomeBinding mActivityHomeBinding;
    private NavController mNavController;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private LoanPackageViewModel mLoanPackageViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mActivityHomeBinding.getRoot());

        mDrawerLayout = mActivityHomeBinding.drawerLayout;
        mNavigationView = mActivityHomeBinding.navigationView;
        mToolbar = mActivityHomeBinding.toolbar;
        mToolbar.setTitle("Micro finance");
        setSupportActionBar(mToolbar);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavController = Navigation.findNavController(HomeActivity.this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(mNavigationView,mNavController);

        mLoanPackageViewModel = new ViewModelProvider(this).get(LoanPackageViewModel.class);
        mLoanPackageViewModel.getPackagesObserver().observe(this,examples -> {
            Log.d(TAG, "onCreate: "+ examples.toString());

        });


    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}