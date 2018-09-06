package com.olesiavasileva.testtaskforlynx_media.view.impl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olesiavasileva.testtaskforlynx_media.R;
import com.olesiavasileva.testtaskforlynx_media.model.entity.EventModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.ViewHolder> {

    private List<EventModel> events = Collections.emptyList();

    void setEvents(List<EventModel> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventsRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsRecyclerAdapter.ViewHolder holder, int position) {
        EventModel eventModel = events.get(position);
        holder.title.setText(eventModel.getTitle());
        holder.coefficient.setText(eventModel.getCoefficient());
        holder.time.setText(eventModel.getTime());
        holder.place.setText(eventModel.getPlace());
        holder.preview.setText(eventModel.getPreview());

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView coefficient;
        private TextView time;
        private TextView place;
        private TextView preview;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.event_title);
            coefficient = itemView.findViewById(R.id.event_coefficient);
            time = itemView.findViewById(R.id.event_time);
            place = itemView.findViewById(R.id.event_place);
            preview = itemView.findViewById(R.id.event_preview);
        }
    }
}
