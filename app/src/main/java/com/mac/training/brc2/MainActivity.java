package com.mac.training.brc2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
BroadcastReceiver mR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter iF = new IntentFilter();
        iF.addAction("com.mac.training.br2.MyAction");

        mR = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context,
                        "New one\n" + intent.getStringExtra("K"),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        };
        registerReceiver(mR, iF);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mR != null){
            unregisterReceiver(mR);
        }
    }
}
