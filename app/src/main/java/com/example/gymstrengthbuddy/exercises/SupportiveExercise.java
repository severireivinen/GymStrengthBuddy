package com.example.gymstrengthbuddy.exercises;

import java.util.ArrayList;

public class SupportiveExercise {
    private ArrayList<String> supportiveExercise;

    public SupportiveExercise() {
        this.supportiveExercise = new ArrayList<>();
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
