package com.beelabs.tbcinfo.model.db;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String gender;
    private String city;
    private Date startMedicine;
    private String tbType;
    private int progressPercentage;


}
