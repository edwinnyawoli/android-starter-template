package com.edwinnyawoli.templateapplication;

import android.app.Application;

import com.edwinnyawoli.templateapplication.di.AppComponent;
import com.edwinnyawoli.templateapplication.di.DaggerAppComponent;
import com.edwinnyawoli.templateapplication.log.CrashlyticsTree;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * TODO Add crashlytics support.
 */

public class TemplateApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor.Level loggingLevel;
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            loggingLevel = HttpLoggingInterceptor.Level.BODY;
        } else {
            Timber.plant(new CrashlyticsTree(this));
            loggingLevel = HttpLoggingInterceptor.Level.NONE;
        }

        appComponent = DaggerAppComponent.builder()
                .context(this)
                .loggingLevel(loggingLevel)
                .build();
    }
}
