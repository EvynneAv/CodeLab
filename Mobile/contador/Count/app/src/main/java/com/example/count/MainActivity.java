package com.example.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView count;
    Button btnCount;

    int contador= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.tvCount);
        btnCount = findViewById(R.id.btnContador);
        btnCount.setOnClickListener(v -> {
            contador ++;
            count.setText(String.valueOf(contador));
        });

    }
}