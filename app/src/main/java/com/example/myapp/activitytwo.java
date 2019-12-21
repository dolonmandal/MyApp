package com.example.myapp;

import android.content.ActivityNotFoundException;

import android.content.Intent;

import android.speech.RecognizerIntent;


import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.ArrayList;

import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;




public class activitytwo extends AppCompatActivity {



    private TextView voiceInput;

    private Button micButton;

    private final int REQ_CODE_VOICE_INPUT = 100;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activitytwo);



        voiceInput = (TextView) findViewById(R.id.outputtext);

        micButton = (Button) findViewById(R.id.button);



        micButton.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {

                getVoiceInput();

            }

        });



    }



    //trigger RecognizerIntent

    //Prompt Google Voice Assistant

    //Start ActivityForResult which sends the input later we will recieve it

    private void getVoiceInput() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,

                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,("Please speak something "));

        try {

            startActivityForResult(intent, REQ_CODE_VOICE_INPUT);

        } catch (ActivityNotFoundException a) {



        }

    }



    //Recieve voice input and display result

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);



        switch (requestCode) {

            case REQ_CODE_VOICE_INPUT: {

                if (resultCode == RESULT_OK && null != data) {



                    ArrayList<String> result = data

                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    voiceInput.setText(result.get(0));

                }

                break;

            }



        }

    }

}
