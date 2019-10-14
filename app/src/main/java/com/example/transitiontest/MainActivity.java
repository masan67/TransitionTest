package com.example.transitiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button buttonSecondActivity;
    private ImageView imageViewPoster;
    private LinearLayout llBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPoster = findViewById(R.id.iv_poster);
        llBackground = findViewById(R.id.ll_background);
        buttonSecondActivity = findViewById(R.id.btn_irSegundaActivity);

        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(llBackground, "backgroundTransition");
                pairs[1] = new Pair<View, String>(imageViewPoster, "imageTransition");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(intent, activityOptions.toBundle());
            }
        });
    }
}
