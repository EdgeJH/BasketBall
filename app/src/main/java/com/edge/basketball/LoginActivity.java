package com.edge.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailEdit,pwdEdit;
    Button loginBt,signupBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        emailEdit = findViewById(R.id.email_edit);
        pwdEdit = findViewById(R.id.pwd_edit);
        loginBt = findViewById(R.id.login_bt);
        signupBt = findViewById(R.id.signup_bt);
        setClickListener();
    }

    private void setClickListener(){
        loginBt.setOnClickListener(new MyClickListner());
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        signupBt.setOnClickListener(onClickListener);
        signupBt.setOnClickListener(this);
    }
    View.OnClickListener onClickListener  =new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    class MyClickListner implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_bt:
                String email = emailEdit.getText().toString();
                String pwd = pwdEdit.getText().toString();
                Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
                break;
            case R.id.signup_bt:
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }


}
