package com.example.ap1android.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ap1android.dao.TaskDao;
import com.example.ap1android.model.Task;

@Database(entities = {Task.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
