package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentPersonalLoanBinding;


public class PersonalLoan extends Fragment {

    FragmentPersonalLoanBinding mFragmentPersonalLoanBinding;

    public PersonalLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentPersonalLoanBinding = FragmentPersonalLoanBinding.inflate(inflater, container, false);
        return mFragmentPersonalLoanBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragmentPersonalLoanBinding.personalLoanRequestBtn.setOnClickListener(v -> personalRequestLoan());
    }

    private void personalRequestLoan() {
        if (mFragmentPersonalLoanBinding.personalLoanEditText.getText().toString().trim().isEmpty()) {
            mFragmentPersonalLoanBinding.personalErrorText.setText("Cannot be empty");
        } else if (Integer.parseInt(mFragmentPersonalLoanBinding.personalLoanEditText.getText().toString()) < 5000) {
            mFragmentPersonalLoanBinding.personalErrorText.setText("Please enter amount above 5000");
        } else if (Integer.parseInt(mFragmentPersonalLoanBinding.personalLoanEditText.getText().toString()) > 200000) {
            mFragmentPersonalLoanBinding.personalErrorText.setText("Should not exceed 200000");
        } else {
            handlePersonalLoanRequest();
        }
    }

    private void handlePersonalLoanRequest() {
    }
}