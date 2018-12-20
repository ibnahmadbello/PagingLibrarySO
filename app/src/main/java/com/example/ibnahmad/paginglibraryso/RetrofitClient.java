package com.example.ibnahmad.paginglibraryso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "https://api.stackexchange.com/2.2/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }

        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
