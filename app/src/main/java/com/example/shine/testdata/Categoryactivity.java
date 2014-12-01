package com.example.shine.testdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


/**
 * Created by SHINE on 11/30/2014.
 */
public class Categoryactivity extends Activity {

    Button button1,button2,button3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final Context context = this;
        Button button1 = (Button) findViewById(R.id.javabutton);
        Button button2 = (Button) findViewById(R.id.cbutton);
        Button button3 = (Button) findViewById(R.id.cplusbutton);

        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, JavaActivity.class);
                startActivity(intent);
            }

        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, BasicCActivity.class);
                startActivity(intent);

            }

        });

        button3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, CplusActivity.class);
                startActivity(intent);

            }

        });
        return true;
    }


}
