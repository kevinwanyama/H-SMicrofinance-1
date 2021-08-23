package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBimaLoanBinding;


public class BimaLoan extends Fragment {


FragmentBimaLoanBinding mFragmentBimaLoanBinding;
    public BimaLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBimaLoanBinding = FragmentBimaLoanBinding.inflate(inflater,container,false);
        return inflater.inflate(R.layout.fragment_bima_loan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBimaLoanBinding.bimaLoanRequestBtn.setOnClickListener(
                v-> bimaRequestLoan()
        );
    }

    private void bimaRequestLoan() {
        if(Integer.parseInt(mFragmentBimaLoanBinding.bimaLoanEditText.getText().toString()) < 10000){
            mFragmentBimaLoanBinding.bimaErrorText.setText("Please enter amount above 10000");
        }
        else if(Integer.parseInt(mFragmentBimaLoanBinding.bimaLoanEditText.getText().toString()) > 250000){
            mFragmentBimaLoanBinding.bimaErrorText.setText("Should not exceed 250000000");
        }
    }
}