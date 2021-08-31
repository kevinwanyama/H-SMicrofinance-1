package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBasicLoanPackagesBinding;
import com.example.hsmicrofinance.entity.Example;
import com.example.hsmicrofinance.viewmodels.LoanPackageViewModel;

import java.util.List;


public class BasicLoanPackages extends Fragment {
    private static final String TAG = "BasicLoanPackages";

    FragmentBasicLoanPackagesBinding mFragmentBasicLoanPackagesBinding;
    private NavController mNavController;
    private LoanPackageViewModel mLoanPackageViewModel;

    public BasicLoanPackages() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicLoanPackagesBinding = FragmentBasicLoanPackagesBinding.inflate(inflater, container, false);
        return mFragmentBasicLoanPackagesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);

        mFragmentBasicLoanPackagesBinding.logbookPackageBtn.setOnClickListener(v ->mNavController.navigate(R.id.action_basicLoanPackages_to_logBookLoan));
        mFragmentBasicLoanPackagesBinding.bimaPackageBtn.setOnClickListener(v -> mNavController.navigate(R.id.action_basicLoanPackages_to_bimaLoan));
        mFragmentBasicLoanPackagesBinding.businessPackageBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicLoanPackages_to_businessLoan));
        mFragmentBasicLoanPackagesBinding.kilimoPackageBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicLoanPackages_to_kilimoLoan));
        mFragmentBasicLoanPackagesBinding.personalPackageBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicLoanPackages_to_personalLoan));
        mFragmentBasicLoanPackagesBinding.titleDeedPackageBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicLoanPackages_to_titleDeedLoan));
        mFragmentBasicLoanPackagesBinding.chamaPackageBtn.setOnClickListener(v->mNavController.navigate(R.id.action_basicLoanPackages_to_chamaLoan));

        mLoanPackageViewModel = new ViewModelProvider(requireActivity()).get(LoanPackageViewModel.class);
        try{
            mLoanPackageViewModel.getPackagesObserver().observe(getViewLifecycleOwner(), examples -> Log.d(TAG, "onChanged: " + examples));
            mLoanPackageViewModel.makeAPIcall();
        }catch (Exception e){

            e.printStackTrace();
        }

    }
}