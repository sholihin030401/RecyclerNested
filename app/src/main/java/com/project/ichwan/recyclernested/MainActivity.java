package com.project.ichwan.recyclernested;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    String titles;
    ArrayList<Childs> listchilds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent getdata = getIntent();
        titles = getdata.getStringExtra("name");
        listchilds = getdata.getParcelableArrayListExtra("list");

        rvMain = findViewById(R.id.recycler_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        rvMain.setLayoutManager(layoutManager);
        ParentAdapter adapter = new ParentAdapter(ItemData());
        rvMain.setAdapter(adapter);

        findViewById(R.id.fab_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });
    }

    private List<Parents> ItemData() {
        List<Parents> listParent = new ArrayList<>();
        Parents parentsItem = new Parents(titles,listchilds);
        listParent.add(parentsItem);

        return listParent;
    }
}