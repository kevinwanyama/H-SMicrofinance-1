package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentPlatinumDepositBinding;


public class PlatinumDeposit extends Fragment {

    FragmentPlatinumDepositBinding mFragmentPlatinumDepositBinding;

    public PlatinumDeposit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentPlatinumDepositBinding = FragmentPlatinumDepositBinding.inflate(inflater, container, false);
        return mFragmentPlatinumDepositBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPlatinumDepositBinding.platinumPackageDepostBtn.setOnClickListener(v -> platinumDeposit());
    }

    private void platinumDeposit() {
        if (mFragmentPlatinumDepositBinding.platinumPackageEditText.getText().toString().trim().isEmpty()) {
            mFragmentPlatinumDepositBinding.standardErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentPlatinumDepositBinding.platinumPackageEditText.getText().toString()) < 20000) {
            mFragmentPlatinumDepositBinding.standardErrorText.setText("Please enter amount above 20000");
        } else if (Integer.parseInt(mFragmentPlatinumDepositBinding.platinumPackageEditText.getText().toString()) > 250000) {
            mFragmentPlatinumDepositBinding.standardErrorText.setText("Should not exceed ksh 250000");
        } else {
            handlePlatinumDeposit();
        }
    }

    private void handlePlatinumDeposit() {
    }
}