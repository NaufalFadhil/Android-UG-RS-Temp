package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegister = findViewById(R.id.btn_move_activity_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login){

            String inputEmail = edtEmail.getText().toString();
            String inputPassword = edtPassword.getText().toString();

            boolean isEmptyFields  = false;

            if(TextUtils.isEmpty(inputEmail)) {
                isEmptyFields = true;
                edtEmail.setError("Field email kosong!");
            }

            if(TextUtils.isEmpty(inputPassword)) {
                isEmptyFields = true;
                edtPassword.setError("Field password kosong!");
            }

            if(!isEmptyFields) {
                if(inputEmail.equals("spongebob@google.com") && inputPassword.equals("squarepants")) {
                    Intent moveIntent = new Intent(MainActivity.this, NavigationActivity.class);
                    Toast.makeText(this, "Selamat Datang!", Toast.LENGTH_SHORT).show();
                    startActivity(moveIntent);
                } else if (inputEmail.equals("spongebob@google.com")) {
                    Toast.makeText(this, "Password yang dimasukkan salah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Anda belum terdaftar", Toast.LENGTH_SHORT).show();
                    edtEmail.setError("Email yang dimasukkan tidak terdaftar");
                }
            }
        }

        if (v.getId() == R.id.btn_move_activity_register){
            Intent moveIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(moveIntent);
        }
    }
}