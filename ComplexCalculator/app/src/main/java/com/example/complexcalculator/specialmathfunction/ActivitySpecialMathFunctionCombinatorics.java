package com.example.complexcalculator.specialmathfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.complexcalculator.R;

import java.util.Locale;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class ActivitySpecialMathFunctionCombinatorics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_math_function_combinatorics);

        EditText editTextCombinatorics_combination_n = findViewById(R.id.editTextCombinatorics_combination_n);
        EditText editTextCombinatorics_combination_k = findViewById(R.id.editTextCombinatorics_combination_k);
        Button buttonCombinatorics_combination = findViewById(R.id.buttonCombinatorics_combination);
        TextView textViewCombinatorics_combination_result = findViewById(R.id.textViewCombinatorics_combination_result);

        EditText editTextCombinatorics_permutation_n = findViewById(R.id.editTextCombinatorics_permutation_n);
        EditText editTextCombinatorics_permutation_k = findViewById(R.id.editTextCombinatorics_permutation_k);
        Button buttonCombinatorics_permutation = findViewById(R.id.buttonCombinatorics_permutation);
        TextView textViewCombinatorics_permutation_result = findViewById(R.id.textViewCombinatorics_permutation_result);

        buttonCombinatorics_combination.setOnClickListener(v -> {
            int n, k;
            String n_str = editTextCombinatorics_combination_n.getText().toString();
            String k_str = editTextCombinatorics_combination_k.getText().toString();
            try {
                n = Integer.parseInt(n_str);
                k = Integer.parseInt(k_str);
            } catch (Exception e1) {
                return;
            }
            if ((n < 0) || (k > n)) {
                return;
            }
            long ans = CombinatoricsUtils.binomialCoefficient(n, k);
            textViewCombinatorics_combination_result.setText(String.format(Locale.US, "Combination(%d, %d) = %d", n, k, ans));
        });

        buttonCombinatorics_permutation.setOnClickListener(v -> {
            int n, k;
            String n_str = editTextCombinatorics_permutation_n.getText().toString();
            String k_str = editTextCombinatorics_permutation_k.getText().toString();
            try {
                n = Integer.parseInt(n_str);
                k = Integer.parseInt(k_str);
            } catch (Exception e1) {
                return;
            }
            if ((n < 0) || (k > n)) {
                return;
            }
            long ans = CombinatoricsUtils.binomialCoefficient(n, k) * CombinatoricsUtils.factorial(k);
            textViewCombinatorics_permutation_result.setText(String.format(Locale.US, "Permutation(%d, %d) = %d", n, k, ans));
        });
    }
}