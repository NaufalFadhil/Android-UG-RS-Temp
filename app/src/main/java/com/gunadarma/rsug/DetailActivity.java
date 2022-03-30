package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView photox = findViewById(R.id.img_item_photo);
        TextView namex = findViewById(R.id.tv_item_name);
        TextView detailx = findViewById(R.id.tv_item_detail);

        Glide.with(this).load(getIntent().getIntExtra(EXTRA_PHOTO,0)).into(photox);
        namex.setText(getIntent().getStringExtra(EXTRA_NAME));
        detailx.setText(getIntent().getStringExtra(EXTRA_DETAIL));

        Button btnRegister = findViewById(R.id.btn_check);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_check){
            Toast.makeText(this, "Mohon Maaf! Pasien yang sedang menunggu sedang penuh, silahkan coba beberapa saat lagi", Toast.LENGTH_SHORT).show();
        }
    }
}