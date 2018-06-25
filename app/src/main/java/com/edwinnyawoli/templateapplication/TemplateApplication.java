package com.edwinnyawoli.templateapplication;

import com.edwinnyawoli.templateapplication.di.DaggerAppComponent;
import com.edwinnyawoli.templateapplication.log.CrashlyticsTree;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 *
 */

public class TemplateApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        HttpLoggingInterceptor.Level loggingLevel;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            loggingLevel = HttpLoggingInterceptor.Level.BODY;
        } else {
            Timber.plant(new CrashlyticsTree(this));
            loggingLevel = HttpLoggingInterceptor.Level.NONE;
        }

        return DaggerAppComponent.builder()
                .loggingLevel(loggingLevel)
                .create(this);
    }
}
