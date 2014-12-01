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
public class BasicCResult extends Activity {
    TextView rv;
    Button rbtn;
    ListView listView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicresult);

        rv = (TextView) findViewById(R.id.resultview1);
        //  av=(TextView)findViewById(R.id.answers);
        rbtn = (Button) findViewById(R.id.restart1);
        listView = (ListView) findViewById(R.id.listView1);

        // Defined Array values to show in ListView
        String[] values = new String[]{"ANSWERS", "1) &temp",
                "2) Syntax Errors",
                "3) Two",
                "4) Iteration",
                "5) Tokens"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answers: " + BasicCActivity.correct);
        sb.append("\nWrong Answers: " + BasicCActivity.wrong);
        sb.append("\nTotal Score: " + BasicCActivity.marks);
        //av.setText(JavaActivity.);
        rv.setText(sb);
        BasicCActivity.correct = 0;
        BasicCActivity.wrong = 0;
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Categoryactivity.class);
                startActivity(in);
            }
        });


    }

}



