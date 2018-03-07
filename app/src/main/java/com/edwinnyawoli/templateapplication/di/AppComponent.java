package com.edwinnyawoli.templateapplication.di;

import android.content.Context;

import com.edwinnyawoli.templateapplication.di.module.DataModule;
import com.edwinnyawoli.templateapplication.di.module.NetModule;

import dagger.BindsInstance;
import dagger.Component;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 */
@Component(modules = {DataModule.class, NetModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder loggingLevel(HttpLoggingInterceptor.Level loggingLevel);

        AppComponent build();
    }
}
