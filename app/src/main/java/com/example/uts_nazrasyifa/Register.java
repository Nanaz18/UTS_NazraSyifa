package com.example.uts_nazrasyifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class Register extends AppCompatActivity {


    //deklarasi variable
    EditText edtemail,edtpass,edtretype;
    String alamatemail, pass, retypeemail;
    TextView login;
    Button btnregister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Menginisialisasi variable
        edtemail = findViewById(R.id.alamatemail);
        edtpass = findViewById(R.id.pass);
        edtretype = findViewById(R.id.retypeemail);
        btnregister = findViewById(R.id.btnregister);


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekRegister ();
            }
        });
    }

    private void cekRegister() {
        alamatemail = edtemail.getText().toString();
        pass = edtpass.getText().toString();
        retypeemail = edtemail.getText().toString();

        mAuth.createUserWithEmailAndPassword(alamatemail,retypeemail)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent i = new Intent(Register.this,MainListView.class);
                            startActivity(i);
                            // Pesan untuk menampilkan jika register berhasil
                            Toast.makeText(Register.this, "Register Succesful !", Toast.LENGTH_SHORT).show();
                        }else {
                            // Pesan untuk menampilkan jika register gagal
                            Toast.makeText(Register.this, "Register Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}

