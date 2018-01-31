package com.anim.androidanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnViewProperty, btnConstraintAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewProperty = findViewById(R.id.btn_property_anim);
        btnViewProperty.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewPropertyAnimActivity.class);
            startActivity(intent);
        });

        btnConstraintAnim = findViewById(R.id.btn_constraint_anim);
        btnConstraintAnim.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConstraintAnimActivity.class);
            startActivity(intent);
        });

    }
}
