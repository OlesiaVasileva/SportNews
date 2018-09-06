package com.olesiavasileva.testtaskforlynx_media.model;


import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;
import com.olesiavasileva.testtaskforlynx_media.model.entity.EventsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Olesia on 04.09.2018.
 */

public interface IRestService {
    @GET("list.php")
    Observable<EventsResponse> getList(@Query(value = "category")
                                               String category);

    @GET("post.php")
    Observable<ArticleModel> getArticle(@Query(value = "article")
                                                String article);
}
