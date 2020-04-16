package com.example.myapplication;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class GymAdapter extends RecyclerView.Adapter<GymAdapter.GymViewHolder> {
    ArrayList<Gym> gyms;

    public GymAdapter (ArrayList<Gym> gyms){
        this.gyms = gyms;
    }

    public class GymViewHolder extends RecyclerView.ViewHolder{
        EditText edtV;
        EditText edtC;
        TextView desc;

        public GymViewHolder (View view){
            super(view);

            edtV = (EditText) view.findViewById(R.id.edtV);
            edtC = (EditText) view.findViewById(R.id.edtC);
            desc = (TextView) view.findViewById(R.id.desc);

        }
    }

    @NonNull
    @Override
    public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_gym, parent, false);
        return new GymViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GymViewHolder holder, int position) {
        holder.desc.setText(gyms.get(position).getDesc());
        holder.edtV.setText(String.valueOf(gyms.get(position).getEdtV()));
        holder.edtC.setText(String.valueOf(gyms.get(position).getEdtC()));

    }


    @Override
    public int getItemCount() {
        return gyms.size();
    }
}
