package com.example.nietomikaelaquiz4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity3 extends AppCompatActivity {

    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txtEmail =findViewById(R.id.tvEmail);
    }
    public void showActivity2(View v) {
        Intent i = new Intent(this, Activity2.class);
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
        txtEmail.setText(buffer.substring(buffer.indexOf(",")+2));
    }

}
