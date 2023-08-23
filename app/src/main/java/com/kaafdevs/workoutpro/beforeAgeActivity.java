package com.kaafdevs.workoutpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class beforeAgeActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_age);


        newArray = new int[]{
                R.id.pushup_pose, R.id.jumpingSquats_pose, R.id.burpeeJump_pose, R.id.inchWorm_pose,
                R.id.jumpingJack_pose, R.id.single_leg_pose, R.id.punches_pose, R.id.reverseClutues_pose,
                R.id.seatedAbs_pose, R.id.shoulderStretch_pose, R.id.splitJump_pose, R.id.squatKick_pose,
                R.id.squatReach_pose, R.id.staggeredPushup_pose, R.id.wideArmPush_pose
        };
    }

    public void Imagebuttonclicked(View view) {

        for(int i=0; i< newArray.length;i++){

            if(view.getId() == newArray[i]){
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));

                Intent intent = new Intent(beforeAgeActivity.this, WorkStartActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }

        }

    }
}