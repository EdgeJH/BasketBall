package com.edge.basketball;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout back;
    Button sendNumber;
    EditText phone,pincode;
    TextView next;
    String email,pwd,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        getData();
        initView();
        checkPermission();
    }

    private void getData(){
        email = getIntent().getStringExtra("email");
        pwd = getIntent().getStringExtra("pwd");
        name = getIntent().getStringExtra("name");
    }

    private void initView(){
        back  =findViewById(R.id.back);
        sendNumber =findViewById(R.id.send_number);
        phone = findViewById(R.id.phone);
        pincode  = findViewById(R.id.pincode);
        next = findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
        sendNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.next:
                break;
            case R.id.send_number:
                break;
        }

    }

    private void checkPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},100);
        } else {
            phone.setText(getPhoneNumber());
        }
    }

    @SuppressLint("MissingPermission")
    private String getPhoneNumber(){
        TelephonyManager telephonyManager  = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        return telephonyManager.getLine1Number();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }
    }
}
