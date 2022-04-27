package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        ImageButton btnMedicalCheck = findViewById(R.id.btn_move_activity_medical_check);
        ImageButton btnHostpitalization = findViewById(R.id.btn_move_activity_hospitalization);
        ImageButton btnDoctor = findViewById(R.id.btn_move_activity_doctor);
        ImageButton btnLab = findViewById(R.id.btn_move_activity_laboratory);

        btnMedicalCheck.setOnClickListener(this);
        btnHostpitalization.setOnClickListener(this);
        btnDoctor.setOnClickListener(this);
        btnLab.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_move_activity_medical_check) {
            Intent moveIntent = new Intent(NavigationActivity.this, MedicalCheckActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_move_activity_hospitalization) {
            Intent moveIntent = new Intent(NavigationActivity.this, HospitalizationActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_move_activity_doctor) {
            Intent moveIntent = new Intent(NavigationActivity.this, DoctorListActivity.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_move_activity_laboratory){
            Toast.makeText(this, "Mohon maaf! Fitur untuk saat ini belum tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
            return true;
        } else {
            return true;
        }
    }
}