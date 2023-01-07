package com.example.midexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeScreenActivity extends AppCompatActivity {
    EditText etStatus;
    TextView etShortMessage,tvStatus;
    Button btUpload;
    RegisterDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initView();
        db = new RegisterDb(this);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        etShortMessage.setText("welcome " + username);

//        btUpload.setOnClickListener(view -> {
//            db.checkUpload(username,password,etStatus.getText().toString());
//            Utils.showToast(this,"update status");
//        });
//        tvStatus.getText().toString(db.getDbList();

    }

    private void initView() {
        etShortMessage = findViewById(R.id.etShortMessage);
        etStatus = findViewById(R.id.etStatus);
        btUpload = findViewById(R.id.btUpload);
        tvStatus = findViewById(R.id.tvStatus);

    }
}