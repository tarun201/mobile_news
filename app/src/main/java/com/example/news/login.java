package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText)findViewById(R.id.input_email);
        final EditText pass = (EditText)findViewById(R.id.input_password);
        Button b_login = (Button)findViewById(R.id.btn_login);

        login = getSharedPreferences("login", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = login.edit();

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = pass.getText().toString();

                editor.putString("email",e);
                editor.putString("password",p);
                editor.commit();

                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void to_signup(View v){
        Intent i = new Intent(getBaseContext(),sign_up.class);
        startActivity(i);
        finish();
    }
}
