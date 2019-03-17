package com.example.kavi.spcvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GettingSBCvalue extends AppCompatActivity {

    EditText w,b,omega,iq,iomega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_sbcvalue);

        Intent launch = getIntent();
        final Float q = launch.getFloatExtra("q",0);
        //Toast.makeText(getApplicationContext(),"Value is" + q,Toast.LENGTH_SHORT).show();
        final Float nq = launch.getFloatExtra("nq",0);
        final Float nomega = launch.getFloatExtra("nomega",0);
        final Float sq = launch.getFloatExtra("sq",0);
        final Float somega = launch.getFloatExtra("somega",0);
        final Float dq = launch.getFloatExtra("dq",0);
        final Float domega = launch.getFloatExtra("domega",0);


        w = (EditText) findViewById(R.id.w);
        b = (EditText) findViewById(R.id.b);
        omega = (EditText) findViewById(R.id.omega);
        iq = (EditText) findViewById(R.id.iq);
        iomega = (EditText) findViewById(R.id.iomega);

        Button calbtn = (Button) findViewById(R.id.calvalue);





        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String vw = w.getText().toString();
                    String vb = b.getText().toString();
                    String vomega = omega.getText().toString();
                    String viq = iq.getText().toString();
                    String viomega = iomega.getText().toString();

                    final Float w = Float.valueOf(vw);
                    final Float b = Float.valueOf(vb);
                    final Float omega = Float.valueOf(vomega);
                    final Float iq = Float.valueOf(viq);
                    final Float iomega = Float.valueOf(viomega);


                    Float qd;
                    qd = (q * (nq - 1) * sq * dq * iq) + ((1/2) * b * omega * nomega * somega * domega * iomega * w);
                    //Toast.makeText(getApplicationContext(),"Value is " + qd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ValueDisplay.class);
                    intent.putExtra("qd",qd);
                    startActivity(intent);



                } catch (RuntimeException e){
                    e.printStackTrace();
                }


            }
        });

    }


}
