package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SuaThongTin extends AppCompatActivity {

    ImageView thoat;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);

        thoat = findViewById(R.id.thoat2);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXemThongTinCaNhan();
            }
        });

        bt = findViewById(R.id.luu);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXemThongTinCaNhan();
            }
        });
    }
    public void openXemThongTinCaNhan(){
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
        finish();
    }
}