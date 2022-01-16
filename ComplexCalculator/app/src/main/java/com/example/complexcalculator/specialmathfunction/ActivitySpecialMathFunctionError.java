package com.example.complexcalculator.specialmathfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.complexcalculator.R;

import org.apache.commons.math3.special.Erf;

import java.util.Locale;

public class ActivitySpecialMathFunctionError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_math_function_error);

        EditText editTextErrorFunction_erfFunc_z = findViewById(R.id.editTextErrorFunction_erfFunc_z);
        Button buttonErrorFunction_erfFunc = findViewById(R.id.buttonErrorFunction_erfFunc);
        TextView textViewErrorFunction_erfFunc_result = findViewById(R.id.textViewErrorFunction_erfFunc_result);

        EditText editTextErrorFunction_inverseErfFunc_z = findViewById(R.id.editTextErrorFunction_inverseErfFunc_z);
        Button buttonErrorFunction_inverseErfFunc = findViewById(R.id.buttonErrorFunction_inverseErfFunc);
        TextView textViewErrorFunction_inverseErfFunc_result = findViewById(R.id.textViewErrorFunction_inverseErfFunc_result);

        EditText editTextErrorFunction_erfcFunc_z = findViewById(R.id.editTextErrorFunction_erfcFunc_z);
        Button buttonErrorFunction_erfcFunc = findViewById(R.id.buttonErrorFunction_erfcFunc);
        TextView textViewErrorFunction_erfcFunc_result = findViewById(R.id.textViewErrorFunction_erfcFunc_result);

        EditText editTextErrorFunction_inverseErfcFunc_z = findViewById(R.id.editTextErrorFunction_inverseErfcFunc_z);
        Button buttonErrorFunction_inverseErfcFunc = findViewById(R.id.buttonErrorFunction_inverseErfcFunc);
        TextView textViewErrorFunction_inverseErfcFunc_result = findViewById(R.id.textViewErrorFunction_inverseErfcFunc_result);

        buttonErrorFunction_erfFunc.setOnClickListener(v -> {
            double z, ans;
            String z_str = editTextErrorFunction_erfFunc_z.getText().toString();
            try {
                z = Double.parseDouble(z_str);
                ans = Erf.erf(z);
            } catch (Exception e1) {
                return;
            }
            textViewErrorFunction_erfFunc_result.setText(String.format(Locale.US, "erf(%f) = %f", z, ans));
        });

        buttonErrorFunction_inverseErfFunc.setOnClickListener(v -> {
            double x, ans;
            String x_str = editTextErrorFunction_inverseErfFunc_z.getText().toString();
            try {
                x = Double.parseDouble(x_str);
                ans = Erf.erfInv(x);

            } catch (Exception e1) {
                return;
            }
            textViewErrorFunction_inverseErfFunc_result.setText(String.format(Locale.US, "Inverse_erf(%f) = %f", x, ans));
        });

        buttonErrorFunction_erfcFunc.setOnClickListener(v -> {
            double z, ans;
            String z_str = editTextErrorFunction_erfcFunc_z.getText().toString();
            try {
                z = Double.parseDouble(z_str);
                ans = Erf.erfc(z);

            } catch (Exception e1) {
                return;
            }
            textViewErrorFunction_erfcFunc_result.setText(String.format(Locale.US, "erfc(%f) = %f", z, ans));
        });

        buttonErrorFunction_inverseErfcFunc.setOnClickListener(v -> {
            double x, ans;
            String x_str = editTextErrorFunction_inverseErfcFunc_z.getText().toString();
            try {
                x = Double.parseDouble(x_str);
                ans = Erf.erfcInv(x);

            } catch (Exception e1) {
                return;
            }
            textViewErrorFunction_inverseErfcFunc_result.setText(String.format(Locale.US, "Inverse_erfc(%f) = %f", x, ans));
        });
    }
}