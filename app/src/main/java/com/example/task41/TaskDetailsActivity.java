package com.example.task41;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {
    EditText taskTitle, taskDescription, taskDueDate;
    Button btnUpdate, btnDelete;
    TaskDatabase db;
    int taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        taskTitle = findViewById(R.id.taskTitle);
        taskDescription = findViewById(R.id.taskDescription);
        taskDueDate = findViewById(R.id.taskDueDate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        db = TaskDatabase.getInstance(this);

        taskId = getIntent().getIntExtra("id", -1);
        taskTitle.setText(getIntent().getStringExtra("title"));
        taskDescription.setText(getIntent().getStringExtra("description"));
        taskDueDate.setText(getIntent().getStringExtra("dueDate"));

        btnUpdate.setOnClickListener(v -> {
            String title = taskTitle.getText().toString();
            String description = taskDescription.getText().toString();
            String dueDate = taskDueDate.getText().toString();
            Task updatedTask = new Task(title, description, dueDate);
            updatedTask.id = taskId;
            db.taskDao().update(updatedTask);
            finish();
        });

        btnDelete.setOnClickListener(v -> {
            Task taskToDelete = new Task(taskTitle.getText().toString(),
                    taskDescription.getText().toString(),
                    taskDueDate.getText().toString());
            taskToDelete.id = taskId;
            db.taskDao().delete(taskToDelete);
            finish();
        });
    }
}
