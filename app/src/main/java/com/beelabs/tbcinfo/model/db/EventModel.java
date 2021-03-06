package com.beelabs.tbcinfo.model.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EventModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int typeEvent;

    public int getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }
}
