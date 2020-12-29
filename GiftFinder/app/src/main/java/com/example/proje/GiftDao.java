package com.example.proje;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GiftDao {
    @Insert
    public void addGift(Gift gift);

    @Query("Select gift_name from Gift")
    public String[] getGiftname();

    @Query("Select giftid from Gift")
    public int[] getGiftid();
}
