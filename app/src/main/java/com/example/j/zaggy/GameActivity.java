package com.example.j.zaggy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
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

    SharedPreferences pref;
    Editor editor;
    Boolean gameOverCalled, ballRight;
    int scoreVal, highScoreVal;
    final Handler h = new Handler();
    RelativeLayout layout;
    Button playBtn, retryBtn;
    TextView scoreOnBoard, highScoreOnBoard, score;
    ImageView ball, gameOver, scoreBoard, logo, pillar1, pillar2, pillar3, pillar4, pillar5, pillar6, pillar7, pillar8,
            pillar9,  pillar10, pillar11, pillar12, pillar13, pillar14, pillar15, pillar16, pillar17, pillar18, pillar19,
            pillar20, pillarTop1, pillarTop2, pillarTop3, pillarTop4, pillarTop5, pillarTop6;
    Rect ballRect = new Rect();
    Rect pillar1Rect = new Rect();
    Rect pillar2Rect = new Rect();
    Rect pillar3Rect = new Rect();
    Rect pillar4Rect = new Rect();
    Rect pillar5Rect = new Rect();
    Rect pillar6Rect = new Rect();
    Rect pillar7Rect = new Rect();
    Rect pillar8Rect = new Rect();
    Rect pillar9Rect = new Rect();
    Rect pillar10Rect = new Rect();
    Rect pillar11Rect = new Rect();
    Rect pillar12Rect = new Rect();
    Rect pillar13Rect = new Rect();
    Rect pillar14Rect = new Rect();
    Rect pillar15Rect = new Rect();
    Rect pillar16Rect = new Rect();
    Rect pillar17Rect = new Rect();
    Rect pillar18Rect = new Rect();
    Rect pillar19Rect = new Rect();
    Rect pillar20Rect = new Rect();
    Rect pillarTop1Rect = new Rect();
    Rect pillarTop2Rect = new Rect();
    Rect pillarTop3Rect = new Rect();
    Rect pillarTop4Rect = new Rect();
    Rect pillarTop5Rect = new Rect();
    Rect pillarTop6Rect = new Rect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pref = getApplicationContext().getSharedPreferences("com.example.j.zaggy_preferences.xml", 0);

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

        highScoreVal = pref.getInt("highScoreSaved", 0);

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
        pillar11 = (ImageView) findViewById(R.id.pillar11);
        pillar12 = (ImageView) findViewById(R.id.pillar12);
        pillar13 = (ImageView) findViewById(R.id.pillar13);
        pillar14 = (ImageView) findViewById(R.id.pillar14);
        pillar15 = (ImageView) findViewById(R.id.pillar15);
        pillar16 = (ImageView) findViewById(R.id.pillar16);
        pillar17 = (ImageView) findViewById(R.id.pillar17);
        pillar18 = (ImageView) findViewById(R.id.pillar18);
        pillar19 = (ImageView) findViewById(R.id.pillar19);
        pillar20 = (ImageView) findViewById(R.id.pillar20);
        pillarTop1 = (ImageView) findViewById(R.id.pillarTop1);
        pillarTop2 = (ImageView) findViewById(R.id.pillarTop2);
        pillarTop3 = (ImageView) findViewById(R.id.pillarTop3);
        pillarTop4 = (ImageView) findViewById(R.id.pillarTop4);
        pillarTop5 = (ImageView) findViewById(R.id.pillarTop5);
        pillarTop6 = (ImageView) findViewById(R.id.pillarTop6);

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
        pillar11.setVisibility(View.INVISIBLE);
        pillar12.setVisibility(View.INVISIBLE);
        pillar13.setVisibility(View.INVISIBLE);
        pillar14.setVisibility(View.INVISIBLE);
        pillar15.setVisibility(View.INVISIBLE);
        pillar16.setVisibility(View.INVISIBLE);
        pillar17.setVisibility(View.INVISIBLE);
        pillar18.setVisibility(View.INVISIBLE);
        pillar19.setVisibility(View.INVISIBLE);
        pillar20.setVisibility(View.INVISIBLE);
        pillarTop1.setVisibility(View.INVISIBLE);
        pillarTop2.setVisibility(View.INVISIBLE);
        pillarTop3.setVisibility(View.INVISIBLE);
        pillarTop4.setVisibility(View.INVISIBLE);
        pillarTop5.setVisibility(View.INVISIBLE);
        pillarTop6.setVisibility(View.INVISIBLE);
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
        ball.setY(870);
        pillar2.setX(pillar1.getX() + 78);
        pillar2.setY(pillar1.getY() - 55);
        pillar3.setX(pillar2.getX() + 78);
        pillar3.setY(pillar2.getY() - 55);

        pillarTop1.setX(pillar2.getX());
        pillarTop1.setY(pillar2.getY());
        pillarTop2.setX(pillar1.getX());
        pillarTop2.setY(pillar1.getY());

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
        pillar11.setX(pillarPlacementX(pillar10.getX()));
        pillar11.setY(pillarPlacementY(pillar10.getY()));
        pillar12.setX(pillarPlacementX(pillar11.getX()));
        pillar12.setY(pillarPlacementY(pillar11.getY()));
        pillar13.setX(pillarPlacementX(pillar12.getX()));
        pillar13.setY(pillarPlacementY(pillar12.getY()));
        pillar14.setX(pillarPlacementX(pillar13.getX()));
        pillar14.setY(pillarPlacementY(pillar13.getY()));
        pillar15.setX(pillarPlacementX(pillar14.getX()));
        pillar15.setY(pillarPlacementY(pillar14.getY()));
        pillar16.setX(pillarPlacementX(pillar15.getX()));
        pillar16.setY(pillarPlacementY(pillar15.getY()));
        pillar17.setX(pillarPlacementX(pillar16.getX()));
        pillar17.setY(pillarPlacementY(pillar16.getY()));
        pillar18.setX(pillarPlacementX(pillar17.getX()));
        pillar18.setY(pillarPlacementY(pillar17.getY()));
        pillar19.setX(pillarPlacementX(pillar18.getX()));
        pillar19.setY(pillarPlacementY(pillar18.getY()));
        pillar20.setX(pillarPlacementX(pillar19.getX()));
        pillar20.setY(pillarPlacementY(pillar19.getY()));

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
        pillar11.setVisibility(View.VISIBLE);
        pillar12.setVisibility(View.VISIBLE);
        pillar13.setVisibility(View.VISIBLE);
        pillar14.setVisibility(View.VISIBLE);
        pillar15.setVisibility(View.VISIBLE);
        pillar16.setVisibility(View.VISIBLE);
        pillar17.setVisibility(View.VISIBLE);
        pillar18.setVisibility(View.VISIBLE);
        pillar19.setVisibility(View.VISIBLE);
        pillar20.setVisibility(View.VISIBLE);

        pillarTop1.setVisibility(View.VISIBLE);
        pillarTop2.setVisibility(View.VISIBLE);
        pillarTop3.setVisibility(View.VISIBLE);
        pillarTop4.setVisibility(View.VISIBLE);
        pillarTop5.setVisibility(View.VISIBLE);
        pillarTop6.setVisibility(View.VISIBLE);

        ball.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
    }

    protected void movement() {
        final int delay = 40;

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
//
               if(ballRight) {
                   ball.setX(ball.getX() + 6.7f);
                   ball.setY(ball.getY() - 0.5f);
               } else {
                   ball.setX(ball.getX() - 6.7f);
                   ball.setY(ball.getY() - 0.5f);
               }

               // moving the pillars down 5
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
               pillar11.setY(pillar11.getY() + 5);
               pillar12.setY(pillar12.getY() + 5);
               pillar13.setY(pillar13.getY() + 5);
               pillar14.setY(pillar14.getY() + 5);
               pillar15.setY(pillar15.getY() + 5);
               pillar16.setY(pillar16.getY() + 5);
               pillar17.setY(pillar17.getY() + 5);
               pillar18.setY(pillar18.getY() + 5);
               pillar19.setY(pillar19.getY() + 5);
               pillar20.setY(pillar20.getY() + 5);
               ball.setY(ball.getY() + 0.5f);

               if(checkPillarPosition(pillar1.getY())) {
                   sendViewToBack(pillar1);
                   pillar1.setX(pillarPlacementX(pillar20.getX()));
                   pillar1.setY(pillarPlacementY(pillar20.getY()));
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
               } else if(checkPillarPosition(pillar11.getY())) {
                   sendViewToBack(pillar11);
                   pillar11.setX(pillarPlacementX(pillar10.getX()));
                   pillar11.setY(pillarPlacementY(pillar10.getY()));
               } else if(checkPillarPosition(pillar12.getY())) {
                   sendViewToBack(pillar12);
                   pillar12.setX(pillarPlacementX(pillar11.getX()));
                   pillar12.setY(pillarPlacementY(pillar11.getY()));
               } else if(checkPillarPosition(pillar13.getY())) {
                   sendViewToBack(pillar13);
                   pillar13.setX(pillarPlacementX(pillar12.getX()));
                   pillar13.setY(pillarPlacementY(pillar12.getY()));
               } else if(checkPillarPosition(pillar14.getY())) {
                   sendViewToBack(pillar14);
                   pillar14.setX(pillarPlacementX(pillar13.getX()));
                   pillar14.setY(pillarPlacementY(pillar13.getY()));
               } else if(checkPillarPosition(pillar15.getY())) {
                   sendViewToBack(pillar15);
                   pillar15.setX(pillarPlacementX(pillar14.getX()));
                   pillar15.setY(pillarPlacementY(pillar14.getY()));
               } else if(checkPillarPosition(pillar16.getY())) {
                   sendViewToBack(pillar16);
                   pillar16.setX(pillarPlacementX(pillar15.getX()));
                   pillar16.setY(pillarPlacementY(pillar15.getY()));
               } else if(checkPillarPosition(pillar17.getY())) {
                   sendViewToBack(pillar17);
                   pillar17.setX(pillarPlacementX(pillar16.getX()));
                   pillar17.setY(pillarPlacementY(pillar16.getY()));
               } else if(checkPillarPosition(pillar18.getY())) {
                   sendViewToBack(pillar18);
                   pillar18.setX(pillarPlacementX(pillar17.getX()));
                   pillar18.setY(pillarPlacementY(pillar17.getY()));
               } else if(checkPillarPosition(pillar19.getY())) {
                   sendViewToBack(pillar19);
                   pillar19.setX(pillarPlacementX(pillar18.getX()));
                   pillar19.setY(pillarPlacementY(pillar18.getY()));
               } else if(checkPillarPosition(pillar20.getY())) {
                   sendViewToBack(pillar20);
                   pillar20.setX(pillarPlacementX(pillar19.getX()));
                   pillar20.setY(pillarPlacementY(pillar19.getY()));
               }

               ball.getHitRect(ballRect);
               pillar1.getHitRect(pillar1Rect);
               pillar2.getHitRect(pillar2Rect);
               pillar3.getHitRect(pillar3Rect);
               pillar4.getHitRect(pillar4Rect);
               pillar5.getHitRect(pillar5Rect);
               pillar6.getHitRect(pillar6Rect);
               pillar7.getHitRect(pillar7Rect);
               pillar8.getHitRect(pillar8Rect);
               pillar9.getHitRect(pillar9Rect);
               pillar10.getHitRect(pillar10Rect);
               pillar11.getHitRect(pillar11Rect);
               pillar12.getHitRect(pillar12Rect);
               pillar13.getHitRect(pillar13Rect);
               pillar14.getHitRect(pillar14Rect);
               pillar15.getHitRect(pillar15Rect);
               pillar16.getHitRect(pillar16Rect);
               pillar17.getHitRect(pillar17Rect);
               pillar18.getHitRect(pillar18Rect);
               pillar19.getHitRect(pillar19Rect);
               pillar20.getHitRect(pillar20Rect);

               pillarTop1.getHitRect(pillarTop1Rect);
               pillarTop2.getHitRect(pillarTop2Rect);
               pillarTop3.getHitRect(pillarTop3Rect);
               pillarTop4.getHitRect(pillarTop4Rect);
               pillarTop5.getHitRect(pillarTop5Rect);
               pillarTop6.getHitRect(pillarTop6Rect);

               if(Rect.intersects(ballRect, pillar1Rect)) {
                   pillarTop4.setVisibility(View.INVISIBLE);
                   pillarTop5.setVisibility(View.INVISIBLE);
                   pillarTop6.setVisibility(View.INVISIBLE);

                   pillarTop1.setX(pillar2.getX());
                   pillarTop1.setY(pillar2.getY());
                   pillarTop2.setX(pillar1.getX());
                   pillarTop2.setY(pillar1.getY());
                   pillarTop3.setX(pillar20.getX());
                   pillarTop3.setY(pillar20.getY());
                   pillarTop4.setX(pillar19.getX());
                   pillarTop4.setY(pillar19.getY());
                   pillarTop5.setX(pillar18.getX());
                   pillarTop5.setY(pillar18.getY());
                   pillarTop6.setX(pillar17.getX());
                   pillarTop6.setY(pillar17.getY());
               } else if(Rect.intersects(ballRect, pillar2Rect)) {
                   pillarTop1.setX(pillar3.getX());
                   pillarTop1.setY(pillar3.getY());
                   pillarTop2.setX(pillar2.getX());
                   pillarTop2.setY(pillar2.getY());
                   pillarTop3.setX(pillar1.getX());
                   pillarTop3.setY(pillar1.getY());
                   pillarTop4.setX(pillar20.getX());
                   pillarTop4.setY(pillar20.getY());
                   pillarTop5.setX(pillar19.getX());
                   pillarTop5.setY(pillar19.getY());
                   pillarTop6.setX(pillar18.getX());
                   pillarTop6.setY(pillar18.getY());
               } else if(Rect.intersects(ballRect, pillar3Rect)) {
                   pillarTop4.setVisibility(View.INVISIBLE);
                   pillarTop5.setVisibility(View.INVISIBLE);
                   pillarTop6.setVisibility(View.INVISIBLE);

                   pillarTop1.setX(pillar4.getX());
                   pillarTop1.setY(pillar4.getY());
                   pillarTop2.setX(pillar3.getX());
                   pillarTop2.setY(pillar3.getY());
                   pillarTop3.setX(pillar2.getX());
                   pillarTop3.setY(pillar2.getY());
               } else if(Rect.intersects(ballRect, pillar4Rect)) {
                   pillarTop1.setX(pillar5.getX());
                   pillarTop1.setY(pillar5.getY());
                   pillarTop2.setX(pillar4.getX());
                   pillarTop2.setY(pillar4.getY());
                   pillarTop3.setX(pillar3.getX());
                   pillarTop3.setY(pillar3.getY());
               } else if(Rect.intersects(ballRect, pillar5Rect)) {
                   pillarTop1.setX(pillar6.getX());
                   pillarTop1.setY(pillar6.getY());
                   pillarTop2.setX(pillar5.getX());
                   pillarTop2.setY(pillar5.getY());
                   pillarTop3.setX(pillar4.getX());
                   pillarTop3.setY(pillar4.getY());
               } else if(Rect.intersects(ballRect, pillar6Rect)) {
                   pillarTop1.setX(pillar7.getX());
                   pillarTop1.setY(pillar7.getY());
                   pillarTop2.setX(pillar6.getX());
                   pillarTop2.setY(pillar6.getY());
                   pillarTop3.setX(pillar5.getX());
                   pillarTop3.setY(pillar5.getY());
               } else if(Rect.intersects(ballRect, pillar7Rect)) {
                   pillarTop1.setX(pillar8.getX());
                   pillarTop1.setY(pillar8.getY());
                   pillarTop2.setX(pillar7.getX());
                   pillarTop2.setY(pillar7.getY());
                   pillarTop3.setX(pillar6.getX());
                   pillarTop3.setY(pillar6.getY());
               } else if(Rect.intersects(ballRect, pillar8Rect)) {
                   pillarTop1.setX(pillar9.getX());
                   pillarTop1.setY(pillar9.getY());
                   pillarTop2.setX(pillar8.getX());
                   pillarTop2.setY(pillar8.getY());
                   pillarTop3.setX(pillar7.getX());
                   pillarTop3.setY(pillar7.getY());
               } else if(Rect.intersects(ballRect, pillar9Rect)) {
                   pillarTop1.setX(pillar10.getX());
                   pillarTop1.setY(pillar10.getY());
                   pillarTop2.setX(pillar9.getX());
                   pillarTop2.setY(pillar9.getY());
                   pillarTop3.setX(pillar8.getX());
                   pillarTop3.setY(pillar8.getY());
               } else if(Rect.intersects(ballRect, pillar10Rect)) {
                   pillarTop1.setX(pillar11.getX());
                   pillarTop1.setY(pillar11.getY());
                   pillarTop2.setX(pillar10.getX());
                   pillarTop2.setY(pillar10.getY());
                   pillarTop3.setX(pillar9.getX());
                   pillarTop3.setY(pillar9.getY());
               } else if(Rect.intersects(ballRect, pillar11Rect)) {
                   pillarTop1.setX(pillar12.getX());
                   pillarTop1.setY(pillar12.getY());
                   pillarTop2.setX(pillar11.getX());
                   pillarTop2.setY(pillar11.getY());
                   pillarTop3.setX(pillar10.getX());
                   pillarTop3.setY(pillar10.getY());
               } else if(Rect.intersects(ballRect, pillar12Rect)) {
                   pillarTop1.setX(pillar13.getX());
                   pillarTop1.setY(pillar13.getY());
                   pillarTop2.setX(pillar12.getX());
                   pillarTop2.setY(pillar12.getY());
                   pillarTop3.setX(pillar11.getX());
                   pillarTop3.setY(pillar11.getY());
               } else if(Rect.intersects(ballRect, pillar13Rect)) {
                   pillarTop1.setX(pillar14.getX());
                   pillarTop1.setY(pillar14.getY());
                   pillarTop2.setX(pillar13.getX());
                   pillarTop2.setY(pillar13.getY());
                   pillarTop3.setX(pillar12.getX());
                   pillarTop3.setY(pillar12.getY());
               } else if(Rect.intersects(ballRect, pillar14Rect)) {
                   pillarTop1.setX(pillar15.getX());
                   pillarTop1.setY(pillar15.getY());
                   pillarTop2.setX(pillar14.getX());
                   pillarTop2.setY(pillar14.getY());
                   pillarTop3.setX(pillar13.getX());
                   pillarTop3.setY(pillar13.getY());
               } else if(Rect.intersects(ballRect, pillar15Rect)) {
                   pillarTop1.setX(pillar16.getX());
                   pillarTop1.setY(pillar16.getY());
                   pillarTop2.setX(pillar15.getX());
                   pillarTop2.setY(pillar15.getY());
                   pillarTop3.setX(pillar14.getX());
                   pillarTop3.setY(pillar14.getY());
               } else if(Rect.intersects(ballRect, pillar16Rect)) {
                   pillarTop1.setX(pillar17.getX());
                   pillarTop1.setY(pillar17.getY());
                   pillarTop2.setX(pillar16.getX());
                   pillarTop2.setY(pillar16.getY());
                   pillarTop3.setX(pillar15.getX());
                   pillarTop3.setY(pillar15.getY());
               } else if(Rect.intersects(ballRect, pillar17Rect)) {
                   pillarTop1.setX(pillar18.getX());
                   pillarTop1.setY(pillar18.getY());
                   pillarTop2.setX(pillar17.getX());
                   pillarTop2.setY(pillar17.getY());
                   pillarTop3.setX(pillar16.getX());
                   pillarTop3.setY(pillar16.getY());
               } else if(Rect.intersects(ballRect, pillar18Rect)) {
                   pillarTop1.setX(pillar19.getX());
                   pillarTop1.setY(pillar19.getY());
                   pillarTop2.setX(pillar18.getX());
                   pillarTop2.setY(pillar18.getY());
                   pillarTop3.setX(pillar17.getX());
                   pillarTop3.setY(pillar17.getY());
               } else if(Rect.intersects(ballRect, pillar19Rect)) {
                   pillarTop1.setX(pillar20.getX());
                   pillarTop1.setY(pillar20.getY());
                   pillarTop2.setX(pillar19.getX());
                   pillarTop2.setY(pillar19.getY());
                   pillarTop3.setX(pillar18.getX());
                   pillarTop3.setY(pillar18.getY());
               } else if(Rect.intersects(ballRect, pillar20Rect)) {
                   pillarTop1.setX(pillar1.getX());
                   pillarTop1.setY(pillar1.getY());
                   pillarTop2.setX(pillar20.getX());
                   pillarTop2.setY(pillar20.getY());
                   pillarTop3.setX(pillar19.getX());
                   pillarTop3.setY(pillar19.getY());
               }

               if(Rect.intersects(ballRect, pillarTop1Rect) || Rect.intersects(ballRect, pillarTop2Rect) || Rect.intersects(ballRect, pillarTop3Rect)
                       || Rect.intersects(ballRect, pillarTop4Rect) || Rect.intersects(ballRect, pillarTop5Rect) || Rect.intersects(ballRect, pillarTop6Rect)) {

               } else {
                   gameOver();
               }

               h.postDelayed(this, delay);
           }
        }, delay);
    }

    public void gameOver() {
        gameOverCalled = true;
        h.removeCallbacksAndMessages(null);

        sendViewToBack(pillar1);
        sendViewToBack(pillar2);
        sendViewToBack(pillar3);
        sendViewToBack(pillar4);
        sendViewToBack(pillar5);
        sendViewToBack(pillar6);
        sendViewToBack(pillar7);
        sendViewToBack(pillar8);
        sendViewToBack(pillar9);
        sendViewToBack(pillar10);
        sendViewToBack(pillar11);
        sendViewToBack(pillar12);
        sendViewToBack(pillar13);
        sendViewToBack(pillar14);
        sendViewToBack(pillar15);
        sendViewToBack(pillar16);
        sendViewToBack(pillar17);
        sendViewToBack(pillar18);
        sendViewToBack(pillar19);
        sendViewToBack(pillar20);

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
        pillar11.setVisibility(View.INVISIBLE);
        pillar12.setVisibility(View.INVISIBLE);
        pillar13.setVisibility(View.INVISIBLE);
        pillar14.setVisibility(View.INVISIBLE);
        pillar15.setVisibility(View.INVISIBLE);
        pillar16.setVisibility(View.INVISIBLE);
        pillar17.setVisibility(View.INVISIBLE);
        pillar18.setVisibility(View.INVISIBLE);
        pillar19.setVisibility(View.INVISIBLE);
        pillar20.setVisibility(View.INVISIBLE);
        pillarTop1.setVisibility(View.INVISIBLE);
        pillarTop2.setVisibility(View.INVISIBLE);
        pillarTop3.setVisibility(View.INVISIBLE);
        pillarTop4.setVisibility(View.INVISIBLE);
        pillarTop5.setVisibility(View.INVISIBLE);
        pillarTop6.setVisibility(View.INVISIBLE);
        ball.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);

        if(scoreVal > highScoreVal) {
            highScoreVal = scoreVal;
            editor = pref.edit();
            editor.putInt("highScoreSaved", highScoreVal);
            editor.commit();
        }

        scoreOnBoard.setText(String.valueOf(scoreVal));
        highScoreOnBoard.setText(String.valueOf(highScoreVal));

        gameOver.setVisibility(View.VISIBLE);
        retryBtn.setVisibility(View.VISIBLE);
        scoreBoard.setVisibility(View.VISIBLE);
        scoreOnBoard.setVisibility(View.VISIBLE);
        highScoreOnBoard.setVisibility(View.VISIBLE);

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onCreateNew();
                playBtnClicked();
                movement();
            }
        });
    }

    public static void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup) child.getParent();
        if(parent != null) {
            parent.removeView(child);
            parent.addView(child, 6);
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
