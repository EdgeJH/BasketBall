package com.edge.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout back;
    EditText emailEdit,pwdEdit,nameEdit;
    TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

    }

    private void initView(){
        back = findViewById(R.id.back);
        emailEdit = findViewById(R.id.email_edit);
        pwdEdit = findViewById(R.id.pwd_edit);
        nameEdit =findViewById(R.id.name_edit);
        next  =findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;

            case R.id.next:
                String email = emailEdit.getText().toString().replace(" ","");
                String pwd = pwdEdit.getText().toString().replace(" ","");
                String name = nameEdit.getText().toString().replace(" ","");
                Intent intent = new Intent(SignUpActivity.this,PhoneActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("pwd",pwd);
                intent.putExtra("name",name);
                startActivity(intent);

                break;
        }
    }
}
