package com.olesiavasileva.testtaskforlynx_media.view;

import com.olesiavasileva.testtaskforlynx_media.model.entity.EventModel;

import java.util.List;

/**
 * Created by Olesia on 04.09.2018.
 */

public interface IEventsView {
    void hideLoadingIndicator();
    void showNoConnectionMessage();
    void showNoConnectionToTheServer();
    void setList(List<EventModel> events);
}
