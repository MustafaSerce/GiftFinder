package com.example.proje;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.proje.SecondActivity.p;

public class ThirdActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        textView = findViewById(R.id.textView4);
        textView.setText(new String(String.valueOf(p)));
}
}
