package com.example.hsmicrofinance.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hsmicrofinance.Network.APIService;
import com.example.hsmicrofinance.Network.RetrofitInstance;
import com.example.hsmicrofinance.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpViewModel {


    private APIService mApiService;
    private Call<List<User>> mCall;
    private MutableLiveData<List<User>> mUserMutableLiveData;
    MutableLiveData<User>mLiveData = new MutableLiveData<>();

    public MutableLiveData<List<User>> getUserObserver(){
        return  mUserMutableLiveData;
    }
    public void signUp(){
        mApiService = RetrofitInstance.getRetroClient().create(APIService.class);
        mCall = mApiService.getUser();
        mCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mUserMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mUserMutableLiveData.postValue(null);
            }
    });
    }

    public LiveData<User> getUser(){
        return mLiveData;
    }
    public void setLatestTransaction(User user){
        mLiveData.setValue(user);
    }
}
