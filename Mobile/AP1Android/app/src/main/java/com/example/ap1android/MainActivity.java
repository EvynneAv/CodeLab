package com.example.ap1android;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.ap1android.adapter.AdapterTask;
import com.example.ap1android.dao.TaskDao;
import com.example.ap1android.database.AppDataBase;
import com.example.ap1android.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnSave;

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

        Task t1 = new Task("Supermercado", "Comprar pão");
        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "database-name").enableMultiInstanceInvalidation()
                .allowMainThreadQueries().fallbackToDestructiveMigration()
                .build();

        TaskDao taskDao = db.taskDao();
        taskDao.insertAll(t1);
        List<Task> tasks = taskDao.getAll();
        for(Task t: tasks){
            Log.d("yep", t.toString());
            Toast.makeText(this, t.getTitle(), Toast.LENGTH_SHORT).show();
        }

        recyclerView = findViewById(R.id.rv_AllTasks);
        btnSave = findViewById(R.id.btn_addTask);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddTaskActivity.class);
                startActivity(intent);
            }
        });

        AdapterTask adapter = new AdapterTask(tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}