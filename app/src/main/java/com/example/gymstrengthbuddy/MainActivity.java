package com.example.gymstrengthbuddy;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gymstrengthbuddy.ui.Settings;
import com.example.gymstrengthbuddy.ui.Why531;
import com.example.gymstrengthbuddy.ui.WorkoutView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
/* Jon Nesten, Severi Reivinen, Nicolas Calisiyor
 */
public class MainActivity extends AppCompatActivity {
    public static final String RESULTS_EXTRA = "com.example.gymstrengthbuddy.RESULTS";  /* User input weights */
    public static final String WORKOUT_NAME_EXTRA = "com.example.gymstrengthbuddy.NAME";    /* Workout name */
    public static final String FIRST_OPEN = "com.example.gymstrengthbuddy.FIRSTOPEN";   /* First time user? (boolean) */
    Settings data = new Settings();
    String[] quote = new String [] {"‘The last three or four reps is what makes the muscle grow. This area of pain divides a champion from someone who is not a champion.’\n— Arnold Schwarzenegger, seven-time Mr. Olympia",
            "‘If something stands between you and your success, move it. Never be denied.’\n— Dwayne ‘The Rock’ Johnson, actor and pro wrestler",
            "‘Success is walking from failure to failure with no loss of enthusiasm.’\n— Winston Churchill, British statesman and Prime Minister of the United Kingdom",
            "Always remember to properly warm up before starting your workout!",
            "Remember to stretch",
            "When testing your One Rep Maxes, ask for a spotter.",
            "It's not only about lifting heavy. Eat and sleep well!"};
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Define ActionBar object */
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        /* Define ColorDrawable object and parse color
           using parseColor method
           with color hash code as its parameter */
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#182130"));

        /* Set BackgroundDrawable */
        actionBar.setBackgroundDrawable(colorDrawable);

        /* Set random quote */
        ((TextView)findViewById(R.id.quote)).setText(quote[r.nextInt(quote.length)]);

        /* Check if the user has opened the app before. Gives instructions for first time users. */
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

    /* Open settings view */
    public void openSettings(View v) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /* Open WHY 5/3/1 view */
    public void openWhy(View v) {
        Intent intent = new Intent(this, Why531.class);
        startActivity(intent);
    }

    /* Open work_out_view activity based on button id */
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