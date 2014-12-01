package com.example.shine.testdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by SHINE on 11/30/2014.
 */
public class CplusResult extends Activity {
    TextView rv,av;
    Button rbtn;
    ListView listView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cplusresult);

        rv = (TextView) findViewById(R.id.resultview2);
        //  av=(TextView)findViewById(R.id.answers);
        rbtn = (Button) findViewById(R.id.restart2);
        listView = (ListView) findViewById(R.id.listView2);

        // Defined Array values to show in ListView
        String[] values = new String[]{"ANSWERS", "1) main()",
                "2) Parenthesis",
                "3) real",
                "4) 0",
                "5) &&"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answers: " + CplusActivity.correct);
        sb.append("\nWrong Answers: " + CplusActivity.wrong);
        sb.append("\nTOTAL SCORE:   " + CplusActivity.marks);
        //av.setText(JavaActivity.);
        rv.setText(sb);
        CplusActivity.correct = 0;
        CplusActivity.wrong = 0;
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Categoryactivity.class);
                startActivity(in);
            }
        });


    }

}




