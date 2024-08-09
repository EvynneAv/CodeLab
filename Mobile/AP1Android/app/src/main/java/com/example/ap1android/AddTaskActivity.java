
package com.example.ap1android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.ap1android.dao.TaskDao;
import com.example.ap1android.database.AppDataBase;
import com.example.ap1android.model.Task;


public class AddTaskActivity extends AppCompatActivity {
    private Button addTask;
    private EditText addDescription;
    private EditText addtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addDescription = findViewById(R.id.edtxt_add_description);
        addtitle = findViewById(R.id.edttxt_title);








    }
}