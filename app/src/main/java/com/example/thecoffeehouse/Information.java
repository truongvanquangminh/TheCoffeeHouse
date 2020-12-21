package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thecoffeehouse.bottomNavigation.Tintuc;

public class Information extends AppCompatActivity{

    Button bt1, bt2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        bt1 = findViewById(R.id.button_close);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt2 = findViewById(R.id.buttonDoi);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, SuaThongTin.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
