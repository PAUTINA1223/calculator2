package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button chet;
    private TextView  result2;
    private EditText num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        chet = findViewById(R.id.chet);
        result2 = findViewById(R.id.result2);
        num1 = findViewById(R.id.num1);

        chet.setOnClickListener(this);


        }
    @Override
    public void onClick(View v) {
        float num = 0;
        float res = 0;

        try {
            // Get the text from the EditText
            String numStr = num1.getText().toString();
            // Convert the text to a float
            num = Float.parseFloat(numStr);

        } catch (NumberFormatException e) {
            result2.setText("Invalid input"); // More informative error message
            return; // Stop execution if there's an error
        }

        if (v.getId() == R.id.chet) {
            if (num < 0) { // Handle negative input
                result2.setText("Cannot calculate sqrt of negative number");
            } else {
                res = (float) Math.sqrt(num);
                result2.setText(String.valueOf(res));
            }
        }
    }
    public void Click(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


//       if{ operation.setText("sqrt");
//        res = Math.sqrt(num1);
//    } else if (v.getId() == R.id.buttonMultiply) {
//        operation.setText("*");
//        res = num1 * num2;
//    } else if (v.getId() == R.id.buttonClean) {
//        number1.setText("");
//        operation.setText("");
//        number2.setText("");
//        result.setText("");
//        return;
//    } else {
//        result.setText("Неправильная операция");
//        return;
//    }
//
//        result.setText(String.valueOf(res));
//}
//


