package com.example.proje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<ThirdActivityDesign> mThirdActivityDesign;
    public GiftAdapter (Context ct , ArrayList<ThirdActivityDesign> ThirdActivityDesign){

       mContext = ct;
        mThirdActivityDesign = ThirdActivityDesign;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(mContext).inflate(R.layout.thirdactivitydesign,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ThirdActivityDesign currentıtem = mThirdActivityDesign.get(position);

        String ImageUrl = currentıtem.getImageUrl();
        String Giftname = currentıtem.getGiftname();

        holder.mtextGiftname.setText(Giftname);
        Picasso.with(mContext).load(ImageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mThirdActivityDesign.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mtextGiftname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imagegift);
            mtextGiftname = itemView.findViewById(R.id.giftnametxt);


        }
    }
}
