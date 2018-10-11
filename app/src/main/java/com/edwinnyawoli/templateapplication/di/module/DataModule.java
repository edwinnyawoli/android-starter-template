package com.edwinnyawoli.templateapplication.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.edwinnyawoli.templateapplication.data.local.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class DataModule {
    @Provides
    @Singleton
    static AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, AppDatabase.NAME).build();
    }
}
