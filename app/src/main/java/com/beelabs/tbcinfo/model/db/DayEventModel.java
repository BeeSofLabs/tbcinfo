package com.beelabs.tbcinfo.model.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DayEventModel extends RealmObject {
    @PrimaryKey
    private int id;
    private int day;
    private int month;
    private int year;

    private RealmList<EventModel> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public RealmList<EventModel> getEvents() {
        return events;
    }

    public void setEvents(RealmList<EventModel> events) {
        this.events = events;
    }
}
