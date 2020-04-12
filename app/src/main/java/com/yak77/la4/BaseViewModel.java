package com.yak77.la4;

import androidx.lifecycle.ViewModel;

import com.yak77.la4.model.NasaService;

public class BaseViewModel extends ViewModel {

    private NasaService nasaService;

    public BaseViewModel(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    protected final NasaService getNasaService() {
        return nasaService;
    }
}
