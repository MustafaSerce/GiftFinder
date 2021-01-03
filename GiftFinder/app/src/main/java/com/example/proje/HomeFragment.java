package com.example.proje;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button buttonaddnote,noteviewbutton;


    public HomeFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        buttonaddnote = view.findViewById(R.id.buttonaddnote);
        buttonaddnote.setOnClickListener(this);

        noteviewbutton = view.findViewById(R.id.noteviewbutton);
        noteviewbutton.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonaddnote:
            Hatirlatici.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()).addToBackStack(null).commit();
            break;
            case R.id.noteviewbutton:
                Hatirlatici.fragmentManager.beginTransaction().replace(R.id.fragment_container,new KisilerFragment()).addToBackStack(null).commit();

        }


    }
}