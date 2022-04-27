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
                if(inputEmail.equals("s") && inputPassword.equals("s")) {
                    Intent moveIntent = new Intent(MainActivity.this, NavigationActivity.class);
                    startActivity(moveIntent);
                } else {
                    Toast.makeText(this, "Email/Password yang dimasukkan salah", Toast.LENGTH_SHORT).show();
                    edtEmail.setError("Email/Password yang dimasukkan salah");
                    edtPassword.setError("Email/Password yang dimasukkan salah");
                }
            }
        }

        if (v.getId() == R.id.btn_move_activity_register){
            Intent moveIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(moveIntent);
        }
    }
}