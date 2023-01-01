package com.example.midexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
           checkDataEntered();
            if (db.addUser(etUserNameRe.getText().toString(),etPasswordRe.getText().toString())) {

                Utils.showToast(this,"already Register");
            } else {
                Utils.showToast(this,"something wrong");
            }


        });
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);

    }

    private void checkDataEntered() {

        if (isEmpty(etUserNameRe)){
            Utils.showToast(this,"You Must Enter UserName");
        }
        if (isEmpty(etPasswordRe)){
            Utils.showToast(this,"You Must Enter Password");
        }
        if (isEmpty(etPasswordConfirmRe)){
            Utils.showToast(this,"You Must Enter Confirm Password");
        }
         if (etPasswordRe != etPasswordConfirmRe){
            Utils.showToast(this,"You Must Be Same Password");
        }
        else {
            Utils.showToast(this,"please try again");
        }



    }
}