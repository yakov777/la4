package com.yak77.la4;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

public class App extends Application {
    private ViewModelProvider.Factory viewModelFactory;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public ViewModelProvider.Factory getViewModelFactory(){


    }
}
