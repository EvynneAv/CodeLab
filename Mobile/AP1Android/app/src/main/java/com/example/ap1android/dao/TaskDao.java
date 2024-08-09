package com.example.ap1android.dao;

import androidx.room.Dao;
import androidx.room.Query;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.ap1android.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();
    @Query("SELECT * FROM task WHERE uid IN (:userIds)")
    List<Task> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM task WHERE title_db LIKE :title AND " + "description_db LIKE :description LIMIT 1") Task findByName(String title, String description);

    @Insert void insertAll(Task... users);
    @Delete void delete(Task user);



}
