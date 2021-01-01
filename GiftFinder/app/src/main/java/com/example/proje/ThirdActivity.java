package com.example.proje;

import android.os.Bundle;

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


public class ThirdActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private GiftAdapter mGiftAdapter;
    private ArrayList<ThirdActivityDesign> mThirdActivityDesigns;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

        recyclerView = findViewById(R.id.rw2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mThirdActivityDesigns = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url ="https://raw.githubusercontent.com/MustafaSerce/test/main/md.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("Gift");
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
