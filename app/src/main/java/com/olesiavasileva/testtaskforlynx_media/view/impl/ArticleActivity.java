package com.olesiavasileva.testtaskforlynx_media.view.impl;

import android.content.Context;
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
import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;
import com.olesiavasileva.testtaskforlynx_media.presenter.IArticlePresenter;
import com.olesiavasileva.testtaskforlynx_media.presenter.impl.ArticlePresenter;
import com.olesiavasileva.testtaskforlynx_media.view.IArticleView;


/**
 * Created by Olesia on 04.09.2018.
 */

public class ArticleActivity extends AppCompatActivity implements IArticleView {

    public static final String EXTRA_ARTICLE = "article";

    private IArticlePresenter presenter;
    private ProgressBar progressBar;
    private ArticleRecyclerAdapter adapter;

    public static final String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_screen);
        progressBar = findViewById(R.id.article_progressBar);
        RecyclerView recyclerView = findViewById(R.id.rvArticle);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ArticleRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected()) {
            if (presenter == null) {
                presenter = new ArticlePresenter(this);
            }
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String article = bundle.get(EXTRA_ARTICLE).toString().toLowerCase();
                progressBar.setVisibility(View.VISIBLE);
                presenter.loadArticle(article);
            }
        } else {
            showNoConnectionMessage();
        }
    }

    @Override
    public void hideLoadingIndicator() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoConnectionMessage() {
        Log.d(TAG, "Подключите интернет");
        Toast.makeText(ArticleActivity.this, R.string.turn_on_internet, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNoConnectionToTheServer() {
        Log.d(TAG, "Hет соединения с сервером");
        Toast.makeText(ArticleActivity.this, R.string.no_connection_to_the_server, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void setArticle(ArticleModel response) {
        adapter.setArticle(response);
    }
}
