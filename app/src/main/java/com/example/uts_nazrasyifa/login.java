package com.example.uts_nazrasyifa;

import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    // Deklarasi variable
    Button pindahActivity, pindahActivitySaveData;
    EditText inputEmail, inputPassword;
    String email, paswword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Menginisialisasi variable
        inputEmail = findViewById(R.id.email_login);
        inputPassword = findViewById(R.id.password_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Pindah activity ke LoginActivity dari button sign in
        pindahActivitySaveData = findViewById(R.id.btnlogin1);
        pindahActivitySaveData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onLoginClick();
            }
        });
    }

    public void onLoginClick() {
        // Menampilkan pesan di log
        Log.d("Login", "Button Login diklik");
        // Untuk mengambil nilai yang dimasukkan oleh pengguna
        email = inputEmail.getText().toString();
        paswword = inputPassword.getText().toString();
        if (email.equals("")||paswword.equals("")) {
            Toast.makeText(login.this, "Data Cannot Empty", Toast.LENGTH_SHORT).show();
        }
        else if(!email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(login.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, paswword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in sukses, update UI dengan informasi pengguna yang masuk
                                Log.d("Login", "Login Successful");
                                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent pindahKeLoginActivity = new Intent(login.this, MainListView.class);
                                startActivity(pindahKeLoginActivity);
                            } else {
                                // Jika proses masuk gagal, tampilkan pesan kepada pengguna.
                                Log.d("Login", "Login Failed");
                                Toast.makeText(login.this, "Login Failed or Account Not Register Yet", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}