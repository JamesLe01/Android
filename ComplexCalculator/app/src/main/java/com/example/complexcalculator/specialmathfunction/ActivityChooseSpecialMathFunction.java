package com.example.complexcalculator.specialmathfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.complexcalculator.CustomAdapterButton;
import com.example.complexcalculator.R;
import com.example.complexcalculator.probability.probabilitydistribution.ActivityContinuousDistributionEvaluated;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityChooseSpecialMathFunction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = findViewById(R.id.listViewForButton);
        String [] list_distribution = {"Beta Function", "Combinatorics", "Error Function", "Factorial and Gamma Function"};
        ArrayList<String> dataList = new ArrayList<>(Arrays.asList(list_distribution));

        CustomAdapterButton customAdapterButton = new CustomAdapterButton(this,
                R.layout.button_listview, dataList, str -> {
            Intent intent;
            switch (str) {
                case "Beta Function": {
                    intent = new Intent(this, ActivitySpecialMathFunctionBeta.class);
                    break;
                }
                case "Combinatorics": {
                    intent = new Intent(this, ActivitySpecialMathFunctionCombinatorics.class);
                    break;
                }
                case "Error Function": {
                    intent = new Intent(this, ActivitySpecialMathFunctionError.class);
                    break;
                }
                case "Factorial and Gamma Function": {
                    intent = new Intent(this, ActivitySpecialMathFunctionFactorialGamma.class);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }

            startActivity(intent);
        });

        listView.setAdapter(customAdapterButton);
    }
}