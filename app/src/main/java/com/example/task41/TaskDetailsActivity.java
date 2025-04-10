package com.example.task41;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        TextView titleText = findViewById(R.id.taskTitle);
        TextView dueDateText = findViewById(R.id.taskDueDate);

        String title = getIntent().getStringExtra("title");
        String dueDate = getIntent().getStringExtra("dueDate");

        titleText.setText(title);
        dueDateText.setText(dueDate);
    }
}
