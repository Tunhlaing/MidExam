package com.example.midexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText etUserNameLi,etPasswordLi;
    Button btLogin;
    RegisterDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        handlerClick();

    }

    private void initView() {
        etUserNameLi = findViewById(R.id.etUserNameLi);
        etPasswordLi = findViewById(R.id.etPasswordLi);
        btLogin = findViewById(R.id.btLogin);
        db = new RegisterDb(this);
            }
    private void handlerClick() {
        btLogin.setOnClickListener(view -> {
        Boolean loginUserPass = db.checkLogin(etUserNameLi.getText().toString(),etPasswordLi.getText().toString());
        if(loginUserPass==true){

            Utils.showToast(this,"Login success full");
            Intent i = new Intent(this,HomeScreenActivity.class);
            i.putExtra("username",etUserNameLi.getText().toString());
            i.putExtra("password",etPasswordLi.getText().toString());




            startActivity(i);

        }else{
            Utils.showToast(this,"check username and password");
        }

        });
    }
}