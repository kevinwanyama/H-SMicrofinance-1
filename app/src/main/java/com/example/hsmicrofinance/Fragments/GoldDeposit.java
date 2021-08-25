package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentGoldDepositBinding;


public class GoldDeposit extends Fragment {
    FragmentGoldDepositBinding mFragmentGoldDepositBinding;


    public GoldDeposit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mFragmentGoldDepositBinding = FragmentGoldDepositBinding.inflate(inflater, container, false);
        return mFragmentGoldDepositBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentGoldDepositBinding.goldPackageDepostBtn.setOnClickListener(v -> golddeposit());
    }

    private void golddeposit() {
        if (mFragmentGoldDepositBinding.goldPackageEditText.getText().toString().trim().isEmpty()) {
            mFragmentGoldDepositBinding.standardErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentGoldDepositBinding.goldPackageEditText.getText().toString()) < 10000) {
            mFragmentGoldDepositBinding.standardErrorText.setText("Please enter amount above ksh 10000");
        } else if (Integer.parseInt(mFragmentGoldDepositBinding.goldPackageEditText.getText().toString()) > 100000) {
            mFragmentGoldDepositBinding.standardErrorText.setText("Should not exceed ksh 100000");
        } else {
            handleGoldDeposit();
        }
    }

    private void handleGoldDeposit() {
    }
}