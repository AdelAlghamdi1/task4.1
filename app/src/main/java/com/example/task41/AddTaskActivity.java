package com.example.task41;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    EditText edtTitle, edtDueDate;
    Button btnSave;
    TaskDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtTitle = findViewById(R.id.edtTitle);
        edtDueDate = findViewById(R.id.edtDueDate);
        btnSave = findViewById(R.id.btnSave);
        db = TaskDatabase.getInstance(this);

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String dueDate = edtDueDate.getText().toString();

            if (!title.isEmpty() && !dueDate.isEmpty()) {
                Task newTask = new Task(title, dueDate);
                db.taskDao().insert(newTask);
                finish();
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
