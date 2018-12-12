package com.example.nstojkovski.calculator;

import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equals;
    private Button clear;
    private Button store;
    private Button stored;
    private Button decimal;
    private Button sign;
    private TextView screen;
    private TextView answer;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '×';
    private final char DIVISION = '÷';
    private final char EQUALS = 0;
    private double value1 = Double.NaN;
    private double value2 = Double.NaN;
    private double storedValue = Double.NaN;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "9");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                } catch (Exception e) {
                    answer.setText("Invalid input, please try again");
                    return;
                }
                ACTION = ADDITION;
                answer.setText(String.valueOf(value1) + "+");
                screen.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                } catch (Exception e) {
                    answer.setText("Invalid input, please try again");
                    return;
                }
                ACTION = SUBTRACTION;
                answer.setText(String.valueOf(value1) + "-");
                screen.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                } catch (Exception e) {
                    answer.setText("Invalid input, please try again");
                    return;
                }
                ACTION = MULTIPLICATION;
                answer.setText(String.valueOf(value1) + "×");
                screen.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                } catch (Exception e) {
                    answer.setText("Invalid input, please try again");
                    return;
                }
                ACTION = DIVISION;
                answer.setText(String.valueOf(value1) + "÷");
                screen.setText(null);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                } catch (Exception e) {
                    answer.setText("Invalid input, please try again");
                    return;
                }
                ACTION = EQUALS;
                answer.setText(String.valueOf(value1));
                screen.setText(null);
                value2 = Double.NaN;
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                screen.setText(null);
                answer.setText(null);
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    storedValue = Double.valueOf(answer.getText().toString());
                } catch (Exception e) {

                }
            }
        });
        stored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Double.isNaN(storedValue)) {
                    screen.setText(screen.getText().toString() + storedValue);
                }
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + ".");
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "-");
            }
        });
    }

    private void setup() {
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        plus = findViewById(R.id.btnAdd);
        minus = findViewById(R.id.btnSubtract);
        multiply = findViewById(R.id.btnMultiply);
        divide = findViewById(R.id.btnDivide);
        equals = findViewById(R.id.btnEquals);
        clear = findViewById(R.id.btnClear);
        screen = findViewById(R.id.Display);
        answer = findViewById(R.id.answer);
        store = findViewById(R.id.btnStore);
        stored = findViewById(R.id.btnStored);
        decimal = findViewById(R.id.btnDecimal);
        sign = findViewById(R.id.btnSign);
    }

    private void compute() {
        if (!Double.isNaN(value1)) {
            try {
                value2 = Double.valueOf(screen.getText().toString());
            } catch (Exception e) {

            }

            switch (ACTION) {
                case ADDITION :
                    value1 += value2;
                    break;
                case SUBTRACTION :
                    value1 -= value2;
                    break;
                case MULTIPLICATION :
                    value1 *= value2;
                    break;
                case DIVISION :
                    value1 /= value2;
                    break;
                case EQUALS :
                    break;
            }
        } else {
            value1 = Double.valueOf(screen.getText().toString());
        }
    }
}
