package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBusinessLoanBinding;


public class BusinessLoan extends Fragment {

    FragmentBusinessLoanBinding mFragmentBusinessLoanBinding;

    public BusinessLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBusinessLoanBinding = FragmentBusinessLoanBinding.inflate(inflater, container, false);
        return mFragmentBusinessLoanBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBusinessLoanBinding.businessLoanRequestBtn.setOnClickListener(v -> businessRequestLoan());
    }

    private void businessRequestLoan() {
        if (mFragmentBusinessLoanBinding.businessLoanEditText.getText().toString().trim().isEmpty()) {
            mFragmentBusinessLoanBinding.businessErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentBusinessLoanBinding.businessLoanEditText.getText().toString()) < 5000) {
            mFragmentBusinessLoanBinding.businessErrorText.setText("Please enter amount above 5000");
        } else if (Integer.parseInt(mFragmentBusinessLoanBinding.businessLoanEditText.getText().toString()) > 140000) {
            mFragmentBusinessLoanBinding.businessErrorText.setText("Should not exceed 140000");
        } else {
            handleBusinessLoanRequest();
        }
    }

    private void handleBusinessLoanRequest() {
    }
}