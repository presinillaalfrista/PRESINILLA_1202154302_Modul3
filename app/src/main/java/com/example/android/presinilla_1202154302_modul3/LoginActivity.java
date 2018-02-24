package com.example.android.presinilla_1202154302_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText pwd;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.user); //membuat referensi EditText dari layout activity_login.xml
        pwd = (EditText) findViewById(R.id.pwd); //membuat referensi EditText dari layout activity_login.xml
        login = (Button) findViewById(R.id.login); //membuat referensi button dari layout activity_login.xml
    }
    public void onClick(View view) { //method onClick untuk membuat action jika button di klik
        if (user.getText().toString().equals("EAD")&& pwd.getText().toString().equals("MOBILE") ) { //set password dan username
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show(); //jika password dan username sesuai maka muncul toast login berhasil
            Intent intentlogin = new Intent(this, MainActivity.class); // dan berpindah ke halaman selanjutnya
            startActivity(intentlogin);
        } else {
            Toast.makeText(this,"Login Gagal", Toast.LENGTH_SHORT).show(); //jika gagal login akan muncul toast login gagal
        }
    }
}

