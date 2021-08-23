package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentTitleDeedLoanBinding;


public class TitleDeedLoan extends Fragment {

    FragmentTitleDeedLoanBinding mFragmentTitleDeedLoanBinding;

    public TitleDeedLoan() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentTitleDeedLoanBinding = FragmentTitleDeedLoanBinding.inflate(inflater,container,false);
        return mFragmentTitleDeedLoanBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTitleDeedLoanBinding.titledeedLoanRequestBtn.setOnClickListener(v-> titleDeedRequestloan());
    }

    private void titleDeedRequestloan() {
        if(Integer.parseInt(mFragmentTitleDeedLoanBinding.titledeedLoanEditText.getText().toString()) < 25000){
            mFragmentTitleDeedLoanBinding.titledeedErrorText.setText("Please enter amount above 25000");
        }
        else if(Integer.parseInt(mFragmentTitleDeedLoanBinding.titledeedLoanEditText.getText().toString()) > 2000000){
            mFragmentTitleDeedLoanBinding.titledeedErrorText.setText("Should not exceed 2000000");
        }
    }
}