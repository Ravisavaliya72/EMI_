package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etloanamount,etmonths,etintrate;
        Button calculate;
        TextView tvemi,tvinterest,tvtotal;

        etloanamount = findViewById(R.id.etloanamount);
        etmonths = findViewById(R.id.etmonths);
        etintrate = findViewById(R.id.etintrate);
        calculate = findViewById(R.id.calculate);
        tvemi = findViewById(R.id.tvemi);
        tvinterest = findViewById(R.id.tvinterest);
        tvtotal = findViewById(R.id.tvtotal);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int lnamt = Integer.parseInt(etloanamount.getText().toString());
                double intt = Double.parseDouble(etintrate.getText().toString());
                int mon = Integer.parseInt(etmonths.getText().toString());

                double r = intt/(12*100);
                double ent =1;
                for(int i =0; i<mon; i++){
                    ent*=(1+r);
                }

                double ans = lnamt*r*(ent/(ent-1));
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                tvemi.setText("EMI = "+df.format(ans));
                double total = ans*mon;
                tvtotal.setText("Total amount = "+df.format(total));
                double iamt = total-lnamt;
                tvinterest.setText("Interest Amount = "+df.format(iamt));




            }
        });



    }
}