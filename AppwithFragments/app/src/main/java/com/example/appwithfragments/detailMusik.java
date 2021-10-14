package com.example.appwithfragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detailMusik extends AppCompatActivity {

    //membuat sebuah variabel
    ImageView img;
    TextView judul, liriklagu, artist;
    String data1, data2, data3;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_musik); // Menggunakan layout pada "detail_musik" sebagai content View yang akan di tampilkan ke pengguna

        // Menacri elemen widget yang dibutuhkan berdasarkan id untuk nantinya di masukkan sebuah data
        img = findViewById(R.id.detail_pictureMusik);
        judul = findViewById(R.id.detail_judulMusik);
        artist = findViewById(R.id.detail_artist);
        liriklagu = findViewById(R.id.liriklagu);

        // Memanggil sebuah method getData untuk mendapatkan data dari sebuah Array
        getData();
        // Menetapkan data atau nilai yang sudah di ambil dari array untuk di masukkan kedalam komponen widget
        setData();
    }

    // Membuat sebuah method untuk mendapatkan data Attay
    private void getData(){
        dataMusik musik = getIntent().getParcelableExtra("Musik");
        data1 = musik.getJudul();
        data2 = musik.getLiriklagu();
        data3 = musik.getArtist();
        if(getIntent().hasExtra("images")){ //Terdapat sebuah kondisi dimana jika images sama dengan yang diinputkan maka aksi atau statementnya akan dijalankan
            images = getIntent().getIntExtra("images", 1); //statement akan menampung dalam variabel image
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show(); //Menampilkan sebuah pemberitahuan "No Data" dengan Toast jika tidak memenuhi sebuah kondisis tersebut
        }
    }
    // Membuat sebuah method untuk menetapkan nilai pada variabel-variabel yang diperlukan
    private void setData(){
        judul.setText(data1); //Outputnya adalah menampilan judul karena parameter dari setText tersebut menyimpan data judul yang di ambil dari method getData()
        liriklagu.setText(data2); //Outputnya adalah menampilan lirik lagu yang datanya diambil dari data Array-List dengan bantuan method getLirikLagu()
        artist.setText(data3); // Outputnya akan menampilkan data artis penyanyi pada detail musik
        img.setImageResource(images); //Outputnya akan menampilkan gambar
    }
}
