package com.example.proje;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Gift.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {
    public  abstract UserDao userDao();
    public abstract GiftDao giftDao();
}
