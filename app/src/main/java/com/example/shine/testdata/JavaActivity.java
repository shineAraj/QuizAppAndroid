package com.example.shine.testdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by SHINE on 11/30/2014.
 */
public class JavaActivity extends Activity {

TextView que;
    Button nextque;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    String javaquestions[]={"Which is a reserved word in the Java programming language?" ,"Which is a valid keyword in java?","java source code is compiled into","Which of the toool is used to compile java code", "HTML based javaa Documentary help can be accessed using"};
    String javaans[]={"native","interface","Bytecode","Javac","Javadoc"};
    String javaoptions[]={"method","native","subclass","reference","interface","string","Float","unsigned","obj","sourcecode","bytecode","exe","jav","jar","javac","javadoc","javadoc", "none of these","java manual","java help"};
    // String ans[];
    int flag=0;
    public static int marks,correct,wrong;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java);
        que=(TextView)findViewById(R.id.que);

        nextque=(Button)findViewById(R.id.nextque);

        rg=(RadioGroup)findViewById(R.id.radiogroup1);
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        que.setText(javaquestions[flag]);
        rb1.setText(javaoptions[0]);
        rb2.setText(javaoptions[1]);
        rb3.setText(javaoptions[2]);
        rb4.setText(javaoptions[3]);

        nextque.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //RODO Automatically generated
                RadioButton uans=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                String ansText=uans.getText().toString();


                if(ansText.equalsIgnoreCase(javaans[flag]))
                {
                    correct++;

                }
                else
                {
                    wrong++;
                }
                flag++;
                if(flag<javaquestions.length)
                {
                    que.setText(javaquestions[flag]);
                    rb1.setText(javaoptions[flag*4]);
                    rb2.setText(javaoptions[(flag*4)+1]);
                    rb3.setText(javaoptions[(flag*4)+2]);
                    rb4.setText(javaoptions[(flag*4)+3]);

                }
                else {
                    marks = correct;


                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }

            }
        });

    }
}
