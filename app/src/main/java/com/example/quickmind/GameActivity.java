package com.example.quickmind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Find the start button
        startButton = findViewById(R.id.startGameButton);

        // Start the game when the button is clicked
        startButton.setOnClickListener(v -> startGame());
    }

    // Method to start the game
    private void startGame() {
        // Go to the third screen (StartActivity) where the timer is used
        Intent intent = new Intent(GameActivity.this, StartActivity.class);
        startActivity(intent);
    }
}