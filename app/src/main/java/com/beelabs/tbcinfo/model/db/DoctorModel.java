package com.beelabs.tbcinfo.model.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DoctorModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String urlAvatar;

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

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
}
