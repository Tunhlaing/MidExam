package com.example.midexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etUserNameRe,etPasswordRe,etPasswordConfirmRe;
    Button btRegister;
    RegisterDb db;

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


    }
    private void handlerClick() {
        btRegister.setOnClickListener(view -> {
           if(checkDataEntered()) {
               if (db.addUser(etUserNameRe.getText().toString(),etPasswordRe.getText().toString())) {

                   Utils.showToast(this, "Register successful");
               } else {
                   Utils.showToast(this, "something wrong");
               }
           }

        });
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
