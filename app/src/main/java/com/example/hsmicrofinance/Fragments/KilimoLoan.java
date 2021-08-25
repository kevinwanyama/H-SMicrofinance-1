package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentKilimoLoanBinding;


public class KilimoLoan extends Fragment {

    FragmentKilimoLoanBinding mFragmentKilimoLoanBinding;

    public KilimoLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentKilimoLoanBinding = FragmentKilimoLoanBinding.inflate(inflater, container, false);
        return mFragmentKilimoLoanBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentKilimoLoanBinding.kilimoLoanRequestBtn.setOnClickListener(v -> KilimoRequestLoan());
    }

    private void KilimoRequestLoan() {
        if (mFragmentKilimoLoanBinding.kilimoLoanEditText.getText().toString().trim().isEmpty()) {
            mFragmentKilimoLoanBinding.kilimoErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentKilimoLoanBinding.kilimoLoanEditText.getText().toString()) < 5000) {
            mFragmentKilimoLoanBinding.kilimoErrorText.setText("Please enter amount above 5000");
        } else if (Integer.parseInt(mFragmentKilimoLoanBinding.kilimoLoanEditText.getText().toString()) > 140000) {
            mFragmentKilimoLoanBinding.kilimoErrorText.setText("Should not exceed 140000");
        } else {
            handleKilimoLoanRequest();
        }
    }

    private void handleKilimoLoanRequest() {
    }
}