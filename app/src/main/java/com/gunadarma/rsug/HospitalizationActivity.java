package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class HospitalizationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFullname, edtAddress, edtOld, edtHeight, edtWeight, edtBlood, edtDoctorRef, edtComplaintDisease;
    private RadioGroup rgPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalization);

        Spinner dropdown = findViewById(R.id.spin_room);
        String[] items = new String[]{"-- Pilih kelas kamar yang tersedia --", "Kamar kelas VVIP", "Kamar kelas VIP", "Kamar kelas 1",
                "Kamar kelas 2", "Kamar kelas 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        edtFullname = findViewById(R.id.edt_fullname);
        edtAddress = findViewById(R.id.edt_address);
        edtOld  = findViewById(R.id.edt_old);
        edtBlood = findViewById(R.id.edt_blood);
        edtDoctorRef = findViewById(R.id.edt_doctor);
        edtWeight = findViewById(R.id.edt_weight);
        edtHeight =findViewById(R.id.edt_height);
        edtComplaintDisease = findViewById(R.id.edt_complaints_disease);
        rgPayment =findViewById(R.id.rg_payment);

        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register){
            String inputFullname = edtFullname.getText().toString();
            String inputAddress = edtAddress.getText().toString();
            String inputOld = edtOld.getText().toString();
            String inputBlood = edtBlood.getText().toString();
            String inputDoctorRef = edtDoctorRef.getText().toString();
            String inputComplaintDisease = edtComplaintDisease.getText().toString();
            String inputWeight = edtWeight.getText().toString();
            String inputHeight = edtHeight.getText().toString();
            int inputPayment = rgPayment.getCheckedRadioButtonId();

            boolean isEmptyFields  = false;

            if(TextUtils.isEmpty(inputFullname) && TextUtils.isEmpty(inputAddress) &&
                TextUtils.isEmpty(inputOld) && TextUtils.isEmpty(inputBlood)
                && TextUtils.isEmpty(inputDoctorRef) && TextUtils.isEmpty(inputComplaintDisease)
                && TextUtils.isEmpty(inputWeight) && TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                Toast.makeText(this, "Semua field yang tersedia wajib di isi", Toast.LENGTH_SHORT).show();
            } else if(rgPayment.getCheckedRadioButtonId() != 0){
                String value = "null";
                int id = rgPayment.getCheckedRadioButtonId();

                if(id == R.id.rb_payment_cash) {
                    value = "Cash";
                } else if (id == R.id.rb_payment_assurance) {
                    value = "Assurance";
                } else {
                    isEmptyFields = true;
                    Toast.makeText(this, "Metode pembayaran wajib di isi", Toast.LENGTH_SHORT).show();
                }
            }

            if(!isEmptyFields) {
                Intent moveIntent = new Intent(HospitalizationActivity.this, NavigationActivity.class);
                Toast.makeText(this, "Pendaftaran pasien atas nama " + inputFullname + " berhasil", Toast.LENGTH_SHORT).show();
                startActivity(moveIntent);
            }
        }
    }
}