package com.example.hsmicrofinance.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL = "http://192.168.100.58:3000/";
    public static  String Url ="https://jsonplaceholder.typicode.com/";
    private static Retrofit sRetrofit;
    public static Retrofit getRetroClient(){
        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
