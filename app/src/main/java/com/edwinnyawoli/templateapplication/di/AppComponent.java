package com.edwinnyawoli.templateapplication.di;

import com.edwinnyawoli.templateapplication.TemplateApplication;
import com.edwinnyawoli.templateapplication.di.module.ActivityModule;
import com.edwinnyawoli.templateapplication.di.module.DataModule;
import com.edwinnyawoli.templateapplication.di.module.FragmentModule;
import com.edwinnyawoli.templateapplication.di.module.NetModule;
import com.edwinnyawoli.templateapplication.di.module.SchedulersModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
        FragmentModule.class,
        DataModule.class,
        NetModule.class,
        SchedulersModule.class}
)
public interface AppComponent extends AndroidInjector<TemplateApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<TemplateApplication> {
        @BindsInstance
        public abstract Builder loggingLevel(HttpLoggingInterceptor.Level loggingLevel);
    }
}
