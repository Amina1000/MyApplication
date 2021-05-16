package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer result=0;
    private Integer buffer=0;
    private char operation;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        EditText editText1 = findViewById(R.id.editText1);
        TextView textView = findViewById(R.id.textView);
        SwitchCompat switchCompat = findViewById(R.id.switch1);

        button.setOnClickListener(v -> {

            try {
                buffer = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            switch(operation) {
                case '+':
                    result = result + buffer;
                    textView.setText(result.toString());
                    break;
                case '-':
                    result = result - buffer;
                    textView.setText(result.toString());
                    break;
                default:
                    textView.setText("Error! Enter correct operator");
                    return;
            }
            editText1.setText("");
            result = 0;
            buffer =0;
        });
        button3.setOnClickListener(v -> {
            try {
                buffer =Integer.valueOf(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            result = result + buffer;
            operation = '+';
            editText1.setText("");
        });
        button2.setOnClickListener(v -> {
            try {
                buffer =Integer.valueOf(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            result = buffer - result;
            operation = '-';
            editText1.setText("");
        });
        switchCompat.setOnClickListener(v -> {
            result = 0;
            buffer =0;
            editText1.setText("");
            textView.setText("");
        });
    }
}