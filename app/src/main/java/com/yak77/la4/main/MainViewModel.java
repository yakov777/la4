package com.yak77.la4.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yak77.la4.BaseViewModel;
import com.yak77.la4.model.NasaService;
import com.yak77.la4.model.Repository;
import com.yak77.la4.model.Result;

import java.util.Arrays;
import java.util.List;

public class MainViewModel extends BaseViewModel {

private Result<List<Repository>> repositoriesResult=Result.empty();
private MutableLiveData<ViewState> stateLiveData = new MutableLiveData<>();

    {updateViewState(Result.success(Arrays.asList(
            new Repository(1,"repo1","name",100),
            new Repository(2,"repo13","name7",300),
            new Repository(3,"repo14","name6",600),
            new Repository(4,"repo15","name4",700)

    )));}

    public MainViewModel(NasaService nasaService, Result<List<Repository>> repositoriesResult) {
        super(nasaService);
        this.repositoriesResult = repositoriesResult;
    }
}

    public LiveData<ViewState> getViewState(){

    return stateLiveData;
}

public void getRepositories(String username) {
        //
}
static class ViewState {
    private boolean enableSearchButton;
    private boolean showList;
    private boolean showEmptyHint;
    private boolean showError;
    private boolean showProgress;
    private List<Repository> repositories;

    public boolean isEnableSearchButton() {
        return enableSearchButton;
    }

    public boolean isShowList() {
        return showList;
    }

    public boolean isShowEmptyHint() {
        return showEmptyHint;
    }

    public boolean isShowError() {
        return showError;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }
}
private void updateViewState(Result<List<Repository>> repositoriesResult)
{
    ViewState state = new ViewState();
    state.enableSearchButton = repositoriesResult.getStatus() != Result.Status.LOADING;
    state.showList = repositoriesResult.getStatus() == Result.Status.SUCCESS;
    state.showEmptyHint = repositoriesResult.getStatus() == Result.Status.EMPTY;
    state.showError = repositoriesResult.getStatus() == Result.Status.ERROR;
    state.showProgress = repositoriesResult.getStatus() == Result.Status.LOADING;
    state.repositories = repositoriesResult.getData();
    stateLiveData.setValue(state);
}
}