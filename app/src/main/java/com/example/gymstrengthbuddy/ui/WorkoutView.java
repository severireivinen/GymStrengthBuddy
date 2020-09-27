package com.example.gymstrengthbuddy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gymstrengthbuddy.MainActivity;
import com.example.gymstrengthbuddy.R;
import com.example.gymstrengthbuddy.exercises.Exercise;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class WorkoutView extends AppCompatActivity {
    private Exercise mainExercise, suppExercise;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);
        decimalFormat = new DecimalFormat("0.00");

        // Set name for the workout day
        ((TextView)findViewById(R.id.workout_name)).setText(getIntent().getStringExtra(MainActivity.WORKOUT_NAME_EXTRA));

        // Main workout sets
        double maxWeight= getIntent().getDoubleExtra(MainActivity.RESULTS_EXTRA, 0);
        mainExercise = new Exercise(maxWeight);
        setMainSets(mainExercise);

        // Supportive workout
        suppExercise = new Exercise();
        // Add TextViews to a list
        ArrayList<TextView> supportiveExercisesTv = new ArrayList<>();
        addTextViewsToList(supportiveExercisesTv);

        // Set supportive exercises for each day
        switch (((TextView)findViewById(R.id.workout_name)).getText().toString()) {
            case "Squat Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    supportiveExercisesTv.get(i).setText(suppExercise.getSquatSupp(i));
                }
                break;
            case "Bench Press Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    supportiveExercisesTv.get(i).setText(suppExercise.getBenchSupp(i));
                }
                break;
            case "Deadlift Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    supportiveExercisesTv.get(i).setText(suppExercise.getDeadliftSupp(i));
                }
                break;
            case "Overhead Press Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    supportiveExercisesTv.get(i).setText(suppExercise.getOverheadSupp(i));
                }
                break;
            default:
                throw new RuntimeException("Unknown Day");
        }
    }

    // Update workout set table
    public void setMainSets(Exercise mainExercise) {
        ((TextView)findViewById(R.id.week1set1)).setText(decimalFormat.format(mainExercise.getSetOne(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set2)).setText(decimalFormat.format(mainExercise.getSetTwo(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set3)).setText(decimalFormat.format(mainExercise.getSetThree(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week2set1)).setText(decimalFormat.format(mainExercise.getSetOneWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set2)).setText(decimalFormat.format(mainExercise.getSetTwoWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set3)).setText(decimalFormat.format(mainExercise.getSetThreeWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week3set1)).setText(decimalFormat.format(mainExercise.getSetOneWeekThree(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week3set2)).setText(decimalFormat.format(mainExercise.getSetTwoWeekThree(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week3set3)).setText(decimalFormat.format(mainExercise.getSetThreeWeekThree(mainExercise.getTrainingMax())) + " x1+");
        ((TextView)findViewById(R.id.week4set1)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set2)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set3)).setText("Test MAX");
        Log.d("setSets", "Sets read");
    }

    // Add TextViews to a new list
    public void addTextViewsToList(ArrayList<TextView> tv) {
        tv.add(((TextView)findViewById(R.id.supportive1)));
        tv.add(((TextView)findViewById(R.id.supportive2)));
        tv.add(((TextView)findViewById(R.id.supportive3)));
        tv.add(((TextView)findViewById(R.id.supportive4)));
    }
}