package com.example.androidlab.broadcastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Este método é chamado toda vez que um evento
        // de broadcast é chamado
        if (intent.getAction() != null && intent.getAction().
                equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            boolean isAirplaneModeOn = intent.
                    getBooleanExtra("state", false);
            String msg = isAirplaneModeOn ? "Airplane Mode ins On" : "Airplane Mode is OFF";
            Toast.makeText(context, ""+msg, Toast.LENGTH_LONG).show();
        }
    }
}
