package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup faculties;
    RadioGroup courses;

    RadioButton courseButton;
    RadioButton facultyButton;

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = findViewById(R.id.courseGroup);
        faculties = findViewById(R.id.facultyGroup);
        text = findViewById(R.id.labView);
    }

    public void onClickOKButton(View view) {
        int facultyId = faculties.getCheckedRadioButtonId();
        int courseId = courses.getCheckedRadioButtonId();

        if (facultyId == -1 | courseId == -1) {
            Toast.makeText(MainActivity.this, "Введіть усі дані", Toast.LENGTH_LONG).show();
        } else {
            courseButton = findViewById(courseId);
            facultyButton = findViewById(facultyId);

            String message = courseButton.getText() + " курс\n" + facultyButton.getText();

            text.setText(message);
        }
    }

    public void onClickCancelButton(View view) {
        faculties.clearCheck();
        courses.clearCheck();
        text.setText("Варіант 13");
    }
}