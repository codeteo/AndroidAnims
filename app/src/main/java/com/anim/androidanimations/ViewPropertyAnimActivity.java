package com.anim.androidanimations;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import static android.view.View.VISIBLE;

public class ViewPropertyAnimActivity extends AppCompatActivity {

    EditText etProfession, etCompany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);

        etProfession = findViewById(R.id.et_profession);
        etCompany = findViewById(R.id.et_company);

        setProfessionActionListener();

    }

    private void setProfessionActionListener() {
        etProfession.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {

                startCompanyAnim();

                return false;
            }
            return false;
        });
    }

    private void startCompanyAnim() {
        etCompany.animate()
                .setDuration(2000L)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        etCompany.setVisibility(VISIBLE);
                        Log.i("ANIM", "START: TOP == " + etCompany.getTop() + " and Y == " + etCompany.getY());
                        Log.i("ANIM", "START: LEFT == " + etCompany.getLeft() + " and X == " + etCompany.getX());
                        Log.i("ANIM", "START: getTranslationY == " + etCompany.getTranslationY());
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("ANIM", "END: TOP == " + etCompany.getTop() + " and Y == " + etCompany.getY());
                        Log.i("ANIM", "END: LEFT == " + etCompany.getLeft() + " and X == " + etCompany.getX());
                        Log.i("ANIM", "END: getTranslationY == " + etCompany.getTranslationY());
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .y(etProfession.getTop())
                .start();
    }
}
