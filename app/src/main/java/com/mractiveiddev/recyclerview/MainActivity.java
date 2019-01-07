package com.mractiveiddev.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked{

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Ahmad", "Teknik", "bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        //layoutManager = new LinearLayoutManager(this);
        //Horizontakl list view
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //Gridlayout
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("Maulana Ahmad", "Programmer", "bus"));
        people.add(new Person("Dinda Paramitha", "Hukum", "plane"));
        people.add(new Person("Mdul", "Dinda Maulana", "bus"));
        people.add(new Person("Din", "Dindol", "plane"));
        people.add(new Person("Yunan", "yto", "bus"));
        people.add(new Person("Temmy", "Alex", "plane"));
        people.add(new Person("Hasan", "rcti", "bus"));
        people.add(new Person("MNC", "Media", "plane"));
        people.add(new Person("RCTI", "Media", "bus"));
        people.add(new Person("Mdul", "Dinda Maulana", "plane"));
        people.add(new Person("Din", "Dindol", "plane"));
        people.add(new Person("Yunan", "yto", "bus"));
        people.add(new Person("Temmy", "Alex", "plane"));
        people.add(new Person("Hasan", "rcti", "bus"));
        people.add(new Person("MNC", "Media", "plane"));
        people.add(new Person("RCTI", "Media", "bus"));
        people.add(new Person("Mdul", "Dinda Maulana", "plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int indext) {

        Toast.makeText(this, "username: " + people.get(indext).getUsername() , Toast.LENGTH_SHORT).show();
    }
}
