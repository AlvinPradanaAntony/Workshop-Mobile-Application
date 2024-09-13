package com.example.appwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //untuk implisit
    Button button;
    EditText editText;

    //untuk explisit
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi untuk implisit
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        //memberikan aksi ketika button VISIT diklik dan membuka jendela baru untuk menuju alamat URL
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //inisialisasi untuk explisit
        name = (EditText) findViewById(R.id.edt_nama);
        btnSend = (Button) findViewById(R.id.btn_send);

        //memberikan aksi untuk membuka second activity dan menampilkan nama pengguna yang telah diinputkan sebelumnya ketika button SEND di klik
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nama = name.getText().toString();
                    //ketika nama telah diinputkan, maka program akan menuju second activity
                    if (nama != ""){
                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        //jika nama kosong, maka program akan menampilkan pesan di bawah
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT);
                    }
                } catch (Exception e){
                    //jika terjadi error maka akan menampilkan pesan di bawah
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}