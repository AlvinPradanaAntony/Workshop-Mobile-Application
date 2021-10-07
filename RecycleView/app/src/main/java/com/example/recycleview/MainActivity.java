package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Mendeklarasikan variabel
    RecyclerView recyclerView;
    adapterListFood foodAdapter;
    EditText editText;

    // Membuat method untuk filtering data list
    private void filter(String text) {
        // Membuat objek ArrayList baru yang datanya diambil dari "dataFood"
        ArrayList<dataFood> filteredList = new ArrayList<>();
        // Sebuah kondisi yang mana jika hasil inputan yang diambil dari widget edittext sesuai pada data list
        // maka list tersebut akan ditampilkan
        for (dataFood item : dataFood) {
            // Proses filtering dilakukan berdasarkan nama dan huruf besar dan huruf kecil tidak mempengaruhi saat proses filtering
            if (item.getNama().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        foodAdapter.filterList(filteredList);
    }

    // Menginisialisasikan untuk membuat objek baru dari ArrayList
    ArrayList<dataFood> dataFood = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mencari widget berdasarkan id
        recyclerView = findViewById(R.id.recycleview);
        // Menambahkan data array list yang akan disimpan ke dalam objek dataFood
        dataFood.add(new dataFood("Nasi Goreng", "Tingkat Kesulitan : Mudah", "Nasi goreng merupakan sajian nasi yang digoreng dalam sebuah wajan atau penggorengan menghasilkan cita rasa berbeda karena dicampur dengan bumbu-bumbu seperti bawang putih, bawang merah, merica dan kecap manis. Selain itu, ditambahkan bahan-bahan pelengkap seperti telur, sayur-sayuran, makanan laut, atau daging. Makanan tersebut sering kali disantap sendiri atau disertai dengan hidangan lainnya. Nasi goreng adalah komponen populer dari masakan Asia Timur, Tenggara dan Selatan pada wilayah tertentu. Sebagai hidangan buatan rumah, " +
                "nasi goreng biasanya dibuat dengan bahan-bahan yang tersisa dari hidangan lainnya, " +
                "yang berujung pada ragam yang tak terbatas. Menjadi penopang ekonomi, hal yang sama juga terjadi pada mi goreng atau pyttipanna.", 7.9));

        dataFood.add(new dataFood("Mie Goreng", "Tingkat Kesulitan : Mudah", "Mi goreng berarti \"mi yang digoreng\" [2] adalah makanan yang berasal dari Indonesia yang populer dan juga digemari di Malaysia, dan Singapura. Mi goreng terbuat dari mi kuning yang digoreng dengan sedikit minyak goreng, dan ditambahkan bawang putih, bawang merah, udang serta daging ayam atau daging sapi, irisan bakso, cabai, sayuran, tomat, telur ayam, dan acar. Makanan ini sangat populer dan dapat ditemui di mana-mana di Indonesia, mulai dari pedagang pinggir jalan (kaki lima) sampai restoran mewah. Mi goreng juga dapat ditemukan " +
                "di warung mamak di Malaysia dan Singapura. Versi mi instan dari mi goreng juga sangat populer, seperti Indomie Mi goreng.", 7.5));

        dataFood.add(new dataFood("Sate", "Tingkat Kesulitan : Mudah", "Sate atau satai adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu, kemudian dipanggang menggunakan bara arang kayu. Sate disajikan dengan berbagai macam bumbu yang bergantung pada variasi resep sate.[1] Daging yang dijadikan sate antara lain daging ayam, kambing, domba, sapi, babi, kelinci, kuda, dan lain-lain.", 8.0));

        dataFood.add(new dataFood("Pizza", "Tingkat Kesulitan : Sulit", "Piza (menurut KBBI) (atau pizza) adalah hidangan gurih dari Italia sejenis adonan bundar dan pipih, yang dipanggang di oven dan biasanya dilumuri saus tomat serta keju dengan bahan makanan tambahan lainnya yang bisa dipilih. Keju yang dipakai biasanya mozzarella atau \"keju pizza\", bisa juga keju parmesan dan beberapa keju lainnya.\n" +
                "\n" +
                "Jenis bahan lain juga dapat ditaruh di atas pizza, biasanya daging dan saus, seperti salami dan pepperoni, ham, bacon, buah seperti nanas dan zaitun, sayuran seperti cabe dan paprika, dan juga bawang bombay, jamur dan lain lain." +
                "yang berujung pada ragam yang tak terbatas. Menjadi penopang ekonomi, hal yang sama juga terjadi pada mi goreng atau pyttipanna.", 8.2));

        dataFood.add(new dataFood("Rujak", "Tingkat Kesulitan : Mudah", "Rujak adalah hidangan salad buah dan sayuran tradisional Indonesia-Jawa, umumnya ditemukan di Indonesia, Malaysia, dan Singapura.[2][3] Selain mengacu pada hidangan salad buah ini,[4] istilah rujak juga berarti \"campuran\" atau \"campuran eklektik\" dalam bahasa Melayu sehari-hari.", 7.2));

        dataFood.add(new dataFood("Rendang", "Tingkat Kesulitan : Sedang", "Rendang atau randang (Jawi: رندڠ) adalah masakan daging asli Indonesia yang berasal dari Minangkabau. Masakan ini dihasilkan dari proses memasak suhu rendah dalam waktu lama menggunakan aneka rempah-rempah dan santan. Proses memasaknya memakan waktu berjam-jam (biasanya sekitar empat jam) hingga yang tinggal hanyalah potongan daging berwarna hitam pekat dan dedak. Dalam suhu ruangan, rendang dapat bertahan hingga berminggu-minggu. " +
                "Rendang yang dimasak dalam waktu yang lebih singkat dan santannya belum mengering disebut kalio, berwarna cokelat terang keemasan.", 9.0));


        // Inisialisasi untuk membuat objek baru
        foodAdapter = new adapterListFood(dataFood);
        // Menampilkan data ke wu=idget melalui adapter
        recyclerView.setAdapter(foodAdapter);
        // Menampilkan tampilan awal dengan layout MainActivity
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // Mencari widget berdasarkan id
        editText = findViewById(R.id.search);
        // Implementeasi method
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
}
