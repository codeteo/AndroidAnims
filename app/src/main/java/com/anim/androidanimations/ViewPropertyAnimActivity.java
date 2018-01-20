package com.anim.androidanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ViewPropertyAnimActivity extends AppCompatActivity {

    EditText etProfession, etCompany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);

        etProfession = findViewById(R.id.et_profession);
        etCompany = findViewById(R.id.et_company);

    }
}
