package com.example.proje;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

public class Hatirlatici extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static UserDb userDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatirlatici_olustur);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
        userDb = Room.databaseBuilder(getApplicationContext(),UserDb.class,"UserDb").allowMainThreadQueries().build();


    }
}
