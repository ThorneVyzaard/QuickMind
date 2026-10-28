# QuickMind

A fast-paced Android math game. You have **60 seconds** to solve as many equations as you can. Every correct answer earns **10 points**.

## How to Play

1. Tap the start button on the main screen.
2. A math equation appears (for example `7 * 3` or `3 - 7`).
3. Type your answer and press **Submit**.
4. A correct answer gives you **+10 points** and a new equation appears right away.
5. When the timer hits zero, the game ends and your final score is shown.

## Features

- 60-second countdown timer
- Random equations using addition, subtraction and multiplication
- Numbers from 1 to 10
- Negative answers supported (for example `3 - 7 = -4`)
- Instant feedback after each answer
- Final score screen at the end of every round

## Download

You can download the latest APK from the [Releases](../../releases) page and install it on your Android device.

> You may need to allow installing apps from unknown sources in your phone settings.

## Build from Source

**Requirements:** Android Studio and a device or emulator running Android.

```bash
git clone https://github.com/YOUR-USERNAME/QuickMind.git
```

1. Open the project folder in Android Studio.
2. Wait for Gradle to finish syncing.
3. Press **Run** to launch the game on an emulator or a connected phone.

To build an APK from the terminal:

```bash
./gradlew assembleDebug
```

The APK will be in `app/build/outputs/apk/debug/`.

## Tech Stack

- Java
- Android SDK
- Gradle (Kotlin DSL)

## Project Structure

```
app/src/main/
├── java/com/example/quickmind/   # Activities (game logic and screens)
└── res/                          # Layouts, drawables, colors, strings
```

## Screenshots

<!-- Add screenshots here, for example: -->
<!-- ![Gameplay](screenshots/gameplay.png) -->

## Possible Future Improvements

- Difficulty levels with larger numbers
- Division questions
- High score saving
- Sound effects

## License

Add a license of your choice here (for example MIT), or remove this section.
