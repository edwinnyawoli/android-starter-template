package com.edwinnyawoli.templateapplication.data.repository;

import com.edwinnyawoli.templateapplication.data.remote.Api;

import javax.inject.Inject;

/**
 *
 */

public class TestModelRepository {

    private Api api;

    @Inject
    public TestModelRepository(Api api) {
        this.api = api;
    }
}
