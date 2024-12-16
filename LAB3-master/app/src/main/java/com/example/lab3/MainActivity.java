package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorScreen;
    private String currentInput = "";
    private double result = 0;
    private String lastOperator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        setupNumberButtons();
        setupOperatorButtons();
    }

    private void setupNumberButtons() {
        int[] numberIds = {R.id.n0, R.id.n1, R.id.n2, R.id.n3, R.id.n4, R.id.n5, R.id.n6, R.id.n7, R.id.n8, R.id.n9};
        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            if (isOperatorPressed) {
                currentInput = "";
                isOperatorPressed = false;
            }
            currentInput += button.getText().toString();
            calculatorScreen.setText(currentInput);
        };

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupOperatorButtons() {
        findViewById(R.id.nplus).setOnClickListener(view -> handleOperator("+"));
        findViewById(R.id.nminus).setOnClickListener(view -> handleOperator("-"));
        findViewById(R.id.multiplication).setOnClickListener(view -> handleOperator("*"));
        findViewById(R.id.division).setOnClickListener(view -> handleOperator("/"));
        findViewById(R.id.squareRoot).setOnClickListener(view -> handleSquareRoot());
        findViewById(R.id.plusMinus).setOnClickListener(view -> handleSignChange());
        findViewById(R.id.clearEverything).setOnClickListener(view -> handleClear());
        findViewById(R.id.back).setOnClickListener(view -> handleBackspace());
        findViewById(R.id.nequal).setOnClickListener(view -> calculateResult());
    }

    private void handleOperator(String operator) {
        calculateResult();
        lastOperator = operator;
        isOperatorPressed = true;
    }

    private void handleSquareRoot() {
        double number = Double.parseDouble(currentInput);
        result = Math.sqrt(number);
        calculatorScreen.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
    }

    private void handleSignChange() {
        double number = Double.parseDouble(currentInput);
        result = -number;
        calculatorScreen.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
    }

    private void handleClear() {
        currentInput = "";
        result = 0;
        lastOperator = "";
        calculatorScreen.setText("0");
    }

    private void handleBackspace() {
        if (currentInput.length() > 0) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            calculatorScreen.setText(currentInput);
        }
    }

    private void calculateResult() {
        double currentNumber = currentInput.isEmpty() ? 0 : Double.parseDouble(currentInput);
        switch (lastOperator) {
            case "+":
                result += currentNumber;
                break;
            case "-":
                result -= currentNumber;
                break;
            case "*":
                result *= currentNumber;
                break;
            case "/":
                if (currentNumber != 0) {
                    result /= currentNumber;
                } else {
                    calculatorScreen.setText("Error");
                    return;
                }
                break;
            default:
                result = currentNumber;
                break;
        }
        calculatorScreen.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
    }
}
