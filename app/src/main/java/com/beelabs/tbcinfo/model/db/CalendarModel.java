package com.beelabs.tbcinfo.model.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by arysuryawan on 2/15/18.
 */

public class CalendarModel extends RealmObject {
    @PrimaryKey
    private int id;
    private long date;
    private String name;
    private boolean status;
    private boolean delete;
    private RealmList<Integer> eventId;

    public int getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public RealmList<Integer> getEventId() {
        return eventId;
    }

    public void setEventId(RealmList<Integer> eventId) {
        this.eventId = eventId;
    }
}
