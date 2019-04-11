package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txt_salary;
    TextView txt_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = (TextView) findViewById(R.id.txt_result);
        txt_salary  = (EditText) findViewById(R.id.txt_salary);
    }

    public void calculateTax(View view){
        Integer salary = Integer.parseInt(txt_salary.getText().toString());

        double tax;
        if(salary >1 && salary <= 200000) {

            tax = 0.01 * salary;

        }
        else if(salary > 200000 && salary <= 350000){
            double first_part = 0.01 * 200000;
            double second_part = 0.15 * (salary - 200000);

            tax = first_part+second_part;
        }else if(salary > 350000){
            double first_part = 0.01 * 200000;
            double second_part = 0.15 * 150000;
            double third_part = 0.25 * (salary - 200000 - 150000);

            tax = first_part + second_part+third_part;
        }else{
            tax = 0.0;
        }

        txt_result.setText(tax+"");

    }
}
