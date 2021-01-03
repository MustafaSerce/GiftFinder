package com.example.proje;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String d1[],d2[];
    Context fr;

    int d3[];



    public MyAdapter (Context ct , String s1[], String s2[] , int s3[]){

        fr = ct;
        d1 = s1;
        d2 = s2;
        d3 = s3;
     }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



             LayoutInflater inflater= LayoutInflater.from(fr.getApplicationContext());
        View view = inflater.inflate(R.layout.orginalkisiler,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.btn.setText("Note : "+d1[position]+"\n "+"Date : "+d2[position]);
        holder.btn.setId(d3[position]);
        }


    @Override
    public int getItemCount() {
        return d1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Button btn;


        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.noteitemtext);






            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = new User();
                    user.setId(btn.getId());
                    Hatirlatici.userDb.userDao().deleteUser(user);
                    Toast.makeText(fr.getApplicationContext(),"Succesfully Deleted.",Toast.LENGTH_SHORT).show();
                }
            });

        }



    }
}
