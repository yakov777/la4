package com.yak77.la4.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yak77.la4.R;
import com.yak77.la4.details.DetailsActivity;

public class MainActivity extends AppCompatActivity {
private Button searchButton;
private RecyclerView repositoriesList;
private EditText usernameEditText;
private ProgressBar progress;
private TextView emptyTextView;
private TextView errorTextView;
private MainViewModel viewModel;
private RepositoriesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchButton);
        repositoriesList = findViewById(R.id.repositoriesList);
        usernameEditText = findViewById(R.id.usernameEditText);
        progress = findViewById(R.id.progress);
        emptyTextView = findViewById(R.id.emptyTextView);
        errorTextView = findViewById(R.id.errorTextView);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(MainViewModel.class);
        viewModel.getViewState().observe(this, state -> {
            searchButton.setEnabled(state.isEnableSearchButton());
            repositoriesList.setVisibility(toVisibility(state.isShowList()));
progress.setVisibility(toVisibility(state.isShowProgress()));
emptyTextView.setVisibility(toVisibility(state.isShowEmptyHint()));
errorTextView.setVisibility(toVisibility(state.isShowError()));
adapter.setRepositories(state.getRepositories());
        });
        searchButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
viewModel.getRepositories(username);
        });
        initRepositoriesList();
    }
    private void initRepositoriesList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        repositoriesList.setLayoutManager(layoutManager);
        adapter = new RepositoriesAdapter(repository -> {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(DetailsActivity.EXTRA_REPOSITORY_ID, repository.getId());
            startActivity(intent);
        });
        repositoriesList.setAdapter(adapter);
    }

    static int toVisibility(boolean show) {
        return show ? View.VISIBLE : View.GONE;
    }

}
