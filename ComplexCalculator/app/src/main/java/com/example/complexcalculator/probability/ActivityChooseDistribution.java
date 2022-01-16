package com.example.complexcalculator.probability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.complexcalculator.CustomAdapterButton;
import com.example.complexcalculator.R;
import com.example.complexcalculator.probability.probabilitydistribution.ActivityContinuousDistributionEvaluated;
import com.example.complexcalculator.probability.probabilitydistribution.ActivityDiscreteDistributionEvaluated;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityChooseDistribution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = findViewById(R.id.listViewForButton);
        String discreteOrContinuous = (String) getIntent().getExtras().get("ContinuousOrDiscrete");
        String [] list_distribution;
        ArrayList<String> dataList;
        CustomAdapterButton customAdapterButton;

        if (discreteOrContinuous.equals("Continuous")) {
            list_distribution = new String[]{"Beta Distribution", "Chi Squared Distribution",
                    "Exponential Distribution", "F Distribution", "Gamma Distribution",
                    "Log-normal Distribution", "Normal Distribution", "T Distribution",
                    "(Continuous) Uniform Distribution"};
            dataList = new ArrayList<>(Arrays.asList(list_distribution));
            customAdapterButton = new CustomAdapterButton(this,
                    R.layout.button_listview, dataList, str -> {
                Intent intent = new Intent(this,
                        ActivityContinuousDistributionEvaluated.class);
                intent.putExtra("DistributionType", str);
                startActivity(intent);
            });
        }
        else {
            list_distribution = new String[]{"Bernoulli Distribution", "Binomial Distribution",
                    "Geometric Distribution", "Hypergeometric Distribution",
                    "Negative Binomial Distribution", "Poisson Distribution",
                    "(Discrete) Uniform Distribution"};
            dataList = new ArrayList<>(Arrays.asList(list_distribution));
            customAdapterButton = new CustomAdapterButton(this,
                    R.layout.button_listview, dataList, str -> {
                Intent intent = new Intent(this,
                        ActivityDiscreteDistributionEvaluated.class);
                intent.putExtra("DistributionType", str);
                startActivity(intent);
            });
        }
        listView.setAdapter(customAdapterButton);
    }
}