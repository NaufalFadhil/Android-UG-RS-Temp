package com.gunadarma.rsug;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView rvDoctors;
    private ArrayList<Doctor> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        rvDoctors =findViewById(R.id.rv_doctors);
        rvDoctors.setHasFixedSize(true);

        list.addAll(DoctorsData.getListData());
        showRecyclerList();


    }

    private void showRecyclerList(){
        rvDoctors.setLayoutManager(new LinearLayoutManager(this));
        ListDoctorAdapter listHeroAdapter = new ListDoctorAdapter(list);
        rvDoctors.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListDoctorAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Doctor data) {
                showSelectedDoctor(data);
            }
        });
    }

    private void showSelectedDoctor(Doctor data) {
        Toast.makeText(this, "Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DoctorListActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, data.getName());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, data.getDetail());
        intent.putExtra(DetailActivity.EXTRA_PHOTO, data.getPhoto());
        startActivity(intent);

    }
}