package com.example.harshita.keygaurdapp;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        Intent intent = keyguardManager.createConfirmDeviceCredentialIntent("User Authentication Required",
                "Please use your device password to continue.");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (intent != null) {
            super.startActivityForResult(intent, requestCode);
        } else {
            Toast.makeText(this, "Please set password on device.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == -1) {
                Toast.makeText(this, "Welcome you successfully entered passcode.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error You failed to enter correct passcode.", Toast.LENGTH_LONG).show();
            }
        }
    }

}