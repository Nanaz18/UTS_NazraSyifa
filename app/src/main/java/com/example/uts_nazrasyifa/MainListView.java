package com.example.uts_nazrasyifa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainListView extends AppCompatActivity {
    // deklarasi variable
    private RecyclerView recyclerView;
    private AdapterList myAdapter;
    private List<ItemList> ItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlistview);
        //inisialisasi variable
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // inisialisasi daftar item
        ItemList = new ArrayList<>();
        ItemList.add(new ItemList("https://i.pinimg.com/236x/db/a4/58/dba4587ea7f4f8077f720c2082561c9c.jpg", "Bunda","Assalamualaikum", "12.20"));
        ItemList.add(new ItemList("https://i.pinimg.com/236x/a2/1f/63/a21f638517f349c1f84bce2cd1c3e731.jpg", "Ayah", "Hallo, Apa Kabar?","15.40"));
        ItemList.add(new ItemList("https://i.pinimg.com/236x/5d/09/df/5d09df4f5f436bac47e6d414cb814efb.jpg", "Bestie", "Lagi dimana ?", "22.30"));
        ItemList.add(new ItemList("https://i.pinimg.com/236x/9d/13/ef/9d13ef97f741021d5a9976956ef39d08.jpg", "Dosen Wali", "Baik, Semangat ya !", "10.39"));
        ItemList.add(new ItemList("https://i.pinimg.com/236x/90/c0/34/90c0341be5db83f64e1ded1eadaa1bb5.jpg", "Kakak", "Semangat belajarnya!", "12.00"));
        ItemList.add(new ItemList("https://i.pinimg.com/236x/23/4f/ff/234fff52b2908ae907511ad6a79aaf05.jpg", "Eunwoo", "Hari ini kamu cantik", "10.00"));
        // inisialisai adapter RecyclerView
        myAdapter = new AdapterList(ItemList);
        recyclerView.setAdapter((RecyclerView.Adapter)myAdapter);
    }
}