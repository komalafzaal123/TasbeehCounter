package com.example.tasbeehcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {

    ListView listViewTasbeeh;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        listViewTasbeeh = findViewById(R.id.listViewStudent);

        db = new DbHelper(show.this);

        List<Counter> list = db.getAllData();

        List<String> myStringList = new ArrayList<>();
        int count = 0;
        while(count<list.size()){
            myStringList.add("Date: "+list.get(count).getDate());
            myStringList.add("Kalma: "+list.get(count).getKalmaCount());
            myStringList.add("Darood e Pak: "+list.get(count).getDaroodCount());
            myStringList.add("Astgafar: "+list.get(count).getAstagfarCount());
            count++;

        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(show.this, android.R.layout.simple_list_item_1, myStringList);
        listViewTasbeeh.setAdapter(arrayAdapter);
    }
}