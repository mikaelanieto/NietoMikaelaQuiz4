package com.example.nietomikaelaquiz4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtPassword, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName =findViewById(R.id.tvUser);
        txtPassword = findViewById(R.id.tvPassword);
        txtEmail = findViewById(R.id.etEmail);
    }

    public void showActivity2(View v) {
        Intent i = new Intent(this, Activity2.class);
        String name = txtEmail.getText().toString();
        Intent i2 = new Intent(this, Activity3.class);
        i2.putExtra("person", name);
        startActivity(i);
    }

    public void saveExternal(View v) {
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user", txtName.getText().toString());
        editor.putString("user", txtPassword.getText().toString());
        editor.putString("user", txtEmail.getText().toString());
        editor.commit();
        Toast.makeText(this, "saved data in external storage", Toast.LENGTH_LONG).show();
    }

}
