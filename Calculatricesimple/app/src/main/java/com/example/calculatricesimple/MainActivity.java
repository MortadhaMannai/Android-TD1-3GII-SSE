package com.example.calculatricesimple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    Spinner spinnerOperator;
    Button btnCalculate;
    TextView textViewResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        spinnerOperator = findViewById(R.id.spinnerOperator);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Define a list of operators (+, -, *, /)
        String[] operators = {"+", "-", "*", "/"};
        ArrayAdapter<String> operatorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operators);
        operatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperator.setAdapter(operatorAdapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation();
            }
        });
    }

    private void performCalculation() {
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();
        String selectedOperator = spinnerOperator.getSelectedItem().toString();

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            // Display an error message if either number is empty.
            return;
        }

        double number1 = Double.parseDouble(number1Str);
        double number2 = Double.parseDouble(number2Str);
        double result = 0;

        // Perform the calculation based on the selected operator.
        switch (selectedOperator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    // Handle division by zero.
                    return;
                }
                break;
        }

        // Display the result in a TextView.
        textViewResult.setText("Result: " + result);
    }
}
