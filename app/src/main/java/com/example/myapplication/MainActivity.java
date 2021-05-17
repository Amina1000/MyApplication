package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    private Integer result = 0;
    private Integer buffer = 0;
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
        CheckBox checkBox = findViewById(R.id.checkBox);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        button.setOnClickListener(v -> {

            try {
                buffer = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            switch (operation) {
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
            buffer = 0;
        });
        button3.setOnClickListener(v -> {
            try {
                buffer = Integer.valueOf(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            result = result + buffer;
            operation = '+';
            editText1.setText("");
        });
        button2.setOnClickListener(v -> {
            try {
                buffer = Integer.valueOf(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView.setText("Введите число");
            }
            result = buffer - result;
            operation = '-';
            editText1.setText("");
        });
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                result = 0;
                buffer = 0;
                editText1.setText("");
                textView.setText("");
            }
        });
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView.isChecked()) {
                checkBox.setVisibility(View.VISIBLE);
                switchCompat.setVisibility(View.VISIBLE);
            } else {
                checkBox.setVisibility(View.GONE);
                switchCompat.setVisibility(View.GONE);
            }
        });

    }

    public void onCheckboxClicked(View view) {
        CheckBox checkBox = findViewById(R.id.checkBox);
        LinearLayout linearLayout = findViewById(R.id.llHead);
        if (checkBox.isChecked())
            linearLayout.setBackgroundResource(R.color.design_default_color_background);
        else
            linearLayout.setBackgroundResource(R.color.background_color);
    }
}