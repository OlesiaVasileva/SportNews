package com.olesiavasileva.testtaskforlynx_media.presenter.impl;

import android.util.Log;

import com.olesiavasileva.testtaskforlynx_media.model.impl.EventsApi;
import com.olesiavasileva.testtaskforlynx_media.model.entity.EventsResponse;
import com.olesiavasileva.testtaskforlynx_media.presenter.IEventsPresenter;
import com.olesiavasileva.testtaskforlynx_media.view.IEventsView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventsPresenter implements IEventsPresenter {

    private final EventsApi model;
    private final IEventsView view;
    private static final String TAG = "MyLogs";

    public EventsPresenter(IEventsView view) {
        this.view = view;
        model = new EventsApi();
    }

    @Override
    public void getResponse(String category) {
        Observable<EventsResponse> dataObservable = model.getResponse(category);
        Log.d(TAG, "dataObservable:" + dataObservable);

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ->
                {
                    view.hideLoadingIndicator();
                    Log.d(TAG, "response:" + response);
                    if (response == null) view.showNoConnectionMessage();
                    else {
                        view.setList(response.getEvents());
                    }
                }, error -> {
                    Log.e(TAG, "error:", error);
                    view.showNoConnectionToTheServer();
                    view.hideLoadingIndicator();
                });
    }
}
