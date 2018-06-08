package com.m00061016.gamenews.Helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit;
    private static final String baseurl = "http://gamenewsuca.herokuapp.com/";

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit;
    }

}
