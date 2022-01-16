package com.example.complexcalculator.probability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.complexcalculator.R;

public class ActivityProbability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probability);

        Button buttonDiscreteDistribution = findViewById(R.id.buttonDiscreteDistribution);
        buttonDiscreteDistribution.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityChooseDistribution.class);
            intent.putExtra("ContinuousOrDiscrete", "Discrete");
            startActivity(intent);
        });

        Button buttonContinuousDistribution = findViewById(R.id.buttonContinuousDistribution);
        buttonContinuousDistribution.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityChooseDistribution.class);
            intent.putExtra("ContinuousOrDiscrete", "Continuous");
            startActivity(intent);
        });
    }
}