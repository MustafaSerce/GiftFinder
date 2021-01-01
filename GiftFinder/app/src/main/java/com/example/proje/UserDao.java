package com.example.proje;

import android.widget.ArrayAdapter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User users);

    @Query("Select user_name from users")
    public String[] getUsers();



    @Query("Select user_date from users")
    public String[] getsUsers();



    @Query("Select id from users")
    public int[] getssUsers();

    @Delete
    public void deleteUser(User user);


}
