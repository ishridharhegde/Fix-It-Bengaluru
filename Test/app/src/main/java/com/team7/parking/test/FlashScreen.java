package com.team7.parking.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FlashScreen extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ImageView myImageView = (ImageView) findViewById(R.id.logo);
        TextView myTextView = (TextView)findViewById(R.id.logotext);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        myImageView.startAnimation(myFadeInAnimation);
        myTextView.startAnimation(myFadeInAnimation);


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(FlashScreen.this, Login.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        finish();
    }
}
