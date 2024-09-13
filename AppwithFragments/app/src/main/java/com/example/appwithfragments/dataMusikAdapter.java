package com.example.appwithfragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataMusikAdapter extends RecyclerView.Adapter<dataMusikAdapter.dataMusicViewHolder> {
    // Mendeklarasikan sebuah variabel untuk menampung arrayList maupun images atau gambar
    ArrayList<dataMusik> arrayListMusic;
    int images[];

    // Membuata Construktor
    public dataMusikAdapter(ArrayList<dataMusik> arrayListMusic, int[] images) {
        this.arrayListMusic = arrayListMusic;
        this.images = images;
    }


    // Implemantasi method sebagai ViewHolder
    @NonNull
    @Override
    public dataMusikAdapter.dataMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_data, parent, false);
        return new dataMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataMusikAdapter.dataMusicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Membuat konstanta untuk mendapatkan posisi indeks dari daftar list
        final dataMusik musik = arrayListMusic.get(position);
        // Menset atau menetapkan nilai kedalam view atau widget yang tersimpan pada ArrayList
        holder.img.setImageResource(images[position]);
        holder.judul.setText(musik.getJudul());
        holder.artist.setText(musik.getArtist());
        //Memberi action pada data list ketika di klik maka akan menanpilkan detail dari list tersebut
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(holder.itemView.getContext(), detailMusik.class);
                intent.putExtra("Musik", musik);
                intent.putExtra("images", images[position]);
                //Menjalankan perpindahan MainActivity ke detailMovie
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    public void filterList(ArrayList<dataMusik> filteredList) {
        arrayListMusic = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return arrayListMusic.size();
    }

    // Membuat class
    public class dataMusicViewHolder extends RecyclerView.ViewHolder {
        TextView judul, artist;
        ImageView img;
        public dataMusicViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_judul);
            artist = itemView.findViewById(R.id.txt_deskripsi);
            img = itemView.findViewById(R.id.picture);
        }
    }
}
