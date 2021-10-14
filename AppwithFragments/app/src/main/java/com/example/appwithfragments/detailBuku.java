package com.example.appwithfragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detailBuku extends AppCompatActivity {

    //membuat sebuah variabel
    ImageView img;
    TextView judul, detailBuku;
    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_buku); // Menggunakan layout pada "detail_buku" sebagai content View yang akan di tampilkan ke pengguna

        // Menacri elemen widget yang dibutuhkan berdasarkan id untuk nantinya di masukkan sebuah data
        img = findViewById(R.id.detail_picture);
        judul = findViewById(R.id.detail_judul);
        detailBuku = findViewById(R.id.detail_buku);

        // Memanggil sebuah method getData untuk mendapatkan data dari sebuah Array
        getData();
        // Menetapkan data atau nilai yang sudah di ambil dari array untuk di masukkan kedalam komponen widget
        setData();
    }

    // Membuat sebuah method untuk mendapatkan data Attay
    private void getData(){
        if(getIntent().hasExtra("images") && getIntent().hasExtra("data1" )&& getIntent().hasExtra("data2")){ //membuat sebuah kondisi dimana jika image, title dan description sama dengan yang diinputkan maka akan membuat sebuauh aksi seperti dibawah
            data1 = getIntent().getStringExtra("data1"); //aksi akan menampung dalam variabel data1
            data2 = getIntent().getStringExtra("data2"); //aksi akan menampung dalam variabel data2
            images = getIntent().getIntExtra("images", 1); //aksi akan menampung dalam variabel image
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show(); //jika tidak sesuai kondisi diatas maka akan menampilkan No data.
        }
    }
    // Membuat sebuah method untuk menetapkan nilai pada variabel-variabel yang diperlukan
    private void setData(){
        judul.setText(data1); //akan menampilkan title berdasarkan apa yang ditampung di variabel data1
        detailBuku.setText(data2); //akan menampilkan description berdasarkan apa yang ditampung di variabel data2
        img.setImageResource(images); //akan menampilkan mainImageView berdasarkan apa yang ditampung di variabel image
    }
}
