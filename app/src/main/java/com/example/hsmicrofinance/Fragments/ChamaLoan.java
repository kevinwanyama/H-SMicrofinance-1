package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentChamaLoanBinding;


public class ChamaLoan extends Fragment {

    FragmentChamaLoanBinding mFragmentChamaLoanBinding;

    public ChamaLoan() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentChamaLoanBinding = FragmentChamaLoanBinding.inflate(inflater,container,false);
        return mFragmentChamaLoanBinding.getRoot();




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentChamaLoanBinding.chamaLoanRequestBtn.setOnClickListener(v->chamaLoanRequest());
    }

    private void chamaLoanRequest() {
        if(Integer.parseInt(mFragmentChamaLoanBinding.chamaLoanEditText.getText().toString()) < 50000){
            mFragmentChamaLoanBinding.chamaErrorText.setText("Please amount above 50000");
        }
        else if (Integer.parseInt(mFragmentChamaLoanBinding.chamaLoanEditText.getText().toString())> 300000){
            mFragmentChamaLoanBinding.chamaErrorText.setText("Should not exceed 300000");
        }
    }
}