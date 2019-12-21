package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity {

    Button button;
    Button closeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.idnewbutton);

    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, activity2.class);
        startActivity(intent);
    }
}


