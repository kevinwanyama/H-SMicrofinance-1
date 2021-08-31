package com.example.hsmicrofinance.adapters;

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
   public LatestTransactionsBinding mLatestTransactionsBinding;
  public LatestTransactionInterface mLatestTransactionInterface;
    private Context mContext;
    private List<LatestTransaction> mLatestTransactions;
    private LatestTransaction mLatestTransaction;
    private LayoutInflater mLayoutInflater;


    public LatestTransactionAdapter(Context context, List<LatestTransaction> latestTransactions, LatestTransactionInterface latestTransactionInterface) {
        super(LatestTransaction.sItemCallback);
        this.mContext = context;
        this.mLatestTransactions = latestTransactions;
        this.mLatestTransactionInterface = latestTransactionInterface;
    }
    public void setLatestTransactions(List<LatestTransaction> latestTransactions){
        this.mLatestTransactions = latestTransactions;
        notifyDataSetChanged();
    }
    public interface LatestTransactionInterface {
        void onClickTransaction(LatestTransaction latestTransaction);
    }

    @NonNull
    @Override
    public LatestTransactionViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mLatestTransactionsBinding = LatestTransactionsBinding.inflate(mLayoutInflater, parent, false);
        mLatestTransactionsBinding.setLatestTransactionInterface(mLatestTransactionInterface);
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
