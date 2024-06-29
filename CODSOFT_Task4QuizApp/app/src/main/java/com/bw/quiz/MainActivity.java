package com.bw.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Quiz> quizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizList = new ArrayList<>();
        quizList.add(new Quiz("Computer Science", Arrays.asList(
                new Question("What does CPU stand for in computer science?", Arrays.asList("Central Processing Unit", "Central Program Unit", "Central Peripheral Unit", "Central Performance Unit"), 0),
                new Question("What is the main language used to create web pages?", Arrays.asList("Python", "HTML", "Java", "C++"), 1),
                new Question("Which of the following is a non-volatile memory?", Arrays.asList("RAM", "ROM", "Cache", "Register"), 1),
                new Question("What is the name of the network topology where all nodes are connected to a central hub?", Arrays.asList("Ring", "Mesh", "Star", "Bus"), 2),
                new Question("Which of the following is used to style web pages?", Arrays.asList("HTML", "CSS", "SQL", "PHP"), 1)
        )));
        quizList.add(new Quiz("Math", Arrays.asList(
                new Question("What is the value of π (pi) to two decimal places?", Arrays.asList("3.12", "3.14", "3.16", "3.18"), 1),
                new Question("What is 25% of 200?", Arrays.asList("25", "50", "75", "100"), 1),
                new Question("Solve for x: 2x + 3 = 11", Arrays.asList("2", "3", "4", "5"), 2),
                new Question("What is the square root of 81?", Arrays.asList("7", "8", "9", "10"), 2),
                new Question("What is the area of a triangle with base 10 units and height 5 units?", Arrays.asList("15 square units", "20 square units", "25 square units", "30 square units"), 2)
        )));

        Button startRandomQuizButton = findViewById(R.id.startRandomQuizButton);
        Button startGeneralKnowledgeQuizButton = findViewById(R.id.startGeneralKnowledgeQuizButton);
        Button startScienceQuizButton = findViewById(R.id.startScienceQuizButton);

        startRandomQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomIndex = (int) (Math.random() * quizList.size());
                Quiz randomQuiz = quizList.get(randomIndex);
                startQuizActivity(randomQuiz);
            }
        });

        startGeneralKnowledgeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz generalKnowledgeQuiz = quizList.get(0);
                startQuizActivity(generalKnowledgeQuiz);
            }
        });

        startScienceQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz scienceQuiz = quizList.get(1);
                startQuizActivity(scienceQuiz);
            }
        });
    }

    private void startQuizActivity(Quiz quiz) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("quiz", (Serializable) quiz);
        startActivity(intent);
    }
}
