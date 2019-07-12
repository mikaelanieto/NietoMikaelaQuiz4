package com.example.nietomikaelaquiz4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    TextView txtName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtName =findViewById(R.id.etName);
        txtPassword = findViewById(R.id.etPassword);
    }

    public void showMainActivity(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void showActivity3(View v) {
        Intent i = new Intent(this, Activity3.class);
        startActivity(i);
    }

    public void displayInternal(View v) {

        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            fis = openFileInput("user.txt");
            while ((letter = fis.read()) != -1) {
                buffer.append((char) letter);
            }
        }

        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

        txtName.setText(buffer.substring(0, buffer.indexOf(",")));
        txtPassword.setText(buffer.substring(buffer.indexOf(",")+1));
    }

}
