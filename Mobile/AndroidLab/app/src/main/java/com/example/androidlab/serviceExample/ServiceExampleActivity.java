package com.example.androidlab.serviceExample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidlab.R;

public class ServiceExampleActivity extends AppCompatActivity {
    Button buttonIniciarMusica , buttonPararMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonIniciarMusica = findViewById(R.id.btn_IniciarMusica);
        buttonPararMusica = findViewById(R.id.btn_pararMusica);

        buttonIniciarMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ServiceExampleActivity.this, "Musica começou", Toast.LENGTH_SHORT).show();
                Intent startMusic = new Intent(v.getContext(), MusicInBackgroundService.class);
                startService(startMusic);
            }

        });
        buttonPararMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ServiceExampleActivity.this, "Musica parou", Toast.LENGTH_SHORT).show();
                Intent startMusic = new Intent(v.getContext(), MusicInBackgroundService.class);
                stopService(startMusic);
            }
        });
    }
}