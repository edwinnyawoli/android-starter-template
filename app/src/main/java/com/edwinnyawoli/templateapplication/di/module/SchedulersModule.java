package com.edwinnyawoli.templateapplication.di.module;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
@Module
public class SchedulersModule {
    @Provides
    static Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @IO
    static Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Computation
    static Scheduler providesComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Trampoline
    static Scheduler providesTrampolineScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Single
    static Scheduler providesSingleScheduler() {
        return Schedulers.single();
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface IO {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Computation {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Trampoline {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Single {
    }
}
