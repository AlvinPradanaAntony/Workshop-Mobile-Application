package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailFood extends AppCompatActivity {
    TextView judul, rating, tgl_rilis, deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        judul = findViewById(R.id.nama);
        rating = findViewById(R.id.rating);
        tgl_rilis = findViewById(R.id.level);
        deskripsi = findViewById(R.id.deskripsi);

        // Memanggil data intent yang disimpan dalam objek varaibel "dataFood"
        dataFood food = getIntent().getParcelableExtra("Food");
        judul.setText(food.getNama());
        rating.setText(String.valueOf(food.getRating()));
        tgl_rilis.setText(food.getLevel());
        deskripsi.setText(food.getDeskripsi());
    }
}