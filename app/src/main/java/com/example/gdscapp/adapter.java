package com.example.gdscapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class adapter extends RecyclerView.Adapter {
    Context mainactivity5;



    ArrayList<userhelper> userhelperArrayList;


    public adapter(MainActivity5 mainActivity5, ArrayList<userhelper> userhelperArrayList) {
        this.userhelperArrayList=userhelperArrayList;
        this.mainactivity5=mainactivity5;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainactivity5).inflate(R.layout.differentusers,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder , int position) {

        userhelper users=userhelperArrayList.get(position);

       /* holder.t7.setText(users.name);
        holder.t8.setText(users.domain);
        holder.t9.setText(users.phone);
        holder.t10.setText(users.email);
        holder.t11.setText(users.year);*/
    }


    @Override
    public int getItemCount() {
        return userhelperArrayList.size();
    } class Viewholder extends RecyclerView.ViewHolder {
        TextView t7,t8,t9,t11;
        TextView t10;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            t7=itemView.findViewById(R.id.textview7);
            t8=itemView.findViewById(R.id.textView8);
            t9=itemView.findViewById(R.id.textView9);
            t10=itemView.findViewById(R.id.textView10);
            t11=itemView.findViewById(R.id.textView11);
        }
    }



}