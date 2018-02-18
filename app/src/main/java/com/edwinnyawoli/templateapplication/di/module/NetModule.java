package com.edwinnyawoli.templateapplication.di.module;

import com.edwinnyawoli.templateapplication.data.LoggingInterceptor;
import com.edwinnyawoli.templateapplication.data.remote.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
@Module
public class NetModule {
    @Provides
    @Singleton
    static ApiService provideActioService(Gson gson, OkHttpClient okHttpClient, @ApiService.BaseUrl String baseUrl) {
        Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofitBuilder.create(ApiService.class);
    }

    @Provides
    static Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    @Provides
    static OkHttpClient provideOkHttpClient(@LoggingInterceptor Interceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }
}
