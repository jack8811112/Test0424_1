package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText height;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        name = (EditText) findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
    }

    public void show(View view) {
        TextView s = findViewById(R.id.tv_bmi);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        String h = height.getText().toString();
        String w = weight.getText().toString();

//        double h_value = Double.parseDouble(height.getText().toString());
//        double w_value = Double.parseDouble(weight.getText().toString());
//        double bmi = w_value / (h_value/100.0 * h_value/100.0);
        double bmi = Double.parseDouble(w) / (Double.parseDouble(h)/100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.##");

        String msg;
        if (bmi>=24) {
            msg="Your weight is overweight";
            //Toast.makeText(this, "Your weight is overweight", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b3);
        }
        else if(bmi<=18.5){
            msg="Your weight is underweight";
            // Toast.makeText(this, "Your weight is underweight", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b1);
        }
        else{
            msg="Your weight is moderate";
            //Toast.makeText(this, "Your weight is moderate", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b2);
    }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        s.setText(name.getText().toString() + ", welcome." + "\n" +"Your BMI is " + df.format(bmi) + "\n" + msg);
    }

        Bundle bundle = new Bundle();
            public void nextPage(View view) {
        bundle.putString("height",height.getText().toString());
        bundle.putString("weight",weight.getText().toString());
        bundle.putString("name",name.getText().toString());

        Intent intent = new Intent(this,ShowBMIActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
