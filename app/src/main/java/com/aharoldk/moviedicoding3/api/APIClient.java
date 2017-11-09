package com.aharoldk.moviedicoding3.api;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String TAG = APIClient.class.getSimpleName();

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static Retrofit retrofit = null;

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {

        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG, message);
            }
        });
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .addInterceptor(getHttpLoggingInterceptor())
                .build();
    }

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
