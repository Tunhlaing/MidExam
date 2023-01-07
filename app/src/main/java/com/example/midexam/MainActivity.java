package com.example.midexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etUserNameRe,etPasswordRe,etPasswordConfirmRe;
    Button btRegister,btLoginMain;
    RegisterDb db;
    TextView tvAlreadyAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handlerClick();
        db = new RegisterDb(this);

    }

    private void initView() {
        etUserNameRe = findViewById(R.id.etUserNameRe);
        etPasswordRe = findViewById(R.id.etPasswordRe);
        etPasswordConfirmRe = findViewById(R.id.etPasswordConfirmRe);
        btRegister = findViewById(R.id.btRegister);
        tvAlreadyAcc = findViewById(R.id.tvAlreadyAcc);
        btLoginMain = findViewById(R.id.btLoginMain);


    }
    private void handlerClick() {
        btRegister.setOnClickListener(view -> {
           if(checkDataEntered()) {
               if (db.addUser(etUserNameRe.getText().toString(),etPasswordRe.getText().toString())) {

                   Utils.showToast(this, "Register successful");
                   Intent i = new Intent(this,LoginActivity.class);
                   startActivity(i);
               } else {
                   Utils.showToast(this, "something wrong");
               }

           }

        });
        btLoginMain.setOnClickListener((view -> {
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);

        }));
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private boolean checkDataEntered() {

        if (isEmpty(etUserNameRe)) {
            Utils.showToast(this, "You Must Enter UserName");
            return false;
        }
        if(db.checkUserName(etUserNameRe.getText().toString())){
            Utils.showToast(this,"UserName is already exist.");
            return false;
        }
       else if (isEmpty(etPasswordRe)) {
            Utils.showToast(this, "You Must Enter Password");
            return false;
        } else if (etPasswordRe.getText().toString().length() < 6) {
            Utils.showToast(this, "Password Length should be greater than 6");
            return false;
        } else if (isEmpty(etPasswordConfirmRe)) {
            Utils.showToast(this, "You Must Enter Confirm Password");
            return false;
        } else if (!etPasswordRe.getText().toString().equals(etPasswordConfirmRe.getText().toString())) {
            Utils.showToast(this, "You Must Be Same Password");
            return false;
        } else {
            return true;
        }

    }
    }
