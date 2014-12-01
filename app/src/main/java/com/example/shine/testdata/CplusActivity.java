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
public class CplusActivity extends Activity {

    TextView que;
    Button nextque;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
// Storing questios, answers and options in string
    String questions[]={"What is the only function all C++ programs must contain?", "Every function in C++ are followed by", "Which of the following is not a correct variable type?","What is the correct value to return to the operating system upon the successful completion of a program?","Which of the following is the boolean operator for logical-and?"};
    String ans[]={"main()","Parenthesis","real","0","&&"};
    String options[]={"start()","system()","main()","program()","Parameters","Parenthesis","Curly braces","None of these","float","real","int","double","-1"," 1","0","none"," &","&&", "both","none"};
    int flag=0;
    public static int marks,correct,wrong;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cplus);

        que=(TextView)findViewById(R.id.que3);

        nextque=(Button)findViewById(R.id.nextque2);

        rg=(RadioGroup)findViewById(R.id.radiogroup3);
        rb1=(RadioButton)findViewById(R.id.radioButton9);
        rb2=(RadioButton)findViewById(R.id.radioButton10);
        rb3=(RadioButton)findViewById(R.id.radioButton11);
        rb4=(RadioButton)findViewById(R.id.radioButton12);
        que.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        nextque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Automatically generated
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


                    Intent in = new Intent(getApplicationContext(), CplusResult.class);
                    startActivity(in);
                }

            }
        });

    }
}


