package com.edwinnyawoli.templateapplication.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;

/**
 *
 */

@Entity
@Data
public class TestModel {
    @PrimaryKey
    private long id;
}
