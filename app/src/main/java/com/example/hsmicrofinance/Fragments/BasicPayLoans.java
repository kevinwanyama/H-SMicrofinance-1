package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBasicPayLoansBinding;


public class BasicPayLoans extends Fragment {
    private static final String TAG = "Payloans";

   FragmentBasicPayLoansBinding mFragmentBasicPayLoansBinding;

    public BasicPayLoans() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicPayLoansBinding = FragmentBasicPayLoansBinding.inflate(inflater,container,false);
        return mFragmentBasicPayLoansBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: "+ "paylaon");
        mFragmentBasicPayLoansBinding.payloanSubmitBtn.setOnClickListener(v-> executePayloan());
    }

    private void executePayloan() {
        if(mFragmentBasicPayLoansBinding.payloanAccountNo.getText().toString().trim().isEmpty() || mFragmentBasicPayLoansBinding.payloanAmount.getText().toString().trim().isEmpty()){
            mFragmentBasicPayLoansBinding.payloanErrorTxt.setText("All fields required");
        }else {
            doPayLoan();
        }
    }

    private void doPayLoan() {
        Toast.makeText(getContext(), "Pay loans", Toast.LENGTH_SHORT).show();
    }
}