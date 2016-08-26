package com.example.gagandeep.myshapes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    View circle;
    AnimatorSet scaleUp;
    AnimatorSet scaleUp1;
    AnimatorSet scaleUp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       circle = (View)findViewById(R.id.view);
        int x = (int) circle.getX();
        int y = (int)circle.getY();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle, "scaleX", 5.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle, "scaleY", 5.0f);
        ObjectAnimator moveX = ObjectAnimator.ofFloat(circle, "x",x,360 );
        ObjectAnimator moveY = ObjectAnimator.ofFloat(circle, "y", y,670);
        ObjectAnimator moveX1 = ObjectAnimator.ofFloat(circle, "x",360,x );
        ObjectAnimator moveY1 = ObjectAnimator.ofFloat(circle, "y", 670,y);
        //ObjectAnimator alpha = ObjectAnimator.ofFloat(circle, "alpha", 1.0f, 0.0f);

        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(circle, "scaleX", 1);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(circle, "scaleY", 1);

        scaleX.setDuration(5000);
        scaleY.setDuration(5000);
        moveX.setDuration(5000);
        moveY.setDuration(5000);
        scaleX1.setDuration(5000);
        scaleY1.setDuration(5000);
        moveX1.setDuration(5000);
        moveY1.setDuration(5000);
        scaleUp = new AnimatorSet();
        scaleUp1 = new AnimatorSet();
        scaleUp3 = new AnimatorSet();
        scaleUp.play(scaleY).with(scaleX).with(moveX).with(moveY);
        scaleUp1.play(scaleY1).with(scaleX1).with(moveX1).with(moveY1);
        scaleUp3.playSequentially(scaleUp,scaleUp1);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleUp3.start();
            }
        });





        //mAllAnim.playTogether(scaleUp);

    }



}
