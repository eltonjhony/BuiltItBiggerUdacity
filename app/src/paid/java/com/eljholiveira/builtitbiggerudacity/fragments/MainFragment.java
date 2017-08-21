package com.eljholiveira.builtitbiggerudacity.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eljholiveira.androidjokelib.DisplayJokeActivity;
import com.eljholiveira.builtitbiggerudacity.R;
import com.eljholiveira.builtitbiggerudacity.tasks.JokesAsyncTask;

/**
 * Created by eltonjhony on 19/08/17.
 */

public class MainFragment extends Fragment implements JokesAsyncTask.OnLoadJokesListener {

    private Button showJokeButton;
    private ProgressBar progressBar;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        showJokeButton = view.findViewById(R.id.show_joke_button);
        progressBar = view.findViewById(R.id.progress_bar);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JokesAsyncTask(MainFragment.this).execute();
            }
        });
    }

    @Override
    public void onStartRequest() {
        showLoading(true);
    }

    @Override
    public void onSuccess(String joke) {
        showLoading(false);
        DisplayJokeActivity.start(MainFragment.this.getContext(), joke);
    }

    @Override
    public void onError(String message) {
        showLoading(false);
        Toast.makeText(MainFragment.this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void showLoading(boolean show) {
        if (show) {
            showJokeButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            showJokeButton.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}
