package com.example.user.quizapplication3rdproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.user.quizapplication3rdproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int score = 0;

    public void question1(View view) {
        RadioButton option1 = findViewById(R.id.RBq1_o1);
        RadioButton option2 = findViewById(R.id.RBq1_o2);
        boolean clicked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            case R.id.RBq1_o2:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option2.setEnabled(false);
                    option1.setEnabled(false);
                }

                break;
        }
    }

    public void question2(View view) {
        RadioButton option1 = findViewById(R.id.RBq2_o1);
        RadioButton option2 = findViewById(R.id.RBq2_o2);
        RadioButton option3 = findViewById(R.id.RBq2_o3);
        boolean clicked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.RBq2_o3:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option3.setEnabled(false);
                    option1.setEnabled(false);
                    option2.setEnabled(false);
                }

                break;
        }
    }

    public void question3(View view) {
        CheckBox option2 = findViewById(R.id.RBq3_o2);

        CheckBox option1 = findViewById(R.id.RBq3_o1);
        boolean option1Answered = option1.isChecked();

        CheckBox option3 = findViewById(R.id.RBq3_o3);
        boolean option3Answered = option3.isChecked();


        if (option1Answered) {
            option1.setEnabled(false);
        }

        if (option3Answered) {
            option3.setEnabled(false);
        }

        if (option1Answered && option3Answered) {
            score++;
            Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
            option2.setEnabled(false);
        }

    }

    public void question4(View view) {
        RadioButton option1 = findViewById(R.id.RBq4_o1);
        RadioButton option2 = findViewById(R.id.RBq4_o2);

        boolean clicked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.RBq4_o2:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option2.setEnabled(false);
                    option1.setEnabled(false);
                }

                break;
        }
    }

    public void question5(View view) {
        RadioButton option1 = findViewById(R.id.RBq5_o1);
        RadioButton option2 = findViewById(R.id.RBq5_o2);
        RadioButton option3 = findViewById(R.id.RBq5_o3);
        boolean clicked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.RBq5_o2:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option2.setEnabled(false);
                    option1.setEnabled(false);
                    option3.setEnabled(false);
                }

                break;
        }
    }

    public void question6(View view) {
        RadioButton option1 = findViewById(R.id.RBq6_o1);
        RadioButton option2 = findViewById(R.id.RBq6_o2);
        boolean clicked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            case R.id.RBq6_o1:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option2.setEnabled(false);
                    option1.setEnabled(false);
                }

                break;
        }
    }

    public void question7(View view) {
        RadioButton option1 = findViewById(R.id.RBq7_o1);
        RadioButton option2 = findViewById(R.id.RBq7_o2);
        RadioButton option3 = findViewById(R.id.RBq7_o3);
        boolean clicked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.RBq7_o2:
                if (clicked) {
                    score++;
                    Toast.makeText(MainActivity.this, "Score: " + score, Toast.LENGTH_SHORT).show();
                    option3.setEnabled(false);
                    option1.setEnabled(false);
                    option2.setEnabled(false);
                }

                break;
        }
    }

    public void submit(View view) {
        EditText nameText = findViewById(R.id.name);
        String name = nameText.getText().toString();

        EditText dateText = findViewById(R.id.date);
        String date = dateText.getText().toString();

        if (name.matches(""))
        {
            Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
        }

        else if (date.matches(""))
        {
            Toast.makeText(MainActivity.this, "Please enter a date.", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT,name + "'s Astronomy Quiz Results");
            intent.putExtra(Intent.EXTRA_TEXT,  "On " + date + ": \n" + name + "'s score in the Astronomy Quiz was: " + score + "/7");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

}
