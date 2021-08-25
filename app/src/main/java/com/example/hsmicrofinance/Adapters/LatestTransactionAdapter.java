package com.example.hsmicrofinance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hsmicrofinance.entity.LatestTransaction;
import com.example.hsmicrofinance.databinding.LatestTransactionsBinding;

import java.util.List;

public class LatestTransactionAdapter extends ListAdapter<LatestTransaction,LatestTransactionAdapter.LatestTransactionViewholder> {
    LatestTransactionsBinding mLatestTransactionsBinding;
    private Context mContext;
    private List<LatestTransaction> mLatestTransactions;
    private LatestTransaction mLatestTransaction;
    private LayoutInflater mLayoutInflater;

    public LatestTransactionAdapter(Context context, List<LatestTransaction> latestTransactions) {
        super(LatestTransaction.sItemCallback);
        this.mContext = context;
        this.mLatestTransactions = latestTransactions;
    }
    public void setLatestTransactions(List<LatestTransaction> latestTransactions){
        this.mLatestTransactions = latestTransactions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LatestTransactionViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mLatestTransactionsBinding = LatestTransactionsBinding.inflate(mLayoutInflater, parent, false);
        return new LatestTransactionViewholder(mLatestTransactionsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestTransactionViewholder holder, int position) {
        mLatestTransaction = getItem(position);
        holder.mLatestTransactionsBinding.setLatestTransaction(mLatestTransaction);
        holder.mLatestTransactionsBinding.executePendingBindings();


    }

     class LatestTransactionViewholder extends RecyclerView.ViewHolder {
        LatestTransactionsBinding mLatestTransactionsBinding;

        public LatestTransactionViewholder(@NonNull LatestTransactionsBinding binding) {
            super(binding.getRoot());
            this.mLatestTransactionsBinding = binding;

        }
    }
}
