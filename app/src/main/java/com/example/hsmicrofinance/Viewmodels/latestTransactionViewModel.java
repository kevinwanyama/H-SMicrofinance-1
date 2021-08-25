package com.example.hsmicrofinance.Viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hsmicrofinance.entity.LatestTransaction;
import com.example.hsmicrofinance.Network.APIService;
import com.example.hsmicrofinance.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class latestTransactionViewModel extends ViewModel {

    private APIService mApiService;
    private Call<List<LatestTransaction>> mCall;
    private MutableLiveData<List<LatestTransaction>> mLatestTransactionMutableLiveData;

    public latestTransactionViewModel() {
        mLatestTransactionMutableLiveData = new MutableLiveData<>();

    }
    public MutableLiveData<List<LatestTransaction>> getLatestTransactionObserver(){
        return  mLatestTransactionMutableLiveData;
    }
    public void makeAPIcall(){
        mApiService = RetrofitInstance.getRetroClient().create(APIService.class);
        mCall = mApiService.getLatestTransaction();
        mCall.enqueue(new Callback<List<LatestTransaction>>() {
            @Override
            public void onResponse(Call<List<LatestTransaction>> call, Response<List<LatestTransaction>> response) {
                mLatestTransactionMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LatestTransaction>> call, Throwable t) {
                mLatestTransactionMutableLiveData.postValue(null);
            }
        });
    }
}
