package com.example.proje;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;



public class AddUserFragment extends Fragment {



private EditText dateText,noteText;
private Button addNoteButton;
DatePickerDialog.OnDateSetListener setListener;


    public AddUserFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        noteText = view.findViewById(R.id.notetext);
        dateText = view.findViewById(R.id.datetext);

        addNoteButton = view.findViewById(R.id.addnotebutton);





        dateText.setOnClickListener(new View.OnClickListener() {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
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

                StringBuilder sonuc2 = new StringBuilder();
                Calendar cx = Calendar.getInstance();
                cx.set(year,month,dayOfMonth);
                sonuc2.append(year).append("-").append(month+1).append("-").append(dayOfMonth);



                dateText.setText("");
                dateText.setText(sonuc2);


              /*  long diffInMillisec =cx.getTimeInMillis() - c.getTimeInMillis();
                long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillisec);
                long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillisec);
                long diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMillisec);
                long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
                final String cıktı2 = String.format("%S",diffInMillisec);
                txtwc.setText(cıktı2);
                int pushtime = (int) diffInMillisec;*/

                //FARK 604800000 (7 GÜN) oldugunda pushlayacaktı :(.
            }

        };



        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String username = noteText.getText().toString();
                    String userdate = dateText.getText().toString();

                    User user = new User();
                    user.setName(username);
                    user.setDate(userdate);
                    Hatirlatici.userDb.userDao().addUser(user);
                    Toast.makeText(getActivity(), "Başarıyla Eklendi", Toast.LENGTH_SHORT).show();

                    noteText.setText("");
                    dateText.setText("");
                }
        });
        return view;
    }
    }