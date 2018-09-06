package com.olesiavasileva.testtaskforlynx_media.view.impl;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.olesiavasileva.testtaskforlynx_media.R;
import com.olesiavasileva.testtaskforlynx_media.model.entity.EventModel;
import com.olesiavasileva.testtaskforlynx_media.presenter.impl.EventsPresenter;
import com.olesiavasileva.testtaskforlynx_media.presenter.IEventsPresenter;
import com.olesiavasileva.testtaskforlynx_media.view.IEventsView;

import java.util.List;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventsActivity extends AppCompatActivity implements IEventsView {

    public static final String EXTRA_CATEGORY = "category";
    private IEventsPresenter presenter;
    private ProgressBar progressBar;
    private EventsRecyclerAdapter adapter;
    private List<EventModel> events;

    public static final String TAG = "MyLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        init();
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected()) {
            if (presenter == null) {
                presenter = new EventsPresenter(this);
            }
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String category = bundle.get(EXTRA_CATEGORY).toString().toLowerCase();
                progressBar.setVisibility(View.VISIBLE);
                presenter.getResponse(category, false);
            }
        } else {
            showNoConnectionMessage();
        }
    }

    private void init() {
        progressBar = findViewById(R.id.events_progressBar);
        RecyclerView recyclerView = findViewById(R.id.rvEvents);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new EventsRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(EventsActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String article = events.get(position).getArticle();
                        startNewActivity(article);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private void startNewActivity(String article) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra(ArticleActivity.EXTRA_ARTICLE, article);
        startActivity(intent);
    }

    @Override
    public void hideLoadingIndicator() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoConnectionMessage() {
        Log.d(TAG, "Подключите интернет");
        Toast.makeText(EventsActivity.this, R.string.turn_on_internet, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoConnectionToTheServer() {
        Log.d(TAG, "Hет соединения с сервером");
        Toast.makeText(EventsActivity.this, R.string.no_connection_to_the_server, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setList(List<EventModel> events) {
        this.events = events;
        Log.d(TAG, "events_set " + events);
        adapter.setEvents(events);
    }
}