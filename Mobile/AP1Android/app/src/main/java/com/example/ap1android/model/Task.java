package com.example.ap1android.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true) public int uid;

    @ColumnInfo(name = "title_db") public String title;
    @ColumnInfo(name = "description_db") public  String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return this.uid + " | " + this.title+ " | " + this.description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
