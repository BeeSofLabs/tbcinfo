package com.beelabs.tbcinfo.model.dao;

import com.beelabs.tbcinfo.model.db.ArticleModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.beelabs.com.codebase.base.BaseDao;

public class ArticleDao extends BaseDao {

    private static String[] dataArticle = new String[] {
            "Tutorial Penggunaan Apps",
            "Apa itu Tuberkulosis?",
            "Mengenal Tuberkulosis di Indonesia"
    };

    public static List<ArticleModel> buildArticleList() {
        Calendar cal = Calendar.getInstance();

        List<ArticleModel> list = new ArrayList();
        for(String title : dataArticle) {
            ArticleModel model = new ArticleModel(cal.getTimeInMillis(), title, "");
            list.add(model);
        }


        return list;
    }
}
