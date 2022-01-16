package com.example.complexcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.complexcalculator.probability.ActivityProbability;
import com.example.complexcalculator.specialmathfunction.ActivityChooseSpecialMathFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonProbabilityActivityMain = findViewById(R.id.buttonProbabilityActivityMain);
        Button buttonSpecialMathFunctionActivityMain = findViewById(R.id.buttonSpecialMathFunctionActivityMain);

        buttonProbabilityActivityMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityProbability.class);
            startActivity(intent);
        });

        buttonSpecialMathFunctionActivityMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityChooseSpecialMathFunction.class);
            startActivity(intent);
        });
    }
}