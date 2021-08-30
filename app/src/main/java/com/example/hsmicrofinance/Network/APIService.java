package com.example.hsmicrofinance.Network;

import com.example.hsmicrofinance.entity.Example;
import com.example.hsmicrofinance.entity.InvestmentHistory;
import com.example.hsmicrofinance.entity.LatestTransaction;
import com.example.hsmicrofinance.entity.LoanPackages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("getAll")
    Call<List<LatestTransaction>>getLatestTransaction();
    @GET("getInvestment")
    Call<List<InvestmentHistory>>getAllInvestmentHistory();
    @GET("loan-package")
    Call<List<Example>>getAllLoanPackages();
}
