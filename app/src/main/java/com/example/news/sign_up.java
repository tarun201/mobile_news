package com.example.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText e = (EditText)findViewById(R.id.input_email);
        Button b = (Button)findViewById(R.id.btn_signup);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e.getText().toString();
                if(email.isEmpty()){
                    e.setError("Enter email");
                }else{
                    Toast.makeText(getApplicationContext(),email,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void to_login(View v){
        Intent i = new Intent(getBaseContext(),login.class);
        startActivity(i);
        finish();
    }
}
