package com.example.pdbsflhr22.shareride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class SignupActivity extends Activity implements View.OnClickListener {
    private static String APPID = "78B99260-0440-BC64-FF07-0D8B00C0FF00";
    private static String APIKEY = "CFB37F63-3F25-54D1-FFE4-3FA539FAF700";
    int count = 0;
    EditText ed_name,ed_email,ed_password;
    TextView tv_login;
    Button btn_register;

    BackendlessUser user = new BackendlessUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_register=findViewById(R.id.btn_register);
        ed_name=findViewById(R.id.ed_name);
        ed_email=findViewById(R.id.ed_email);
        ed_password=findViewById(R.id.ed_password);
        tv_login=findViewById(R.id.tv_login);
        Backendless.initApp(this, APPID, APIKEY);


        tv_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);


    }


    public void mSignUp(){
        final String str_name = ed_name.getText().toString();
        final String str_email = ed_email.getText().toString();
        final String str_pwd = ed_password.getText().toString();
        user.setEmail(ed_email.getText().toString());
        user.setPassword(ed_password.getText().toString());
        user.setProperty("name", ed_name.getText().toString());




        if (TextUtils.isEmpty(str_name)) {
            ed_name.setError("Can't be Empty");
            ed_name.requestFocus();
            return;
        }if (TextUtils.isEmpty(str_email)) {
            ed_email.setError("Email Field Can't be Empty");
            ed_email.requestFocus();
            return;
        }if (TextUtils.isEmpty(str_pwd)) {
            ed_password.setError("Can't be Empty");
            ed_password.requestFocus();
            return;
        }
        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                //  progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(), "User has been registered", Toast.LENGTH_LONG).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
//                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
    public Context getContext() {
        return this;
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


                break;
            default:
                break;
        }
    }
}
