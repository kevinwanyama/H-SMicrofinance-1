package com.example.hsmicrofinance.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hsmicrofinance.Network.APIService;
import com.example.hsmicrofinance.Network.RetrofitInstance;
import com.example.hsmicrofinance.entity.Example;
import com.example.hsmicrofinance.entity.LoanPackages;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoanPackageViewModel extends ViewModel {
    private static final String TAG = "LoanPackageViewModel";


    private APIService mAPIService;
    private Call<List<Example>>mCall;
    private MutableLiveData<List<Example>>mListMutableLiveData;

    public LoanPackageViewModel() {
        mListMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Example>>getPackagesObserver(){
        return mListMutableLiveData;
    }

    public void makeAPIcall(){
        mAPIService = RetrofitInstance.getRetroClient().create(APIService.class);
        mCall = mAPIService.getAllLoanPackages();
        mCall.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                mListMutableLiveData.postValue(response.body());
                Log.d(TAG, "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
    }
}
