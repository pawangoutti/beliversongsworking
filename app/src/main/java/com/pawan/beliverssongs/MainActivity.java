package com.pawan.beliverssongs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    Animation top;
    private static final int SPLASH_TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        Log.d("Pawan_t", "onCreate: " + this.getClass().getSimpleName());

        setContentView(R.layout.activity_main);



        FirebaseMessaging.getInstance().subscribeToTopic("song")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Pawan";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }

                    }
                });


        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView img1 = (ImageView) findViewById(R.id.logo);
        top = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mainlogoanimation);
        img1.setAnimation(top);

        img1.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), SongTypes.class));
            finish();
        }, SPLASH_TIMEOUT);
    }

    /*@Override
    protected void onPause() {
        Log.d("Pawan_t", "onPause: " +this.getClass().getSimpleName());
        super.onPause();
    }*/

    @Override
    protected void onDestroy() {
        Log.d("Pawan_t", "onDestroy: " + this.getClass().getSimpleName());
        super.onDestroy();
    }
}