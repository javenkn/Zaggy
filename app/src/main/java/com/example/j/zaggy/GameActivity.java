package com.example.j.zaggy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Boolean gameOverCalled, ballRight;
    int scoreVal;
    final Handler h = new Handler();
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
                playBtnClicked();
                movement();
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

        gameOverCalled = false;
        ballRight = true;
        scoreVal = 0;

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
        logo.setVisibility(View.INVISIBLE);
        playBtn.setVisibility(View.INVISIBLE);

        pillar1.setX(335);
        pillar1.setY(768);
        ball.setX(320);
        ball.setY(520);
        pillar2.setX(pillar1.getX() + 78);
        pillar2.setY(pillar1.getY() - 55);
        pillar3.setX(pillar2.getX() + 78);
        pillar3.setY(pillar2.getY() - 55);

        pillar4.setX(pillarPlacementX(pillar3.getX()));
        pillar4.setY(pillarPlacementY(pillar3.getY()));
        pillar5.setX(pillarPlacementX(pillar4.getX()));
        pillar5.setY(pillarPlacementY(pillar4.getY()));
        pillar6.setX(pillarPlacementX(pillar5.getX()));
        pillar6.setY(pillarPlacementY(pillar5.getY()));
        pillar7.setX(pillarPlacementX(pillar6.getX()));
        pillar7.setY(pillarPlacementY(pillar6.getY()));
        pillar8.setX(pillarPlacementX(pillar7.getX()));
        pillar8.setY(pillarPlacementY(pillar7.getY()));
        pillar9.setX(pillarPlacementX(pillar8.getX()));
        pillar9.setY(pillarPlacementY(pillar8.getY()));
        pillar10.setX(pillarPlacementX(pillar9.getX()));
        pillar10.setY(pillarPlacementY(pillar9.getY()));

        pillar1.setVisibility(View.VISIBLE);
        pillar2.setVisibility(View.VISIBLE);
        pillar3.setVisibility(View.VISIBLE);
        pillar4.setVisibility(View.VISIBLE);
        pillar5.setVisibility(View.VISIBLE);
        pillar6.setVisibility(View.VISIBLE);
        pillar7.setVisibility(View.VISIBLE);
        pillar8.setVisibility(View.VISIBLE);
        pillar9.setVisibility(View.VISIBLE);
        pillar10.setVisibility(View.VISIBLE);
        ball.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
    }

    protected void movement() {
        final int delay = 45;

        h.postDelayed(new Runnable() {
           public void run() {

               layout.setOnTouchListener(new View.OnTouchListener() {
                   @Override
                   public boolean onTouch(View v, MotionEvent event) {
                       if(event.getAction() == MotionEvent.ACTION_UP) {

                           if(!gameOverCalled) {
                               scoreVal++;
                               score.setText(String.valueOf(scoreVal));
                               if(ballRight) {
                                   ballRight = false;
                               } else {
                                   ballRight = true;
                               }
                           }
                           return true;
                       }
                       return false;
                   }
               });

               if(ballRight) {
                   ball.setX(ball.getX() + 6.7f);
                   ball.setY(ball.getY() - 0.5f);
               } else {
                   ball.setX(ball.getX() - 6.7f);
                   ball.setY(ball.getY() - 0.5f);
               }

               pillar1.setY(pillar1.getY() + 5);
               pillar2.setY(pillar2.getY() + 5);
               pillar3.setY(pillar3.getY() + 5);
               pillar4.setY(pillar4.getY() + 5);
               pillar5.setY(pillar5.getY() + 5);
               pillar6.setY(pillar6.getY() + 5);
               pillar7.setY(pillar7.getY() + 5);
               pillar8.setY(pillar8.getY() + 5);
               pillar9.setY(pillar9.getY() + 5);
               pillar10.setY(pillar10.getY() + 5);
               ball.setY(ball.getY() + 0.5f);

               if(checkPillarPosition(pillar1.getY())) {
                   sendViewToBack(pillar1);
                   pillar1.setX(pillarPlacementX(pillar10.getX()));
                   pillar1.setY(pillarPlacementY(pillar10.getY()));
               } else if(checkPillarPosition(pillar2.getY())) {
                   sendViewToBack(pillar2);
                   pillar2.setX(pillarPlacementX(pillar1.getX()));
                   pillar2.setY(pillarPlacementY(pillar1.getY()));
               } else if(checkPillarPosition(pillar3.getY())) {
                   sendViewToBack(pillar3);
                   pillar3.setX(pillarPlacementX(pillar2.getX()));
                   pillar3.setY(pillarPlacementY(pillar2.getY()));
               } else if(checkPillarPosition(pillar4.getY())) {
                   sendViewToBack(pillar4);
                   pillar4.setX(pillarPlacementX(pillar3.getX()));
                   pillar4.setY(pillarPlacementY(pillar3.getY()));
               } else if(checkPillarPosition(pillar5.getY())) {
                   sendViewToBack(pillar5);
                   pillar5.setX(pillarPlacementX(pillar4.getX()));
                   pillar5.setY(pillarPlacementY(pillar4.getY()));
               } else if(checkPillarPosition(pillar6.getY())) {
                   sendViewToBack(pillar6);
                   pillar6.setX(pillarPlacementX(pillar5.getX()));
                   pillar6.setY(pillarPlacementY(pillar5.getY()));
               } else if(checkPillarPosition(pillar7.getY())) {
                   sendViewToBack(pillar7);
                   pillar7.setX(pillarPlacementX(pillar6.getX()));
                   pillar7.setY(pillarPlacementY(pillar6.getY()));
               } else if(checkPillarPosition(pillar8.getY())) {
                   sendViewToBack(pillar8);
                   pillar8.setX(pillarPlacementX(pillar7.getX()));
                   pillar8.setY(pillarPlacementY(pillar7.getY()));
               } else if(checkPillarPosition(pillar9.getY())) {
                   sendViewToBack(pillar9);
                   pillar9.setX(pillarPlacementX(pillar8.getX()));
                   pillar9.setY(pillarPlacementY(pillar8.getY()));
               } else if(checkPillarPosition(pillar10.getY())) {
                   sendViewToBack(pillar10);
                   pillar10.setX(pillarPlacementX(pillar9.getX()));
                   pillar10.setY(pillarPlacementY(pillar9.getY()));
               }

               h.postDelayed(this, delay);
           }
        }, delay);
    }

    public static void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup) child.getParent();
        if(parent != null) {
            parent.removeView(child);
            parent.addView(child, 0);
        }
    }

    public boolean checkPillarPosition(float y) {
        if(y > 1250f) {
            return true;
        }
        return false;
    }

    public float pillarPlacementX(float x) {
        float pillarNewX = 0f;

        int random = (int)(Math.random() * 2 + 1);

        if(random == 1) {
            if(x >= 600) {
                pillarNewX = x - 79;
            } else {
                pillarNewX = x + 78;
            }

        } else {
            if(x < 40) {
                pillarNewX = x + 78;
            } else {
                pillarNewX = x - 79;
            }
        }

        return pillarNewX;
    }

    public float pillarPlacementY(float y) {
        y = y - 57;
        return y;
    }
}
