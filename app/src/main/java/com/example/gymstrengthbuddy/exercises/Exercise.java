package com.example.gymstrengthbuddy.exercises;

import com.example.gymstrengthbuddy.Calculator;

import java.util.ArrayList;
/** Jon Nesten, Severi Reivinen, Nicolas Calisiyor
 */
public class Exercise extends Calculator {
    private double trainingMax;
    private ArrayList<String> squatSupp, benchSupp, deadliftSupp, overheadSupp;

    public Exercise(double max) {
        this.trainingMax = (max * 0.9);
    }

    public Exercise() {
        this.squatSupp = new ArrayList<>();
        this.benchSupp = new ArrayList<>();
        this.deadliftSupp = new ArrayList<>();
        this.overheadSupp = new ArrayList<>();
        fillSquat(squatSupp);
        fillBench(benchSupp);
        fillDeadlift(deadliftSupp);
        fillOverhead(overheadSupp);
    }

    /**Return Training max*/
    public double getTrainingMax() { return this.trainingMax; }

    /**Methods for supportive exercises below*/
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

    public ArrayList<String> getSquatSuppList() {
        return this.squatSupp;
    }

    public ArrayList<String> getBenchSuppList() {
        return this.benchSupp;
    }

    public ArrayList<String> getDeadliftSuppList() {
        return this.deadliftSupp;
    }

    public ArrayList<String> getOverheadSuppList() {
        return this.overheadSupp;
    }

    /**Fill Squat ArrayList with supportive exercises*/
    public void fillSquat(ArrayList<String>squatList) {
        squatList.add("Legpress\nSets: 4\t\tReps: 8-12");
        squatList.add("Leg Extension\nSets: 3\t\tReps: 10-15");
        squatList.add("Leg Curl\nSets: 4\t\tReps: 10-15");
        squatList.add("Planking\nSets: 3\t\tTime: 60-120s");
    }

    /**Fill Bench Press ArrayList with supportive exercises*/
    public void fillBench(ArrayList<String>benchList) {
        benchList.add("Incline Bench Press\nSets: 4\t\tReps: 8-12");
        benchList.add("Dumbbell Flies\nSets: 3\t\tReps: 10-12");
        benchList.add("Skull Crushers\nSets: 4\t\tReps: 8-12");
        benchList.add("Cable Extension\nSets: 3\t\tReps: 10-15");
    }

    /**Fill Deadlift ArrayList with supportive exercises*/
    public void fillDeadlift(ArrayList<String>deadliftList) {
        deadliftList.add("Pullups\nSets: 4\t\tReps: 8-12");
        deadliftList.add("T-bat Row\nSets: 4\t\tReps: 8-12");
        deadliftList.add("Dumbbell Row\nSets: 3\t\tReps: 8-12");
        deadliftList.add("Leg Raises\nSets: 3\t\tReps: 10-15");
    }

    /**Fill Overhead Press ArrayList with supportive exercises*/
    public void fillOverhead(ArrayList<String>pressList) {
        pressList.add("Dumbbell Overhead Press\nSets: 4\t\tReps: 8-12");
        pressList.add("Side Laterals\nSets: 4\t\tReps: 8-12");
        pressList.add("Barbell Curls\nSets: 4\t\tReps: 10-12");
        pressList.add("Dumbbell Curls\nSets: 3\t\tReps: 10-12");
    }
}
