package com.missouristate.davis916.unitconversioncalculator;

/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 *
 * The Conversion class sets some of the basic
 * conversion values needed for this app.
 * This class also creates methods for switching
 * between different conversions.
 */

public class Conversion {
    //Declare and initialize variables
    static final int FEET = 1;
    static final int INCHES = 2;
    static final int POUNDS = 3;
    static final double METERS_PER_FOOT = 0.3048;
    static final double CENTIMETERS_PER_INCH = 2.56;
    static final double GRAMS_PER_POUND = 453.592;

    private int isA;
    String inputLabel;
    String outputLabel;

    public Double inputValue;
    public Double outputValue;

    //Instantiate Conversion object
    public Conversion(){
        isA = FEET;

        inputLabel = "FEET";
        outputLabel = "METERS";
        inputValue = 0.0;
        outputValue = 0.0;
    }//end Conversion()

    //Changes the conversion i/o to Feet & Meters, respectively
    public void switch_toFeetMeters(){
        isA = FEET;
        inputLabel = "FEET";
        outputLabel = "METERS";
        compute();
    }//end switch_toFeetMeters()

    //Changes the conversion i/o to Inches & Centimeters, respectively
    public void switch_toInchesCent(){
        isA = INCHES;
        inputLabel = "INCHES";
        outputLabel = "CENTIMETERS";
        compute();
    }//end switch_toInchesCent()

    //Changes the conversion i/o to Pounds & Grams, respectively
    public void switch_toPoundsGrams(){
        isA = POUNDS;
        inputLabel = "POUNDS";
        outputLabel = "GRAMS";
        compute();
    }//end switch_toPoundsGrams

    //Computes conversion based on final values
    public void compute(){
        switch (isA){
            case FEET:
                outputValue = inputValue * METERS_PER_FOOT;
                break;
            case INCHES:
                outputValue = inputValue * CENTIMETERS_PER_INCH;
                break;
            case POUNDS:
                outputValue = inputValue * GRAMS_PER_POUND;
                break;
        }
    }//end compute()

}//end Conversion class
