package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean, buttonStep;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Предполагается, что layout файл существует

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonClean = findViewById(R.id.buttonClean);
        buttonStep = findViewById(R.id.buttonStep);
        operation = findViewById(R.id.operation);
        result = findViewById(R.id.result);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonStep.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;

        try { // Add try-catch block to handle potential NumberFormatException
            num1 = Float.parseFloat(number1.getText().toString());
            num2 = Float.parseFloat(number2.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("");
            return;
        }

        if (v.getId() == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (v.getId() == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        } else if (v.getId() == R.id.buttonStep) {
            operation.setText("a^n");
            res = (float) Math.pow (num1,num2);
        } else if (v.getId() == R.id.buttonDivide) {
            if (num2 == 0) {
                result.setText("Деление на ноль!");
                return;
            }

            operation.setText("/");
            res = num1 / num2;
        } else if (v.getId() == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        } else if (v.getId() == R.id.buttonClean) {
            number1.setText("");
            operation.setText("");
            number2.setText("");
            result.setText("");
            return;
        } else {
            result.setText("Неправильная операция");
            return;
        }

        result.setText(String.valueOf(res));
    }
    public void Click(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

}
