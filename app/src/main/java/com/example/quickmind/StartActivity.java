package com.example.quickmind;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class StartActivity extends AppCompatActivity {

    private TextView timerText, questionText;
    private EditText answerInput;
    private Button submitButton;
    private int score = 0;
    private int timeLeft = 60;
    private Random random = new Random();
    private String currentQuestion;
    private int correctAnswer;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Find the views
        timerText = findViewById(R.id.timerText);
        questionText = findViewById(R.id.questionText);
        answerInput = findViewById(R.id.answerInput);
        submitButton = findViewById(R.id.submitButton);

        // Start the timer
        startTimer();

        // Set an initial question
        generateQuestion();

        // Set up the button click listener
        submitButton.setOnClickListener(v -> checkAnswer());
    }

    // Start the countdown timer
    private void startTimer() {
        timer = new CountDownTimer(timeLeft * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = (int) (millisUntilFinished / 1000);
                timerText.setText(String.valueOf(timeLeft));
            }

            @Override
            public void onFinish() {
                finishGame();
            }
        }.start();
    }

    // Generate a random math question
    private void generateQuestion() {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        String operator = random.nextBoolean() ? "+" : random.nextBoolean() ? "-" : "*";
        currentQuestion = num1 + " " + operator + " " + num2;
        questionText.setText(currentQuestion);

        // Calculate the correct answer
        switch (operator) {
            case "+":
                correctAnswer = num1 + num2;
                break;
            case "-":
                correctAnswer = num1 - num2;
                break;
            case "*":
                correctAnswer = num1 * num2;
                break;
        }
    }

    // Check the answer inputted by the player
    private void checkAnswer() {
        try {
            int playerAnswer = Integer.parseInt(answerInput.getText().toString());
            if (playerAnswer == correctAnswer) {
                score += 10;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
            }
            // Generate a new question after the current one
            generateQuestion();
            answerInput.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }
    }

    // Finish the game and go to the finish screen
    private void finishGame() {
        Intent intent = new Intent(StartActivity.this, FinishActivity.class);
        intent.putExtra("score", score);  // Pass the score to the finish screen
        startActivity(intent);
        finish();  // Close the current activity
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}
