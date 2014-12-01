package com.example.shine.testdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by SHINE on 11/30/2014.
 */
public class BasicCActivity extends Activity {
    TextView que;
    Button nextque;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[]={"The address of a variable temp of type float is?" ,"What type of errors are checked during compilation?","The minimum number of temporary variable needed to swap the contents of two variable is","The process of repeating a group of statements in an algorithm is known as", "The individual units of a C program is known as"};
    String ans[]={"&temp","syntax errors","two","iteration","tokens"};
    String options[]={"temp","&temp","float&temp","float temp&","logical errors","divide by zero error","run - time errors","syntax errors","Three","one","zero","two","sequence","iteration","flow","selection","records","tokens","units","program"};

    int flag=0;
    public static int marks,correct,wrong;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicc);

        que=(TextView)findViewById(R.id.que2);

        nextque=(Button)findViewById(R.id.nextque1);

        rg=(RadioGroup)findViewById(R.id.radiogroup2);
        rb1=(RadioButton)findViewById(R.id.radioButton5);
        rb2=(RadioButton)findViewById(R.id.radioButton6);
        rb3=(RadioButton)findViewById(R.id.radioButton7);
        rb4=(RadioButton)findViewById(R.id.radioButton8);
        que.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        nextque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //RODO Automatically generated
                RadioButton uans=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                String ansText=uans.getText().toString();


                if(ansText.equalsIgnoreCase(ans[flag]))
                {
                    correct++;

                }
                else
                {
                    wrong++;
                }
                flag++;
                if(flag<questions.length)
                {
                    que.setText(questions[flag]);
                    rb1.setText(options[flag*4]);
                    rb2.setText(options[(flag*4)+1]);
                    rb3.setText(options[(flag*4)+2]);
                    rb4.setText(options[(flag*4)+3]);

                }
                else {
                    marks = correct;


                    Intent in = new Intent(getApplicationContext(), BasicCResult.class);
                    startActivity(in);
                }

            }
        });

    }
}


