package com.example.selectionwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*
    Pada implemetasi selection widget terdapat 3 komponen, yaitu :
    a.  Autocomplete adalah sebuah komponen editable TextView yang menunjukkan saran penyelesaian secara otomatis saat pengguna mengetik
        berdasarkan item yang tersedia.
    b.  Spinner adalah sebuah komponen yang menyediakan cara cepat untuk memilih sebuah list atau nilai. Spinner sering disebut juga sebagai dropdown.
    c.  ListView adalah komponen yang menampilkan daftar list secara vertical yang dapat di scroll jika data yang ditampilkan melebihi parentnya.
     */

    //Mendeklarasikan sebuah variabel//
    AutoCompleteTextView cari; // ---> untuk membuat variabel autocomplete dengan nama variabel "cari".
    Spinner kategori; // ---> untuk membuat variabel spinner dengan nama variabel "kategori".
    ListView databuku; // ---> untuk membuat variabel listviuew dengan nama variabel "databuku".
    ArrayAdapter<?> adapter; // ---> untuk membuat variabel framework data adapter yang datanya diambil dari suatu array maupun database.

    //Inisialisasi sebuah array guna menampung kumpulan data yang dipakai sebagai kategori yang bertipe data string.
    String [] category = new String[] {"All", "Dongeng", "Novel", "Kamus", "Other" };

    /*
    Pada tahap ini membuat sebuah container sebagai sumber data yang akan dipakai nantinya.
    Container ini berisi list data array yang mana memasukan data sesuai parameter yang dibuat pada class tertentu seperti nama buku dan id dari kategori.
     */
    private ArrayList<buku> detailBuku() { // ---> Membuat container atau suatu objek yang didalamnya list data array.
        ArrayList<buku> data = new ArrayList<>(); // ---> Menginisialisasikan untuk membuat objek baru dari ArrayList (list array)

        /*  data(ini adalah nama variabel objek dari ArrayList). .add adalah sebuah method/fungsi dari class ArrayList untuk menambahkan data array kedalam list.
        Menggunakan objek baru dari class "buku" guna memasukkan nilai parameter yang diinginkan sesuai parameter yang telah dibuat pada class "buku". Parameter
        yang dimasuukan kedalam data array adalah nama buku dan id kategori. Ket : categoryID = 1 ---> Kategori Dongeng
                                                                                                2 ---> Kategori Novel
                                                                                                3 ---> Kategori Kamus
                                                                                                4 ---> Kategori Others
        * */
        data.add(new buku("Si Kancil Mencuri Mentimun", 1));
        data.add(new buku("Pinochio", 1));
        data.add(new buku("Timun Emas", 1));
        data.add(new buku("Laskar Pelangi", 2));
        data.add(new buku("5 Cm", 2));
        data.add(new buku("Filosofi Kopi", 2));
        data.add(new buku("Kamus Bahasa Indonesia Lengkap", 3));
        data.add(new buku("Kamus Bahasa Inggris Lengkap", 3));
        data.add(new buku("E.Y.D Bahasa Infonesia", 3));
        data.add(new buku("Atlas", 4));
        data.add(new buku("Api Abadi", 4));
        data.add(new buku("A Cup of tea", 2));
        data.add(new buku("A History China", 4));
        data.add(new buku("Belajar koding", 4));

        return data; // ---> mengembalikan nilai kedalam variabel "data" .
    }
    /*
    Pada tahap ini membuat sebuah kondisi yang mana mendapatkan kategori ketika kategori di klik dan hasilnya akan di hubungkan ke ListView melalui adapter
     */
    private void getSelectCategory(int categoryID) {
        // Menyimpan data yang dipilih
        ArrayList<buku> dataKategori = new ArrayList<>(); // Inisialisasi untuk membuat sebuah objek baru dari ArrayList
        // Sebuah kodisi untuk menyaring atau filtering data buku menyesuaikan kategori berdasarkan id kategori yang telah ditetapkan sebelumnya pada data ArrayList "detailBuku()"
        if(categoryID == 0)
        {
            // Mengambil sebuah data array dari "detailBuku()" dan ditampilkan menggunakan tampilan layout "simple_list_item_1"
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, detailBuku());
        }else{
            for (buku buku : detailBuku()) {
                if (buku.getCategoryId() == categoryID) {
                    dataKategori.add(buku);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataKategori);
        }
        // Menampilkan hasil filtering kategori pada ListView melalui adapter
        databuku.setAdapter(adapter);
    }

    /* Membuat sebuah method untuk memberikan sebuah tindakan atau action dari AutoComplete
        Tindakan atau Actionnya adalah ketika mengetikkan sesuatu pada editable TextView dan memunculkan kotak saran dalam pengetikkan maka jika diklik saran tersebut
        akan memunculkan sebuah text menggunakan toast
     */
    public void actionAutoComplete() {
        cari.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Anda memilih buku : " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* Membuat sebuah method untuk memberikan sebuah tindakan atau action dari ListView
    Tindakan atau Actionnya adalah memilih atau mengklik suatu data dari daftar list akan memunculkan sebuah text menggunakan toast
    akan memunculkan sebuah text menggunakan toast
    */
    public void actionListView() {
        databuku.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Anda memilih buku : " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* Membuat sebuah method untuk memberikan sebuah tindakan atau action dari Spinner atau dropdown list
    Tindakan atau Actionnya adalah memilih atau mengklik salah satu kategori yang mana akan menfiltering data buku sesuai kategori yang dipilih.
    */
    public void actionSpinner() {
        //spinner selection events
        kategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < category.length) { // ---> Memabandingkan posisi saat ini atau posisi yang diklik dengan posisi yang ada pada panjang data dari kategori
                    // Karena menggunakan operasi logika && yang artinya harus menghasilkan nilai true dari hasil perbandingan tersebut sehigga jika benar akan mengeksekusi code dibawah ini
                    getSelectCategory(position); // ---> Untuk memproses filtering berdasarkan posisi kategori yang dipilih dengan id kategori pada data buku
                } else { // Jika kondisi tidak terpenuhi maka kode ini akan dijalankan yang mana menampilkan sebuah teks menggunakan toast.
                    Toast.makeText(MainActivity.this, "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menginisialisasi variabel "cari" pada elemen widget AutoComplete yang berfungsi untuk mencari sebuah resource komponen pada View menggunakan ID.
        cari = findViewById(R.id.cari);
        // Untuk menampilkan data array kedalam AutoComplete diperlukan sebuah adapter.
        // Fungsi adapter tersebut adalah untuk menghubungkan data Array yang telah dibuat pada file strings.xml dengan nama array "buku" ke dalam elemen View pada file layout.xml.
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.buku, android.R.layout.simple_list_item_1);
        cari.setAdapter(adapter1); // Menampilkan data ke View melalui adapter
        actionAutoComplete(); // Menjalankan method untuk memberikan tindakan atau Action pada widget ListView.

        // Menginisialisasi variabel "databuku" pada elemen widget ListView yang berfungsi untuk mencari sebuah resource komponen pada View menggunakan ID.
        databuku = findViewById(R.id.databuku);
        // Untuk menampilkan data array kedalam ListView diperlukan sebuah adapter.
        // Fungsi adapter tersebut adalah untuk menghubungkan data Array yang telah dibuat pada file strings.xml dengan nama array "buku" ke dalam elemen View pada file layout.xml.
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.buku, android.R.layout.simple_list_item_1);
        databuku.setAdapter(adapter2);// Menampilkan data ke View melalui adapter
        actionListView();  // Menjalankan method untuk memberikan tindakan atau Action pada widget ListView.

        // Menginisialisasi variabel "kategori" pada elemen widget Spinner yang berfungsi untuk mencari sebuah resource komponen pada View menggunakan ID.
        kategori = findViewById(R.id.kategori);
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, category);
        // Untuk menampilkan data array kedalam ListView diperlukan sebuah adapter.
        // Fungsi adapter tersebut adalah untuk menghubungkan data Array yang telah dibuat dengan nama array "category" ke dalam elemen View pada file layout.xml.
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Mengubah tampilan data dengan menggunakan layout "simple_spinner_dropdown_item"
        kategori.setAdapter(adapter3); // Menampilkan data ke View melalui adapter
        actionSpinner(); // Menjalankan method untuk memberikan tindakan atau Action pada widget Spinner.


        FloatingActionButton btn = findViewById(R.id.btnhome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome Back Alvin !!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
        Membuat class yang mana untuk membuat objek untuk nama buku dan mendapat id kategori berdasarkan paramater yang telah dibuat
     */
    class buku {
        private String name;
        private int categoryID;

        public String getName() {
            return name;
        }

        public int getCategoryId() {
            return categoryID;
        }

        public buku(String name, int categoryID) {
            this.name = name;
            this.categoryID = categoryID;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}