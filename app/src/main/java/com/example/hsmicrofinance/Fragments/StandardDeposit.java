package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentStandardDepositBinding;

public class StandardDeposit extends Fragment {

    FragmentStandardDepositBinding mFragmentStandardDepositBinding;

    public StandardDeposit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentStandardDepositBinding = FragmentStandardDepositBinding.inflate(inflater, container, false);
        return mFragmentStandardDepositBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentStandardDepositBinding.standardPackageDepostBtn.setOnClickListener(v -> StandardDepost());
    }

    private void StandardDepost() {
        if (mFragmentStandardDepositBinding.standardPackageEditText.getText().toString().trim().isEmpty()) {
            mFragmentStandardDepositBinding.standardErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentStandardDepositBinding.standardPackageEditText.getText().toString()) < 500) {
            mFragmentStandardDepositBinding.standardErrorText.setText("Please enter amount above ksh 500");
        } else if (Integer.parseInt(mFragmentStandardDepositBinding.standardPackageEditText.getText().toString()) > 20000) {
            mFragmentStandardDepositBinding.standardErrorText.setText("Should not exceed 20000");
        } else {
            handlestandardDeposit();
        }
    }

    private void handlestandardDeposit() {
    }
}