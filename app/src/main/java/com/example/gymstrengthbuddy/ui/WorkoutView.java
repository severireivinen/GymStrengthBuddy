package com.example.gymstrengthbuddy.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gymstrengthbuddy.MainActivity;
import com.example.gymstrengthbuddy.R;
import com.example.gymstrengthbuddy.exercises.Exercise;

import java.text.DecimalFormat;
import java.util.ArrayList;
/** Jon Nesten, Severi Reivinen, Nicolas Calisiyor
 */
public class WorkoutView extends AppCompatActivity {
    private Exercise mainExercise, suppExercise;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_view);

        /** Define ActionBar object */
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        /** Define ColorDrawable object and parse color
           using parseColor method
           with color hash code as its parameter */
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#182130"));

        /** Set BackgroundDrawable */
        actionBar.setBackgroundDrawable(colorDrawable);

        decimalFormat = new DecimalFormat("0.00");

        /** Set name for the workout day */
        ((TextView)findViewById(R.id.workout_name)).setText(getIntent().getStringExtra(MainActivity.WORKOUT_NAME_EXTRA));

        /** Main workout sets */
        double maxWeight= getIntent().getDoubleExtra(MainActivity.RESULTS_EXTRA, 0);
        mainExercise = new Exercise(maxWeight);
        setMainSets(mainExercise);

        /** Supportive workout */
        suppExercise = new Exercise();

        /** Add TextViews to a list */
        ArrayList<TextView> supportiveExercisesTv = new ArrayList<>();
        addTextViewsToList(supportiveExercisesTv);

        /** Set supportive exercises for each day */
        switch (((TextView)findViewById(R.id.workout_name)).getText().toString()) {
            case "Squat Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    for (int j = 0; j < suppExercise.getSquatSuppList().size(); j++) {
                        supportiveExercisesTv.get(j).setText(suppExercise.getSquatSupp(j));
                    }
                }
                break;
            case "Bench Press Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    for (int j = 0; j < suppExercise.getBenchSuppList().size(); j++) {
                        supportiveExercisesTv.get(j).setText(suppExercise.getBenchSupp(j));
                    }
                }
                break;
            case "Deadlift Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    for (int j = 0; j < suppExercise.getDeadliftSuppList().size(); j++) {
                        supportiveExercisesTv.get(j).setText(suppExercise.getDeadliftSupp(j));
                    }
                }
                break;
            case "Overhead Press Day":
                for (int i = 0; i < supportiveExercisesTv.size(); i++) {
                    for (int j = 0; j < suppExercise.getOverheadSuppList().size(); j++) {
                        supportiveExercisesTv.get(j).setText(suppExercise.getOverheadSupp(j));
                    }
                }
                break;
            default:
                throw new RuntimeException("Unknown Day");
        }
    }

    /** Update workout set table */
    public void setMainSets(Exercise mainExercise) {
        ((TextView)findViewById(R.id.week1set1)).setText(decimalFormat.format(mainExercise.getSetOne(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set2)).setText(decimalFormat.format(mainExercise.getSetTwo(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week1set3)).setText(decimalFormat.format(mainExercise.getSetThree(mainExercise.getTrainingMax())) + " x5+");
        ((TextView)findViewById(R.id.week2set1)).setText(decimalFormat.format(mainExercise.getSetOneWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set2)).setText(decimalFormat.format(mainExercise.getSetTwoWeekTwo(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week2set3)).setText(decimalFormat.format(mainExercise.getSetThreeWeekTwo(mainExercise.getTrainingMax())) + " x3+");
        ((TextView)findViewById(R.id.week3set1)).setText(decimalFormat.format(mainExercise.getSetOneWeekThree(mainExercise.getTrainingMax())) + " x5");
        ((TextView)findViewById(R.id.week3set2)).setText(decimalFormat.format(mainExercise.getSetTwoWeekThree(mainExercise.getTrainingMax())) + " x3");
        ((TextView)findViewById(R.id.week3set3)).setText(decimalFormat.format(mainExercise.getSetThreeWeekThree(mainExercise.getTrainingMax())) + " x1+");
        ((TextView)findViewById(R.id.week4set1)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set2)).setText("Test MAX");
        ((TextView)findViewById(R.id.week4set3)).setText("Test MAX");
        Log.d("setSets", "Sets read");
    }

    /** Add TextViews to a new list */
    public void addTextViewsToList(ArrayList<TextView> tv) {
        tv.add(((TextView)findViewById(R.id.supportive1)));
        tv.add(((TextView)findViewById(R.id.supportive2)));
        tv.add(((TextView)findViewById(R.id.supportive3)));
        tv.add(((TextView)findViewById(R.id.supportive4)));
    }
}