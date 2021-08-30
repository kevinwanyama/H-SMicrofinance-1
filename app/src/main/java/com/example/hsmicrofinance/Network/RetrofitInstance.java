package com.example.hsmicrofinance.Network;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL = "https://whispering-inlet-50206.herokuapp.com/";
    public static String HS_BASE_URL = "https://www.member.hsgroup.tech/api/";
    public static  String Url ="https://jsonplaceholder.typicode.com/";
    private static Retrofit sRetrofit;


    HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();


    public static Retrofit getRetroClient(){
        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(HS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
