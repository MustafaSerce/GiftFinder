package com.example.proje;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;


@Entity (tableName = "users")
public class User  {
    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo (name = "user_name")
    private String name;



    @ColumnInfo (name = "user_date")
    private String date;



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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
