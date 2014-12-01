package com.example.shine.testdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

/**
 * Created by SHINE on 11/29/2014.
 */

public class MainActivity extends Activity {
    EditText editTextUserName,editTextPassword;
    Button btnSignIn;
    LoginActivity LoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // instance of SQLite Database
        LoginActivity=new LoginActivity(this);
        LoginActivity=LoginActivity.open();

        final EditText editTextUserName=(EditText)findViewById(R.id.user);
        final EditText editTextPassword=(EditText)findViewById(R.id.password);

        // Refference Of Buttons
        final Context context = this;
        Button btnSignIn=(Button)findViewById(R.id.in);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                // get User name and Password
                 String userName=editTextUserName.getText().toString();
                 String password=editTextPassword.getText().toString();

                // fetch Password form database for respective user name
                String storedPassword=LoginActivity.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {


                    Intent intent = new Intent(context, Categoryactivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        LoginActivity.close();
    }
}