package com.gunadarma.rsug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFullname, edtEmail, edtPassword, golonganDarah, tinggiBadan, beratBadan;
    private RadioGroup rgGender;

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFullname = findViewById(R.id.edt_fullname);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        rgGender = findViewById(R.id.rg_gender);

        Button btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register){

            String inputFullname = edtFullname.getText().toString();
            String inputEmail = edtEmail.getText().toString();
            String inputPassword = edtPassword.getText().toString();
            int inputGender = rgGender.getCheckedRadioButtonId();

            boolean isEmptyFields  = false;

            if(TextUtils.isEmpty(inputFullname)) {

                edtFullname.setError("Field ini wajib di isi!");
            }

            if(TextUtils.isEmpty(inputEmail)) {
                isEmptyFields = true;
                edtEmail.setError("Field ini wajib di isi!");
            }

            if(TextUtils.isEmpty(inputPassword)) {
                isEmptyFields = true;
                edtPassword.setError("Field ini wajib di isi!");
            }

            if(rgGender.getCheckedRadioButtonId() != 0){
                String value = "null";
                int id = rgGender.getCheckedRadioButtonId();

                if(id == R.id.rb_pria) {
                    value = "Pria";
                } else if (id == R.id.rb_wanita) {
                    value = "Wanita";
                } else {
                    isEmptyFields = true;
                    Toast.makeText(this, "Jenis kelamin wajib di isi", Toast.LENGTH_SHORT).show();
                }
            }

            if(!isEmptyFields) {
                Intent moveIntent = new Intent(RegisterActivity.this, NavigationActivity.class);
                Toast.makeText(this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                startActivity(moveIntent);
            }
        }
    }
}