package com.olesiavasileva.testtaskforlynx_media.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventsResponse implements Serializable {
    @SerializedName("events")
    @Expose
    private List<EventModel> events;

    public List<EventModel> getEvents() {
        return events;
    }
}
