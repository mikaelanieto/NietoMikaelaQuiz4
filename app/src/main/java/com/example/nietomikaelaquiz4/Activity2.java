package com.example.nietomikaelaquiz4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView txtName, txtPassword, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtName =findViewById(R.id.tvUser);
        txtPassword = findViewById(R.id.tvPassword);
    }

    public void showMainActivity(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void showScreen2(View v) {
        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        txtName.setText(sp.getString("user", ""));
        txtPassword.setText(sp.getString("user", ""));
        String name = txtName.getText().toString();
        Intent i2 = new Intent(this, Activity2.class);
        i2.putExtra("person", name);
        startActivity(i2);
    }

}
