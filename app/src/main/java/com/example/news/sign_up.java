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

public class sign_up extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editTextname, editTextemail, editTextpassword;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        setContentView(R.layout.activity_sign_up);
        editTextname = (EditText) findViewById(R.id.input_name);
        editTextemail = (EditText) findViewById(R.id.input_email);
        editTextpassword = (EditText) findViewById(R.id.input_password);

        signup = (Button) findViewById(R.id.btn_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextemail.getText().toString();
                String name = editTextname.getText().toString();
                String password = editTextpassword.getText().toString();
                if (email.isEmpty()) {
                    editTextemail.setError("Email can't be empty");
                    editTextemail.requestFocus();
                }else if(name.isEmpty()){
                    editTextname.setError("Name can't be empty");
                    editTextname.requestFocus();
                }else if(password.isEmpty()){
                    editTextpassword.setError("Password can't be empty");
                    editTextpassword.requestFocus();
                } else {
                    AddData();
                }
            }
        });
    }

    public void to_login(View v) {
        Intent i = new Intent(getBaseContext(), login.class);
        startActivity(i);
        finish();
    }

    public void AddData() {

//        Toast.makeText(getApplicationContext(),e_mail.getText().toString(),Toast.LENGTH_SHORT).show();

        String name = editTextname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        boolean isInserted = myDB.insertData(name, email, password);

        if (isInserted == true) {
            final SharedPreferences login = getSharedPreferences("login", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = login.edit();
            editor.putString("username", name);
            editor.commit();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
//                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Data not Inserted", Toast.LENGTH_LONG).show();

    }

//    public void viewAll() {
//        btnviewAll.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDB.getAllData();
//                        if(res.getCount() == 0) {
//                        // show message
//                        // showMessage("Error","No Data Found...");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//
//                        while (res.moveToNext()) {
//                            buffer.append("Id :"+ res.getString (0)+"\n");
//                            buffer.append("Name :"+ res.getString(1)+"\n");
//                            buffer.append("Surname :"+ res.getString(2)+"\n");
//                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
//                        }
//// Show all data
////                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }

}
