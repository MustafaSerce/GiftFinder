package com.example.proje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
TextView textView3;
Spinner spinner;
public static int p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        textView3= findViewById(R.id.textView3);



        // HMS Ads Servinin tetikliyoruz.
        HwAds.init(this);

        // Banner Ad example


        myPreferences = getSharedPreferences("my_setting", MODE_PRIVATE);
        increaseCounterValue();
        Toast.makeText(this, getCounterValue() + " kez actınız...", Toast.LENGTH_SHORT).show();
        if(getCounterValue() == 3) {
            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdId("testw6vs28auh3");
            interstitialAd.setAdListener(adListener);

            loadBannerAd();
            setCounterValue(0);
        }
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Cevap1, android.R.layout.simple_spinner_item);
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

        // Kode uzerınden bır abnner ad view yaratıyoruz
        BannerView bannerView = new BannerView(this);
        // Ad Id: Sızın tekıl reklam idniz. Bu id sayesinde reklamın size ait oldugu anlasılıyor ve reklamla ılgılı ayarlar cekılıyor.
        bannerView.setAdId("testw6vs28auh3");
        // Reklamın Boyutunu ayarlıyoruz
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_DYNAMIC);

        // Reklamın gosterileceği layouta erişiyoruz
        LinearLayout rootView = findViewById(R.id.scndactivity);
        // Reklam viewini bu layout içine ekliyoruz
        rootView.addView(bannerView);


        // Ads Parameter objesini olustur
        AdParam adParam = new AdParam.Builder().build();
        // Reklamın gosterılmesını tetıklıyoruz.
        bannerView.loadAd(adParam);
    }

    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Toast.makeText(SecondActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
            // Display an interstitial ad.
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
