package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentSingleInvestmentHistoryBinding;
import com.example.hsmicrofinance.viewmodels.InvestmentHistoryViewModel;


public class SingleInvestmentHistory extends Fragment {


FragmentSingleInvestmentHistoryBinding mFragmentSingleInvestmentHistoryBinding;
    private InvestmentHistoryViewModel mInvestmentHistoryViewModel;

    public SingleInvestmentHistory() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentSingleInvestmentHistoryBinding = FragmentSingleInvestmentHistoryBinding.inflate(inflater,container,false);
        return mFragmentSingleInvestmentHistoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInvestmentHistoryViewModel = new ViewModelProvider(requireActivity()).get(InvestmentHistoryViewModel.class);
        mFragmentSingleInvestmentHistoryBinding.setInvestHistoryViewModel(mInvestmentHistoryViewModel);
    }
}