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

public class dataFilmAdapter extends RecyclerView.Adapter<dataFilmAdapter.dataFilmViewHolder> {
    // Mendeklarasikan sebuah variabel untuk menampung arrayList maupun images atau gambar
    ArrayList<dataFIlm> arrayListFilm;
    int images[];

    // Membuata Construktor
    public dataFilmAdapter(ArrayList<dataFIlm> arrayListFilm, int[] images) {
        this.arrayListFilm = arrayListFilm;
        this.images = images;
    }

    // Implemantasi method sebagai ViewHolder
    @NonNull
    @Override
    public dataFilmAdapter.dataFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_data, parent, false);
        return new dataFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataFilmAdapter.dataFilmViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Membuat konstanta untuk mendapatkan posisi indeks dari daftar list
        final dataFIlm film = arrayListFilm.get(position);
        // Menset atau menetapkan nilai kedalam view atau widget yang tersimpan pada ArrayList
        holder.img.setImageResource(images[position]);
        holder.judul.setText(film.getJudul());
        holder.releaseDate.setText(film.getReleaseDate());
        //Memberi action pada data list ketika di klik maka akan menanpilkan detail dari list tersebut
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(holder.itemView.getContext(), detailFilm.class);
                intent.putExtra("Film", film);
                intent.putExtra("images", images[position]);
                //Menjalankan perpindahan MainActivity ke detailMovie
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public void filterList(ArrayList<dataFIlm> filteredList) {
        arrayListFilm = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return arrayListFilm.size();
    }

    // Membuat class
    public class dataFilmViewHolder extends RecyclerView.ViewHolder {
        TextView judul, releaseDate;
        ImageView img;
        public dataFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_judul);
            releaseDate = itemView.findViewById(R.id.txt_deskripsi);
            img = itemView.findViewById(R.id.picture);
        }
    }
}
