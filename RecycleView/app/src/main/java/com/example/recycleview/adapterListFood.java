package com.example.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterListFood extends RecyclerView.Adapter<adapterListFood.FoodViewHolder>{
    ArrayList<dataFood> arrayListFood;

    public adapterListFood(ArrayList<dataFood> arrayListFood) {
        this.arrayListFood = arrayListFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        // Membuat konstanta untuk mendapatkan posisi indeks dari daftar list
        final dataFood food = arrayListFood.get(position);
        // Menset atau menetapkan nilai kedalam view atau widget yang tersimpan pada ArrayList
        holder.nama.setText(food.getNama());
        holder.rating.setText(String.valueOf(food.getRating()));
        holder.level.setText(food.getLevel());

        //Memberi action pada data list ketika di klik maka akan menanpilkan detail dari list tersebut
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(holder.itemView.getContext(), detailFood.class);
                intent.putExtra("Food", food);
                //Menjalankan perpindahan MainActivity ke detailFood
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    public void filterList(ArrayList<dataFood> filteredList) {
        arrayListFood = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { //Mendapatkan jumlah data dari ArrayList
        return arrayListFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        //Mendeklarasikan sebuah widget atau view didalam layout item.xml
        TextView nama, rating, level;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.nama);
            rating = itemView.findViewById(R.id.rating);
            level = itemView.findViewById(R.id.level);
        }
    }
}
