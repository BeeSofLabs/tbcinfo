package com.beelabs.tbcinfo.model.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArticleModel extends RealmObject {

    @PrimaryKey
    private long id;
    private String title;
    private String resourceUrl;

    public ArticleModel() {
    }

    public ArticleModel(long id, String title, String resourceUrl) {
        this.id = id;
        this.title = title;
        this.resourceUrl = resourceUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
