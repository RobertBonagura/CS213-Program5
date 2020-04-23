package com.example.cs213_program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView calculatedBmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(android.view.View targetedView){

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculatedBmiTextView = findViewById(R.id.calculatedBmiTextView);

        /* Still need to write error handling for receiving non numeric characters*/
        int weight = Integer.parseInt(weightEditText.getText().toString());
        int height = Integer.parseInt(heightEditText.getText().toString());
        int sum = weight + height;

        String calculationStr = Integer.toString(sum);
        calculatedBmiTextView.setText(calculationStr);
    }

    public void displayAdvice(android.view.View targetedView){

    }
}
