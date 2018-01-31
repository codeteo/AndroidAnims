package com.anim.androidanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class CustomConstraintAnimActivity extends AppCompatActivity {

    public static final String TAG = "CONSTRAINT-ANIM";

    private ConstraintLayout constraintLayout;
    private EditText etProfession, etCompany, etIndustry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_constraint);

        constraintLayout = findViewById(R.id.constraint_custom);
        etProfession = findViewById(R.id.et_profession);
        etCompany = findViewById(R.id.et_company);
        etIndustry = findViewById(R.id.et_industry);

        etProfession.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Log.i(TAG, "Profession - hasFocus");
                showProfessionLayout();
            }
        });

        etCompany.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Log.i(TAG, "Company - hasFocus");
                showCompanyLayout();
            }
        });

        etIndustry.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Log.i(TAG, "Industry - hasFocus");
                showIndustryLayout();
            }
        });

        setProfessionNextButtonListener();
        setCompanyNextButtonListener();
        setDoneButtonPressedListener();
    }

    private void setProfessionNextButtonListener() {
        etProfession.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                Log.i(TAG, "PROFESSION - NEXT-BUTTON");
                showCompanyLayout();

                return false;
            }
            return false;
        });
    }

    private void setCompanyNextButtonListener() {
        etCompany.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                Log.i(TAG, "COMPANY - NEXT-BUTTON");
                showIndustryLayout();

                return false;
            }
            return false;
        });
    }

    private void setDoneButtonPressedListener() {
        etIndustry.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Log.i(TAG, "DONE BUTTON PRESSED");
                showInitialLayout();

                return false;
            }
            return false;
        });
    }

    private void showProfessionLayout() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_custom_constraint_profession);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }

    private void showCompanyLayout() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_custom_constraint_company);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }

    private void showIndustryLayout() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_custom_constraint_industry);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }

    private void showInitialLayout() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_custom_constraint);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }
}
