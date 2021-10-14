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
 * Use the {@link fragmusic#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmusic extends Fragment {
    /*Membuat kelas fragment yang didalamnya terdapat construktor-contrukstor */

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Mendeklarasikan sebuah variabel
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    dataMusikAdapter adapter;
    // Membuat sebuah objek ArrayList
    ArrayList<dataMusik> objMusik = new ArrayList<>();
    // Membuat sebuah array yang menyimpan daftar gambar dengan tipe data integer
    int images[] = {R.drawable.icom1, R.drawable.icom2, R.drawable.icom3, R.drawable.icom4,
            R.drawable.icom5, R.drawable.icom6, R.drawable.icom7, R.drawable.icom8, R.drawable.
            icom9, R.drawable.icom10};

    public fragmusic() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmusic.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmusic newInstance(String param1, String param2) {
        fragmusic fragment = new fragmusic();
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

        // Membuat objek baru view dari salah satu layout yang ingin digunakan
        View view = inflater.inflate(R.layout.fragment_fragmusic, container, false);

        /*Didalam fragmen music terdapat recycle view untuk meembuat daftar lagu*/

        // Mencari widget recycler view yang ingin digunakan berdasarkan id
        recyclerView = view.findViewById(R.id.recycleViewMusic);
        // Menambahkan data ke dalam sebuah ArrayList untuk menampung daftar-daftar lagu yang nantinya
        // akan ditampilkan pada fragmen music
        objMusik.add(new dataMusik("To the Bone", "Pamungkas",
                "Have I ever told you\n" +
                        "I want you to the bone?\n" +
                        "Have I ever called you\n" +
                        "When you are all alone?\n" +
                        "And if I ever forget\n" +
                        "To tell you how I feel\n" +
                        "Listen to me now, babe\n" +
                        "I want you to the bone\n" +
                        "I want you to the bone, ooh, ooh, ooh, ooh\n" +
                        "I want you to the bone, oh, oh, oh, oh\n" +
                        "Maybe if you can see\n" +
                        "What I feel through my bone\n" +
                        "Every corner in me\n" +
                        "There's your presence that grown\n" +
                        "Maybe I nurture it more\n" +
                        "By saying how I feel\n" +
                        "But I did mean it before\n" +
                        "I want you to the bone\n" +
                        "I want you to-\n" +
                        "Take me home, I'm fallin'\n" +
                        "Love me long, I'm rollin'\n" +
                        "Losing control, body and soul\n" +
                        "Mind too for sure, I'm already yours\n" +
                        "Walk you down, I'm all in\n" +
                        "Hold you tight, you call and\n" +
                        "I'll take control your body and soul\n" +
                        "Mind too for sure, I'm already yours\n" +
                        "Would that be alright?\n" +
                        "Hey, would that be alright?\n" +
                        "I want you to the bone, ooh, ooh, ooh, ooh\n" +
                        "So bad I can't breathe, oh, oh, oh, oh, ooh\n" +
                        "I want you to the bone\n" +
                        "Of all the ones that begged to stay\n" +
                        "I'm still longing for you\n" +
                        "Of all the ones that cried their way\n" +
                        "I'm still waiting on you\n" +
                        "Maybe we seek for something that\n" +
                        "We couldn't ever have\n" +
                        "Maybe we choose the only love\n" +
                        "We know we won't accept\n" +
                        "Or maybe we're taking all the risks\n" +
                        "For somethin' that is real\n" +
                        "'Cause maybe the greatest love of all\n" +
                        "Is who the eyes can't see, yeah\n" +
                        "Take me home, I'm fallin'\n" +
                        "Love me long, I'm rollin'\n" +
                        "Losing control, body and soul\n" +
                        "Mind too for sure, I'm already yours\n" +
                        "Walk you down, I'm all in\n" +
                        "Hold you tight, I call and\n" +
                        "I'll take control of your body and soul\n" +
                        "Mind too for sure, I'm already yours, oh\n" +
                        "Oh, yes\n" +
                        "I want you to the bone, yeah\n" +
                        "I want you to the bone\n" +
                        "I want you to the bone, yeah\n" +
                        "I want you to the bone, bone, ooh\n" +
                        "I want you to the bone"));

        objMusik.add(new dataMusik("Here's Your Perfect", "Jamie Miller",
                "I remember the day\n" +
                        "Even wrote down the date, that I fell for you (mmhm)\n" +
                        "And now it's crossed out in red\n" +
                        "But I still can't forget if I wanted too\n" +
                        "And it drives me insane\n" +
                        "Think I'm hearing your name, everywhere I go\n" +
                        "But it's all in my head\n" +
                        "It's just all in my head\n" +
                        "But you won't see me break, call you up in three days\n" +
                        "Or send you a bouquet, saying, \"It's a mistake\"\n" +
                        "Drink my troubles away, one more glass of champagne\n" +
                        "And you know\n" +
                        "I'm the first to say that I'm not perfect\n" +
                        "And you're the first to say you want the best thing\n" +
                        "But now I know a perfect way to let you go\n" +
                        "Give my last hello, hope it's worth it\n" +
                        "Here's your perfect\n" +
                        "My best was just fine\n" +
                        "How I tried, how I tried to be great for you\n" +
                        "I'm flawed by design and you love to remind me\n" +
                        "No matter what I do\n" +
                        "But you won't see me break, call you up in three days\n" +
                        "Or send you a bouquet, saying, \"It's a mistake\"\n" +
                        "Drink my troubles away, one more glass of champagne\n" +
                        "And you know\n" +
                        "I'm the first to say that I'm not perfect\n" +
                        "And you're the first to say you want the best thing\n" +
                        "But now I know a perfect way to let you go\n" +
                        "Give my last hello, hope it's worth it\n" +
                        "I'm the first to say that I'm not perfect\n" +
                        "And you're the first to say you want the best thing (best thing, yeah)\n" +
                        "But now I know a perfect way to let you go\n" +
                        "Give my last hello, hope it's worth it\n" +
                        "Say yeah, yeah, yeah\n" +
                        "Ayy-ayy, ayy-ayy\n" +
                        "But now I know a perfect way to let you go\n" +
                        "Give my last hello, hope it's worth it\n" +
                        "Here's your perfect"));
        objMusik.add(new dataMusik("Peaches", "Justin Bieber", "-"));
        objMusik.add(new dataMusik("Stay", "Justin Bieber", "-"));
        objMusik.add(new dataMusik("Happier", "Olivia Rodrigo", "-"));
        objMusik.add(new dataMusik("It's You", "Sezairi", "-"));
        objMusik.add(new dataMusik("Life Goes On", "Olivia Rodrigo", "-"));
        objMusik.add(new dataMusik("Roxanne", "Arizona Zervas", "-"));
        objMusik.add(new dataMusik("Bohemian Rhapsody", "Queen", "-"));
        objMusik.add(new dataMusik("Hotel California", "Eagles", "-"));


        // Membuat objek adapter baru untuk menghubungkan data pada java dengan widget recycler view yang berada pada suatu layout tertentu
        adapter = new dataMusikAdapter(objMusik, images);
        recyclerView.setAdapter(adapter); //mengambil data dari kumpulan data dan menampilkan data array ke recycleview
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // menyusun kumpulan item dengan tata letak berupa daftar atau list
        return view;
    }
}