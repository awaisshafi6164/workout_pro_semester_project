package com.kaafdevs.workoutpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class WorkStartActivity extends AppCompatActivity {

    TextView exName;
    LottieAnimationView jsonAnimation;
    String buttonvalue;

    Button startBtn;
    CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_start);

        myMethod();

        startBtn = findViewById(R.id.startBtn);
        mtextview = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MTimeRunning){
                    stopTimer();
                }else{
                    startTimer();
                }
            }
        });
    }

    private void stopTimer(){
        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("START");
    }

    private void startTimer(){
        final CharSequence valeu1 = mtextview.getText();
        String num1 = valeu1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        MTimeLeftinmills = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long l) {
                MTimeLeftinmills = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newValue = Integer.valueOf(buttonvalue)+1;
                if(newValue  <= 7){
                    Intent intent = new Intent(WorkStartActivity.this, WorkStartActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);
                    finish();
                }
                else{
                    newValue = 1;
                    Intent intent = new Intent(WorkStartActivity.this, WorkStartActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);
                    finish();
                }
            }
        }.start();

        startBtn.setText("PAUSE");
        MTimeRunning = true;
    }

    private void updateTimer(){
        int minutes = (int) MTimeLeftinmills / 60000;
        int seconds = (int) MTimeLeftinmills % 60000 / 1000;

        String timeLeftText = "";

        if(minutes < 10){
            timeLeftText = "0";
        }
        timeLeftText = timeLeftText + minutes + ":";

        if(seconds < 10){
            timeLeftText += "0";
        }
        timeLeftText += seconds;

        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void myMethod(){

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        exName = findViewById(R.id.exName_TV);
        jsonAnimation = findViewById(R.id.jsonAnimation);

        int intValue = Integer.valueOf(buttonvalue);

        if(intValue == 1){
            exName.setText("Military Push Ups");
            jsonAnimation.setAnimation(R.raw.pushups);
        }
        else if(intValue == 2){
            exName.setText("Jumping Squats");
            jsonAnimation.setAnimation(R.raw.jumpingsquats);
        }
        else if(intValue == 3){
            exName.setText("Burpee And Jump");
            jsonAnimation.setAnimation(R.raw.burpeeandjumpexercise);
        }
        else if(intValue == 4){
            exName.setText("Inch Worm");
            jsonAnimation.setAnimation(R.raw.inchworm);
        }
        else if(intValue == 5){
            exName.setText("Jumping Jack");
            jsonAnimation.setAnimation(R.raw.jumpingjack);
        }
        else if(intValue == 6){
            exName.setText("Leg Hip Rotation");
            jsonAnimation.setAnimation(R.raw.singleleghiprotation);
        }
        else if(intValue == 7){
            exName.setText("Punches");
            jsonAnimation.setAnimation(R.raw.punches);
        }
        else if(intValue == 8){
            exName.setText("Reverse Crunches");
            jsonAnimation.setAnimation(R.raw.reversecrunches);
        }
        else if(intValue == 9){
            exName.setText("Seated ABS Circles");
            jsonAnimation.setAnimation(R.raw.seatedabscircles);
        }
        else if(intValue == 10){
            exName.setText("Shoulder Stretch");
            jsonAnimation.setAnimation(R.raw.shoulderstretch);
        }
        else if(intValue == 11){
            exName.setText("Split Jump");
            jsonAnimation.setAnimation(R.raw.splitjumpexercise);
        }
        else if(intValue == 12){
            exName.setText("Squat Kick");
            jsonAnimation.setAnimation(R.raw.squatkick);
        }
        else if(intValue == 13){
            exName.setText("Squat Reach");
            jsonAnimation.setAnimation(R.raw.squatreach);
        }
        else if(intValue == 14){
            exName.setText("Staggered Push Ups");
            jsonAnimation.setAnimation(R.raw.staggeredpushups);
        }
        else if(intValue == 15){
            exName.setText("Wide Push Ups");
            jsonAnimation.setAnimation(R.raw.widearmpushup);
        }

    }
}