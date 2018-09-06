package com.olesiavasileva.testtaskforlynx_media.model;

import com.olesiavasileva.testtaskforlynx_media.model.entity.EventsResponse;

import rx.Observable;

/**
 * Created by Olesia on 04.09.2018.
 */

public interface IEventsApi {
    Observable<EventsResponse> getResponse(String category);
}
