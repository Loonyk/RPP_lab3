package com.example.rpp_lab3.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true) int id;
    String FIO;
    Date time_add;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Date getTime_add() {
        return time_add;
    }

    public void setTime_add(Date time_add) {
        this.time_add = time_add;
    }
}
