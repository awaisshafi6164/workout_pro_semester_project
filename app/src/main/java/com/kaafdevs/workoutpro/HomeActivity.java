package com.kaafdevs.workoutpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Collections;

public class HomeActivity extends AppCompatActivity {

    Button beforeAgeBtn, afterAgeBtn, foodTipsBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        beforeAgeBtn = findViewById(R.id.beforeAgeBtn);
        afterAgeBtn = findViewById(R.id.afterAgeBtn);
        foodTipsBtn = findViewById(R.id.tipsBtn);

        beforeAgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, beforeAgeActivity.class);
                startActivity(intent);
            }
        });

        afterAgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, beforeAgeActivity.class);
                startActivity(intent);
            }
        });

        foodTipsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_exp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.aboutUs:
                Toast.makeText(this, "About Us is Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, About_Us_Activity.class);
                startActivity(intent);
                return true;

            case R.id.share:
                Toast.makeText(this, "Share is Selected", Toast.LENGTH_SHORT).show();
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_TEXT,
                        "APP Name: Workout Pro \nMade By: Abdullah Saleem & Muhammad Awais Shafi \n24765 & 22930");
                startActivity(Intent.createChooser(intentShare, "Share Via..."));
                return true;

            case R.id.LogOut:
                Toast.makeText(this, "Log Out is Selected", Toast.LENGTH_SHORT).show();

                mAuth.signOut();
                Intent in = new Intent(HomeActivity.this, WelcomeActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}