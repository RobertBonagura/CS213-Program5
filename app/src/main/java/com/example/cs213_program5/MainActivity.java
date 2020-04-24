package com.example.cs213_program5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView calculatedBmiTextView;
    private RadioButton englishRadioButton;
    private RadioButton metricRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * On-Click handler for Calculate BMI Button
     * Calculate's BMI and then updates BMI textview.
     * @param targetedView
     */
    public void setBMI(android.view.View targetedView){
        String bmi;
        try {
            bmi = calculateBMI();
        } catch (NumberFormatException e) {
            // TODO: Display bad input Toast Message (user entered non numeric)
            return;
        } catch (ArithmeticException e){
            // TODO: Display bad input Toast Message (user entered 0 or empty value)
            return;
        }
        calculatedBmiTextView.setText(bmi);
    }

    /**
     * On-Click handler for Get Advice Button
     * @param targetedView
     */
    public void startAdviceActivity(android.view.View targetedView){
        String bmi;
        try {
            bmi = calculateBMI();
        } catch (NumberFormatException e) {
            // TODO: Toast Message
            return;
        } catch (ArithmeticException e){
            // TODO: Toast Message
            return;
        }
        calculatedBmiTextView.setText(bmi);
        if (bmi == null || bmi.length() == 0){
            // TODO: Toast Message
        } else {
            Intent intent = new Intent(MainActivity.this, AdviceActivity.class);
            intent.putExtra("BMI", bmi);
            startActivity(intent);
        }
    }

    /**
     * Calculate BMI based on current TextView values.
     * Returns BMI as a string
     * @return
     */
    private String calculateBMI(){
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculatedBmiTextView = findViewById(R.id.calculatedBmiTextView);

        int weight = Integer.parseInt(weightEditText.getText().toString());
        int height = Integer.parseInt(heightEditText.getText().toString());

        // TODO: Read from Radio Buttons
        // And set isMetric boolean value appropriately
        englishRadioButton = findViewById(R.id.englishRadioButton);
        metricRadioButton = findViewById(R.id.metricRadoButton);

        boolean isMetric = false;

        // TODO: Update weightEditText and heightEditText hint values based on Radio Buttons
        // This should actually be done in a seperate On-click listener method.

        float bmi;
        if (isMetric) {
            bmi = weight / (height * height);
        } else {
            bmi = weight * 703 / (height * height);
        }

        String bmiString = Float.toString(bmi);
        return bmiString;
    }

}
