package com.example.task41;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView taskListView;
    TaskDatabase db;
    List<Task> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        taskListView = findViewById(R.id.taskListView);
        db = TaskDatabase.getInstance(this);

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        taskListView.setOnItemClickListener((parent, view, position, id) -> {
            Task clickedTask = taskList.get(position);
            Intent intent = new Intent(MainActivity.this, TaskDetailsActivity.class);
            intent.putExtra("id", clickedTask.id);
            intent.putExtra("title", clickedTask.getTitle());
            intent.putExtra("description", clickedTask.getDescription());
            intent.putExtra("dueDate", clickedTask.getDueDate());
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskList = db.taskDao().getAllTasks();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Task task : taskList) {
            adapter.add(task.getTitle() + " - " + task.getDueDate());
        }
        taskListView.setAdapter(adapter);
    }
}
