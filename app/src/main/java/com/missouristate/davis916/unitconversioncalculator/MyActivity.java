package com.missouristate.davis916.unitconversioncalculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Laura Davis CIS 262-902
 * 8 March 2018
 *
 * This app is a basic conversion calculator that can convert
 * feet to meters, inches to centimeters, and pounds to grams.
 * The constant conversion factors and computation is in the
 * Conversion class which is also instantiated as an object to be used here.
 */

public class MyActivity extends AppCompatActivity {

    //References to the user interface elements on the layout
    private TextView inputLabel;
    private TextView outputLabel;
    private TextView outputMeasurement;
    private TextView inputMeasurement;

    Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        conversion = new Conversion();
        setUpReferenceDisplay();
    }//end onCreate()

    private void setUpReferenceDisplay(){
        inputLabel = (TextView) findViewById(R.id.textView);
        inputLabel.setText(conversion.inputLabel);

        outputLabel = (TextView) findViewById(R.id.textView2);
        outputLabel.setText(conversion.outputLabel);

        outputMeasurement = (TextView) findViewById(R.id.textView3);
        outputMeasurement.setText(conversion.outputValue.toString());

        inputMeasurement = (EditText) findViewById(R.id.editText);
        inputMeasurement.setText(conversion.inputValue.toString());
        inputMeasurement.addTextChangedListener(inputTextWatcher);
    }//end setUpReferenceDisplay()

    private TextWatcher inputTextWatcher = new TextWatcher() {
        //THe input element is attached to an editable,
        //therefore these methods are called when text is changed

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Catch an exception when the input is not a number
            try {
                conversion.inputValue =
                        Double.parseDouble(s.toString());
            } catch (NumberFormatException e){
                conversion.inputValue = 0.0;
            }
            conversion.compute();
            outputMeasurement.setText(conversion.outputValue.toString());
        }//end onTextChanged

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    };//end TextWatcher

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            toggleActionBar();
        }
        return true;
    }//end onTouchEvent

    private void toggleActionBar(){
        android.app.ActionBar actionbar = getActionBar();

        if(actionbar != null){
            if(actionbar.isShowing()) {
                actionbar.hide();
            }
            else {
                actionbar.show();
            }
        }
    }//end toggleActionBar()

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }//end createOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button,
        //as long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menuitem_feet_meters){
            conversion.switch_toFeetMeters();
            resetDisplay();
            return true;
        }
        else if(id == R.id.menuitem_inches_cent){
            conversion.switch_toInchesCent();
            resetDisplay();
            return true;
        }
        else if(id == R.id.menuitem_pounds_grams){
            conversion.switch_toPoundsGrams();
            resetDisplay();
            return true;
        }
        else if(id == R.id.menuitem_quit){
            //Close activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected

    private void resetDisplay(){
        inputLabel.setText(conversion.inputLabel);
        outputLabel.setText(conversion.outputLabel);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement.setText(conversion.outputValue.toString());
    }

}//end MyActivity class
