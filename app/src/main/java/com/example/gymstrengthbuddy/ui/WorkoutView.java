package com.example.gymstrengthbuddy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gymstrengthbuddy.MainActivity;
import com.example.gymstrengthbuddy.R;
import com.example.gymstrengthbuddy.exercises.MainExercise;
import com.example.gymstrengthbuddy.exercises.SupportiveExercise;

import java.util.ArrayList;

public class WorkoutView extends AppCompatActivity {
    private MainExercise mainExercise;
    private SupportiveExercise supportiveExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        // Set name for the workout day
        ((TextView)findViewById(R.id.workout_name)).setText(getIntent().getStringExtra(MainActivity.WORKOUT_NAME_EXTRA));

        // Main workout sets
        double maxWeight= getIntent().getDoubleExtra(MainActivity.RESULTS_EXTRA, 0);
        mainExercise = new MainExercise(maxWeight);
        setMainSets(mainExercise);

        // Supportive workout
        ArrayList<TextView> supportiveExercises = new ArrayList<>();
        addTextViewsToList(supportiveExercises);



    }

    // Update workout set table
    public void setMainSets(MainExercise mainExercise) {
        ((TextView)findViewById(R.id.week1set1)).setText(Double.toString(mainExercise.getSetOne(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set2)).setText(Double.toString(mainExercise.getSetTwo(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set3)).setText(Double.toString(mainExercise.getSetThree(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week2set1)).setText(Double.toString(mainExercise.getSetOneWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set2)).setText(Double.toString(mainExercise.getSetTwoWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set3)).setText(Double.toString(mainExercise.getSetThreeWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week3set1)).setText(Double.toString(mainExercise.getSetOneWeekThree(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week3set2)).setText(Double.toString(mainExercise.getSetTwoWeekThree(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week3set3)).setText(Double.toString(mainExercise.getSetThreeWeekThree(mainExercise.getTrainingMax())) + " x1+");
        ((TextView)findViewById(R.id.week4set1)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set2)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set3)).setText("Test MAX");
        Log.d("setSets", "Sets read");
    }

    public void addTextViewsToList(ArrayList<TextView> tv) {
        tv.add(((TextView)findViewById(R.id.supportive1)));
        tv.add(((TextView)findViewById(R.id.supportive2)));
        tv.add(((TextView)findViewById(R.id.supportive3)));
        tv.add(((TextView)findViewById(R.id.supportive4)));
    }
}