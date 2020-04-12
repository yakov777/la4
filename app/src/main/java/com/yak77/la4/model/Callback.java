package com.yak77.la4.model;

public interface Callback<T> {
    void onError(Throwable error);
    void onResult(T data);
    void onSuccess();
}
