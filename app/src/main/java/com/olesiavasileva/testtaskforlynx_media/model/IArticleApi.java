package com.olesiavasileva.testtaskforlynx_media.model;

import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;

import rx.Observable;

/**
 * Created by Olesia on 04.09.2018.
 */

public interface IArticleApi {
    Observable<ArticleModel> getArticle(String article);
}
