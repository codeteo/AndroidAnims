package com.anim.androidanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class CustomConstraintAnimActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private EditText et

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_constraint);

        constraintLayout = findViewById(R.id.constraint_custom);



    }
}
