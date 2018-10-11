package com.edwinnyawoli.templateapplication.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.edwinnyawoli.templateapplication.domain.model.TestModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TestModelEntity extends TestModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @Override
    public int getId() {
        return id;
    }
}
