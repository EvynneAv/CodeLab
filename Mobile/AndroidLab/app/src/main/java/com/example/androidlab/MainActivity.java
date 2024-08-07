package com.example.androidlab;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidlab.broadcastExample.AirplaneModeReceiver;
import com.example.androidlab.recycleViewExample.RecycleView;
import com.example.androidlab.serviceExample.ServiceExampleActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonMenuRv;
    private Button buttonMenuService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //exemplo broadcast modo avião
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        AirplaneModeReceiver br = new AirplaneModeReceiver();
        registerReceiver(br, intentFilter);
        //fim do exemplo


        buttonMenuRv = findViewById(R.id.btn_rvMenu);
        buttonMenuService = findViewById(R.id.btn_serviceMenu);

//      Botões

        buttonMenuRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getApplicationContext(), RecycleView.class);
                startActivity(intent);
            }
        });
        buttonMenuService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceExampleActivity.class);
                startActivity(intent);
            }
        });
    }
}