package com.example.gymstrengthbuddy.exercises;

import com.example.gymstrengthbuddy.Calculator;

import java.util.ArrayList;

public class MainExercise extends Calculator {
    private double trainingMax;
    private ArrayList<String> squatSupp, benchSupp, deadliftSupp, overheadSupp;

    public MainExercise(double max) {
        this.trainingMax = (max * 0.9);
    }

    public MainExercise() {
        this.squatSupp = new ArrayList<>();
        this.benchSupp = new ArrayList<>();
        this.deadliftSupp = new ArrayList<>();
        this.overheadSupp = new ArrayList<>();
        fillSquat(squatSupp);
        fillBench(benchSupp);
        fillDeadlift(deadliftSupp);
        fillOverhead(overheadSupp);
    }

    public double getTrainingMax() { return this.trainingMax; }

    public String getSquatSupp(int i) {
        return this.squatSupp.get(i);
    }

    public String getBenchSupp(int i) {
        return this.benchSupp.get(i);
    }

    public String getDeadliftSupp(int i) {
        return this.deadliftSupp.get(i);
    }

    public String getOverheadSupp(int i) {
        return this.overheadSupp.get(i);
    }

    public void fillSquat(ArrayList<String>squatList) {
        squatList.add("Legpress");
        squatList.add("Leg Extension");
        squatList.add("Leg Curl");
        squatList.add("Planking");
    }

    public void fillBench(ArrayList<String>benchList) {
        benchList.add("Incline Bench Press");
        benchList.add("Dumbell Flies");
        benchList.add("Skull Crushers");
        benchList.add("Cable Extension");
    }

    public void fillDeadlift(ArrayList<String>deadliftList) {
        deadliftList.add("Pullups");
        deadliftList.add("T-bat Row");
        deadliftList.add("Dumbell Row");
        deadliftList.add("Leg Raises");
    }

    public void fillOverhead(ArrayList<String>pressList) {
        pressList.add("Dumbell Press");
        pressList.add("Side Laterals");
        pressList.add("Bar curls");
        pressList.add("Dumbell curls");
    }
}
