package com.example.proje;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class KisilerFragment extends Fragment {



    public String s1[], s2[];
    public int s3[];

    RecyclerView rw;


    public KisilerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kisiler, container, false);

        rw = view.findViewById(R.id.rw1);

        s1 = Hatirlatici.userDb.userDao().getUsers();
        s2 = Hatirlatici.userDb.userDao().getsUsers();
        s3 = Hatirlatici.userDb.userDao().getssUsers();


        MyAdapter myAdapter = new MyAdapter(this.requireContext(),s1,s2,s3);
        rw.setAdapter(myAdapter);

        rw.setLayoutManager(new LinearLayoutManager(this.requireContext()));




        return view;
    }




}