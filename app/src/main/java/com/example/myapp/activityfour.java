package com.example.myapp;

import android.Manifest;

import android.content.Context;

import android.content.DialogInterface;

import android.content.pm.PackageManager;

import android.hardware.camera2.CameraAccessException;

import android.hardware.camera2.CameraManager;

import android.content.DialogInterface;

import android.app.AlertDialog;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;





public class activityfour extends AppCompatActivity {



    private Button flashLight;

    private static final int CAMERA_REQUEST = 50;

    private boolean flashLightStatus = false;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activitythree);



        flashLight = (Button) findViewById(R.id.button);



        ActivityCompat.requestPermissions(activityfour.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);



        final boolean hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);



        if (!hasCameraFlash) {

            AlertDialog alert = new AlertDialog.Builder(activityfour.this)

                    .create();

            alert.setTitle("Error !!");

            alert.setMessage("Your device doesn't support flash light!");

            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    // close the application

                    finish();

                    System.exit(0);

                }

            });

            alert.show();

            return;

        }



        flashLight.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                {

                    if (flashLightStatus)

                        turnLightOff();
                    else

                        turnLightOn();

                }

            }

        });

    }



    private void turnLightOn() {

        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {

            String cam_Id = cameraManager.getCameraIdList()[0];

            cameraManager.setTorchMode(cam_Id, true);

            flashLightStatus = true;

        } catch (CameraAccessException e) {

        }

    }



    private void turnLightOff() {

        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {

            String cam_Id = cameraManager.getCameraIdList()[0];

            cameraManager.setTorchMode(cam_Id, false);

            flashLightStatus = false;

        } catch (CameraAccessException e) {

        }

    }



    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case CAMERA_REQUEST:

                if (!(grantResults.length > 0) && !(grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    AlertDialog alert = new AlertDialog.Builder(activityfour.this)

                            .create();

                    alert.setTitle("Error !!");

                    alert.setMessage("Camera permission not granted!");

                    alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            // close the application

                            finish();

                            System.exit(0);

                        }

                    });

                    alert.show();

                    return;

                }

                break;

        }

    }

}
