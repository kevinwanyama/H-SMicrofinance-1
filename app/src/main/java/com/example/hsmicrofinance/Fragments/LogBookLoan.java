package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentLogBookLoanBinding;


public class LogBookLoan extends Fragment {

    FragmentLogBookLoanBinding mFragmentLogBookLoanBinding;

    public LogBookLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentLogBookLoanBinding = FragmentLogBookLoanBinding.inflate(inflater, container, false);
        return mFragmentLogBookLoanBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragmentLogBookLoanBinding.logbookLoanRequestBtn.setOnClickListener(v -> logBookRequestLoan());

    }

    private void logBookRequestLoan() {
        if (mFragmentLogBookLoanBinding.logbookLoanEditText.getText().toString().trim().isEmpty()) {
            mFragmentLogBookLoanBinding.logbookErrorText.setText("Cannot be Empty");
        } else if (Integer.parseInt(mFragmentLogBookLoanBinding.logbookLoanEditText.getText().toString()) < 10000) {
            mFragmentLogBookLoanBinding.logbookErrorText.setText("Please enter 10000 and above");
        } else if (Integer.parseInt(mFragmentLogBookLoanBinding.logbookLoanEditText.getText().toString()) > 500000) {
            mFragmentLogBookLoanBinding.logbookErrorText.setText("Should not exceed 500000");
        } else {
            handleLogBookLoanRequest();
        }
    }

    private void handleLogBookLoanRequest() {
    }
}