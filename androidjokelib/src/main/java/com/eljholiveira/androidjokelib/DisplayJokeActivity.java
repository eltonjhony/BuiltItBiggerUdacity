package com.eljholiveira.androidjokelib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by eltonjhony on 19/08/17.
 */

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String NEW_JOKE_EXTRA = "NEW_JOKE";

    public static void start(Context context, String joke) {
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra(NEW_JOKE_EXTRA, joke);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        String joke = getIntent().getStringExtra(NEW_JOKE_EXTRA);

        TextView jokeView = (TextView) findViewById(R.id.joke_view);
        jokeView.setText(joke);
    }
}
