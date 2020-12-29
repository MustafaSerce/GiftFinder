package com.example.proje;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Gift")
public class Gift {
    @PrimaryKey (autoGenerate = true)
    private int giftid;

    @ColumnInfo (name = "gift_name")
    private String giftname;

    public int getGiftid() {
        return giftid;
    }

    public void setGiftid(int giftid) {
        this.giftid = giftid;
    }

    public String getGiftname() {
        return giftname;
    }

    public void setGiftname(String giftname) {
        this.giftname = giftname;
    }
}
