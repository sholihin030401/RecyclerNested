package com.project.ichwan.recyclernested;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutRow;
    List<Childs> titleList = new ArrayList<>();
    String txname, txsubname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        layoutRow = findViewById(R.id.layout_list);
        EditText title = findViewById(R.id.edt_name);
        txname = title.getText().toString();
        findViewById(R.id.btn_add_item).setOnClickListener(this);
        findViewById(R.id.btn_submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_item:
                addView();
                break;
            case R.id.btn_submit:
                if(checkValidate()){
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("name",txname);
                    intent.putExtra("subname",txsubname);
                    startActivity(intent);
                }
        }
    }

    private boolean checkValidate(){
        titleList.clear();
        boolean result = true;

        for (int i = 0;i < layoutRow.getChildCount();i++){

            View listview = layoutRow.getChildAt(i);
            EditText items = listview.findViewById(R.id.edt_item);
            txsubname = items.getText().toString();

            Childs childs = new Childs();

            if (!items.getText().toString().isEmpty()){
                childs.setTitle(items.getText().toString());
            } else {
                result = false;
                break;
            }

            titleList.add(childs);
        }

        if (titleList.size() == 0){
            result = false;
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
        } else if(!result){
            Toast.makeText(this, "Semua Data Kosong!", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addView(){
        final View titleView = getLayoutInflater().inflate(R.layout.row_add_item,null,false);

        EditText txsubname = titleView.findViewById(R.id.edt_item);
        ImageButton btnClose = titleView.findViewById(R.id.bt_close_item);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(titleView);
            }
        });

        layoutRow.addView(titleView);
    }

    private void removeView(View titleView) {
        layoutRow.removeView(titleView);
    }
}