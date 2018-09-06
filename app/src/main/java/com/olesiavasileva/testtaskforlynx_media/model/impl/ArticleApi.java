package com.olesiavasileva.testtaskforlynx_media.model.impl;

import com.olesiavasileva.testtaskforlynx_media.model.IArticleApi;
import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;

import rx.Observable;

/**
 * Created by Olesia on 04.09.2018.
 */

public class ArticleApi implements IArticleApi {
    private RestApi restApi = RestApi.getInstance();

    @Override
    public Observable<ArticleModel> getArticle(String article) {
        return restApi.getRestApi().getArticle(article);
    }
}
