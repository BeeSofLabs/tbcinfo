package com.beelabs.tbcinfo.model.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArticleModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String resourceUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
