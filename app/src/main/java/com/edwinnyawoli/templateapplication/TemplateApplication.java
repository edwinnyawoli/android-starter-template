package com.edwinnyawoli.templateapplication;

import android.app.Application;

import timber.log.Timber;

/**
 *
 */

public class TemplateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
    }
}
