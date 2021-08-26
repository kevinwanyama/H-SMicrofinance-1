package com.example.hsmicrofinance.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hsmicrofinance.databinding.InvestmentHistoryItemBinding;
import com.example.hsmicrofinance.entity.InvestmentHistory;

import java.util.List;

public class InvestmentHistoryAdapter extends ListAdapter<InvestmentHistory, InvestmentHistoryAdapter.HistoryHolder> {
    private Context mContext;
    private List<InvestmentHistory> mInvestmentHistoryList;
    private LayoutInflater mLayoutInflater;
    private InvestmentHistoryItemBinding mInvestmentHistoryItemBinding;
    private InvestmentHistory mInvestmentHistory;
    private InvestmentHistoryInterface mInvestmentHistoryInterface;

    public InvestmentHistoryAdapter(Context context, List<InvestmentHistory>investmentHistoryList,InvestmentHistoryInterface investmentHistoryInterface) {
        super(InvestmentHistory.sItemCallback);
        this.mInvestmentHistoryList=investmentHistoryList;
        this.mContext = context;
        this.mInvestmentHistoryInterface  = investmentHistoryInterface;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mInvestmentHistoryItemBinding = InvestmentHistoryItemBinding.inflate(mLayoutInflater,parent,false);
        mInvestmentHistoryItemBinding.setInvestmenthistoryInterface(mInvestmentHistoryInterface);
        return new HistoryHolder(mInvestmentHistoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        mInvestmentHistory = getItem(position);
        holder.mInvestmentHistoryItemBinding.setInvestmenthistory(mInvestmentHistory);
        holder.mInvestmentHistoryItemBinding.executePendingBindings();

    }
    public void setInvestmentHistory(List<InvestmentHistory>investmentHistory){
        this.mInvestmentHistoryList = investmentHistory;
        notifyDataSetChanged();
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        InvestmentHistoryItemBinding mInvestmentHistoryItemBinding;
        public HistoryHolder(InvestmentHistoryItemBinding binding) {
            super(binding.getRoot());
            this.mInvestmentHistoryItemBinding = binding;
        }
    }
    public interface InvestmentHistoryInterface{
        void onClickInvestment(InvestmentHistory investmentHistory);
    }
}
