package com.example.hsmicrofinance.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hsmicrofinance.Network.APIService;
import com.example.hsmicrofinance.Network.RetrofitInstance;
import com.example.hsmicrofinance.entity.InvestmentHistory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestmentHistoryViewModel extends ViewModel {
    private static final String TAG = "Invest";
    public APIService mService;
    public Call<List<InvestmentHistory>>mCall;
    public MutableLiveData<List<InvestmentHistory>>mInvestmentHistoryMutableLiveData;
    public  MutableLiveData<InvestmentHistory>mLiveData = new MutableLiveData<>();


    public InvestmentHistoryViewModel() {
        mInvestmentHistoryMutableLiveData = new MutableLiveData<>();
    }
    public MutableLiveData<List<InvestmentHistory>>getInvestmentHistoryMutableLiveDataObserver(){
        return mInvestmentHistoryMutableLiveData;
    }
    public void makeApiCall(){
        mService = RetrofitInstance.getRetroClient().create(APIService.class);
        mCall = mService.getAllInvestmentHistory();
        mCall.enqueue(new Callback<List<InvestmentHistory>>() {
            @Override
            public void onResponse(Call<List<InvestmentHistory>> call, Response<List<InvestmentHistory>> response) {
                Log.d(TAG, "onResponse: "+ response.body());
                mInvestmentHistoryMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<InvestmentHistory>> call, Throwable t) {
                mInvestmentHistoryMutableLiveData.postValue(null);

            }
        });

    }

    public LiveData<InvestmentHistory>getInvestmentHistory(){
        return mLiveData;
    }
    public void setInvestmentHistory(InvestmentHistory investmentHistory){
        mLiveData.setValue(investmentHistory);
    }
}
