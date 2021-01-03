package com.example.proje;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;

import static com.example.proje.SecondActivity.p;
import static com.example.proje.SecondActivity.px;


public class ThirdActivity extends AppCompatActivity  {


    private RecyclerView recyclerView;
    private GiftAdapter mGiftAdapter;
    private ArrayList<ThirdActivityDesign> mThirdActivityDesigns;
    private RequestQueue mRequestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

        Toast.makeText(ThirdActivity.this,"p"+p,Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.rw2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mThirdActivityDesigns = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }



    private void parseJSON() {
        String url ="https://raw.githubusercontent.com/ahmetsaiderdem/Resimler/main/deneme3232.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,




                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        JSONArray jsonArray;
                        String ArrayName="";
                        if (px==2&&p==3){
                            p=6;
                        }
                        else if(px==2&&p==4){
                            p=7;
                        }

                        try {
                                switch (p)
                                {

                                    case 2:
                                        ArrayName="Gift1";
                                        p=0;
                                        px=0;

                                        break;
                                    case 3:
                                        ArrayName="Gift3";
                                        p=0;
                                        px=0;
                                        break;

                                    case 4:
                                        ArrayName="Gift2";
                                        p=0;
                                        px=0;
                                        break;
                                    case 5:
                                        ArrayName="Gift5";
                                        p=0;
                                        px=0;
                                        break;
                                    case 6:
                                        ArrayName="Gift4";
                                        p=0;
                                        px=0;
                                        break;
                                    case 7:
                                        ArrayName="Gift6";
                                        p=0;
                                        px=0;
                                        break;


                                }
                            jsonArray = response.getJSONArray(ArrayName);
                            for (int i =0; i <jsonArray.length();i++){
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String Giftname =hit.getString("name");
                                String iimageurl = hit.getString("url");
                                mThirdActivityDesigns.add(new ThirdActivityDesign(iimageurl,Giftname));

                            }


                            mGiftAdapter = new GiftAdapter(ThirdActivity.this,mThirdActivityDesigns);
                            recyclerView.setAdapter(mGiftAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
