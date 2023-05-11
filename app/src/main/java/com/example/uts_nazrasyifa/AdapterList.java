package com.example.uts_nazrasyifa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    private List<ItemList> ItemList;
    public AdapterList(List<ItemList> ItemList) { this.ItemList = ItemList;}

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {
        ItemList item = ItemList.get(position);
        holder.Judul.setText(item.getJudul());
        holder.Subjudul.setText(item.getSubjudul());
        holder.Waktu.setText(item.getWaktu());
        Glide.with(holder.imageView.getContext()).load(item.getImage()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return ItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView Judul,Subjudul,Waktu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageUrl);
            Judul = itemView.findViewById(R.id.title);
            Subjudul = itemView.findViewById(R.id.deskripsi);
            Waktu = itemView.findViewById(R.id.jam);
        }
    }
}





