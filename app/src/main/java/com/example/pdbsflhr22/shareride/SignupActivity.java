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

public class SignupActivity extends Activity implements View.OnClickListener {
    int count = 0;
    EditText ed_name,ed_email,ed_phone,ed_password,ed_plate;
    TextView tv_login;
    Button btn_register,btn_rider,btn_driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_register=findViewById(R.id.btn_register);
        btn_rider=findViewById(R.id.btn_rider);
        btn_driver=findViewById(R.id.btn_driver);
        ed_name=findViewById(R.id.ed_name);
        ed_email=findViewById(R.id.ed_email);
        ed_phone=findViewById(R.id.ed_phone);
        ed_password=findViewById(R.id.ed_password);
        tv_login=findViewById(R.id.tv_login);
        ed_plate =findViewById(R.id.ed_plate);

        tv_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_rider.setOnClickListener(this);
        btn_driver.setOnClickListener(this);
        ed_plate.setOnClickListener(this);


    }


    public void mSignUp(){
        if (count == 0) {
            btn_rider.setEnabled(false);
            btn_driver.setEnabled(false);
        }

        final String str_name = ed_name.getText().toString();
        final String str_email = ed_email.getText().toString();
        final String str_phone = ed_phone.getText().toString();
        final String str_pwd = ed_password.getText().toString();
        final String str_plate = ed_plate.getText().toString();



        if (TextUtils.isEmpty(str_name)) {
            ed_name.setError("Can't be Empty");
            ed_name.requestFocus();
            return;
        }if (TextUtils.isEmpty(str_email)) {
            ed_email.setError("Email Field Can't be Empty");
            ed_email.requestFocus();
            return;
        }if (TextUtils.isEmpty(str_phone)) {
            ed_phone.setError("Can't be Empty");
            ed_phone.requestFocus();
            return;
        }if (TextUtils.isEmpty(str_pwd)) {
            ed_password.setError("Can't be Empty");
            ed_password.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(str_plate)) {
            ed_plate.setError("Can't be Empty");
            ed_plate.requestFocus();
            return;
        }

        Toast.makeText(this, ""+ed_name.getText().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tv_login:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;

            case R.id.btn_register:
                mSignUp();
                startActivity(new Intent(this,MapsActivity.class));
                finish();

                break;
            case R.id.btn_rider:
                count++;
                btn_rider.setEnabled(false);
                Toast.makeText(this, "Button Disabled", Toast.LENGTH_LONG).show();
                btn_driver.setEnabled(true);
                mSignUp();
                ed_plate.setVisibility(View.INVISIBLE);

                startActivity(new Intent(this,MapsActivity.class));


                break;
            case R.id.btn_driver:
                Toast.makeText(this, "Button Disabled", Toast.LENGTH_LONG).show();
                count--;
                btn_rider.setEnabled(true);
                btn_driver.setEnabled(false);
                ed_plate.setVisibility(View.VISIBLE);
                mSignUp();
                startActivity(new Intent(this,MapsActivity.class));

                break;
            default:
                break;
        }
    }
}
