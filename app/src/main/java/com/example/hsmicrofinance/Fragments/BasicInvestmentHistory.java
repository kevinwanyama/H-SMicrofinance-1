package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.adapters.InvestmentHistoryAdapter;
import com.example.hsmicrofinance.databinding.FragmentBasicInvestmentHistoryBinding;
import com.example.hsmicrofinance.entity.InvestmentHistory;
import com.example.hsmicrofinance.viewmodels.InvestmentHistoryViewModel;

import java.util.List;


public class BasicInvestmentHistory extends Fragment implements InvestmentHistoryAdapter.InvestmentHistoryInterface {
    private static final String TAG = "BasicInvestmentHistory";
    FragmentBasicInvestmentHistoryBinding mFragmentBasicInvestmentHistoryBinding;
    private RecyclerView mRecyclerView;
    private List<InvestmentHistory>mInvestmentHistoryList;
    private InvestmentHistoryAdapter mAdapter;
    private NavController mNavController;
    private InvestmentHistoryViewModel mInvestmentHistoryViewModel;

    public BasicInvestmentHistory() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicInvestmentHistoryBinding = FragmentBasicInvestmentHistoryBinding.inflate(inflater,container,false);
        return mFragmentBasicInvestmentHistoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = mFragmentBasicInvestmentHistoryBinding.investmenthistoryRecycler;
        mAdapter = new InvestmentHistoryAdapter(getContext(),mInvestmentHistoryList,this);
        mRecyclerView.setAdapter(mAdapter);

        mNavController = Navigation.findNavController(view);

        mInvestmentHistoryViewModel = new ViewModelProvider(requireActivity()).get(InvestmentHistoryViewModel.class);
        mInvestmentHistoryViewModel.getInvestmentHistoryMutableLiveDataObserver().observe(getViewLifecycleOwner(), new Observer<List<InvestmentHistory>>() {
            @Override
            public void onChanged(List<InvestmentHistory> investmentHistoryList) {
                mInvestmentHistoryList = investmentHistoryList;
                mAdapter.submitList(investmentHistoryList);
                mAdapter.setInvestmentHistory(investmentHistoryList);
            }
        });
        mInvestmentHistoryViewModel.makeApiCall();

    }

    @Override
    public void onClickInvestment(InvestmentHistory investmentHistory) {
        Log.d(TAG, "onClickInvestment: "+ investmentHistory.toString());
        mInvestmentHistoryViewModel.setInvestmentHistory(investmentHistory);
        mNavController.navigate(R.id.action_basicInvestmentHistory_to_singleInvestmentHistory);

    }
}