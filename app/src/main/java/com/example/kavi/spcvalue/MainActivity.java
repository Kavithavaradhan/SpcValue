package com.example.kavi.spcvalue;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String selectedItem="";
    EditText sbcvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do You Know the Soil Type and SBC value?");
        //builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Proceed....!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
                Intent intent = new  Intent(getApplicationContext(),CalculateActivity.class);
                startActivity(intent);
            }
        });

        builder.show();



        final Spinner spinner = (Spinner) findViewById(R.id.spinnersoil);
        Button rstbtn = (Button) findViewById(R.id.rstbtn);
        sbcvalue = (EditText) findViewById(R.id.sbcvalue);




        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Spinnersoil.soilname));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedItem = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        rstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DisplayValue.class);
                intent.putExtra("selectedItem",selectedItem);
                try {
                    String value = sbcvalue.getText().toString();
                    final Float xv = Float.valueOf(value);
                    intent.putExtra("sbcvalue",xv);

                }
                catch (RuntimeException e){
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });


    }
}
