package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


        	public class activity2 extends AppCompatActivity {

       	    TabHost host;

                Button button;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity2);
                    Button b1 = (Button) findViewById(R.id.button);
                    Button b2 = (Button) findViewById(R.id.button2);
                    Button b3 = (Button) findViewById(R.id.button3);


                    b1.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            Intent myintent2 = new Intent(activity2.this, activityone.class);
                            startActivity(myintent2);

                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            Intent myintent2 = new Intent(activity2.this, activitytwo.class);
                            startActivity(myintent2);

                        }
                    });
                    b3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            Intent myintent2 = new Intent(activity2.this, activityfour.class);
                            startActivity(myintent2);

                        }
                    });







        host = (TabHost)findViewById(R.id.tabHost);

        host.setup();



        //Tab 1

        TabHost.TabSpec spec = host.newTabSpec("Task One");

        //set the content for the tab as we set content for an activity in the oncreate method

//you can pass an intent to this as well to load activity or load a fragmen

        //ctivity_main.xml

                // we will pass the tab1 id to our setcontent method



        spec.setContent(R.id.tab1);

        spec.setIndicator("Task One");

        host.addTab(spec);



        //Tab 2

        spec = host.newTabSpec("Task Two");

        spec.setContent(R.id.tab2);

        spec.setIndicator("Task Two");

        host.addTab(spec);



        //Tab 3

        spec = host.newTabSpec("Task Three");

        spec.setContent(R.id.tab3);

        spec.setIndicator("Task Three");

        host.addTab(spec);



    }

}
