package com.example.androidlab.recycleViewExample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlab.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleView extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<Time> times = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        times.add(new Time("Fortaleza", "fortaleza"));
        times.add(new Time("Flamengo", "flamengo"));
        times.add(new Time("Palmeiras", "palmeiras"));
        times.add(new Time("Botafogo", "botafogo"));
        Toast.makeText(this, "entrou", Toast.LENGTH_SHORT).show();
        AdapterRv adapterRv = new AdapterRv(times);

        recyclerView = findViewById(R.id.rv_times);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterRv);





    }
}