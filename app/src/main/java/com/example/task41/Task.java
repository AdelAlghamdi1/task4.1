package com.example.task41;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String dueDate;

    // ✅ Constructor
    public Task(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    // ✅ Getter for title
    public String getTitle() {
        return title;
    }

    // ✅ Getter for dueDate
    public String getDueDate() {
        return dueDate;
    }

}
