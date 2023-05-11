package com.example.uts_nazrasyifa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SpachlesTiga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //
        setContentView(R.layout.activity_spachles_tiga);
        //
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //untuk pindah activity
                startActivity(new Intent(getApplicationContext(),Welcome.class));
                finish();
            }
        }, 3000L); // waktu untuk berjalannya splash screen
    }
}