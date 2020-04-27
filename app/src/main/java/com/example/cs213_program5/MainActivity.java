package com.example.cs213_program5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView calculatedBmiTextView;
    private RadioButton metricRadioButton;
    private RadioButton englishRadioButton;
    String BMIValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);

        metricRadioButton = findViewById(R.id.metricRadioButton);
        englishRadioButton = findViewById(R.id.englishRadioButton);

    }

    public void radioButtonClick(View v){
        String toastMessage = "default message";
        if(metricRadioButton.isChecked()) {
            toastMessage = "Calculating in metric system.";
            weightEditText.setHint("Enter weight in kg");
            heightEditText.setHint("Enter height in cm");
        }else {
            weightEditText.setHint("Enter weight in lb");
            heightEditText.setHint("Enter height in inches");
            toastMessage = "Calculating in imperial system";
        }

        sendToastMessage(toastMessage);
    }

    private void sendToastMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    /**
     * On-Click handler for Calculate BMI Button
     * Calculate's BMI and then updates BMI textview.
     * @param targetedView
     */
    public void setBMI(android.view.View targetedView){
        try {
            calculateBMI();
        } catch (NumberFormatException e) {
            // TODO: Display bad input Toast Message (user entered non numeric)
            sendToastMessage("Please enter a value for both height and weight");
            return;
        } catch (ArithmeticException e){
            // TODO: Display bad input Toast Message (user entered 0 or empty value)
            sendToastMessage("Height value cannot be zero");
            return;
        }
        if(BMIValue != null) {
            calculatedBmiTextView.setText(BMIValue);
        }
    }

    /**
     * On-Click handler for Get Advice Button
     * @param targetedView
     */
    public void startAdviceActivity(android.view.View targetedView){
        if (BMIValue == null || BMIValue.length() == 0){
            // TODO: Toast Message
            sendToastMessage("please calculate a BMI value");
            return;
        } else {
            Intent intent = new Intent(MainActivity.this, AdviceActivity.class);
            intent.putExtra("BMI", BMIValue);
            startActivity(intent);
        }
    }

    /**
     * Calculate BMI based on current TextView values.
     * Returns BMI as a string
     * @return
     */
    private void calculateBMI(){
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculatedBmiTextView = findViewById(R.id.calculatedBmiTextView);

        int weight = Integer.parseInt(weightEditText.getText().toString());
        int height = Integer.parseInt(heightEditText.getText().toString());

        boolean isMetric = false;

        if(metricRadioButton.isChecked()) {
            isMetric = true;
        }

        // TODO: Update weightEditText and heightEditText hint values based on Radio Buttons
        // This should actually be done in a seperate On-click listener method.

        float bmi;
        if (isMetric) {
            bmi = weight / (float)(height * height);
        } else {
            bmi = weight * 703 / (float)(height * height);
        }
        bmi = ((float)Math.round(bmi * 100.0) / 100);

        String bmiString = Float.toString(bmi);
        BMIValue = bmiString;
    }

}
