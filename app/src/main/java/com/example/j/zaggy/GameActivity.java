package com.example.j.zaggy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    RelativeLayout layout;
    Button playBtn, retryBtn;
    TextView scoreOnBoard, highScoreOnBoard, score;
    ImageView ball, gameOver, scoreBoard, logo, pillar1, pillar2, pillar3, pillar4, pillar5, pillar6, pillar7, pillar8,  pillar9,  pillar10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        onCreateNew();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    protected void onCreateNew() {
        layout = (RelativeLayout) findViewById(R.id.layout);
        playBtn = (Button) findViewById(R.id.playBtn);
        retryBtn = (Button) findViewById(R.id.retryBtn);
        scoreOnBoard = (TextView) findViewById(R.id.scoreOnBoard);
        highScoreOnBoard = (TextView) findViewById(R.id.highScoreOnBoard);
        score = (TextView) findViewById(R.id.score);
        ball = (ImageView) findViewById(R.id.ball);
        gameOver = (ImageView) findViewById(R.id.gameOver);
        scoreBoard = (ImageView) findViewById(R.id.scoreBoard);
        logo = (ImageView) findViewById(R.id.logo);
        pillar1 = (ImageView) findViewById(R.id.pillar1);
        pillar2 = (ImageView) findViewById(R.id.pillar2);
        pillar3 = (ImageView) findViewById(R.id.pillar3);
        pillar4 = (ImageView) findViewById(R.id.pillar4);
        pillar5 = (ImageView) findViewById(R.id.pillar5);
        pillar6 = (ImageView) findViewById(R.id.pillar6);
        pillar7 = (ImageView) findViewById(R.id.pillar7);
        pillar8 = (ImageView) findViewById(R.id.pillar8);
        pillar9 = (ImageView) findViewById(R.id.pillar9);
        pillar10 = (ImageView) findViewById(R.id.pillar10);

        pillar1.setVisibility(View.INVISIBLE);
        pillar2.setVisibility(View.INVISIBLE);
        pillar3.setVisibility(View.INVISIBLE);
        pillar4.setVisibility(View.INVISIBLE);
        pillar5.setVisibility(View.INVISIBLE);
        pillar6.setVisibility(View.INVISIBLE);
        pillar7.setVisibility(View.INVISIBLE);
        pillar8.setVisibility(View.INVISIBLE);
        pillar9.setVisibility(View.INVISIBLE);
        pillar10.setVisibility(View.INVISIBLE);
        ball.setVisibility(View.INVISIBLE);
        gameOver.setVisibility(View.INVISIBLE);
        retryBtn.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        scoreBoard.setVisibility(View.INVISIBLE);
        scoreOnBoard.setVisibility(View.INVISIBLE);
        highScoreOnBoard.setVisibility(View.INVISIBLE);

    }

    protected void playBtnClicked() {

    }
}
