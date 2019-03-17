package com.example.kavi.spcvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalValue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_value);

        TextView displaytxt = (TextView) findViewById(R.id.displaytxt);
        TextView displaytxt3 = (TextView) findViewById(R.id.displaytxt3);
        TextView displaytxt2 = (TextView) findViewById(R.id.displaytxt2);
        TextView displaytxt4 = (TextView) findViewById(R.id.displaytxt4);


        Intent launch = getIntent();
        String list = launch.getStringExtra("selectedItem");
        displaytxt.setText(list);
        Float xv = launch.getFloatExtra("sbcvalue", 0);
        displaytxt2.setText(String.valueOf(xv));

        if (list.equals("Rock")) {
            displaytxt3.setText(String.valueOf("3240.0"));
        } else if (list.equals("Soft Rock")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Coarse Sand")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Medium Sand")) {
            displaytxt3.setText(String.valueOf("245.0"));
        } else if (list.equals("Fine Sand")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Soft Shell")) {
            displaytxt3.setText(String.valueOf("100.0"));
        } else if (list.equals("Soft Clay")) {
            displaytxt3.setText(String.valueOf("100.0"));
        } else if (list.equals("Very Soft Clay")) {
            displaytxt3.setText(String.valueOf("100.0"));
        }

        if ((list.equals("Rock") && xv <= 3240.0) || (list.equals("Soft Rock") && xv <= 440.0) || (list.equals("Coarse Sand") && xv <= 440.0) || (list.equals("Medium Sand") && xv <= 245.0) || (list.equals("Fine Sand") && xv <= 440.0) || (list.equals("Soft Shell") && xv <= 100.0) || (list.equals("Soft Clay") && xv <= 100.0) || (list.equals("Very Soft Clay") && xv <= 50.0)){
            // Toast.makeText(getApplicationContext(),"Bearable",Toast.LENGTH_SHORT).show();
            displaytxt4.setText("Bearable");

        } else {
            // Toast.makeText(getApplicationContext(),"Not Bearable",Toast.LENGTH_SHORT).show();
            displaytxt4.setText("Not Bearable");


        }

    }
}
