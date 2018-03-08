package com.example.pdbsflhr22.shareride;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    int count = 0;
    Button btn_login/*,btn_rider,btn_driver*/;
    EditText Ed_username,Ed_password;
    TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=findViewById(R.id.btn_login);
       /* btn_rider=findViewById(R.id.btn_rider);
        btn_driver=findViewById(R.id.btn_driver);*/
        Ed_username=findViewById(R.id.Ed_username);
        Ed_password=findViewById(R.id.Ed_password);
        tv_register=findViewById(R.id.tv_register);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        /*btn_rider.setOnClickListener(this);
        btn_driver.setOnClickListener(this);*/
    }

    public void mLogin(){
/*
            if (count == 0) {
                btn_rider.setEnabled(false);
                btn_driver.setEnabled(false);
            }*/

        final String str_username = Ed_username.getText().toString();
        final String str_password = Ed_password.getText().toString();


        if (TextUtils.isEmpty(str_username)) {
            Ed_username.setError("Can't be Empty");
            Ed_username.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(str_password)) {
            Ed_password.setError("Can't be Empty");
            Ed_password.requestFocus();
            return;
        }

        Toast.makeText(this, "Successfully Login\t"+Ed_username.getText().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_login:
                mLogin();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
                break;

            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
                break;
            /*case R.id.btn_rider:
                count++;
                btn_rider.setEnabled(false);
                Toast.makeText(this, "Button Disabled", Toast.LENGTH_LONG).show();
                btn_driver.setEnabled(true);
                mLogin();
                break;
            case R.id.btn_driver:
                Toast.makeText(this, "Button Disabled", Toast.LENGTH_LONG).show();
                count--;
                btn_rider.setEnabled(true);
                btn_driver.setEnabled(false);
                mLogin();
                break;*/
            default:
                break;
        }
    }
}
