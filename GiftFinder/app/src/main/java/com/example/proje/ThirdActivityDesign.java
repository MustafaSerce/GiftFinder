package com.example.proje;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.proje.SecondActivity.p;

public class ThirdActivityDesign extends AppCompatActivity
{
    private String mImageUrl;
    private String mGiftname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(ThirdActivityDesign.this,"p"+p,Toast.LENGTH_SHORT).show();
    }

    public  ThirdActivityDesign(String ImageUrl , String Giftname){

        mImageUrl=ImageUrl;
        mGiftname = Giftname;
    }



    public String getImageUrl(){
        return mImageUrl;
    }

    public String getGiftname(){
        return mGiftname;
    }

}
