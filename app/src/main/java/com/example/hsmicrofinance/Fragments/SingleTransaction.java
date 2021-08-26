package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.viewmodels.LatestTransactionViewModel;
import com.example.hsmicrofinance.databinding.FragmentSingleTransactionBinding;


public class SingleTransaction extends Fragment {

    FragmentSingleTransactionBinding mFragmentSingleTransactionBinding;
    private LatestTransactionViewModel mLatestTransactionViewModel;

    public SingleTransaction() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentSingleTransactionBinding = FragmentSingleTransactionBinding.inflate(inflater,container,false);
        return mFragmentSingleTransactionBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLatestTransactionViewModel = new ViewModelProvider(requireActivity()).get(LatestTransactionViewModel.class);
        mFragmentSingleTransactionBinding.setLatestTransactionViewModel(mLatestTransactionViewModel);

    }
}