package com.example.appwithfragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.dataViewHolder> {
    // Mendeklarasikan sebuah variabel untuk menampung arrayList maupun images atau gambar, dan context
    String data1[], data2[], data3[];
    int images[];
    Context context;

    // Membuata Construktor
    public dataAdapter(Context ct, String[] s1, String[] s2, String[] s3, int[] img) {
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
    }

    // Implemantasi method sebagai ViewHolder
    @NonNull
    @Override
    public dataAdapter.dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_data, parent, false);
        return new dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataAdapter.dataViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setText(data1[position]);
        holder.txt2.setText(data2[position]);
        holder.img.setImageResource(images[position]);

        //Memberi action pada data list ketika di klik maka akan menanpilkan detail dari list tersebut
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detailBuku.class);
                intent.putExtra("data1", data1[position]);//men-set data berdasarkan posisi
                intent.putExtra("data2", data3[position]);//men-set data berdasarkan posisi
                intent.putExtra("images", images[position]);//men-set data berdasarkan posisi
                //Menjalankan perpindahan MainActivity ke detailFood
                context.startActivity(intent);
            }
        });
    }

    public void filterList(String[] filteredJudul, String[] filteredGenre, String[] filteredDetail, int[] filteredImages) {
        data1 = filteredJudul;
        data2  = filteredGenre;
        data3 = filteredDetail;
        images = filteredImages;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return images.length;
    }

    // Membuat class
    public class dataViewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2;
        ImageView img;
        public dataViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt_judul);
            txt2 = itemView.findViewById(R.id.txt_deskripsi);
            img = itemView.findViewById(R.id.picture);
        }
    }
}
