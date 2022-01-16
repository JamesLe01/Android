package com.example.complexcalculator.specialmathfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.complexcalculator.R;

import org.apache.commons.math3.special.Gamma;

import java.util.Locale;

public class ActivitySpecialMathFunctionFactorialGamma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_math_function_factorial_gamma);

        EditText editTextFactorialGammaFunction_factorial_n = findViewById(R.id.editTextFactorialGammaFunction_factorial_n);
        Button buttonFactorialGammaFunction_factorial = findViewById(R.id.buttonFactorialGammaFunction_factorial);
        TextView textViewFactorialGammaFunction_factorial_result = findViewById(R.id.textViewFactorialGammaFunction_factorial_result);

        EditText editTextFactorialGammaFunction_gamma_z = findViewById(R.id.editTextFactorialGammaFunction_gamma_z);
        Button buttonFactorialGammaFunction_gamma = findViewById(R.id.buttonFactorialGammaFunction_gamma);
        TextView textViewFactorialGammaFunction_gamma_result = findViewById(R.id.textViewFactorialGammaFunction_gamma_result);

        EditText editTextFactorialGammaFunction_digamma_z = findViewById(R.id.editTextFactorialGammaFunction_digamma_z);
        Button buttonFactorialGammaFunction_digamma = findViewById(R.id.buttonFactorialGammaFunction_digamma);
        TextView textViewFactorialGammaFunction_digamma_result = findViewById(R.id.textViewFactorialGammaFunction_digamma_result);

        EditText editTextFactorialGammaFunction_trigamma_z = findViewById(R.id.editTextFactorialGammaFunction_trigamma_z);
        Button buttonFactorialGammaFunction_trigamma = findViewById(R.id.buttonFactorialGammaFunction_trigamma);
        TextView textViewFactorialGammaFunction_trigamma_result = findViewById(R.id.textViewFactorialGammaFunction_trigamma_result);

        buttonFactorialGammaFunction_factorial.setOnClickListener(v -> {
            int n;
            String n_str = editTextFactorialGammaFunction_factorial_n.getText().toString();
            try {
                n = Integer.parseInt(n_str);
            } catch (Exception e1) {
                return;
            }
            if (n < 0) {
                return;
            }
            long ans = org.apache.commons.math3.util.CombinatoricsUtils.factorial(n);
            textViewFactorialGammaFunction_factorial_result.setText(String.format(Locale.US, "%d! = %d", n, ans));
        });
        buttonFactorialGammaFunction_gamma.setOnClickListener(v -> {
            double z;
            String z_str = editTextFactorialGammaFunction_gamma_z.getText().toString();
            try {
                z = Double.parseDouble(z_str);
            } catch (Exception e1) {
                return;
            }
            double ans;
            try {
                ans = Gamma.gamma(z);
            } catch (Exception e1) {
                return;
            }
            textViewFactorialGammaFunction_gamma_result.setText(String.format(Locale.US, "Gamma(%f) = %f", z, ans));
        });

        buttonFactorialGammaFunction_digamma.setOnClickListener(v -> {
            double z;
            String z_str = editTextFactorialGammaFunction_digamma_z.getText().toString();
            try {
                z = Double.parseDouble(z_str);
            } catch (Exception e1) {
                return;
            }
            double ans;
            try {
                ans = Gamma.digamma(z);
            } catch (Exception e1) {
                return;
            }
            textViewFactorialGammaFunction_digamma_result.setText(String.format(Locale.US, "Digamma(%f) = %f", z, ans));
        });

        buttonFactorialGammaFunction_trigamma.setOnClickListener(v -> {
            double z;
            String z_str = editTextFactorialGammaFunction_trigamma_z.getText().toString();
            try {
                z = Double.parseDouble(z_str);
            } catch (Exception e1) {
                return;
            }
            double ans;
            try {
                ans = Gamma.trigamma(z);
            } catch (Exception e1) {
                return;
            }
            textViewFactorialGammaFunction_trigamma_result.setText(String.format(Locale.US, "Trigamma(%f) = %f", z, ans));
        });
    }
}