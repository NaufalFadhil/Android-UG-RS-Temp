package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Button btnMedicalCheck = findViewById(R.id.btn_move_activity_medical_check);
        Button btnProfile = findViewById(R.id.btn_move_activity_profile);
        Button btnHostpitalization = findViewById(R.id.btn_move_activity_hospitalization);
        Button btnDoctor = findViewById(R.id.btn_move_activity_doctor);
        Button btnPoly = findViewById(R.id.btn_move_activity_poly);

        btnMedicalCheck.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnHostpitalization.setOnClickListener(this);
        btnDoctor.setOnClickListener(this);
        btnPoly.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_move_activity_medical_check) {
            Intent moveIntent = new Intent(NavigationActivity.this, MedicalCheckActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_move_activity_profile) {
            Intent moveIntent = new Intent(NavigationActivity.this, ProfileActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_move_activity_hospitalization) {
            Intent moveIntent = new Intent(NavigationActivity.this, HospitalizationActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_move_activity_doctor) {
            Intent moveIntent = new Intent(NavigationActivity.this, DoctorListActivity.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_move_activity_poly){
            Toast.makeText(this, "Mohon maaf! Fitur untuk saat ini belum tersedia", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_move_activity_blog){
            Intent moveIntent = new Intent(NavigationActivity.this, BlogActivity.class);
            startActivity(moveIntent);
        }
    }
}