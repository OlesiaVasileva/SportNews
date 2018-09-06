package com.olesiavasileva.testtaskforlynx_media.model.impl;

import com.olesiavasileva.testtaskforlynx_media.model.IRestService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Olesia on 04.09.2018.
 */

public class RestApi {

    private static RestApi instance;

    private RestApi() {
    }

    static RestApi getInstance() {
        if (instance == null) {
            instance = new RestApi();
        }
        return instance;
    }

    IRestService getRestApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" http://mikonatoruri.win/?")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IRestService.class);
    }
}
