package com.example.complexcalculator.probability.probabilitydistribution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.complexcalculator.R;

import org.apache.commons.math3.distribution.*;

import java.util.Locale;

public class ActivityContinuousDistributionEvaluated extends AppCompatActivity {
    static RealDistribution realDistribution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution_evaluated);

        TextView textViewSummaryProbability = findViewById(R.id.textViewSummaryProbability);
        LinearLayout linearLayout1Probability = findViewById(R.id.linearLayout1Probability);
        TextView textView1Probability = findViewById(R.id.textView1Probability);
        EditText editText1Probability = findViewById(R.id.editText1ContinuousProbability);
        LinearLayout linearLayout2Probability = findViewById(R.id.linearLayout2Probability);
        TextView textView2Probability = findViewById(R.id.textView2Probability);
        EditText editText2Probability = findViewById(R.id.editText2Probability);
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
        textViewSummaryProbability.setText(distributionType);

        switch (distributionType) {
            case "Beta Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter alpha:");
                textView2Probability.setText("Enter beta:");
                editText1Probability.setHint("Enter alpha");
                editText2Probability.setHint("Enter beta");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String alpha_str = editText1Probability.getText().toString();
                    String beta_str = editText2Probability.getText().toString();

                    double alpha;
                    double beta;
                    try {
                        alpha = Double.parseDouble(alpha_str);
                        beta = Double.parseDouble(beta_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((alpha <= 0) || (beta <= 0)) {
                        return;
                    }
                    BetaDistribution betaDistribution = new BetaDistribution(alpha, beta);
                    realDistribution = betaDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", betaDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", betaDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);

                });

                break;
            }
            case "Chi Squared Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter the degree of freedom:");
                editText1Probability.setHint("Enter the degree of freedom");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String df_str = editText1Probability.getText().toString();

                    int df;
                    try {
                        df = Integer.parseInt(df_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (df <= 0) {
                        return;
                    }
                    ChiSquaredDistribution chiSquaredDistribution = new ChiSquaredDistribution(df);
                    realDistribution = chiSquaredDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", chiSquaredDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", chiSquaredDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Exponential Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter the mean:");
                editText1Probability.setHint("Enter the mean");

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
                    ExponentialDistribution exponentialDistribution = new ExponentialDistribution(lambda);
                    realDistribution = exponentialDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", exponentialDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", exponentialDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "F Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter numerator degree of freedom:");
                textView2Probability.setText("Enter denominator degree of freedom:");
                editText1Probability.setHint("Enter numerator degree of freedom");
                editText2Probability.setHint("Enter denominator degree of freedom");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String dfNum_str = editText1Probability.getText().toString();
                    String dfDenom_str = editText2Probability.getText().toString();

                    double dfNum;
                    double dfDenom;
                    try {
                        dfNum = Double.parseDouble(dfNum_str);
                        dfDenom = Double.parseDouble(dfDenom_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((dfNum <= 0) || (dfDenom <= 0)) {
                        return;
                    }
                    FDistribution fDistribution = new FDistribution(dfNum, dfDenom);
                    realDistribution = fDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", fDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", fDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Gamma Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter alpha:");
                textView2Probability.setText("Enter beta:");
                editText1Probability.setHint("Enter alpha");
                editText2Probability.setHint("Enter beta");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String alpha_str = editText1Probability.getText().toString();
                    String beta_str = editText2Probability.getText().toString();

                    double alpha;
                    double beta;
                    try {
                        alpha = Double.parseDouble(alpha_str);
                        beta = Double.parseDouble(beta_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if ((alpha <= 0) || (beta <= 0)) {
                        return;
                    }
                    GammaDistribution gammaDistribution = new GammaDistribution(alpha, beta);
                    realDistribution = gammaDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", gammaDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", gammaDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Log-normal Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter mu:");
                textView2Probability.setText("Enter sigma:");
                editText1Probability.setHint("Enter mu");
                editText2Probability.setHint("Enter sigma");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String mu_str = editText1Probability.getText().toString();
                    String sigma_str = editText2Probability.getText().toString();

                    double mu;
                    double sigma;
                    try {
                        mu = Double.parseDouble(mu_str);
                        sigma = Double.parseDouble(sigma_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (sigma <= 0) {
                        return;
                    }
                    LogNormalDistribution logNormalDistribution = new LogNormalDistribution(mu, sigma);
                    realDistribution = logNormalDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", logNormalDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", logNormalDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "Normal Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter mean:");
                textView2Probability.setText("Enter standard deviation:");
                editText1Probability.setHint("Enter mean");
                editText2Probability.setHint("Enter standard deviation");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String mean_str = editText1Probability.getText().toString();
                    String stdev_str = editText2Probability.getText().toString();

                    double mean;
                    double stdev;
                    try {
                        mean = Double.parseDouble(mean_str);
                        stdev = Double.parseDouble(stdev_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (stdev <= 0) {
                        return;
                    }
                    NormalDistribution normalDistribution = new NormalDistribution(mean, stdev);
                    realDistribution = normalDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", normalDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", normalDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "T Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter the degree of freedom:");
                editText1Probability.setHint("Enter the degree of freedom");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String df_str = editText1Probability.getText().toString();

                    double df;
                    try {
                        df = Double.parseDouble(df_str);
                    } catch (Exception e1) {
                        return;
                    }
                    if (df <= 0) {
                        return;
                    }
                    TDistribution tDistribution = new TDistribution(df);
                    realDistribution = tDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", tDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", tDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
            case "(Continuous) Uniform Distribution": {
                linearLayout1Probability.setVisibility(View.VISIBLE);
                linearLayout2Probability.setVisibility(View.VISIBLE);
                textView1Probability.setText("Enter the lower bound:");
                textView2Probability.setText("Enter the upper bound:");
                editText1Probability.setHint("Enter the lower bound");
                editText2Probability.setHint("Enter the upper bound");

                buttonConfirmProbability.setOnClickListener(v -> {
                    String a_str = editText1Probability.getText().toString();
                    String b_str = editText2Probability.getText().toString();

                    double a;
                    double b;
                    try {
                        a = Double.parseDouble(a_str);
                        b = Double.parseDouble(b_str);
                    } catch (Exception e1) {
                        return;
                    }
                    UniformRealDistribution uniformRealDistribution = new UniformRealDistribution(a, b);
                    realDistribution = uniformRealDistribution;
                    textViewMeanProbability.setText(
                            String.format(Locale.US, "Mean: %f", uniformRealDistribution.getNumericalMean()));
                    textViewVarianceProbability.setText(
                            String.format(Locale.US, "Variance: %f", uniformRealDistribution.getNumericalVariance()));

                    editTextEvaluatePMF_PDF_Probability.setVisibility(View.VISIBLE);
                    buttonConfirmPMF_PDF_Probability.setVisibility(View.VISIBLE);
                    textViewPMF_PDF_ResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmCDFProbability.setVisibility(View.VISIBLE);
                    textViewCDFResultProbability.setVisibility(View.VISIBLE);

                    editTextEvaluateInverseCDFProbability.setVisibility(View.VISIBLE);
                    buttonConfirmInverseCDFProbability.setVisibility(View.VISIBLE);
                    textViewInverseCDFResultProbability.setVisibility(View.VISIBLE);
                });

                break;
            }
        }  // End switch

        buttonConfirmCDFProbability.setOnClickListener(v -> {
            String str = editTextEvaluateCDFProbability.getText().toString();
            double inputCDF;
            try {
                inputCDF = Double.parseDouble(str);
            } catch (Exception e1) {
                return;
            }
            double ans = realDistribution.cumulativeProbability(inputCDF);
            textViewCDFResultProbability.setText(String.format(Locale.US, "CDF(%f) = %f", inputCDF, ans));
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
            double ans = realDistribution.inverseCumulativeProbability(inputInverseCDF);
            textViewInverseCDFResultProbability.setText(String.format(Locale.US, "Quantile(%f) = %f", inputInverseCDF, ans));
        });

        buttonConfirmPMF_PDF_Probability.setText("EVALUATE PDF AT");
        buttonConfirmPMF_PDF_Probability.setOnClickListener(v -> {
            String str = editTextEvaluatePMF_PDF_Probability.getText().toString();
            double inputPDF;
            try {
                inputPDF = Double.parseDouble(str);
            } catch (Exception e1) {
                return;
            }

            double lowerBoundSupport = realDistribution.getSupportLowerBound();
            double upperBoundSupport =  realDistribution.getSupportUpperBound();

            if ((inputPDF < lowerBoundSupport) || (inputPDF > upperBoundSupport)) {
                return;
            }

            double ans = realDistribution.density(inputPDF);
            textViewPMF_PDF_ResultProbability.setText(String.format(Locale.US, "PDF(%f) = %f", inputPDF, ans));
        });

    }  // End onCreate
}