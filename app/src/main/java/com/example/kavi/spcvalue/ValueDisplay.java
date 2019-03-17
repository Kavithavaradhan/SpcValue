package com.example.kavi.spcvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ValueDisplay extends AppCompatActivity {

    String selectedItem="";
    EditText sbcvalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_display);

        sbcvalue = (EditText) findViewById(R.id.sbcvalue);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnersoil);
        Button rstbtn = (Button) findViewById(R.id.rstbtn);


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

        Intent launch = getIntent();
        Float qd = launch.getFloatExtra("qd",0);

        sbcvalue.setText(String.valueOf(qd));


        rstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FinalValue.class);
                intent.putExtra("selectedItem",selectedItem);
                try {
                    String value = sbcvalue.getText().toString();
                    final Float xv = Float.valueOf(value);
                    intent.putExtra("sbcvalue",xv);
                    //Toast.makeText(getApplicationContext(),"The value is" + xv,Toast.LENGTH_SHORT).show();

                }
                catch (RuntimeException e){
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
    }
}
