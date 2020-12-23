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
    String titles, subtitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //java.lang.NoSuchMethodException: checkPermissionWithSpecialUid [class java.lang.String]
        Intent getdata = getIntent();
        titles = getdata.getStringExtra("name");
        subtitles = getdata.getStringExtra("subname");

        rvMain = findViewById(R.id.recycler_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        ParentAdapter adapter = new ParentAdapter(ItemData());
        rvMain.setLayoutManager(layoutManager);
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
        Parents parentsItem = new Parents(titles,SubitemData());
        listParent.add(parentsItem);

        return listParent;
    }

    private List<Childs> SubitemData() {
        List<Childs> listTitle = new ArrayList<>();
        Childs childs = new Childs(subtitles);
        listTitle.add(childs);

        return listTitle;
    }
}