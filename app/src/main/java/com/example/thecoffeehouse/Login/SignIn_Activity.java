package com.example.thecoffeehouse.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thecoffeehouse.MainActivity;
import com.example.thecoffeehouse.R;

public class SignIn_Activity extends AppCompatActivity {

    EditText edName, edPass;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbManager = new DBManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);
        Button imageView1 = (Button) findViewById(R.id.btn_signin);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edName = (EditText) findViewById(R.id.edtEmail);
                edPass = (EditText) findViewById(R.id.edtPassword);
                Button imageView1 = (Button) findViewById(R.id.btn_signin);
                String tenDN = edName.getText().toString();
                String pass = edPass.getText().toString();

                boolean kt = dbManager.KiemTraDangNhap(tenDN, pass);
                if (kt) {
                    imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(SignIn_Activity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(SignIn_Activity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}