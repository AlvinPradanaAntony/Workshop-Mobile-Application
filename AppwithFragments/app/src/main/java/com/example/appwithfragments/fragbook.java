package com.example.appwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragbook#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragbook extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Mendeklarasikan sebuah variabel
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    // Mendeklarasikan sebuah array yang mana datanya berada pada file string.xml sebagai string-array
    String s1 [], s2[], s3[];
    // // Membuat sebuah array yang menyimpan daftar gambar dengan tipe data integer
    int images[] = {R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,
            R.drawable.icon5,R.drawable.icon6,R.drawable.icon7,R.drawable.icon8,R.drawable.icon9,R.drawable.
            icon10,R.drawable.icon11,R.drawable.icon13,R.drawable.icon8,R.drawable.icon12};
    EditText cari;
    Spinner kategori; // ---> untuk membuat variabel spinner dengan nama variabel "kategori".
    //Inisialisasi sebuah array guna menampung kumpulan data yang dipakai sebagai kategori yang bertipe data string.
    String [] category = new String[] {"All", "Dongeng", "Novel", "Kamus", "Others" };

    public fragbook() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragbook.
     */
    // TODO: Rename and change types and number of parameters
    public static fragbook newInstance(String param1, String param2) {
        fragbook fragment = new fragbook();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Membuat objek baru view dari salah satu layout yang ingin digunakan
        View view = inflater.inflate(R.layout.fragment_fragbook, container, false);
        recyclerView = view.findViewById(R.id.recycleViewBuku);

        s1 = getResources().getStringArray(R.array.JudulBuku);
        s2 = getResources().getStringArray(R.array.Genre);
        s3 = getResources().getStringArray(R.array.DetailBuku);

        dataAdapter adapter = new dataAdapter(getContext(), s1, s2, s3, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Menginisialisasi variabel "kategori" pada elemen widget Spinner yang berfungsi untuk mencari sebuah resource komponen pada View menggunakan ID.
        kategori = view.findViewById(R.id.kategoriBuku);
        ArrayAdapter<String> adapterBuku = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, category);
        // Untuk menampilkan data array kedalam ListView diperlukan sebuah adapter.
        // Fungsi adapter tersebut adalah untuk menghubungkan data Array yang telah dibuat dengan nama array "category" ke dalam elemen View pada file layout.xml.
        adapterBuku.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Mengubah tampilan data dengan menggunakan layout "simple_spinner_dropdown_item"
        kategori.setAdapter(adapterBuku); // Menampilkan data ke View melalui adapter

        return view;
    }
}