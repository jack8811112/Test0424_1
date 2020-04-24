package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbmi2);

        TextView show_name = (TextView) findViewById(R.id.tv_name);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        TextView show_bmi = (TextView) findViewById(R.id.tv_bmi);


        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");

//        double h_value = Double.parseDouble(height.getText().toString());
//        double w_value = Double.parseDouble(weight.getText().toString());
//        double bmi = w_value / (h_value/100.0 * h_value/100.0);
        double bmi = Double.parseDouble(w) / (Double.parseDouble(h)/100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.##");

        String msg;
        if (bmi>=24) {
            msg=getString(R.string.strtoohigh);
            //Toast.makeText(this, "Your weight is overweight", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b3);
        }
        else if(bmi<=18.5){
            msg=getString(R.string.strtoolow);
            // Toast.makeText(this, "Your weight is underweight", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b1);
        }
        else{
            msg=getString(R.string.strfit);
            //Toast.makeText(this, "Your weight is moderate", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b2);
        }
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        show_name.setText(name);
        show_bmi.setText(getString(R.string.strshowbmi) + df.format(bmi) + msg);
    }
}
