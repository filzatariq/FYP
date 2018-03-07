package com.example.pdbsflhr22.generalprototype;

/**
 * Created by KaNza_Yahya on 23/02/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmRide extends AppCompatActivity {

    Button riderButton, DriverButton, confirmRiderButton;
    EditText seatsEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrm_ride);

        riderButton = (Button)findViewById(R.id.rider_button);
        DriverButton = (Button)findViewById(R.id.driver_button);
        confirmRiderButton = (Button)findViewById(R.id.confirm_ride_button);
        seatsEditText = (EditText)findViewById(R.id.seats_edit_text);


        riderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seatsEditText.setVisibility(View.INVISIBLE);
            }
        });

        DriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seatsEditText.setVisibility(View.VISIBLE);

            }
        });

        confirmRiderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Your Ride is Confirmed!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });


    }
}

