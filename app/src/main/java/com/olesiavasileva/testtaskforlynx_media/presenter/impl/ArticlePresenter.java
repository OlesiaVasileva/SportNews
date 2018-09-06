package com.olesiavasileva.testtaskforlynx_media.presenter.impl;

import android.util.Log;

import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;
import com.olesiavasileva.testtaskforlynx_media.model.impl.ArticleApi;
import com.olesiavasileva.testtaskforlynx_media.presenter.IArticlePresenter;
import com.olesiavasileva.testtaskforlynx_media.view.IArticleView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Olesia on 04.09.2018.
 */

public class ArticlePresenter implements IArticlePresenter {

    private final ArticleApi model;
    private final IArticleView view;
    public static final String TAG = "MyLogs";

    public ArticlePresenter(IArticleView view) {
        this.view = view;
        model = new ArticleApi();
    }

    @Override
    public void loadArticle(String article) {
        Observable<ArticleModel> dataObservable = model.getArticle(article);
        Log.d(TAG, "dataObservable:" + dataObservable);

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ->
                {
                    view.hideLoadingIndicator();
                    Log.d(TAG, "response:" + response);
                    if (response == null) view.showNoConnectionMessage();
                    else {
                        view.setArticle(response);
                    }
                }, error -> {
                    Log.e(TAG, "error:", error);
                    view.showNoConnectionToTheServer();
                    view.hideLoadingIndicator();
                });
    }
}
