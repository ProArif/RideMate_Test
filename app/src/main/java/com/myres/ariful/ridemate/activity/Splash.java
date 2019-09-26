package com.myres.ariful.ridemate.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.myres.ariful.ridemate.R;

public class Splash extends AppCompatActivity {


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);


        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageView logo= (ImageView) findViewById(R.id.logo);
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                startActivity(new Intent(Splash.this,MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.setAnimation(shake);

    }


}
