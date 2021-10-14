package com.example.appwithfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    // Mendeklarasikan sebuah komponen/widget dengan varibel tertentu
    FloatingActionButton fab; // ===> Komponen/widget floating button
    BottomNavigationView btnNavBottom; //===> Komponenen/widget bottom navigation bar

    //Menentukan tata letak dan menampilkan tata letak dari UI activity atau fragment tersebut
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menampilkan fragment yang diinginkan pertama kalai ketika aplikasi baru dibuka (startup)
        /* Alurnya adalah beriteraksi dengan objek fragmen didalam activity menggunakan FragmentManager, lalu
        * melakukan awaltransaksi guna memberikan tindakan terhadap fragment tersebut dalam suatu aktivitas seperti menambah (add()),
        * membuang (remove()), dan mengganti fragment (replace()). Pada kode di bawah ini saya menggunakan state replace untuk mengganti fragment sebelumnya sehingga didalam
        * state tersebut terdapat beberapa parameter seperti id dari widget framelayout, objek dari fragmen yang diinginkan dan menggunakan
        * commit( ) untuk menerapkan transaksi pada aktivitas yang dibuat*/
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, new fraghome()).commit();

        //Mencari elemen widget yang diiinging berdasarkan ID kemudia diberi tindakan atau action
        btnNavBottom = findViewById(R.id.navBottom);
        //Kode Dibawah ini digunakan untuk melakukan sesuatu yang nampak seperti men-deselected item pada awal aplikasi dibuka.
        btnNavBottom.getMenu().getItem(2).setChecked(true); //item pada index 2 di pilih tetapi tidak nampak dan komponen tersebut dinonaktifkan...
        btnNavBottom.getMenu().getItem(2).setEnabled(false);

        // Mmebuat tindakan atau action ketika item pada bottom navigation bar di klik, maka akan menjalankan fragmen baru sesuai keingginan kita.
        btnNavBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.nav_music:
                        selectedFragment = new fragmusic(); // Ketika memilih item music maka akan menampilkan fragment music
                        break;
                    case R.id.nav_book:
                        selectedFragment = new fragbook(); // Ketika memilih item buku maka akan menampilkan fragment book
                        break;
                    case R.id.nav_film:
                        selectedFragment = new fragfilm(); // Ketika memilih item film maka akan menampilkan fragment film
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new fragprofile(); // Ketika memilih item profile maka akan menampilkan fragment profile
                        break;
                }
                // Menjalankakan sebuah tindakan dari fragment dengan menggunakan state replace (akan menggantikan fragment yang lama dengan fragmen yang baru sesuai dengan item yang dipilih pada
                // bottom navigasi bar)
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, selectedFragment).commit();
                return true; // nilai akan dikembalikan jika bernilai true atau benar
            }
        });

        // Membuat tindakan atau action dari wiget floating button yang mana tindakannnya adalah menuju ke fragment yang diinginkan contoh disini floating button saya sebagai tombol
        // home sehigga ketika saya meng-klik button home tersebut maka akan menuju ke fragmen home alih alih tampilan awal
        FloatingActionButton btn = findViewById(R.id.btnHome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNavBottom.getMenu().getItem(2).setChecked(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, new fraghome()).commit();
            }
        });
    }
}