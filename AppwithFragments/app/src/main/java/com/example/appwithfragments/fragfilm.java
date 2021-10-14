package com.example.appwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragfilm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragfilm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Mendeklarasikan sebuah variabel
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    dataFilmAdapter adapter;
    // Membuat sebuah objek ArrayList
    ArrayList<dataFIlm> objFilm = new ArrayList<>();
    // Membuat sebuah array yang menyimpan daftar gambar dengan tipe data integer
    int images[] = {R.drawable.icof1, R.drawable.icof2, R.drawable.icof3, R.drawable.icof4};

    public fragfilm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragfilm.
     */
    // TODO: Rename and change types and number of parameters
    public static fragfilm newInstance(String param1, String param2) {
        fragfilm fragment = new fragfilm();
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
        View view = inflater.inflate(R.layout.fragment_fragfilm, container, false);
        // Mencari widget recycler view yang ingin digunakan berdasarkan id
        recyclerView = view.findViewById(R.id.recycleViewFilm);
        objFilm.add(new dataFIlm("Squid Game", "18 September 2021",
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games.\n" +
                        "Inside, a tempting prize awaits with deadly high stakes. A survival game that has a whopping 45.6 billion-won prize at stake"));
        objFilm.add(new dataFIlm("Shang Chi", "13 September 2021",
                "Shang-Chi, the master of weaponry-based Kung Fu, is forced to confront his past after being drawn into the Ten Rings organization."));
        objFilm.add(new dataFIlm("Free Guy", "13 Agustus 2021",
                "A bank teller discovers that he's actually an NPC inside a brutal, open world video game"));
        objFilm.add(new dataFIlm("Black Widow", "16 September 2021",
                " In Marvel Studios' action-packed spy thriller \"Black Widow,\" Natasha Romanoff aka Black Widow confronts the darker parts of her\n " +
                        "ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down,\n" +
                        "Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger"));

        /// Membuat objek adapter baru untuk menghubungkan data pada java dengan widget recycler view yang berada pada suatu layout tertentu
        adapter = new dataFilmAdapter(objFilm,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}