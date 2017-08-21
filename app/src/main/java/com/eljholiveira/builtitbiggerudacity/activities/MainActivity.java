package com.eljholiveira.builtitbiggerudacity.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eljholiveira.builtitbiggerudacity.fragments.MainFragment;
import com.eljholiveira.builtitbiggerudacity.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MainFragment.newInstance())
                .commit();
    }
}
