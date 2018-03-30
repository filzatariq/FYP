package com.example.pdbsflhr22.shareride;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by KaNza_Yahya on 23/02/2018.
 */

public class ActivityEdit_profile extends AppCompatActivity{

        Button btn_back, btn_update;
        // EditText etname;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.userprofile);

            btn_back=(Button)findViewById(R.id.btn_back);
            btn_update=(Button)findViewById(R.id.btn_update);

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ActivityEdit_profile.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

        }


    }

