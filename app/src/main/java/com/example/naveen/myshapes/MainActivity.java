package com.example.naveen.myshapes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View circle;
    View triangle;
    View star;
    View square;
    AnimatorSet scaleUp;
    AnimatorSet scaleUp1;
    AnimatorSet scaleUp3;
    TextView textView;

    int startX , startY;
    int endX, endY;

    int centerX, centerY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        circle = findViewById(R.id.circle);
        triangle = findViewById(R.id.triangle);
        square = findViewById(R.id.square);
        star = findViewById(R.id.star);
        circle.setOnClickListener(this);
        square.setOnClickListener(this);
        star.setOnClickListener(this);
        triangle.setOnClickListener(this);




        //mAllAnim.playTogether(scaleUp);

    }

    void playAnimation(View view){

    ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 7.0f);
    ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 7.0f);
    ObjectAnimator moveX = ObjectAnimator.ofFloat(view, "x",startX,centerX );
    ObjectAnimator moveY = ObjectAnimator.ofFloat(view, "y", startY,centerY);
    ObjectAnimator moveX1 = ObjectAnimator.ofFloat(view, "x",centerX,startX );
    ObjectAnimator moveY1 = ObjectAnimator.ofFloat(view, "y", centerY,startY);
    //ObjectAnimator alpha = ObjectAnimator.ofFloat(circle, "alpha", 1.0f, 0.0f);

    ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f);
    ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f);

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
    scaleUp.play(scaleX).with(scaleY).with(moveX).with(moveY);
    scaleUp1.play(scaleX1).with(scaleY1).with(moveX1).with(moveY1);
    scaleUp3.playSequentially(scaleUp,scaleUp1);
}

    @Override
    public void onClick(View view) {

        int[] points = new int[2];

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        centerX = width/2;
        centerY = height/2;


        switch(view.getId())
        {
            case R.id.circle:
                circle.getLocationOnScreen(points);
                startX = points[0];
                startY = points[1];
                textView.setText(view.getTag().toString());
                textView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.RED);
                textView.setBackgroundColor(Color.BLACK);
                break;
            case R.id.square:
                square.getLocationOnScreen(points);
                startX = points[0];
                startY = points[1];
                textView.setText(view.getTag().toString());
                textView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.GREEN);
                textView.setBackgroundColor(Color.BLACK);
                break;
            case R.id.triangle:
                triangle.getLocationOnScreen(points);
                startX = points[0];
                startY = points[1];
                textView.setText(view.getTag().toString());
                textView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.BLUE);
                textView.setBackgroundColor(Color.BLACK);
                break;
            case R.id.star:
                star.getLocationOnScreen(points);
                startX = points[0];
                startY = points[1];
                textView.setText(view.getTag().toString());
                textView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.YELLOW);
                textView.setBackgroundColor(Color.BLACK);
                break;

        }
        playAnimation(view);
        scaleUp3.start();
    }



}
