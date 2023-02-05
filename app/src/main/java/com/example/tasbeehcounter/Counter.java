package com.example.tasbeehcounter;

import java.util.Date;

public class Counter {
    private int id;
    private String KalmaCount;
    private String DaroodCount;
    private String AstagfarCount;
    private Boolean IsRecited;
    private String Date;

    public Counter(String kalma, String darood, String astagfar, Boolean recited, String date) {
        KalmaCount = kalma;
        DaroodCount = darood;
        AstagfarCount = astagfar;
        IsRecited = recited;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKalmaCount() {
        return KalmaCount;
    }

    public void setKalmaCount(String kalmaCount) {
        KalmaCount = kalmaCount;
    }

    public String getDaroodCount() {
        return DaroodCount;
    }

    public void setDaroodCount(String daroodCount) {
        DaroodCount = daroodCount;
    }

    public String getAstagfarCount() {
        return AstagfarCount;
    }

    public void setAstagfarCount(String astagfarCount) {
        AstagfarCount = astagfarCount;
    }

    public Boolean getRecited() {
        return IsRecited;
    }

    public void setRecited(Boolean recited) {
        IsRecited = recited;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Counter(int id, String kalmaCount, String daroodCount, String astagfarCount, Boolean isRecited, String date) {
        this.id = id;
        KalmaCount = kalmaCount;
        DaroodCount = daroodCount;
        AstagfarCount = astagfarCount;
        IsRecited = isRecited;
        Date = date;
    }


}
