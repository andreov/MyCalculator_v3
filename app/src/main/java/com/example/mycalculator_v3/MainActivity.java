package com.example.mycalculator_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mResult;
    private double result;
    private String op;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResult=findViewById(R.id.result);

    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        mResult.append(button.getText());
    }

    public void onOperationClick(View view){
        Button button = (Button)view;
        mResult.append(button.getText());
        op=button.getText().toString();
    }
    public void onNegativeNumClick(View view){
        mResult.append("-");

    }

    public void onClearClick(View view){
        mResult.setText("");
    }

    public void onResultClick(View view) {
        Button button = (Button) view;
        mResult.append(button.getText());

        //String [] temp = mResult.getText().toString().split("^|\\+-|/|[-]+|=|\\+|\\*|%");
        String [] temp = mResult.getText().toString().split("^|/|-|=|\\+|\\*|%");
        Double num1=Double.parseDouble(temp[0]);
        if(temp.length>2) temp[1]="-"+temp[2];

        Double num2=Double.parseDouble(temp[1]);
        switch(op) {
            case "+":
                result = num1 + num2;
                //mResult.setText("");
                mResult.append(Double.toString(result));
                break;
            case "-":
                result = num1 - num2;
                mResult.append(Double.toString(result));
                break;
            case "*":
                result = num1 * num2;
                mResult.append(Double.toString(result));
                break;
            case "/":
                result = num1 / num2;
                mResult.append(Double.toString(result));
                break;
            case "%":
                result = (num1/100) * num2;
                mResult.append(Double.toString(result));
                break;
        }

    }
}