package com.example.gymstrengthbuddy;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gymstrengthbuddy.ui.Settings;
import com.example.gymstrengthbuddy.ui.WorkoutView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String RESULTS_EXTRA = "com.example.gymstrengthbuddy.RESULTS";
    public static final String WORKOUT_NAME_EXTRA = "com.example.gymstrengthbuddy.NAME";
    public static final String FIRST_OPEN = "com.example.gymstrengthbuddy.FIRSTOPEN";
    Settings data = new Settings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(FIRST_OPEN, 0);
        boolean dialogShow = settings.getBoolean("dialogShow", false);

        if (!dialogShow) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("First time user?");
            alertDialog.setMessage("Please set your personal lift records by going to the settings.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            alertDialog.show();

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("dialogShow", true);
            editor.commit();
        }
    }

    // Open settings view
    public void openSettings(View v) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    // Open work_out_view activity based on button id
    public void openWorkoutView(View v) {
        try {
            Intent mainWorkout = new Intent(this, WorkoutView.class);
            switch (v.getId()) {
                case R.id.squatBtn:
                    mainWorkout.putExtra(RESULTS_EXTRA, data.readData("DATA_SQUAT", this));
                    mainWorkout.putExtra(WORKOUT_NAME_EXTRA, "Squat Day");
                    startActivity(mainWorkout);
                    break;
                case R.id.benchBtn:
                    mainWorkout.putExtra(RESULTS_EXTRA, data.readData("DATA_BENCH", this));
                    mainWorkout.putExtra(WORKOUT_NAME_EXTRA, "Bench Press Day");
                    startActivity(mainWorkout);
                    break;
                case R.id.deadliftBtn:
                    mainWorkout.putExtra(RESULTS_EXTRA, data.readData("DATA_DEADLIFT", this));
                    mainWorkout.putExtra(WORKOUT_NAME_EXTRA, "Deadlift Day");
                    startActivity(mainWorkout);
                    break;
                case R.id.overheadpressBtn:
                    mainWorkout.putExtra(RESULTS_EXTRA, data.readData("DATA_OVERHEADPRESS", this));
                    mainWorkout.putExtra(WORKOUT_NAME_EXTRA, "Overhead Press Day");
                    startActivity(mainWorkout);
                    break;
                default:
                    throw new RuntimeException("Unknown button id!");
            }
        } catch (Exception e) {
            Snackbar emptyField = Snackbar.make(v, "Remember to set your lifts in settings", Snackbar.LENGTH_LONG);
            emptyField.show();
            Log.d("OnClick", "Empty fields: " + e.getMessage());
        }
    }
}