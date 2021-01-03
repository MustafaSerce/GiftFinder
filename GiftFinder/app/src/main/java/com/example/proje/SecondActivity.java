package com.example.proje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;


public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    InterstitialAd interstitialAd;
    SharedPreferences myPreferences;
TextView questtext;
Spinner spinner;
public static int p=0 ;
public static int px =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        questtext= findViewById(R.id.questiontitle);


        HwAds.init(this);

        myPreferences = getSharedPreferences("my_setting", MODE_PRIVATE);
        increaseCounterValue();

        if(getCounterValue() == 3) {
            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdId("testw6vs28auh3");
            interstitialAd.setAdListener(adListener);

            loadBannerAd();
            setCounterValue(0);
        }
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reply1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }
    public int getCounterValue(){
        return myPreferences.getInt("counter", 0);
    }

    public void increaseCounterValue() {
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putInt("counter", getCounterValue() + 1);
        editor.commit();
    }

    public void setCounterValue(int value) {
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putInt("counter", value);
        editor.commit();
    }

    public void loadBannerAd(){

        BannerView bannerView = new BannerView(this);
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_DYNAMIC);
        LinearLayout rootView = findViewById(R.id.scndactivity);
        rootView.addView(bannerView);
        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);
    }

    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Toast.makeText(SecondActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
            showInterstitial();
        }

        @Override
        public void onAdFailed(int errorCode) {
            Toast.makeText(SecondActivity.this, "Ad load failed with error code: " + errorCode,
                    Toast.LENGTH_SHORT).show();
            Log.d("TAG", "Ad load failed with error code: " + errorCode);
        }

        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Log.d("TAG", "onAdClosed");
        }

        @Override
        public void onAdClicked() {
            Log.d("TAG", "onAdClicked");
            super.onAdClicked();
        }

        @Override
        public void onAdOpened() {
            Log.d("TAG", "onAdOpened");
            super.onAdOpened();
        }
    };

    private void showInterstitial() {
        // Display an interstitial ad.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        int tx = (int)position;


   int y = spinner.getCount();

       if ((y==5)&&((tx == 1 ) || (tx==2)||(tx==3)||(tx==4)||(tx==5))){
            questtext.setText(R.string.question2);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.reply2, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);

        }
       else if ((y==3)&&( (tx==1)||(tx==2)||(tx==3))){
           questtext.setText(R.string.question3);
           ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                   R.array.reply3, android.R.layout.simple_spinner_item);
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(adapter);
           px+=tx;
           p+=tx;
       }
       else if ((y==4)&&( (tx==1)||(tx==2)||(tx==3))||(tx==4)){
           p+=tx;
           Intent gec = new Intent(SecondActivity.this,ThirdActivity.class);
           startActivity(gec);
       }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
