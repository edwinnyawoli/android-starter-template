package com.edwinnyawoli.templateapplication.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.edwinnyawoli.templateapplication.data.model.TestModel;

/**
 *
 */

@Database(entities = {TestModel.class}, version = AppDatabase.VERSION)
public abstract class AppDatabase extends RoomDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "TemplateDB";
}
