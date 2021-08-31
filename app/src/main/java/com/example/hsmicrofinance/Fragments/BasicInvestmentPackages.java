package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBasicInvestmentPackagesBinding;


public class BasicInvestmentPackages extends Fragment {

    private static final String TAG = "BasicInvestPackages";
    FragmentBasicInvestmentPackagesBinding mFragmentBasicInvestmentPackagesBinding;
    private NavController mNavController;

    public BasicInvestmentPackages() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicInvestmentPackagesBinding = FragmentBasicInvestmentPackagesBinding.inflate(inflater,container,false);
        return mFragmentBasicInvestmentPackagesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated: "+ "created");
        mNavController = Navigation.findNavController(view);

        mFragmentBasicInvestmentPackagesBinding.goldDepositBtn.setOnClickListener(v-> mNavController.navigate(R.id.action_basicInvestmentPackages_to_goldDeposit));
        mFragmentBasicInvestmentPackagesBinding.platinumDepositBtn.setOnClickListener(v-> mNavController.navigate(R.id.action_basicInvestmentPackages_to_platinumDeposit));
        mFragmentBasicInvestmentPackagesBinding.stdDepositBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicInvestmentPackages_to_standardDeposit));
    }
}