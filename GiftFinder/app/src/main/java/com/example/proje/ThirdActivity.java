package com.example.proje;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.proje.SecondActivity.p;

public class ThirdActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView rw2;
    String t1[];
    int t2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        //textView = findViewById(R.id.textView4);
        //textView.setText(new String(String.valueOf(p)));
        rw2 = findViewById(R.id.rw2);

        t1 = Hatirlatici.userDb.giftDao().getGiftname();
        t2 = Hatirlatici.userDb.giftDao().getGiftid();

        GiftAdapter giftAdapter= new GiftAdapter(this, t1,t2);
        rw2.setAdapter(giftAdapter);
        rw2.setLayoutManager(new LinearLayoutManager(this));

}
}
