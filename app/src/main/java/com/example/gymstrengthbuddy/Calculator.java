package com.example.gymstrengthbuddy;
/** @author Jon Nesten, Severi Reivinen, Nicolas Calisiyor
 */
public class Calculator {

    /** Calculate methods for week 1 */
    public double getSetOne(double weight) {
        return weight * 0.65;
    }

    public double getSetTwo(double weight) {
        return weight * 0.75;
    }

    public double getSetThree(double weight) {
        return weight * 0.85;
    }

    /** Calculate methods for week 2 */
    public double getSetOneWeekTwo(double weight) {
        return weight * 0.7;
    }

    public double getSetTwoWeekTwo(double weight) {
        return weight * 0.8;
    }

    public double getSetThreeWeekTwo(double weight) {
        return weight * 0.9;
    }

    /** Calculate methods for week 3 */
    public double getSetOneWeekThree(double weight) {
        return weight * 0.75;
    }

    public double getSetTwoWeekThree(double weight) {
        return weight * 0.85;
    }

    public double getSetThreeWeekThree(double weight) {
        return weight * 0.95;
    }
}
