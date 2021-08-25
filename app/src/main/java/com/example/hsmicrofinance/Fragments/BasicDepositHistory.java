package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.Adapters.TestAdapter;
import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.Viewmodels.TestViewModel;
import com.example.hsmicrofinance.databinding.FragmentBasicDepositHistoryBinding;
import com.example.hsmicrofinance.entity.Test;

import java.util.List;


public class BasicDepositHistory extends Fragment {

    FragmentBasicDepositHistoryBinding mFragmentBasicDepositHistoryBinding;
    private RecyclerView mRecyclerView;
    public List<Test> mTestList;
    private TestAdapter mTestAdapter;
    private TestViewModel mTestViewModel;

    public BasicDepositHistory() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicDepositHistoryBinding = FragmentBasicDepositHistoryBinding.inflate(inflater,container,false);
        return mFragmentBasicDepositHistoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = mFragmentBasicDepositHistoryBinding.testhistory;
        mTestAdapter = new TestAdapter(getContext());
        mRecyclerView.setAdapter(mTestAdapter);

        mTestViewModel = new ViewModelProvider(requireActivity()).get(TestViewModel.class);
        mTestViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                mTestList = tests;
                mTestAdapter.submitList(tests);
                mTestAdapter.setHistory(tests);

            }
        });
        mTestViewModel.makeAPiCall();
    }
}