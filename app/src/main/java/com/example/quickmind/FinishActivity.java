package com.example.quickmind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinishActivity extends AppCompatActivity {

    private TextView finalScoreText;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        // Get score from previous activity
        int finalScore = getIntent().getIntExtra("score", 0);

        // Link views
        finalScoreText = findViewById(R.id.finalScoreText);
        finishButton = findViewById(R.id.finishButton);

        // Display the score
        finalScoreText.setText("Your Score: " + finalScore);

        // Go back to home when button is clicked
        finishButton.setOnClickListener(v -> {
            Intent intent = new Intent(FinishActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Close FinishActivity
        });
    }
}
