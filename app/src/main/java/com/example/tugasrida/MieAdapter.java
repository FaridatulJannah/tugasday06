package com.example.tugasrida;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MieAdapter extends RecyclerView.Adapter<MieAdapter.ViewHolder>{

    private ArrayList<MieModel> mieModel;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public MieAdapter(ArrayList<MieModel> mieModel) {

        this.mieModel = mieModel;
    }

    @NonNull
    @Override
    public MieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MieAdapter.ViewHolder holder, int position) {

        holder.gambarMie.setImageResource(mieModel.get(holder.getAdapterPosition()).getGambarMie());
        holder.namaMie.setText(mieModel.get(holder.getAdapterPosition()).getNamaMie());
        holder.descMie.setText(mieModel.get(holder.getAdapterPosition()).getDescMie());
        holder.hargaMie.setText(mieModel.get(holder.getAdapterPosition()).getHargaMie());

    }

    @Override
    public int getItemCount() {

        return mieModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaMie, descMie, hargaMie;
        ImageView gambarMie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMie = itemView.findViewById(R.id.namaMie);
            descMie = itemView.findViewById(R.id.descMie);
            hargaMie = itemView.findViewById(R.id.HargaMie);
            gambarMie = itemView.findViewById(R.id.gambarMie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && mListener != null) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}