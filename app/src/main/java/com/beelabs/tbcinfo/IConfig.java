package com.beelabs.tbcinfo;

public interface IConfig {

    String[] daylabels = new String[]{
            "Monday_Senin",
            "Tuesday_Selasa",
            "Wednesday_Rabu",
            "Thursday_Kamis",
            "Friday_Jumat",
            "Saturday_Sabtu",
            "Sunday_Minggu"
    };

    String[] monthLabels = new String[]{
            "January_Januari",
            "February_Februari",
            "March_Maret",
            "April_April",
            "May_Mei",
            "June_Juni",
            "July_Juli",
            "August_Agustus",
            "September_September",
            "October_Oktober",
            "November_November",
            "December_Desember"
    };


    // Session
    String SESSION_LOGIN_KEY = "session_login";
    String SESSION_CREDENTIAL_KEY = "credential";

    String KEY_FIRST_INSTALL = "first_install";
}
