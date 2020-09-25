package com.example.gymstrengthbuddy.exercises;

import com.example.gymstrengthbuddy.Calculator;

public class MainExercise extends Calculator {
    private double trainingMax;

    public MainExercise(double max) {
        this.trainingMax = (max * 0.9);
    }

    public double getTrainingMax() { return this.trainingMax; }
}
