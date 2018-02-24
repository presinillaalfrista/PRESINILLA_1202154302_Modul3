package com.example.android.presinilla_1202154302_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000; //variabel untuk menentukan durasi splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() { //menghandle tindakan untuk halaman selanjutnya
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreenActivity.this, LoginActivity.class); //pindah ke halaman loginActivity
                startActivity(homeIntent); //mengaktifkan variabel intent agar berpindah halaman
                finish();

            }
        },SPLASH_TIME_OUT); //pindah ke halaman selanjutnya setelah 2 detik
    }
}
