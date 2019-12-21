package com.example.myapp;

import android.app.Activity;

import android.os.Bundle;

import android.speech.tts.TextToSpeech;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import java.util.Locale;



public class activityone extends Activity implements TextToSpeech.OnInitListener {



    private TextToSpeech tts;

    private Button btnSubmit;

    private EditText inputText;



    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activityone);



        tts = new TextToSpeech(this, this);



        btnSubmit = (Button) findViewById(R.id.button);



        inputText = (EditText) findViewById(R.id.inputtext);



        btnSubmit.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {

                voiceOutput();

            }

        });

    }



    private void voiceOutput() {



        CharSequence text = inputText.getText();



        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");

    }



    @Override

    public void onInit(int status) {



        if (status == TextToSpeech.SUCCESS) {

            //set language, you can change to any built in language given we are using US language locale

            int result = tts.setLanguage(Locale.US);

            float i = 50;



            if (result == TextToSpeech.LANG_MISSING_DATA

                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {

                Toast.makeText(activityone.this, "Language not supported!", Toast.LENGTH_SHORT).show();

            } else {

                btnSubmit.setEnabled(true);

                voiceOutput();

            }



        } else {

            Toast.makeText(activityone.this, "Initilization failed!", Toast.LENGTH_SHORT).show();

        }

    }



    @Override

    public void onDestroy() {

        //shutdown TextToSpeech

        if (tts != null) {

            tts.stop();

            tts.shutdown();

        }

        super.onDestroy();

    }

}
