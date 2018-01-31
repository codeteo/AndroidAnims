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
import android.widget.ImageView;

public class ConstraintAnimActivity extends AppCompatActivity {

    private ImageView ivBackground;
    private ConstraintLayout constraintLayout;

    private boolean show = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        constraintLayout = findViewById(R.id.constraint);
        ivBackground = findViewById(R.id.backgroundImage);

        ivBackground.setOnClickListener(v -> {

            if (show) {
                Log.i("TAG", "HIDE");
                hideComponents();
                show = false;
            } else {
                Log.i("TAG", "SHOW");
                showComponents();
                show = true;
            }
        });

    }

    private void showComponents() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_constraint_2);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }

    private void hideComponents() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_constraint);

        ChangeBounds trans = new ChangeBounds();
        trans.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        trans.setDuration(1200L);

        TransitionManager.beginDelayedTransition(constraintLayout, trans);

        constraintSet.applyTo(constraintLayout);
    }
}
