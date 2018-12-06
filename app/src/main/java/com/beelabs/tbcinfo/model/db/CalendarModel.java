package com.beelabs.tbcinfo.model.db;

import io.realm.RealmObject;

/**
 * Created by arysuryawan on 2/15/18.
 */

public class CalendarModel extends RealmObject {
    private int id;
    private long date;
    private String name;
    private boolean status;
    private boolean delete;
    private int childID;

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

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }
}
