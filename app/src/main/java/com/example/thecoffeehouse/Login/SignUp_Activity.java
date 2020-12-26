package com.example.thecoffeehouse.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thecoffeehouse.R;

public class SignUp_Activity extends AppCompatActivity {
    private EditText edEmail;
    private EditText edName;
    private EditText edPass;
    private Button btndk;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        dbManager = new DBManager(this);
        edEmail = (EditText) findViewById(R.id.edtEmail1);
        edName = (EditText) findViewById(R.id.edtUserName);
        edPass = (EditText) findViewById(R.id.edtPassword1);
        btndk = (Button) findViewById(R.id.bt_signup);
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.addAccount(createAccount());
                Intent intent = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                startActivity(intent);
            }
        });
    }

    private Account createAccount() {
        String name = edName.getText().toString();
        String mail = edEmail.getText().toString();
        String pass = edPass.getText().toString();
        Account account = new Account(name, mail, pass);
        return account;
    }

}