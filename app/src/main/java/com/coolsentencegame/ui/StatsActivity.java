package com.coolsentencegame.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coolsentencegame.R;
import com.coolsentencegame.application.Services;
import com.coolsentencegame.objects.Score;
import com.coolsentencegame.persistence.IScorePersistence;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {

    private IScorePersistence scorePersistence;
    private Button btnBack;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        scorePersistence = Services.getScorePersistence();

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this::onBackBtnTap);

        linearLayout = findViewById(R.id.linLayout);
        ArrayList<Score> scores = scorePersistence.getPrevScores(0);
        Score highScore = scorePersistence.getHighScore();

        TextView tvHighScore = new TextView(this);
        tvHighScore.setText("High Score: " + highScore.toString()+ "\n");
        tvHighScore.setTextSize(20);
        linearLayout.addView(tvHighScore);

        for(Score score : scores) {
            TextView tv = new TextView(this);
            tv.setText(score.toString()+ "\n");
            tv.setTextSize(20);
            linearLayout.addView(tv);
        }

    }


    public void onBackBtnTap(View view)
    {
        finish();
    }

}