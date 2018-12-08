package com.beelabs.tbcinfo.model.dao;

import android.content.Context;

import com.beelabs.tbcinfo.model.db.UserModel;

import app.beelabs.com.codebase.base.BaseDao;

public class UserDao extends BaseDao {
    private static BaseDao.Database db;

    public UserModel getUser(Context context){
        db = BaseDao.Database.initDatabase(context);

        return (UserModel) db.getCollectionRealm(UserModel.class).first();
    }

    public void saveUser(UserModel model, Context context){
        db.saveToRealm(model);
    }

    public void updateUser(UserModel model, Context context){
        db.deleteRealm(UserModel.class);


    }
}
