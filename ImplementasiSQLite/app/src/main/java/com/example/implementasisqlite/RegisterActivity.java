package com.example.implementasisqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    DataHelper dbHelper;
    Button btn_register;
    EditText nama, password, tgl_lahir, gender, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DataHelper(this);
        nama = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        tgl_lahir = (EditText) findViewById(R.id.etdate);
        gender = (EditText) findViewById(R.id.etGender);
        alamat = (EditText) findViewById(R.id.etAddress);
        btn_register = (Button) findViewById(R.id.btnRegister);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String user = nama.getText().toString();
                String pass = password.getText().toString();
                String tgl = tgl_lahir.getText().toString();
                String gen = gender.getText().toString();
                String almt = alamat.getText().toString();

                if(user.isEmpty() || pass.isEmpty() || tgl.isEmpty() || gen.isEmpty() || almt.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuser = dbHelper.checkusername(user);
                    if(checkuser == false){
                        Boolean insert = dbHelper.insertData(user, pass, tgl, gen, almt);
                        if(insert == true){
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Username already exists!", Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}