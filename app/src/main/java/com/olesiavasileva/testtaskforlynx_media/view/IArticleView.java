package com.olesiavasileva.testtaskforlynx_media.view;

import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;


/**
 * Created by Olesia on 04.09.2018.
 */

public interface IArticleView {
    void hideLoadingIndicator();
    void showNoConnectionMessage();
    void showNoConnectionToTheServer();
    void setArticle(ArticleModel response);
}
