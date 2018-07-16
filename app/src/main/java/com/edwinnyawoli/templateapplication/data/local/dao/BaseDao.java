package com.edwinnyawoli.templateapplication.data.local.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 *
 */

public interface BaseDao<T> {
    @Insert
    long insert(T data);

    @Update
    int update(T data);

    @Insert
    List<Long> insertAll(T... args);

    @Delete
    int delete(T data);

    @Delete
    int deleteAll(T... args);
}
