package com.example.proje;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.style.TtsSpan;
import android.text.style.TtsSpan.TimeBuilder;
import android.transition.Scene;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class AddUserFragment extends Fragment {
private EditText nametxt,tarhitxt;
private Button savebtn;
private  TextView txtwc;



    private TextView txtcalender;
    DatePickerDialog.OnDateSetListener setListener;


    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        nametxt = view.findViewById(R.id.nametxt);
        tarhitxt = view.findViewById(R.id.tarihtxt);
        txtwc = view.findViewById(R.id.txtwc);


        final StringBuilder sonuc2 = new StringBuilder();


         final Calendar c = Calendar.getInstance();
         final int year = c.get(Calendar.YEAR);
         final int month = c.get(Calendar.MONTH);
         final int day = c.get(Calendar.DAY_OF_MONTH);



        tarhitxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                         AddUserFragment.this.requireContext(), android.R.style.Theme,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Calendar cx = Calendar.getInstance();
                cx.set(year,month,dayOfMonth);
                sonuc2.append(year).append("-").append(month+1).append("-").append(dayOfMonth);



                tarhitxt.setText("");
                tarhitxt.setText(sonuc2);


                long diffInMillisec =c.getTimeInMillis()+ - +cx.getTimeInMillis();
                long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillisec);
                long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillisec);
                long diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMillisec);
                long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
                final String cıktı2 = String.format("%S",diffInMillisec);
                txtwc.setText(cıktı2);

                //FARK 604800000 (7 GÜN) oldugunda pushlayacak.
            }

        };

        savebtn = view.findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nametxt.getText().toString();
                String userdate =  tarhitxt.getText().toString();


                User user = new User();
                user.setName(username);
                user.setDate(userdate);
                Hatirlatici.userDb.userDao().addUser(user);
                Toast.makeText(getActivity(),"Başarıyla Eklendi",Toast.LENGTH_SHORT).show();

                nametxt.setText("");
                tarhitxt.setText("");


            }
        });
        return view;






    }



}