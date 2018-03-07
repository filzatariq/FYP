package com.example.pdbsflhr22.generalprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyRide extends AppCompatActivity {
    Button scheduleButton, historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ride);

        scheduleButton=(Button)findViewById(R.id.schedule_button);
        historyButton=(Button)findViewById(R.id.history_button);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyRide.this, Schedule.class);
                startActivity(intent);
                finish();
            }
        });


        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyRide.this, History.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
