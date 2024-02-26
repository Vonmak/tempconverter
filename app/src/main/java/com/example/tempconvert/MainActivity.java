package com.example.tempconvert;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views after setContentView()
        editTextTemperature = findViewById(R.id.editTextTemperature);
        Button btnCelsiusToFahrenheit = findViewById(R.id.btnCelsiusToFahrenheit);
        Button btnFahrenheitToCelsius = findViewById(R.id.btnFahrenheitToCelsius);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);


        btnCelsiusToFahrenheit.setOnClickListener(v -> convertCelsiusToFahrenheit());

        btnFahrenheitToCelsius.setOnClickListener(v -> convertFahrenheitToCelsius());

        buttonConvert.setOnClickListener(v -> convertTemperature());


    }

    @SuppressLint("DefaultLocale")
    public void convertCelsiusToFahrenheit() {
        String temperatureStr = editTextTemperature.getText().toString();

        double temperature = Double.parseDouble(temperatureStr);
        double result = (temperature * 9 / 5) + 32;

        textViewResult.setText(String.format("%.2f", result));
    }

    @SuppressLint("DefaultLocale")
    public void convertFahrenheitToCelsius() {
        String temperatureStr = editTextTemperature.getText().toString();

        double temperature = Double.parseDouble(temperatureStr);
        double result = (temperature - 32) * 5 / 9;

        textViewResult.setText(String.format("%.2f", result));
    }
    @SuppressLint("DefaultLocale")
    private void convertTemperature() {
        String temperatureStr = editTextTemperature.getText().toString();

        double temperature = Double.parseDouble(temperatureStr);
        boolean isCelsiusToFahrenheit = findViewById(R.id.btnCelsiusToFahrenheit).isPressed();

        double result;

        if (isCelsiusToFahrenheit) {
            result = (temperature * 9 / 5) + 32;
        } else {
            result = (temperature - 32) * 5 / 9;
        }

        textViewResult.setText(String.format("%.2f", result));

    }
}