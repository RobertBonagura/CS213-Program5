
package com.example.cs213_program5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AdviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        Intent intent = getIntent();
        Float bmi = Float.parseFloat(intent.getStringExtra("BMI"));
        displayAdvice(bmi);
    }

    private void displayAdvice(Float bmi){
        String result;
        ImageView image = findViewById(R.id.imageView);
        TextView advice = findViewById(R.id.adviceTextView);

        //TODO: Find appropriate photos for each case and save files in app/src/main/res/drawable/
        if (bmi < 18.5){
            result = "Underweight";
        } else if (bmi < 25){
            result = "Normal";
            image.setImageResource(R.drawable.pizza);
        } else if (bmi < 30){
            result = "Overweight";
        } else {
            result = "Obese";
        }
        advice.setText(result);
    }

    public void closeActivity(View view){
        finish();
    }

}