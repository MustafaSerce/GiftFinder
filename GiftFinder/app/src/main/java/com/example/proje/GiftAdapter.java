package com.example.proje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.MyViewHolder> {



    String k1[];
    int k2[];
    Context ThirdActivity;
    public GiftAdapter (Context ct , String t1[], int t2[]){

        ThirdActivity = ct;
        k1 = t1;
        k2 = t2;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ThirdActivity);
        View view = inflater.inflate(R.layout.thirdactivitydesign,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.btn1.setText("GiftID :" +k2[position]+" GiftName : "+k1[position]);
    }

    @Override
    public int getItemCount() {
        return k1.length;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        Button btn1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            btn1 = itemView.findViewById(R.id.btngifttxt);
        }
    }
}
