package com.example.kavi.spcvalue;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CalculateActivity extends AppCompatActivity {

    EditText q,nq,nomega,sq,somega,dq,domega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        ImageView nxtbtn = (ImageView) findViewById(R.id.nextbtn);

        q = (EditText) findViewById(R.id.q);
        nq = (EditText) findViewById(R.id.nq);
        nomega = (EditText) findViewById(R.id.nomega);
        sq = (EditText) findViewById(R.id.sq);
        somega = (EditText) findViewById(R.id.somega);
        dq = (EditText) findViewById(R.id.dq);
        domega = (EditText) findViewById(R.id.domega);

        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),GettingSBCvalue.class);

                try {
                    String vq = q.getText().toString();
                    String vnq = nq.getText().toString();
                    String vomega= nomega.getText().toString();
                    String vsq = sq.getText().toString();
                    String vsomega = somega.getText().toString();
                    String vdq = dq.getText().toString();
                    String vdomega = domega.getText().toString();

                    final Float xq = Float.valueOf(vq);
                    final Float xnq = Float.valueOf(vnq);
                    final Float xvomega = Float.valueOf(vomega);
                    final Float xsq = Float.valueOf(vsq);
                    final Float xsomega = Float.valueOf(vsomega);
                    final Float xdq = Float.valueOf(vdq);
                    final Float xdomega = Float.valueOf(vdomega);

                    intent.putExtra("q",xq);
                    intent.putExtra("nq",xnq);
                    intent.putExtra("nomega",xvomega);
                    intent.putExtra("sq",xsq);
                    intent.putExtra("somega",xsomega);
                    intent.putExtra("dq",xdq);
                    intent.putExtra("domega",xdomega);


                } catch (RuntimeException e){
                    e.printStackTrace();
                }
                startActivity(intent);

            }
        });


    }
}
