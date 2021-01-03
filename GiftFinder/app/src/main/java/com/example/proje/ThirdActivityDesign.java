package com.example.proje;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.proje.SecondActivity.p;

public class ThirdActivityDesign
{
    private String mImageUrl;
    private String mGiftname;



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
