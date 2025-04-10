package com.example.task41;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);

    @Query("SELECT * FROM Task ORDER BY dueDate ASC")
    List<Task> getAllTasks();

    @Delete
    void delete(Task task);
}
