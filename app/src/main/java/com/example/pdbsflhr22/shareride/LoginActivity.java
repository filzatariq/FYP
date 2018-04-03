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

public class LoginActivity extends Activity implements View.OnClickListener {
    private static String APPID = "78B99260-0440-BC64-FF07-0D8B00C0FF00";
    private static String APIKEY = "CFB37F63-3F25-54D1-FFE4-3FA539FAF700";

    int count = 0;
    Button btn_login;
    EditText Ed_email,Ed_password;
    TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=findViewById(R.id.btn_login);
        Ed_email=findViewById(R.id.Ed_email);
        Ed_password=findViewById(R.id.Ed_password);
        tv_register=findViewById(R.id.tv_register);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    public void mLogin(){
        Backendless.initApp(this, APPID, APIKEY);

        Backendless.UserService.login(Ed_email.getText().toString(), Ed_password.getText().toString(),
                new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(getContext(), "User has been logged in", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        final String str_username = Ed_email.getText().toString();
        final String str_password = Ed_password.getText().toString();


        if (TextUtils.isEmpty(str_username)) {
            Ed_email.setError("Can't be Empty");
            Ed_email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(str_password)) {
            Ed_password.setError("Can't be Empty");
            Ed_password.requestFocus();
            return;
        }

       /* Toast.makeText(this, "Successfully Login\t"+Ed_email.getText().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
        finish();*/

    }
    public Context getContext() {
        return this;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_login:
             //   mLogin();
                Toast.makeText(this, "Successfully Login\t"+Ed_email.getText().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
        finish();
               // finish();
                break;

            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
