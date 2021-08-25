package com.example.hsmicrofinance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hsmicrofinance.databinding.TestBinding;
import com.example.hsmicrofinance.entity.LatestTransaction;
import com.example.hsmicrofinance.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends ListAdapter<Test,TestAdapter.TestHolder> {
    public Context mContext;
    public List<Test> mTests;
    private Test mTest;
    private LayoutInflater mLayoutInflater;
    TestBinding mTestBinding;

    public TestAdapter(Context context) {
        super(Test.sItemCallback);
        mContext=context;

    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mTestBinding = TestBinding.inflate(mLayoutInflater,parent,false);
        return new TestHolder(mTestBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        mTest = getItem(position);
        holder.mTestBinding.setTest(mTest);
        holder.mTestBinding.executePendingBindings();
    }

    public void setHistory(List<Test> test){
        mTests = test;
        notifyDataSetChanged();
    }

    class TestHolder extends RecyclerView.ViewHolder{
TestBinding mTestBinding;
        public TestHolder(TestBinding binding) {
            super(binding.getRoot());
            this.mTestBinding = binding;
        }
    }
}
