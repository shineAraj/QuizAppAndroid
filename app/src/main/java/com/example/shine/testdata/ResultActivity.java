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
public class ResultActivity extends Activity {

    TextView rv,av;
    Button rbtn;
    ListView listView ;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result);

            rv = (TextView) findViewById(R.id.resultview);
            //  av=(TextView)findViewById(R.id.answers);
            rbtn = (Button) findViewById(R.id.restart);
            listView = (ListView) findViewById(R.id.listView);

            // Defined Array values to show in ListView
            String[] values = new String[]{"ANSWERS", "1) Native",
                    "2) Interface",
                    "3) ByteCode",
                    "4) Javac",
                    "5) Java Doc"
            };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, values);
            listView.setAdapter(adapter);

            StringBuffer sb = new StringBuffer();
            sb.append("Correct Answers: " + JavaActivity.correct);
            sb.append("\nWrong Answers: " + JavaActivity.wrong);
            sb.append("\nTotal Score: " + JavaActivity.marks);
            //av.setText(JavaActivity.);
            rv.setText(sb);
            JavaActivity.correct = 0;
            JavaActivity.wrong = 0;
            rbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getApplicationContext(), Categoryactivity.class);
                    startActivity(in);
                }
            });


        }

}
