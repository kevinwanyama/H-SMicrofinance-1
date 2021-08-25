package com.example.hsmicrofinance.Viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hsmicrofinance.Network.APIService;
import com.example.hsmicrofinance.Network.RetrofitInstance;
import com.example.hsmicrofinance.entity.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestViewModel extends ViewModel {
    private APIService mService;
    private MutableLiveData<List<Test>>mListMutableLiveData;
    private Call <List<Test>>mCall;

    public TestViewModel() {
        mListMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Test>>getListMutableLiveData(){
        return mListMutableLiveData;
    }
    public void makeAPiCall(){
        mService = RetrofitInstance.getRetroClient().create(APIService.class);
        mCall = mService.getAlltest();
        mCall.enqueue(new Callback<List<Test>>() {
            @Override
            public void onResponse(Call<List<Test>> call, Response<List<Test>> response) {
                mListMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Test>> call, Throwable t) {
             mListMutableLiveData.postValue(null);
            }
        });

    }
}
