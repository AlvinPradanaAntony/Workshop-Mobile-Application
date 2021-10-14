package com.example.appwithfragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detailFilm extends AppCompatActivity {

    //membuat sebuah variabel
    ImageView img;
    TextView judul, deskripsiFIlm;
    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);  // Menggunakan layout pada "detail_film" sebagai content View yang akan di tampilkan ke pengguna

        // Menacri elemen widget yang dibutuhkan berdasarkan id untuk nantinya di masukkan sebuah data
        img = findViewById(R.id.detail_pictureFilm);
        judul = findViewById(R.id.detail_judulFilm);
        deskripsiFIlm = findViewById(R.id.deskripsifilm);

        // Memanggil sebuah method getData untuk mendapatkan data dari sebuah Array
        getData();
        // Menetapkan data atau nilai yang sudah di ambil dari array untuk di masukkan kedalam komponen widget
        setData();
    }

    // Membuat sebuah method untuk mendapatkan data Attay
    private void getData(){
        dataFIlm film = getIntent().getParcelableExtra("Film");
        data1 = film.getJudul();
        data2 = film.getDiskripsiFilm();
        if(getIntent().hasExtra("images")){ //Terdapat sebuah kondisi dimana jika images sama dengan yang diinputkan maka aksi atau statementnya akan dijalankan
            images = getIntent().getIntExtra("images", 1); //aksi akan menampung dalam variabel image
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show(); //jika tidak sesuai kondisi diatas maka akan menampilkan No data.
        }
    }
    // Membuat sebuah method untuk menetapkan nilai pada variabel-variabel yang diperlukan
    private void setData(){
        judul.setText(data1); // Menampilkan judul Film pada detail film
        deskripsiFIlm.setText(data2); // Menampilkan deskripsi film tersebut
        img.setImageResource(images); // Menampilkan gambar Film
    }
}
