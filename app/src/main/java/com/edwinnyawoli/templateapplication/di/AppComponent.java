package com.edwinnyawoli.templateapplication.di;

import com.edwinnyawoli.templateapplication.TemplateApplication;
import com.edwinnyawoli.templateapplication.di.module.DataModule;
import com.edwinnyawoli.templateapplication.di.module.NetModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 */
@Component(modules = {DataModule.class, NetModule.class})
public interface AppComponent extends AndroidInjector<TemplateApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<TemplateApplication> {
        @BindsInstance
        public abstract Builder loggingLevel(HttpLoggingInterceptor.Level loggingLevel);
    }
}
