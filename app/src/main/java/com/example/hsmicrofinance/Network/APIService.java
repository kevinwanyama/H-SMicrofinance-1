package com.example.hsmicrofinance.Network;

import com.example.hsmicrofinance.entity.LatestTransaction;
import com.example.hsmicrofinance.entity.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("latestTransaction")
    Call<List<LatestTransaction>>getLatestTransaction();
    @GET("posts")
    Call<List<Test>>getAlltest();
}
