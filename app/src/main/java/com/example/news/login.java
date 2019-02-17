package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    SharedPreferences login;
    DatabaseHelper myDB;

    EditText email,pass;
    Button b_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDB=new DatabaseHelper(this);

        email = (EditText)findViewById(R.id.input_email);
        pass = (EditText)findViewById(R.id.input_password);
        b_login = (Button)findViewById(R.id.btn_login);

        login = getSharedPreferences("login", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = login.edit();

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e_mail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                login(e_mail,password);


            }
        });

    }

//

    public void login(String email,String password){
        Cursor res = myDB.getUser(email);
        if(res.moveToFirst()){
//            Log.d("db password",res.getString(3));
//            Log.d("typed password",password);
            if(res.getString(3).equals(password)){
                SharedPreferences.Editor editor = login.edit();
                editor.putString("username",res.getString(1));
//                editor.putString("password",password);
                editor.commit();

                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Email & Password didn't match",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Email doesn't exist",Toast.LENGTH_LONG).show();
        }
    }

    public void to_signup(View v){
        Intent i = new Intent(getBaseContext(),sign_up.class);
        startActivity(i);
        finish();
    }
}
