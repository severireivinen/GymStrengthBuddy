package com.example.gymstrengthbuddy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.gymstrengthbuddy.R;

public class Settings extends AppCompatActivity {
    private EditText squat, bench, deadlift, overheadpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        squat = findViewById(R.id.squatInput);
        bench = findViewById(R.id.benchInput);
        deadlift = findViewById(R.id.deadliftInput);
        overheadpress = findViewById(R.id.overheadpressInput);

        // Catch error if any of the userInput fields is empty
        try {
            squat.setText(Double.toString(readData("DATA_SQUAT", this)));
        } catch (Exception e) {
            Log.d("SETTINGS:", "Empty fields!" + e.getMessage());
        }

        try {
            bench.setText(Double.toString(readData("DATA_BENCH", this)));
        } catch (Exception e) {
            Log.d("SETTINGS:", "Empty fields!" + e.getMessage());
        }

        try {
            deadlift.setText(Double.toString(readData("DATA_DEADLIFT", this)));
        } catch (Exception e) {
            Log.d("SETTINGS:", "Empty fields!" + e.getMessage());
        }

        try {
            overheadpress.setText(Double.toString(readData("DATA_OVERHEADPRESS", this)));
        } catch (Exception e) {
            Log.d("SETTINGS:", "Empty fields!" + e.getMessage());
        }
    }

    // Submit user max weights
    public void submit(View v) {
        saveData("DATA_SQUAT", squat.getText().toString(), this);
        saveData("DATA_BENCH", bench.getText().toString(), this);
        saveData("DATA_DEADLIFT", deadlift.getText().toString(), this);
        saveData("DATA_OVERHEADPRESS", overheadpress.getText().toString(), this);
    }

    // Save Data
    private static void saveData(String key, String val, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, val);
        editor.commit();
    }

    // Read Data
    public static double readData(String key, Context context) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            return Double.parseDouble(sharedPref.getString(key, null));
    }
}