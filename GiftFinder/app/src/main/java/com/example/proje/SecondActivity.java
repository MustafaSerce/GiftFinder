package com.example.proje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Range;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

TextView textView3;
Spinner spinner;
public static int p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        textView3= findViewById(R.id.textView3);


        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Cevap1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        int tx = (int) position;


   int y = spinner.getCount();

       if ((y==5)&&((tx == 1 ) || (tx==2)||(tx==3)||(tx==4)||(tx==5))){
           p = tx;
            textView3.setText(R.string.soru2);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.Cevap2, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
        }
       else if ((y==3)&&((tx == 1 ) || (tx==2)||(tx==3))){
           textView3.setText(R.string.soru3);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.Cevap3, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
           p+=tx;
       }
       else if ((y==8)&&((tx == 1 ) || (tx==2)||(tx==3)||(tx==4)||(tx==5)||(tx==6)||(tx==7)||(tx==8))) {
           textView3.setText(R.string.soru4);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.Cevap4, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
           p+=tx;
       }
       else if ((y==6)&&((tx == 1 ) || (tx==2)||(tx==3)||(tx==4)||(tx==5)||(tx==6))){
           textView3.setText(R.string.soru5);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.cevap5, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
           p+=tx;
       }
       else if ((y==7)&&((tx == 1 ) || (tx==2)||(tx==3)||(tx==4)||(tx==5)||(tx==6)||(tx==7))){
           Intent gec = new Intent(SecondActivity.this,ThirdActivity.class);
           startActivity(gec);
           p+=tx;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
