package com.beelabs.tbcinfo.model.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String gender;
    private long dob;
    private String city;
    private long diagnosaDate;
    private int minuteAlarm;
    private int secondAlarm;
    private String pathAlarm;
    private boolean aggreeTA;
    private RealmList<ScheduleModel> calendars;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getDiagnosaDate() {
        return diagnosaDate;
    }

    public void setDiagnosaDate(long diagnosaDate) {
        this.diagnosaDate = diagnosaDate;
    }


    public int getMinuteAlarm() {
        return minuteAlarm;
    }

    public void setMinuteAlarm(int minuteAlarm) {
        this.minuteAlarm = minuteAlarm;
    }

    public int getSecondAlarm() {
        return secondAlarm;
    }

    public void setSecondAlarm(int secondAlarm) {
        this.secondAlarm = secondAlarm;
    }

    public String getPathAlarm() {
        return pathAlarm;
    }

    public void setPathAlarm(String pathAlarm) {
        this.pathAlarm = pathAlarm;
    }

    public boolean isAggreeTA() {
        return aggreeTA;
    }

    public void setAggreeTA(boolean aggreeTA) {
        this.aggreeTA = aggreeTA;
    }

    public RealmList<ScheduleModel> getCalendars() {
        return calendars;
    }

    public void setCalendars(RealmList<ScheduleModel> calendars) {
        this.calendars = calendars;
    }
}
