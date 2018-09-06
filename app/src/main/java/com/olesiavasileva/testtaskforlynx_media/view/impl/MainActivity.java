package com.olesiavasileva.testtaskforlynx_media.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.olesiavasileva.testtaskforlynx_media.R;

public class MainActivity extends AppCompatActivity {

    public enum Category {FOOTBALL, HOCKEY, TENNIS, BASKETBALL, VOLLEYBALL, CYBERSPORT}

    public static final String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_football = findViewById(R.id.btn_football);
        Button btn_hockey = findViewById(R.id.btn_hockey);
        Button btn_tennis = findViewById(R.id.btn_tennis);
        Button btn_basketball = findViewById(R.id.btn_basketball);
        Button btn_volleyball = findViewById(R.id.btn_volleyball);
        Button btn_cybersport = findViewById(R.id.btn_cybersport);
        btn_football.setOnClickListener(view -> startNewActivity(Category.FOOTBALL));
        btn_hockey.setOnClickListener(view -> startNewActivity(Category.HOCKEY));
        btn_tennis.setOnClickListener(view -> startNewActivity(Category.TENNIS));
        btn_basketball.setOnClickListener(view -> startNewActivity(Category.BASKETBALL));
        btn_volleyball.setOnClickListener(view -> startNewActivity(Category.VOLLEYBALL));
        btn_cybersport.setOnClickListener(view -> startNewActivity(Category.CYBERSPORT));
    }

    private void startNewActivity(Category category) {
        Log.d(TAG, "category: " + category);
        Intent intent = new Intent(this, EventsActivity.class);
        intent.putExtra(EventsActivity.EXTRA_CATEGORY, category);
        startActivity(intent);
    }
}
