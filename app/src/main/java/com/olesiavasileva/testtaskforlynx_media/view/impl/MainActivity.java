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
        Button btnFootball = findViewById(R.id.btn_football);
        Button btnHockey = findViewById(R.id.btn_hockey);
        Button btnTennis = findViewById(R.id.btn_tennis);
        Button btnBasketball = findViewById(R.id.btn_basketball);
        Button btnVolleyball = findViewById(R.id.btn_volleyball);
        Button btnCybersport = findViewById(R.id.btn_cybersport);
        btnFootball.setOnClickListener(view -> startNewActivity(Category.FOOTBALL));
        btnHockey.setOnClickListener(view -> startNewActivity(Category.HOCKEY));
        btnTennis.setOnClickListener(view -> startNewActivity(Category.TENNIS));
        btnBasketball.setOnClickListener(view -> startNewActivity(Category.BASKETBALL));
        btnVolleyball.setOnClickListener(view -> startNewActivity(Category.VOLLEYBALL));
        btnCybersport.setOnClickListener(view -> startNewActivity(Category.CYBERSPORT));
    }

    private void startNewActivity(Category category) {
        Log.d(TAG, "category: " + category);
        Intent intent = new Intent(this, EventsActivity.class);
        intent.putExtra(EventsActivity.EXTRA_CATEGORY, category);
        startActivity(intent);
    }
}
