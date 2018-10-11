package com.edwinnyawoli.templateapplication.di.module;

import com.edwinnyawoli.templateapplication.data.remote.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    static Api provideApi(Gson gson, OkHttpClient okHttpClient,
                          @Api.BaseUrl String baseUrl,
                          @SchedulersModule.IO Scheduler ioScheduler) {
        Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(ioScheduler))
                .client(okHttpClient)
                .build();
        return retrofitBuilder.create(Api.class);
    }

    @Provides
    static Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    @Provides
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor.Level loggingLevel) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.addInterceptor(new HttpLoggingInterceptor().setLevel(loggingLevel))
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(18, TimeUnit.SECONDS)
                .build();
    }
}
