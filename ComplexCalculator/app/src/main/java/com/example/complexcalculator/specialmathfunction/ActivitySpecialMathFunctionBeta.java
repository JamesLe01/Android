package com.example.complexcalculator.specialmathfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.complexcalculator.R;

import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;

import java.util.Locale;

public class ActivitySpecialMathFunctionBeta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_math_function_beta);

        EditText editTextBetaFunction_betaFunc_a = findViewById(R.id.editTextBetaFunction_betaFunc_a);
        EditText editTextBetaFunction_betaFunc_b = findViewById(R.id.editTextBetaFunction_betaFunc_b);
        Button buttonBetaFunction_betaFunc = findViewById(R.id.buttonBetaFunction_betaFunc);
        TextView textViewBetaFunction_betaFunc_result = findViewById(R.id.textViewBetaFunction_betaFunc_result);

        EditText editTextBetaFunction_betaIncompleteFunc_x = findViewById(R.id.editTextBetaFunction_betaIncompleteFunc_x);
        EditText editTextBetaFunction_betaIncompleteFunc_a = findViewById(R.id.editTextBetaFunction_betaIncompleteFunc_a);
        EditText editTextBetaFunction_betaIncompleteFunc_b = findViewById(R.id.editTextBetaFunction_betaIncompleteFunc_b);
        Button buttonBetaFunction_betaIncompleteFunc = findViewById(R.id.buttonBetaFunction_betaIncompleteFunc);
        TextView textViewBetaFunction_betaIncompleteFunc_result = findViewById(R.id.textViewBetaFunction_betaIncompleteFunc_result);

        EditText editTextBetaFunction_regularizedBeta_x = findViewById(R.id.editTextBetaFunction_regularizedBeta_x);
        EditText editTextBetaFunction_regularizedBeta_a = findViewById(R.id.editTextBetaFunction_regularizedBeta_a);
        EditText editTextBetaFunction_regularizedBeta_b = findViewById(R.id.editTextBetaFunction_regularizedBeta_b);
        Button buttonBetaFunction_regularizedBeta = findViewById(R.id.buttonBetaFunction_regularizedBeta);
        TextView textViewBetaFunction_regularizedBeta_result = findViewById(R.id.textViewBetaFunction_regularizedBeta_result);

        buttonBetaFunction_betaFunc.setOnClickListener(v -> {
            double a, b;
            String a_str = editTextBetaFunction_betaFunc_a.getText().toString();
            String b_str = editTextBetaFunction_betaFunc_b.getText().toString();

            try {
                a = Double.parseDouble(a_str);
                b = Double.parseDouble(b_str);
            } catch (Exception e1) {
                return;
            }
            double ans;
            try {
                ans = Gamma.gamma(a) * Gamma.gamma(b) / Gamma.gamma(a + b);
            } catch (Exception e1) {
                return;
            }
            textViewBetaFunction_betaFunc_result.setText(
                    String.format(Locale.US, "Beta(%f, %f) = %f", a, b, ans)
            );
        });

        buttonBetaFunction_betaIncompleteFunc.setOnClickListener(v -> {
            double x, a, b;
            String x_str = editTextBetaFunction_betaIncompleteFunc_x.getText().toString();
            String a_str = editTextBetaFunction_betaIncompleteFunc_a.getText().toString();
            String b_str = editTextBetaFunction_betaIncompleteFunc_b.getText().toString();

            try {
                x = Double.parseDouble(x_str);
                a = Double.parseDouble(a_str);
                b = Double.parseDouble(b_str);
            } catch (Exception e1) {
                return;
            }
            double beta_ab, ans;
            try {
                beta_ab = Gamma.gamma(a) * Gamma.gamma(b) / Gamma.gamma(a + b);
                ans = Beta.regularizedBeta(x, a, b) * beta_ab;
            } catch (Exception e1) {
                return;
            }

            textViewBetaFunction_betaIncompleteFunc_result.setText(
                    String.format(Locale.US, "Beta(%f, %f, %f) = %f", x, a, b, ans)
            );
        });

        buttonBetaFunction_regularizedBeta.setOnClickListener(v -> {
            double x, a, b;
            String x_str = editTextBetaFunction_regularizedBeta_x.getText().toString();
            String a_str = editTextBetaFunction_regularizedBeta_a.getText().toString();
            String b_str = editTextBetaFunction_regularizedBeta_b.getText().toString();

            try {
                x = Double.parseDouble(x_str);
                a = Double.parseDouble(a_str);
                b = Double.parseDouble(b_str);
            } catch (Exception e1) {
                return;
            }

            double ans;
            try {
                ans = Beta.regularizedBeta(x, a, b);
            }
            catch (Exception e1) {
                return;
            }
            textViewBetaFunction_regularizedBeta_result.setText(
                    String.format(Locale.US, "I(%f, %f, %f) = %f", x, a, b, ans)
            );
        });
    }
}