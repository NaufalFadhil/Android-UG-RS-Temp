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

public class MedicalCheckActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFullname, edtOld, edtHeight, edtWeight, edtBlood, edtComplaintDisease;
    private RadioGroup rgPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_check);
        Spinner dropdown = findViewById(R.id.spin_poly);
        String[] items = new String[]{"-- Pilih poli yang tersedia --", "Poli Anak", "Poli Bedah Umum ", "Poli Bedah Plastik",
                "Poli Bedah Syaraf", "Poli Bedah Mata", "Poli Kebidanan", "Poli Kulit dan Kelamin", "Poli Organ Dalam",
                "Poli Paru"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        edtFullname = findViewById(R.id.edt_fullname);
        edtOld  = findViewById(R.id.edt_old);
        edtBlood = findViewById(R.id.edt_blood);
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
            String inputOld = edtOld.getText().toString();
            String inputBlood = edtBlood.getText().toString();
            String inputComplaintDisease = edtComplaintDisease.getText().toString();
            String inputWeight = edtWeight.getText().toString();
            String inputHeight = edtHeight.getText().toString();
            int inputPayment = rgPayment.getCheckedRadioButtonId();

            boolean isEmptyFields  = false;

            if (TextUtils.isEmpty(inputFullname) && TextUtils.isEmpty(inputOld)
                    && TextUtils.isEmpty(inputBlood) && TextUtils.isEmpty(inputComplaintDisease)
                    && TextUtils.isEmpty(inputWeight) && TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                Toast.makeText(this, "Semua field yang tersedia wajib di isi", Toast.LENGTH_SHORT).show();
            } else if (rgPayment.getCheckedRadioButtonId() != 0){
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
                Intent moveIntent = new Intent(MedicalCheckActivity.this, NavigationActivity.class);
                Toast.makeText(this, "Pendaftaran pasien atas nama " + inputFullname + " berhasil", Toast.LENGTH_SHORT).show();
                startActivity(moveIntent);
            }
        }
    }
}