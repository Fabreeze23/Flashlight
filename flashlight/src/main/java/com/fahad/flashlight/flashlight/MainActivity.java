package com.fahad.flashlight.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Camera.Parameters;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final ToggleButton lightSwitch = (ToggleButton) findViewById(R.id.Lightswitch); //XML bridge finds Lightswitch compound button
       final Camera cam = Camera.open(); //Starts instance of camera... just used to pass down parameters to Parameters class
       final Parameters parameters = cam.getParameters(); //Gets current parameters for camera

        lightSwitch.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) { //Listens for Clicks on lightSwitch
               if (lightSwitch.isChecked()) { // If checked, Flash Mode is Torch
                   parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                   cam.setParameters(parameters); //Passes down new parameters to cam
               }
               if (!lightSwitch.isChecked()) //If lightSwitch is not checked...
               {parameters.setFlashMode(Parameters.FLASH_MODE_OFF);// Flash Mode is off
                   cam.setParameters(parameters); //New parameters passed on to cam
               }
           }
       });
      }
    }

