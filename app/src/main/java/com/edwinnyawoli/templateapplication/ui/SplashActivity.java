package com.edwinnyawoli.templateapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(EmptyActivity.intentFor(this, UUID.randomUUID().toString()));
    }
}
