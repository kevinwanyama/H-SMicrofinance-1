package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hsmicrofinance.adapters.LatestTransactionAdapter;
import com.example.hsmicrofinance.viewmodels.LatestTransactionViewModel;
import com.example.hsmicrofinance.databinding.FragmentBasicDashboardBinding;
import com.example.hsmicrofinance.entity.LatestTransaction;

import java.util.List;
import com.example.hsmicrofinance.R;



public class BasicDashboard extends Fragment implements LatestTransactionAdapter.LatestTransactionInterface {
    private static final String TAG = "BasicDashboard";
    FragmentBasicDashboardBinding mFragmentBasicDashboardBinding;
    private RecyclerView mRecyclerView;
    private LatestTransactionAdapter mAdapter;
    private List<LatestTransaction>mLatestTransactions;
    private LatestTransactionViewModel mLatestTransactionViewModel;
    private NavController mNavController;

    public BasicDashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicDashboardBinding = FragmentBasicDashboardBinding.inflate(inflater, container, false);
        return mFragmentBasicDashboardBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = mFragmentBasicDashboardBinding.latestTransactionRecyclerview;
        mAdapter = new LatestTransactionAdapter(getContext(),mLatestTransactions,this);
        mRecyclerView.setAdapter(mAdapter);
        mNavController = Navigation.findNavController(view);


        mLatestTransactionViewModel = new ViewModelProvider(requireActivity()).get(LatestTransactionViewModel.class);
        mLatestTransactionViewModel.getLatestTransactionObserver().observe(getViewLifecycleOwner(), new Observer<List<LatestTransaction>>() {
            @Override
            public void onChanged(List<LatestTransaction> latestTransactions) {
                mLatestTransactions = latestTransactions;
                mAdapter.submitList(latestTransactions);
                mAdapter.setLatestTransactions(latestTransactions);
            }
        });
        mLatestTransactionViewModel.makeAPIcall();



    }

    @Override
    public void onClickTransaction(LatestTransaction latestTransaction) {
        Log.d(TAG, "onClickTransaction: "+ latestTransaction.toString());
    mLatestTransactionViewModel.setLatestTransaction(latestTransaction);
    mNavController.navigate(R.id.action_basicDashboard_to_singleTransaction);
    }
}