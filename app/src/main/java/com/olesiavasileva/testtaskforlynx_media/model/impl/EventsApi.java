package com.olesiavasileva.testtaskforlynx_media.model.impl;

import com.olesiavasileva.testtaskforlynx_media.model.IEventsApi;
import com.olesiavasileva.testtaskforlynx_media.model.entity.EventsResponse;

import rx.Observable;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventsApi implements IEventsApi {

    private RestApi restApi = RestApi.getInstance();

    @Override
    public Observable<EventsResponse> getResponse(String category) {
        return restApi.getRestApi().getList(category);
    }
}
