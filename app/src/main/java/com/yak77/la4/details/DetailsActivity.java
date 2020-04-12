package com.yak77.la4.details;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.yak77.la4.R;

public class DetailsActivity  extends AppCompatActivity {

    public static final String EXTRA_REPOSITORY_ID = "REPOSITORY_ID";
    private TextView nameTextView;
    private TextView descriptionTextView;
private DetailsViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nameTextView = findViewById(R.id.nameTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        long repositoryId = getIntent().getLongExtra(EXTRA_REPOSITORY_ID, -1);
        if (repositoryId == -1){
            throw new RuntimeException("There is no repository ID");
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(DetailsViewModel.class);
    }
}
