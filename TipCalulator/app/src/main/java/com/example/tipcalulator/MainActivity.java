package com.example.tipcalulator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface; import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; import android.widget.EditText; import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    TextView Percent;
    SeekBar Bar;
    TextView Tip;
    TextView Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        Percent = findViewById(R.id.percent);
        Tip = findViewById(R.id.tip);
        Total = findViewById(R.id.total);
        Bar = findViewById(R.id.seekBar);
        Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override//lorsque bar change
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int percentval = progress;
                Percent.setText(String.valueOf(percentval) + "%");
                calcule();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void calcule() {
        double Amount = Double.parseDouble(amount.getText().toString());
        int percent = Bar.getProgress();
        double tipAmount = Amount * percent * 0.01;
        double totalAmount = Amount + tipAmount;
        Tip.setText(String.valueOf(tipAmount));
        Total.setText(String.valueOf(totalAmount));
    }
}