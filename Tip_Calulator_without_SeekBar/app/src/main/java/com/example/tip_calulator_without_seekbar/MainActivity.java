package com.example.tip_calulator_without_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextBillAmount, editTextTipPercentage, editTextNumberOfPeople;
    Button btnCalculateTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTipPercentage = findViewById(R.id.editTextTipPercentage);
        editTextNumberOfPeople = findViewById(R.id.editTextNumberOfPeople);
        btnCalculateTip = findViewById(R.id.btnCalculateTip);

        btnCalculateTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        String billAmountStr = editTextBillAmount.getText().toString();
        String tipPercentageStr = editTextTipPercentage.getText().toString();
        String numberOfPeopleStr = editTextNumberOfPeople.getText().toString();

        if (billAmountStr.isEmpty() || tipPercentageStr.isEmpty() || numberOfPeopleStr.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        double billAmount = Double.parseDouble(billAmountStr);
        double tipPercentage = Double.parseDouble(tipPercentageStr);
        int numberOfPeople = Integer.parseInt(numberOfPeopleStr);

        double tipAmount = (billAmount * tipPercentage) / 100;
        double totalAmount = billAmount + tipAmount;
        double totalPerPerson = totalAmount / numberOfPeople;

        String result = String.format("Tip Amount: $%.2f\nTotal Amount: $%.2f\nTotal Per Person: $%.2f", tipAmount, totalAmount, totalPerPerson);

        showAlert(result);
    }

    private void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
