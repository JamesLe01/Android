package com.example.complexcalculator.probability.probabilitydistribution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.complexcalculator.R;

import java.util.Locale;

import org.apache.commons.math3.distribution.*;

public class ActivityDiscreteDistributionEvaluated extends AppCompatActivity {
    static IntegerDistribution integerDistribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution_evaluated);

        TextView textViewSummaryContinuousProbability = findViewById(R.id.textViewSummaryProbability);

        LinearLayout linearLayout1Probability = findViewById(R.id.linearLayout1Probability);
        TextView textView1Probability = findViewById(R.id.textView1Probability);
        EditText editText1Probability = findViewById(R.id.editText1ContinuousProbability);
        LinearLayout linearLayout2Probability = findViewById(R.id.linearLayout2Probability);
        TextView textView2Probability = findViewById(R.id.textView2Probability);
        EditText editText2Probability = findViewById(R.id.editText2Probability);
        LinearLayout linearLayout3Probability = findViewById(R.id.linearLayout3Probability);
        TextView textView3Probability = findViewById(R.id.textView3Probability);
        EditText editText3Probability = findViewById(R.id.editText3Probability);

        Button buttonConfirmProbability = findViewById(R.id.buttonConfirmProbability);
        TextView textViewMeanProbability = findViewById(R.id.textViewMeanProbability);
        TextView textViewVarianceProbability = findViewById(R.id.textViewVarianceProbability);
        EditText editTextEvaluateCDFProbability = findViewById(R.id.editTextEvaluateCDFProbability);
        Button buttonConfirmCDFProbability = findViewById(R.id.buttonConfirmCDFProbability);
        TextView textViewCDFResultProbability = findViewById(R.id.textViewCDFResultProbability);
        EditText editTextEvaluateInverseCDFProbability = findViewById(R.id.editTextEvaluateInverseCDFProbability);
        Button buttonConfirmInverseCDFProbability = findViewById(R.id.buttonConfirmInverseCDFProbability);
        TextView textViewInverseCDFResultProbability = findViewById(R.id.textViewInverseCDFResultProbability);

        EditText editTextEvaluatePMF_PDF_Probability = findViewById(R.id.editTextEvaluatePMF_PDF_Probability);
        Button buttonConfirmPMF_PDF_Probability = findViewById(R.id.buttonConfirmPMF_PDF_Probability);
        TextView textViewPMF_PDF_ResultProbability = findViewById(R.id.textViewPMF_PDF_ResultProbability);

        String distributionType = getIntent().getExtras().get("DistributionType").toString();
        textViewSummaryContinuousProbability.setText(distributionType);

        switch (distributionType) {
            case "Bernoulli Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter p:");
                editText1Probability.setHint("Enter p");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String p_str = editText1Probability.getText().toString();

                    double p;
                    try {
                        p = Double.parseDouble(p_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((p < 0) || (p > 1)) {
                        return;
                    }
                    BinomialDistribution bernoulliDistribution = new BinomialDistribution(1, p);
                    integerDistribution = bernoulliDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", bernoulliDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", bernoulliDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Binomial Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter n:");
                textView2Probability.setText("Enter p:");
                editText1Probability.setHint("Enter n");
                editText2Probability.setHint("Enter p");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String n_str = editText1Probability.getText().toString();
                    String p_str = editText2Probability.getText().toString();

                    int n;
                    double p;
                    try {
                        n = Integer.parseInt(n_str);
                        p = Double.parseDouble(p_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((n < 0) || (p < 0) || (p > 1)) {
                        return;
                    }
                    BinomialDistribution binomialDistribution = new BinomialDistribution(n, p);
                    integerDistribution = binomialDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", binomialDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", binomialDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Geometric Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter p:");
                editText1Probability.setHint("Enter p");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String p_str = editText1Probability.getText().toString();

                    double p;
                    try {
                        p = Double.parseDouble(p_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((p < 0) || (p > 1)) {
                        return;
                    }
                    GeometricDistribution geometricDistribution = new GeometricDistribution(p);
                    integerDistribution = geometricDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", geometricDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", geometricDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }

            case "Hypergeometric Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                linearLayout3Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter N:");
                textView2Probability.setText("Enter K:");
                textView3Probability.setText("Enter n:");
                editText1Probability.setHint("Enter N");
                editText2Probability.setHint("Enter K");
                editText3Probability.setHint("Enter n");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String N_str = editText1Probability.getText().toString();
                    String K_str = editText2Probability.getText().toString();
                    String n_str = editText3Probability.getText().toString();

                    int N, K, n;
                    try {
                        N = Integer.parseInt(N_str);
                        K= Integer.parseInt(K_str);
                        n = Integer.parseInt(n_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((K < 0) || (n < 0) || (K > N) || (n > N)) {
                        return;
                    }
                    HypergeometricDistribution hypergeometricDistribution = new HypergeometricDistribution(N, K, n);
                    integerDistribution = hypergeometricDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", hypergeometricDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", hypergeometricDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }

            case "Negative Binomial Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter r:");
                textView2Probability.setText("Enter p:");
                editText1Probability.setHint("Enter r");
                editText2Probability.setHint("Enter p");


                buttonConfirmProbability.setOnClickListener(v -> {
                    String r_str = editText1Probability.getText().toString();
                    String p_str = editText2Probability.getText().toString();

                    int r;
                    double p;
                    try {
                        r = Integer.parseInt(r_str);
                        p = Double.parseDouble(p_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((r <= 0) || (p < 0) || (p > 1)) {
                        return;
                    }
                    PascalDistribution pascalDistribution = new PascalDistribution(r, p);
                    integerDistribution = pascalDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", pascalDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", pascalDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                });

                break;
            }

            case "Poisson Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter lambda:");
                editText1Probability.setHint("Enter lambda");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String lambda_str = editText1Probability.getText().toString();

                    double lambda;
                    try {
                        lambda = Double.parseDouble(lambda_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (lambda <= 0) {
                        return;
                    }
                    PoissonDistribution poissonDistribution = new PoissonDistribution(lambda);
                    integerDistribution = poissonDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", poissonDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", poissonDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });
                break;
            }
            case "(Discrete) Uniform Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter the lower bound:");
                textView2Probability.setText("Enter the upper bound:");
                editText1Probability.setHint("Enter the lower bound");
                editText2Probability.setHint("Enter the upper bound");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String lower_str = editText1Probability.getText().toString();
                    String upper_str = editText2Probability.getText().toString();

                    int lower, upper;
                    try {
                        lower = Integer.parseInt(lower_str);
                        upper = Integer.parseInt(upper_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (lower > upper) {
                        return;
                    }
                    UniformIntegerDistribution uniformIntegerDistribution = new UniformIntegerDistribution(lower, upper);
                    integerDistribution = uniformIntegerDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", uniformIntegerDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", uniformIntegerDistribution.getNumericalVariance()));

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);
                });
                break;
            }
        }  // End switch

        buttonConfirmCDFProbability.setOnClickListener(v -> {
            String str = editTextEvaluateCDFProbability.getText().toString();
            int inputCDF;
            try {
                inputCDF = Integer.parseInt(str);
            } catch (Exception e1) {
                return;
            }
            double ans = integerDistribution.cumulativeProbability(inputCDF);
            textViewCDFResultProbability.setText(String.format(Locale.US, "CDF(%d) = %f", inputCDF, ans));
        });

        buttonConfirmInverseCDFProbability.setOnClickListener(v -> {
            String str = editTextEvaluateInverseCDFProbability.getText().toString();
            double inputInverseCDF;
            try {
                inputInverseCDF = Double.parseDouble(str);
            } catch (Exception e1) {
                return;
            }
            if ((inputInverseCDF < 0) || (inputInverseCDF > 1)) {
                return;
            }
            double ans = integerDistribution.inverseCumulativeProbability(inputInverseCDF);
            textViewInverseCDFResultProbability.setText(String.format(Locale.US, "Quantile(%f) = %f", inputInverseCDF, ans));
        });

        buttonConfirmPMF_PDF_Probability.setText("EVALUATE PMF");
        buttonConfirmPMF_PDF_Probability.setOnClickListener(v -> {
            String str = editTextEvaluatePMF_PDF_Probability.getText().toString();
            int inputPMF;
            try {
                inputPMF = Integer.parseInt(str);
            } catch (Exception e1) {
                return;
            }

            int lowerBoundSupport = integerDistribution.getSupportLowerBound();
            int upperBoundSupport = integerDistribution.getSupportUpperBound();

            if ((inputPMF < lowerBoundSupport) || (inputPMF > upperBoundSupport)) {
                return;
            }

            double ans = integerDistribution.probability(inputPMF);
            textViewPMF_PDF_ResultProbability.setText(String.format(Locale.US, "PMF(%d) = %f", inputPMF, ans));
        });


    } // End onCreate
}